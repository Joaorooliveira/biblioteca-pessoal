package dev.joaorooliveira.biblioteca_pessoal.controller;

import dev.joaorooliveira.biblioteca_pessoal.dto.AutorAtualizarDTO;
import dev.joaorooliveira.biblioteca_pessoal.dto.AutorFiltroRequestDTO;
import dev.joaorooliveira.biblioteca_pessoal.dto.AutorRequestDTO;
import dev.joaorooliveira.biblioteca_pessoal.dto.AutorResponseDTO;
import dev.joaorooliveira.biblioteca_pessoal.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<AutorResponseDTO> salvar(@RequestBody @Valid AutorRequestDTO autorRequestDTO) {
        var autorResponseDTO = autorService.salvarAutor(autorRequestDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autorResponseDTO.id())
                .toUri();
        return ResponseEntity.created(location).body(autorResponseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<AutorResponseDTO>> buscar(AutorFiltroRequestDTO filtro,
                                                         @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(autorService.buscarAutores(filtro, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(autorService.buscarAutorPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AutorAtualizarDTO dto){
        return ResponseEntity.ok(autorService.atualizarAutor(id, dto));
    }


}

