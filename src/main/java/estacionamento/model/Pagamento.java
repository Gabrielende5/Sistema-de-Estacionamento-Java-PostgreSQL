package estacionamento.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idPagamento;
    @OneToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Column(name = "valor_pago")
    private BigDecimal valorPago;
    private String metodo;
    private String status;
    public Pagamento(Reserva reserva, BigDecimal valorPago, String metodo){
        this.reserva = reserva;
        this.valorPago=valorPago;
        this.metodo=metodo;
    }
    public Pagamento(){

    }
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
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
