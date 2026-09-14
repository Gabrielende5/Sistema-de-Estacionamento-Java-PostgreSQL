package estacionamento.model;
//A ideia é que essa classe represente:
        //"As informações do usuário que eu quero mostrar na resposta da reserva."
    // e não:
        //"Todos os dados do usuário."

public class UsuarioResumo {
    private Integer idUsuario;
    private String nome;
    public UsuarioResumo(Integer idUsuario, String nome) {
        this.idUsuario = idUsuario;
        this.nome = nome;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }
}
