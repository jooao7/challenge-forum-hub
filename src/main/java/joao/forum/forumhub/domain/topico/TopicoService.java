package joao.forum.forumhub.domain.topico;

import joao.forum.forumhub.domain.ValidacaoException;
import joao.forum.forumhub.domain.autor.AutorRepository;
import joao.forum.forumhub.domain.curso.CursoRepository;
import joao.forum.forumhub.domain.topico.validacoes.ValidadorAtualizacaoTopico;
import joao.forum.forumhub.domain.topico.validacoes.ValidadorCadastroTopico;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;
    private final AutorRepository autorRepository;
    private final CursoRepository cursoRepository;
    private final List<ValidadorCadastroTopico> validadoresCadastro;
    private final List<ValidadorAtualizacaoTopico> validadoresAtualizacao;

    public TopicoService(TopicoRepository topicoRepository, AutorRepository autorRepository,
                         CursoRepository cursoRepository, List<ValidadorCadastroTopico> validadoresCadastro,
                         List<ValidadorAtualizacaoTopico> validadoresAtualizacao) {
        this.topicoRepository = topicoRepository;
        this.autorRepository = autorRepository;
        this.cursoRepository = cursoRepository;
        this.validadoresCadastro = validadoresCadastro;
        this.validadoresAtualizacao = validadoresAtualizacao;
    }

    public Topico construir(DadosCadastroTopico dados) {
        if (!autorRepository.existsById(dados.idAutor())) {
            throw new ValidacaoException("Não existe autor com o id informado!");
        }
        if (!cursoRepository.existsById(dados.idCurso())) {
            throw new ValidacaoException("Não existe curso com o id informado!");
        }

        validadoresCadastro.forEach(v -> v.validar(dados));

        var autor = autorRepository.getReferenceById(dados.idAutor());
        var curso = cursoRepository.getReferenceById(dados.idCurso());

        return new Topico(dados, autor, curso);
    }

    public Topico retornar(Long id) {
        return topicoRepository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Não existe tópico com o id informado!"));
    }

    public void atualizar(Long id, DadosAtualizacaoTopico dados) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Não existe tópico com este id!"));

        if (!cursoRepository.existsById(dados.idCurso())) {
            throw new ValidacaoException("Não existe curso com este id!");
        }

        validadoresAtualizacao.forEach(v -> v.validar(dados));

        var curso = cursoRepository.getReferenceById(dados.idCurso());
        topico.atualizar(dados, curso);
    }
}