package joao.forum.forumhub.domain.topico;

import jakarta.persistence.*;
import joao.forum.forumhub.domain.autor.Autor;
import joao.forum.forumhub.domain.curso.Curso;
import joao.forum.forumhub.domain.resposta.Resposta;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Resposta> respostas = new ArrayList<>();

    public Topico(DadosCadastroTopico dados, Autor autor, Curso curso) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.status = Status.ABERTO;
        this.autor = autor;
        this.curso = curso;
    }

    public void atualizar(DadosAtualizacaoTopico dados, Curso curso) {
        if (dados.titulo() != null) this.titulo = dados.titulo();
        if (dados.mensagem() != null) this.mensagem = dados.mensagem();
        if (curso != null) this.curso = curso;
    }
}