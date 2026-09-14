package estacionamento.controller;

import estacionamento.model.Usuario;
import estacionamento.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //Diz para o Spring "Essa classe é um Controller."
public class UsuarioController {
    private UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){ //construtor para receber esse UsuarioService e armazená-lo no atributo
        this.usuarioService = usuarioService;
    }

    //criar uma rota HTTP para o cadastro:
    @PostMapping("/usuarios") //"Quando chegar uma requisição HTTP do tipo POST no endereço /usuarios, execute o método que estiver logo abaixo dessa anotação."
    public Usuario cadastroUsuario(@RequestBody Usuario usuario){ //@RequestBody diz ao Spring: "Pegue os dados que vieram no corpo da requisição HTTP e transforme-os em um objeto Usuario."
                                                                        //ex: Vem
                                                                            //        {
                                                                            //            "nome": "Gabriel",
                                                                            //                "email": "gabriel@email.com",
                                                                            //                "senha": "123456",
                                                                            //                "cpf": "123.456.789-00",
                                                                            //                "telefone": "12999999999"
                                                                            //        }
                                                                        //O Spring transforma isso em algo equivalente a:
                                                                            //        Usuario usuario
                                                                            //              ↓
                                                                            //        nome = Gabriel
                                                                            //        email = gabriel@email.com
                                                                            //        senha = 123456
                                                                            //        cpf = 123.456.789-00
                                                                            //        telefone = 12999999999
        return usuarioService.cadastrarUsuario(usuario); //Agora o Controller deve simplesmente repassar para o Service e devolver o resultado
    }
}
