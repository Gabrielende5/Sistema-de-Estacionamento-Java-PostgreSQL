package estacionamento.model;
//A ideia é que essa classe represente:
        //"As informações do usuário que eu quero mostrar na resposta da reserva."
    // e não:
        //"Todos os dados do usuário."

public class UsuarioResumo {
    private Integer idUsuario;
    private String nome;
    private String email;
    public UsuarioResumo(Integer idUsuario, String nome, String email) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
    }

            //Precisa desses getters por conta que "o Jackson que, ao receber um objeto para transformar em JSON, procura propriedades que ele consiga acessar, normalmente através dos getters"
                //Se não colocar getters no Resumo, vai resultar em {} na saida
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
