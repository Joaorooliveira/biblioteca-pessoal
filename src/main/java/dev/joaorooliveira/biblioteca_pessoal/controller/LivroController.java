package dev.joaorooliveira.biblioteca_pessoal.controller;

import dev.joaorooliveira.biblioteca_pessoal.dto.LivroFiltroRequest;
import dev.joaorooliveira.biblioteca_pessoal.dto.LivroRequestDTO;
import dev.joaorooliveira.biblioteca_pessoal.dto.LivroResponseDTO;
import dev.joaorooliveira.biblioteca_pessoal.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<LivroResponseDTO> salvar(@RequestBody @Valid LivroRequestDTO dto) {

        LivroResponseDTO livroResponseDTO = livroService.salvarLivro(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(livroResponseDTO.id())
                .toUri();
        return ResponseEntity.created(location).body(livroResponseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<LivroResponseDTO>> buscar(LivroFiltroRequest filtro,
                                                         @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(livroService.listarLivros(pageable, filtro));
    }
}
