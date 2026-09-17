package estacionamento.model;

import java.math.BigDecimal;

public class PagamentoResumo {
    private Integer idPagamento;
    private ReservaAvaliacaoResumo reservaAvaliacaoResumo;
    private BigDecimal valorPago;
    private String metodo;
    private String status;
    public PagamentoResumo(Integer idPagamento, ReservaAvaliacaoResumo reservaAvaliacaoResumo, BigDecimal valorPago, String metodo, String status){
        this.idPagamento=idPagamento;
        this.reservaAvaliacaoResumo = reservaAvaliacaoResumo;
        this.valorPago=valorPago;
        this.metodo = metodo;
        this.status = status;
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public ReservaAvaliacaoResumo getReservaAvaliacaoResumo() {
        return reservaAvaliacaoResumo;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public String getMetodo() {
        return metodo;
    }

    public String getStatus() {
        return status;
    }
}
