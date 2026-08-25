package dev.joaorooliveira.biblioteca_pessoal.service;

import dev.joaorooliveira.biblioteca_pessoal.domain.Autor;
import dev.joaorooliveira.biblioteca_pessoal.domain.Livro;
import dev.joaorooliveira.biblioteca_pessoal.dto.LivroAtualizarDTO;
import dev.joaorooliveira.biblioteca_pessoal.dto.LivroFiltroRequest;
import dev.joaorooliveira.biblioteca_pessoal.dto.LivroRequestDTO;
import dev.joaorooliveira.biblioteca_pessoal.dto.LivroResponseDTO;
import dev.joaorooliveira.biblioteca_pessoal.exception.EntidadeNaoEncontradaException;
import dev.joaorooliveira.biblioteca_pessoal.exception.RegraNegocioException;
import dev.joaorooliveira.biblioteca_pessoal.repository.AutorRepository;
import dev.joaorooliveira.biblioteca_pessoal.repository.LivroRepository;
import dev.joaorooliveira.biblioteca_pessoal.specification.LivroSpecification;
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
                () -> new EntidadeNaoEncontradaException("Autor não encontrado"));
        Livro livro = livroRepository.save(dto.toEntity(autor));
        return LivroResponseDTO.fromEntity(livro);
    }

    public Page<LivroResponseDTO> listarLivros(Pageable pageable, LivroFiltroRequest filtro) {
        return livroRepository.findAll(LivroSpecification.comFiltros(filtro), pageable)
                .map(LivroResponseDTO::fromEntity);
    }

    public LivroResponseDTO buscarLivroPorId(Long id) {
        Livro livro = livroRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Livro não encontrado"));
        return LivroResponseDTO.fromEntity(livro);
    }

    @Transactional
    public void deletarLivro(Long id) {
        Livro livro = livroRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Livro não encontrado"));
        livroRepository.delete(livro);
    }

    @Transactional
    public LivroResponseDTO atualizarLivro(Long id, LivroAtualizarDTO dto) {
        Livro livro = livroRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Livro não encontrado"));
        dto.preencher(livro);
        if (dto.autorId() != null) {
            Autor autor = autorRepository.findById(dto.autorId()).orElseThrow(
                    () -> new EntidadeNaoEncontradaException("Autor não encontrado"));
            livro.setAutor(autor);
        }
        livroRepository.save(livro);
        return LivroResponseDTO.fromEntity(livro);
    }
}
