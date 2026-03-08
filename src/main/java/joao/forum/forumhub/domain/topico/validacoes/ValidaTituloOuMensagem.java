package joao.forum.forumhub.domain.topico.validacoes;

import joao.forum.forumhub.domain.ValidacaoException;
import joao.forum.forumhub.domain.topico.DadosCadastroTopico;
import joao.forum.forumhub.domain.topico.TopicoRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidaTituloOuMensagem implements ValidadorCadastroTopico {

    private final TopicoRepository repository;

    public ValidaTituloOuMensagem(TopicoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validar(DadosCadastroTopico dados) {
        if (repository.existsByTitulo(dados.titulo())) {
            throw new ValidacaoException("Já existe um tópico com este título!");
        }
        if (repository.existsByMensagem(dados.mensagem())) {
            throw new ValidacaoException("Já existe um tópico com esta mensagem!");
        }
    }
}