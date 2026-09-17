package estacionamento.controller;

import estacionamento.model.Pagamento;
import estacionamento.model.PagamentoResumo;
import estacionamento.service.PagamentoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentoController {
    private PagamentoService pagamentoService;
    public PagamentoController(PagamentoService pagamentoService){
        this.pagamentoService = pagamentoService;
    }
    @PostMapping("/reserva/pagamento")
    public PagamentoResumo realizarPagamento(@RequestBody Pagamento pagamento){
        return pagamentoService.realizarPagamento(pagamento);
    }
}
