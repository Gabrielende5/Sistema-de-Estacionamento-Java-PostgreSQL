package estacionamento.service;

import estacionamento.model.*;
import estacionamento.repository.AvaliacaoRepository;
import estacionamento.repository.ReservaRepository;
import estacionamento.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AvaliacaoService {
    private AvaliacaoRepository avaliacaoRepository;
    private ReservaRepository reservaRepository;
    private UsuarioRepository usuarioRepository;
    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository, ReservaRepository reservaRepository, UsuarioRepository usuarioRepository){
        this.avaliacaoRepository = avaliacaoRepository;
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
    }
    public RelatorioAvaliacao buscarMediaAvaliacoes(){
        return avaliacaoRepository.buscarMediaAvaliacoes();
    }
    public AvaliacaoResumo registrarAvaliacao(Avaliacao avaliacao){
         if (avaliacao.getNota()<1 || avaliacao.getNota()>5){ //Provavelmente não precisa, pois no SQL já filtra
             throw new RuntimeException("Nota fora do intervalo de 1-5");
         }
         avaliacao.setData(LocalDateTime.now());
        Usuario usuario = usuarioRepository.findById(avaliacao.getUsuario().getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário com esse id não existe"));
        Reserva reserva = reservaRepository.findById(avaliacao.getUsuario().getIdUsuario())
                .orElseThrow(()-> new RuntimeException("Reserva com esse id não existe"));
        UsuarioResumo usuarioResumo = new UsuarioResumo(usuario.getIdUsuario(), usuario.getNome(), usuario.getEmail());
        ReservaAvaliacaoResumo reservaAvaliacaoResumo = new ReservaAvaliacaoResumo(reserva.getIdReserva());

        Avaliacao avaliacaoSalva = avaliacaoRepository.save(avaliacao);
        return new AvaliacaoResumo(
                avaliacaoSalva.getIdAvaliacao(),
                usuarioResumo,
                reservaAvaliacaoResumo,
                avaliacaoSalva.getNota(),
                avaliacao.getComentario(),
                avaliacao.getData()
        );
    }
}
