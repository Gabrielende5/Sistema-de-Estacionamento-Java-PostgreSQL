package estacionamento.service;

import estacionamento.model.Pagamento;
import estacionamento.model.PagamentoResumo;
import estacionamento.model.Reserva;
import estacionamento.model.ReservaAvaliacaoResumo;
import estacionamento.repository.PagamentoRepository;
import estacionamento.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class PagamentoService {
    private PagamentoRepository pagamentoRepository;
    private ReservaRepository reservaRepository;
    public PagamentoService(ReservaRepository reservaRepository, PagamentoRepository pagamentoRepository){
        this.reservaRepository = reservaRepository;
        this.pagamentoRepository = pagamentoRepository;
    }
    public PagamentoResumo realizarPagamento(Pagamento pagamento){
        if(pagamentoRepository.existsByReservaIdReserva(pagamento.getReserva().getIdReserva())){
            throw new RuntimeException("Essa reserva já possui um pagamento");
        }
        Reserva reserva = reservaRepository.findById(pagamento.getReserva().getIdReserva())
                .orElseThrow(()-> new RuntimeException("Reserva com esse id não existe"));
        List<String> metodosValidos = List.of(
                "crédito",
                "débito",
                "pix",
                "boleto",
                "paypal",
                "applepay",
                "googlepay"
        );
        if(!metodosValidos.contains(pagamento.getMetodo().toLowerCase())){
            throw new RuntimeException("Método de pagamento inválido");
        }
        pagamento.setValorTotal(reserva.getValorTotal());
        if(pagamento.getValorTotal().compareTo(pagamento.getValorPago())>0){ //">0" -> "a" maior do que "b", com "a.compareTo(b)"
            throw new RuntimeException("Valor pago insuficiente para essa reserva");
        }
        pagamento.setStatus("APROVADO");


        ReservaAvaliacaoResumo reservaAvaliacaoResumo = new ReservaAvaliacaoResumo(reserva.getIdReserva());
        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);
        return new PagamentoResumo(
                pagamento.getIdPagamento(),
                reservaAvaliacaoResumo,
                pagamento.getValorPago(),
                pagamento.getMetodo(),
                pagamento.getStatus()
        );
    }
}
