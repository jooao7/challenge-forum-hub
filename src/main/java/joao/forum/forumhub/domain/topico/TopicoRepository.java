package joao.forum.forumhub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Boolean existsByTitulo(String titulo);
    Boolean existsByMensagem(String mensagem);
}