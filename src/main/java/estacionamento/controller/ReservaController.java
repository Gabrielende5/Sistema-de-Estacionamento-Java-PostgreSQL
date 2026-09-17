package estacionamento.controller;

import estacionamento.model.RelatorioUsuario;
import estacionamento.model.Reserva;
import estacionamento.model.ReservaResumo;
import estacionamento.service.ReservaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservaController {
    private ReservaService reservaService;
    public ReservaController(ReservaService reservaService){
        this.reservaService = reservaService;
    }
    @PostMapping("/reserva")
    public ReservaResumo fazerReserva(@RequestBody Reserva reserva){
        return reservaService.fazerReserva(reserva);
    }

    @GetMapping("/reserva/relatorio")
    public List<RelatorioUsuario> gerarRelatorio(){
        return reservaService.gerarRelatorio();
    }
}
