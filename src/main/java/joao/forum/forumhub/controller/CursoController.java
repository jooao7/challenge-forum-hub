package joao.forum.forumhub.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import joao.forum.forumhub.domain.curso.Curso;
import joao.forum.forumhub.domain.curso.CursoRepository;
import joao.forum.forumhub.domain.curso.CursoService;
import joao.forum.forumhub.domain.curso.DadosCadastroCurso;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    private final CursoService service;
    private final CursoRepository repository;

    public CursoController(CursoService service, CursoRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroCurso dados) {
        Curso curso = service.construir(dados);
        repository.save(curso);
        return ResponseEntity.ok(dados);
    }
}