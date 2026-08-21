package dev.joaorooliveira.biblioteca_pessoal.dto;

import dev.joaorooliveira.biblioteca_pessoal.enums.GeneroLivro;

public record LivroResponseDTO(
        Long id,
        String isbn,
        String titulo,
        Integer anoPublicacao,
        GeneroLivro genero,
        String editora,
        AutorResponseDTO autor
) {
}
