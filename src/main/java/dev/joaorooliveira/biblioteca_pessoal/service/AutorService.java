package dev.joaorooliveira.biblioteca_pessoal.service;

import dev.joaorooliveira.biblioteca_pessoal.domain.Autor;
import dev.joaorooliveira.biblioteca_pessoal.domain.Livro;
import dev.joaorooliveira.biblioteca_pessoal.dto.AutorAtualizarDTO;
import dev.joaorooliveira.biblioteca_pessoal.dto.AutorFiltroRequestDTO;
import dev.joaorooliveira.biblioteca_pessoal.dto.AutorRequestDTO;
import dev.joaorooliveira.biblioteca_pessoal.dto.AutorResponseDTO;
import dev.joaorooliveira.biblioteca_pessoal.projection.QuantidadeLivrosPorAutorProjection;
import dev.joaorooliveira.biblioteca_pessoal.repository.AutorRepository;
import dev.joaorooliveira.biblioteca_pessoal.repository.LivroRepository;
import dev.joaorooliveira.biblioteca_pessoal.specification.AutorSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;
    private final LivroRepository livroRepository;

    public AutorService(AutorRepository autorRepository, LivroRepository livroRepository) {
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
    }

    @Transactional
    public AutorResponseDTO salvarAutor(AutorRequestDTO dto) {
        Autor autor = autorRepository.save(dto.toEntity());
        return AutorResponseDTO.fromEntity(autor);
    }
    public Page<AutorResponseDTO> buscarAutores(AutorFiltroRequestDTO filtro, Pageable pageable) {
        return autorRepository.findAll(AutorSpecification.comFiltros(filtro), pageable)
                .map(AutorResponseDTO::fromEntity);
    }

    public AutorResponseDTO buscarAutorPorId(Long id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        return AutorResponseDTO.fromEntity(autor);
    }

    @Transactional
    public void deletarAutor(Long id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        if (livroRepository.existsByAutorId(id)) {
            throw new RuntimeException("Não é possível excluir o autor, pois ele possui livros cadastrados.");
        }
        autorRepository.delete(autor);
    }

    @Transactional
    public AutorResponseDTO atualizarAutor(Long id, AutorAtualizarDTO dto){
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        dto.preencher(autor);
        autor = autorRepository.save(autor);
        return AutorResponseDTO.fromEntity(autor);
    }

    public List<QuantidadeLivrosPorAutorProjection> quantidadeLivrosPorAutor() {
        return autorRepository.quantidadeLivrosPorAutor();
    }

}
