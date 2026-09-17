package estacionamento.model;


import java.math.BigDecimal;

//Parte do NativeQuery
public class RelatorioUsuario {
    private Integer idUsuario;
    private String nome;
    private  Long quantidadeReservas;
    private BigDecimal valorGasto;
    public RelatorioUsuario(Integer idUsuario, String nome, Long quantidadeReservas, BigDecimal valorGasto) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.quantidadeReservas = quantidadeReservas;
        this.valorGasto = valorGasto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public Long getQuantidadeReservas() {
        return quantidadeReservas;
    }

    public BigDecimal getValorGasto() {
        return valorGasto;
    }
}
