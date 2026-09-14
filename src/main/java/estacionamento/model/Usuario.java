package estacionamento.model;

import jakarta.persistence.*;

@Entity //"Essa classe é uma entidade que será mapeada para o banco."
            //Ou seja, representa uma tabela do PostgreSQL
@Table(name = "usuario") //Para "dizer" ao JPA qual tabela especificamente essa classe representa
public class Usuario {
    //A ideia é fazer o JPA entender cada atributo da classe e como ele corresponde às colunas da tabela

    @Id //Este atributo é o identificador/chave primária dessa entidade, a da linha de baixo
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para PostgreSQL com uma coluna SERIAL, a estratégia que normalmente usamos no JPA é essa
                                                            //@GeneratedValue → o valor será gerado automaticamente.
                                                            //GenerationType.IDENTITY → o banco gera esse valor.
    @Column(name = "id_usuario") //Como estamos usando um nome diferentes da tabela, precisa disso
    private Integer idUsuario; //Tem que ser "int" ao invés de String por conta que o SERIAL é um número inteiro gerado automaticamente pelo PostgreSQL.
                                    //Integer só para poder ser null
    @Column(length = 100) //o length = 100 não vai alterar a tabela. Ele serve para o mapeamento da entidade. A restrição real de VARCHAR(100) já está no banco
                                //Não é necessário, pois o banco já define o tamanho, mas é bom colocar
    private String nome;    //Usa private em tudo por conta que ao fazer:
                                    //    Usuario usuario1 = new Usuario();
                                    //    Usuario usuario2 = new Usuario();
                                    //
                                    //    usuario1.nome = "Gabriel";
                                    //    usuario2.nome = "João";
                                //Como nome é static, o segundo valor sobrescreveria o primeiro, mesmo criando objetos diferentes
    @Column(unique = true) //Também não é necessário, pois o banco já definiu que essa coluna é unique
    private String email;
    private String senha;
    private String cpf;
    private String telefone;


    public Usuario(String nome, String email, String senha, String cpf, String telefone){
        this.nome=nome;
        this.email=email;
        this.senha = senha;
        this.cpf=cpf;
        this.telefone=telefone;
    }
    public Usuario(){ //Para permitir criar um objeto da classe Usuario sem passar os parametros

    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
