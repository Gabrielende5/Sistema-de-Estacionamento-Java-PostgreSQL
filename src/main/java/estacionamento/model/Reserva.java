package estacionamento.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;

        //Já que "id_usuario" é uma chave extrangeira:
    @ManyToOne //"muitos para um", ou seja, Um Usuario pode ter muitas Reserva; Uma Reserva pertence a um Usuario.
                    //Muitas Reserva → um Usuario.
    @JoinColumn(name = "id_usuario") //Aqui estamos dizendo qual coluna do banco faz essa ligação.
                                     // fala para o JPA: "A coluna id_usuario da tabela reserva é a coluna que conecta essa Reserva ao Usuario."
                                        //O Java está apenas mapeando essa relação.
    private Usuario usuario; //a Reserva guarda uma referência para um objeto Usuario.
        //Ou seja: "Uma Reserva pertence a um Usuario. A ligação entre eles é feita pela coluna id_usuario da tabela reserva, e no Java essa relação será representada pelo objeto Usuario."


    @Column(name = "data_inicio")
    private LocalDateTime dataInicio; //"LocalDateTime" por conta que no SQL está "TIMESTAMP"
    @Column(name = "data_fim")
    private LocalDateTime dataFim;
    private String status;
    @Column(name = "vaga_coberta")
    private Boolean vagaCoberta;
    @Column(name = "tamanho_vaga")
    private String tamanhoVaga;
    @Column(name = "lava_jato")
    private Boolean lavaJato;
    @Column(name = "lavagem_interna")
    private Boolean lavagemInterna;
    private Boolean manobrista;
    @Column(name = "placa_veiculo")
    private String placaVeiculo;
    @Column(name = "modelo_veiculo")
    private String modeloVeiculo;
    @Column(name = "valor_base")
    private BigDecimal valorBase; //"BigDecimal" por conta que no SQL está "DECIMAL(10,2)"
    @Column(name = "valor_adicional")
    private BigDecimal valorAdicional;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    public Reserva(Usuario usuario, LocalDateTime dataInicio, LocalDateTime dataFim, Boolean vagaCoberta, String tamanhoVaga, Boolean lavaJato, Boolean lavagemInterna, Boolean manobrista, String placaVeiculo, String modeloVeiculo){
        this.usuario = usuario;
        this.dataInicio=dataInicio;
        this.dataFim=dataFim;
//        this.status=status; //O usuário não vai inserir qual o status da reserva, o backend que vai definir
        this.vagaCoberta=vagaCoberta;
        this.tamanhoVaga=tamanhoVaga;
        this.lavaJato=lavaJato;
        this.lavagemInterna=lavagemInterna;
        this.manobrista=manobrista;
        this.placaVeiculo=placaVeiculo;
        this.modeloVeiculo=modeloVeiculo;

                //O usuário não vai inserir os valores dos custos, o backend que vai definir com base no que foi pedido
//        this.valorBase=valorBase;
//        this.valorAdicional=valorAdicional;
//        this.valorTotal=valorTotal;
    }
    public Reserva(){

    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public String getStatus() {
        return status;
    }

    public Boolean getVagaCoberta() {
        return vagaCoberta;
    }

    public String getTamanhoVaga() {
        return tamanhoVaga;
    }

    public Boolean getLavaJato() {
        return lavaJato;
    }

    public Boolean getLavagemInterna() {
        return lavagemInterna;
    }

    public Boolean getManobrista() {
        return manobrista;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setVagaCoberta(Boolean vagaCoberta) {
        this.vagaCoberta = vagaCoberta;
    }

    public void setTamanhoVaga(String tamanhoVaga) {
        this.tamanhoVaga = tamanhoVaga;
    }

    public void setLavaJato(Boolean lavaJato) {
        this.lavaJato = lavaJato;
    }

    public void setLavagemInterna(Boolean lavagemInterna) {
        this.lavagemInterna = lavagemInterna;
    }

    public void setManobrista(Boolean manobrista) {
        this.manobrista = manobrista;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public void setValorBase(BigDecimal valorBase) {
        this.valorBase = valorBase;
    }

    public void setValorAdicional(BigDecimal valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
