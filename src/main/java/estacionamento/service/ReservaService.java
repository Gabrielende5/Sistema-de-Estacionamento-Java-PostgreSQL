package estacionamento.service;

import estacionamento.model.Reserva;
import estacionamento.model.ReservaResumo;
import estacionamento.model.Usuario;
import estacionamento.model.UsuarioResumo;
import estacionamento.repository.ReservaRepository;
import estacionamento.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ReservaService {
    private ReservaRepository reservaRepository;
    private UsuarioRepository usuarioRepository; //Para verificar se o usuário existe
    public ReservaService(ReservaRepository reservaRepository, UsuarioRepository usuarioRepository){
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
    }
    public ReservaResumo fazerReserva(Reserva reserva){
        if(!reserva.getDataInicio().isBefore(reserva.getDataFim())){ //Não tem como voltar no tempo
            throw new RuntimeException("A data de início deve ser anterior à data de fim");
        }
        if(reserva.getDataInicio().isBefore(LocalDateTime.now())){
            throw new RuntimeException("A data de início não pode estar no passado");
        }
//        if(!usuarioRepository.existsById(reserva.getUsuario().getIdUsuario())){ //Para criar uma reserva, o usuário precisa existir
//            throw new RuntimeException("Usuário não existe");
//        }
        Usuario usuario = usuarioRepository //Verifica se tem um usuário com esse id, se sim, busca o usuário e guarda em um objeto, se não existir, dá o if da linha acima
                .findById(reserva.getUsuario().getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não existe"));
        reserva.setUsuario(usuario); //Retorna todas as informações do usuário, o que é bom por saber o nome, mas ruim por mandar o CPF, senha, email e etc quando fizer o pedido de uma reserva
                                        //Logo, se irá criar um ReservaResumo e um UsuarioResumo para resolver esse problema e mostrar apenas o nome + id
        UsuarioResumo usuarioResumo = new UsuarioResumo(
                usuario.getIdUsuario(),
                usuario.getNome()
        );

        reserva.setValorBase(BigDecimal.TEN); //Impede que o usuário controle o valorBase
        reserva.setStatus("PENDENTE"); //Impede que o usuário controle o status da reserva
        double valorAdicional=0;
        if(reserva.getVagaCoberta()){
            valorAdicional+=10;
        }
        if(reserva.getTamanhoVaga().equalsIgnoreCase("P")){ //Vaga pequena
            valorAdicional+=0;
        } else if(reserva.getTamanhoVaga().equalsIgnoreCase("M")){ //Vaga média
            valorAdicional+=5;
        } else if(reserva.getTamanhoVaga().equalsIgnoreCase("G")){ //Vaga grande
            valorAdicional+=10;
        }
        if(reserva.getLavaJato()){
            valorAdicional+=20;
        }
        if(reserva.getLavagemInterna()){
            valorAdicional+=15;
        }
        if(reserva.getManobrista()){
            valorAdicional+=25;
        }

        Duration duracao = Duration.between(reserva.getDataInicio(), reserva.getDataFim()); //Isso vai calcular a diferença entre as duas datas.
        long minutos = duracao.toMinutes();
        long horas = (long) Math.ceil(minutos / 60.0); //Pega somente a quantidade de horas, arredondando para cima, pois se a pessoa ficou 1h e 30 minutos, será descontada 2 horas

                        //Transformando para BigDecimal, pois valorTotal é um BigDecimal (foi definido em model/Reserva)
        BigDecimal valorBaseComHoras = reserva.getValorBase()
                .multiply(BigDecimal.valueOf(horas));
        BigDecimal adicional = BigDecimal.valueOf(valorAdicional);
        reserva.setValorAdicional(adicional);

        reserva.setValorTotal(valorBaseComHoras.add(adicional)); //valorBase + adicional

        Reserva reservaSalva = reservaRepository.save(reserva);
        return new ReservaResumo( //Se quiser adicionar qualquer outra coisa para retornar na saída do Json, é só adicionar no contrutor ReservaResumo no model, criando uma variável ali
                                    //E não se esquecer de adicionar o getter dele também
                reservaSalva.getIdReserva(),
                usuarioResumo,
                reservaSalva.getValorBase(),
                reservaSalva.getValorAdicional(),
                reservaSalva.getValorTotal(),
                reservaSalva.getStatus()
        );
//        return reservaRepository.save(reserva);
    }
}
