package estacionamento.service;

import estacionamento.model.Usuario;
import estacionamento.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service //Falar que é um Service, ou seja, "Spring, gerencie essa classe e permita que ela seja injetada em outras classes."
public class UsuarioService {
    private UsuarioRepository usuarioRepository; //O Service precisa conseguir chamar, por exemplo:
                                                    //repository.save(usuario);
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository; //O construtor precisa receber um UsuarioRepository como parâmetro e colocar esse objeto no atributo:
    }

    public Usuario cadastrarUsuario(Usuario usuario){ //É nesse método que vamos colocar as verificações, se o email já existe e etc
                                                        //existsBy... pode ser usado para praticamente qualquer atributo da entidade, desde que o nome corresponda a uma propriedade que o Spring Data JPA consiga interpretar, só precisa colocar no repository
        if(usuarioRepository.existsByEmail(usuario.getEmail())){ //"O email desse usuário já existe no banco?"
            throw  new RuntimeException("Email já cadastrado"); //lança uma exeção que o email já foi cadastrado
        }
        if(usuarioRepository.existsByCpf(usuario.getCpf())){
            throw new RuntimeException("CPF já cadastrado");
        }
        return usuarioRepository.save(usuario); //"Salve esse usuário no banco e retorne o usuário salvo."
    }
}
