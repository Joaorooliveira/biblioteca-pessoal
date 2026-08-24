package dev.joaorooliveira.biblioteca_pessoal.controller;

import dev.joaorooliveira.biblioteca_pessoal.dto.AutorRequestDTO;
import dev.joaorooliveira.biblioteca_pessoal.dto.AutorResponseDTO;
import dev.joaorooliveira.biblioteca_pessoal.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    public ResponseEntity<AutorResponseDTO> salvar(@RequestBody @Valid AutorRequestDTO autorRequestDTO) {
        var autorResponseDTO = autorService.salvarAutor(autorRequestDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autorResponseDTO.id())
                .toUri();
        return ResponseEntity.created(location).body(autorResponseDTO);
    }
}
