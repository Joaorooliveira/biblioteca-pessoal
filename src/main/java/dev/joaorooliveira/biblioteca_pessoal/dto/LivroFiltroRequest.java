package dev.joaorooliveira.biblioteca_pessoal.dto;

import dev.joaorooliveira.biblioteca_pessoal.enums.GeneroLivro;

public record LivroFiltroRequest(
        String isbn,
        String titulo,
        String autor,
        GeneroLivro genero,
        Integer anoPublicacao,
        String editora
) {
}
