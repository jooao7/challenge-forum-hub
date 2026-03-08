package joao.forum.forumhub.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import joao.forum.forumhub.domain.autor.AutorRepository;
import joao.forum.forumhub.domain.autor.AutorService;
import joao.forum.forumhub.domain.autor.DadosCadastroAutor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
@SecurityRequirement(name = "bearer-key")
public class AutorController {

    private final AutorService service;
    private final AutorRepository repository;

    public AutorController(AutorService service, AutorRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroAutor dados) {
        var autor = service.construir(dados);
        repository.save(autor);
        return ResponseEntity.ok(dados);
    }
}