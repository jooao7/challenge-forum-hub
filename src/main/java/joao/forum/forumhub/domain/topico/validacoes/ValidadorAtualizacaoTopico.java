package joao.forum.forumhub.domain.topico.validacoes;

import joao.forum.forumhub.domain.topico.DadosAtualizacaoTopico;

public interface ValidadorAtualizacaoTopico {
    void validar(DadosAtualizacaoTopico dados);
}