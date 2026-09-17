package estacionamento.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avaliacao")
    private Integer idAvaliacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @OneToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    private Integer nota;
    private String comentario;
    private LocalDateTime data;

    public Avaliacao(Usuario usuario, Reserva reserva, Integer nota, String comentario){
        this.usuario = usuario;
        this.reserva=reserva;
        this.nota=nota;
        this.comentario=comentario;
    }
    public Avaliacao(){};

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getComentario() {
        return comentario;
    }

    public Integer getNota() {
        return nota;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }
}
