package joao.forum.forumhub.domain.topico.validacoes;

import joao.forum.forumhub.domain.topico.DadosCadastroTopico;

public interface ValidadorCadastroTopico {
    void validar(DadosCadastroTopico dados);
}