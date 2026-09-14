package estacionamento.model;
//A ideia será ela representar a reserva que queremos devolver para o cliente, usando UsuarioResumo no lugar de Usuario.

import java.math.BigDecimal;

public class ReservaResumo {
    private Integer idReserva;
    private UsuarioResumo usuario;
    private BigDecimal valorBase;
    private BigDecimal valorAdicional;
    private BigDecimal valorTotal;
    private String status;



    public ReservaResumo(Integer idReserva, UsuarioResumo usuario, BigDecimal valorBase, BigDecimal valorAdicional, BigDecimal valorTotal, String status) {
        this.idReserva = idReserva;
        this.usuario = usuario;
        this.valorBase = valorBase;
        this.valorAdicional = valorAdicional;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public UsuarioResumo getUsuario() {
        return usuario;
    }
    public BigDecimal getValorBase() {
        return valorBase;
    }

    public BigDecimal getValorAdicional() {
        return valorAdicional;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public String getStatus() {
        return status;
    }
}
