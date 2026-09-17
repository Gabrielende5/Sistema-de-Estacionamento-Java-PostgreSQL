package estacionamento.controller;

import estacionamento.model.Avaliacao;
import estacionamento.model.AvaliacaoResumo;
import estacionamento.service.AvaliacaoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
