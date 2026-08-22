package dev.joaorooliveira.biblioteca_pessoal.service;

import dev.joaorooliveira.biblioteca_pessoal.domain.Autor;
import dev.joaorooliveira.biblioteca_pessoal.domain.Livro;
import dev.joaorooliveira.biblioteca_pessoal.dto.LivroFiltroRequest;
import dev.joaorooliveira.biblioteca_pessoal.dto.LivroRequestDTO;
import dev.joaorooliveira.biblioteca_pessoal.dto.LivroResponseDTO;
import dev.joaorooliveira.biblioteca_pessoal.repository.AutorRepository;
import dev.joaorooliveira.biblioteca_pessoal.repository.LivroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    @Transactional
    public LivroResponseDTO salvarLivro(LivroRequestDTO dto) {
        Autor autor = autorRepository.findById(dto.autorId()).orElseThrow(
                () -> new RuntimeException("Autor não encontrado"));
        Livro livro = livroRepository.save(dto.toEntity(autor));
        return LivroResponseDTO.fromEntity(livro);
    }

    public Page<LivroResponseDTO> listarLivros(Pageable pageable, LivroFiltroRequest filtro) {}

    public LivroResponseDTO buscarLivroPorId(Long id) {
        Livro livro = livroRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Livro não encontrado"));
        return LivroResponseDTO.fromEntity(livro);
    }
}
