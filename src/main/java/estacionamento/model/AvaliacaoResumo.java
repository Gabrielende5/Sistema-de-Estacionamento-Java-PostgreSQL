package estacionamento.model;

import java.time.LocalDateTime;

public class AvaliacaoResumo {
    private Integer idAvaliacao;
    private UsuarioResumo usuarioResumo;
    private ReservaAvaliacaoResumo reservaAvaliacaoResumo;
    private Integer nota;
    private String comentario;
    private LocalDateTime data;
    public AvaliacaoResumo(Integer idAvaliacao, UsuarioResumo usuarioResumo, ReservaAvaliacaoResumo reservaAvaliacaoResumo, Integer nota, String comentario, LocalDateTime data){
        this.idAvaliacao = idAvaliacao;
        this.usuarioResumo=usuarioResumo;
        this.reservaAvaliacaoResumo=reservaAvaliacaoResumo;
        this.nota = nota;
        this.comentario = comentario;
        this.data = data;
    }

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public UsuarioResumo getUsuarioResumo() {
        return usuarioResumo;
    }

    public ReservaAvaliacaoResumo getReservaAvaliacaoResumo() {
        return reservaAvaliacaoResumo;
    }

    public Integer getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public LocalDateTime getData() {
        return data;
    }
}
