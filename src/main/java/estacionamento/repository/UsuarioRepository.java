package estacionamento.repository;

import estacionamento.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Não precisa identificar, pois ao colocar "extends JpaRepository", o Spring já identifica que é um Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> { //Qual entidade esse repository vai controlar? → Usuario
                                                                                //Qual é o tipo do ID dessa entidade? → Integer
    //Os métodos "save(), findById(), findAll(), etc" já vem automaticamente com o JpaRepository

    public boolean existsByEmail(String email); //"Existe algum usuário com esse email?"
                                                    //Precisa ser esse nome da função / método para o Spring Data JPA entender
                                                    //existsBy... pode ser usado para praticamente qualquer atributo da entidade, desde que o nome corresponda a uma propriedade que o Spring Data JPA consiga interpretar.
    public boolean existsByCpf(String cpf);
}
