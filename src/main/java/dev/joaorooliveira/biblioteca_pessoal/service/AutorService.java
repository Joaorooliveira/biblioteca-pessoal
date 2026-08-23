package dev.joaorooliveira.biblioteca_pessoal.service;

import dev.joaorooliveira.biblioteca_pessoal.domain.Autor;
import dev.joaorooliveira.biblioteca_pessoal.dto.AutorRequestDTO;
import dev.joaorooliveira.biblioteca_pessoal.dto.AutorResponseDTO;
import dev.joaorooliveira.biblioteca_pessoal.repository.AutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Transactional
    public AutorResponseDTO salvarAutor(AutorRequestDTO dto) {
        Autor autor = autorRepository.save(dto.toEntity());
        return AutorResponseDTO.fromEntity(autor);
    }



}
