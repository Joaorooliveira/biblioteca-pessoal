package dev.joaorooliveira.biblioteca_pessoal.dto;

import dev.joaorooliveira.biblioteca_pessoal.domain.Autor;

import java.time.LocalDate;

public record AutorResponseDTO(
        Long id,
        String nome,
        String nacionalidade,
        LocalDate dataNascimento
) {

    public static AutorResponseDTO fromEntity(Autor autor) {
        return new AutorResponseDTO(
                autor.getId(),
                autor.getNome(),
                autor.getNacionalidade(),
                autor.getDataNascimento()
        );
    }
}
