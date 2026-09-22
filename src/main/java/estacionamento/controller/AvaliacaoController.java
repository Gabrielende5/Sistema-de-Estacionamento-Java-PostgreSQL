package estacionamento.controller;

import estacionamento.model.Avaliacao;
import estacionamento.model.AvaliacaoResumo;
import estacionamento.model.RelatorioAvaliacao;
import estacionamento.service.AvaliacaoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.math.BigDecimal;

import java.math.BigDecimal;

@RestController
public class AvaliacaoController {
    private AvaliacaoService avaliacaoService;
    public AvaliacaoController(AvaliacaoService avaliacaoService){
        this.avaliacaoService =avaliacaoService;
    }
    @PostMapping("/avaliacao")
    public AvaliacaoResumo registrarAvaliacao(@RequestBody Avaliacao avaliacao){
        return avaliacaoService.registrarAvaliacao(avaliacao);
    }

    @GetMapping("/avaliacao/media")
    public RelatorioAvaliacao buscarMediaAvaliacoes(){
        return avaliacaoService.buscarMediaAvaliacoes();
    }
}
