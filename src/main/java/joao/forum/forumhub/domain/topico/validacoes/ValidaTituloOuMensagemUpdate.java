package joao.forum.forumhub.domain.topico.validacoes;

import joao.forum.forumhub.domain.ValidacaoException;
import joao.forum.forumhub.domain.topico.DadosAtualizacaoTopico;
import joao.forum.forumhub.domain.topico.TopicoRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidaTituloOuMensagemUpdate implements ValidadorAtualizacaoTopico {

    private final TopicoRepository repository;

    public ValidaTituloOuMensagemUpdate(TopicoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validar(DadosAtualizacaoTopico dados) {
        if (repository.existsByTitulo(dados.titulo())) {
            throw new ValidacaoException("Já existe um tópico com este título!");
        }
        if (repository.existsByMensagem(dados.mensagem())) {
            throw new ValidacaoException("Já existe um tópico com esta mensagem!");
        }
    }
}