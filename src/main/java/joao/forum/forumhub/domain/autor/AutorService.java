package joao.forum.forumhub.domain.autor;

import org.springframework.stereotype.Service;

@Service
public class AutorService {

    public Autor construir(DadosCadastroAutor dados) {
        return new Autor(dados);
    }
}