package dev.joaorooliveira.biblioteca_pessoal.dto;

import dev.joaorooliveira.biblioteca_pessoal.domain.Livro;
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


    public static LivroResponseDTO fromEntity(Livro livro) {
        return new LivroResponseDTO(
                livro.getId(),
                livro.getIsbn(),
                livro.getTitulo(),
                livro.getAnoPublicacao(),
                livro.getGenero(),
                livro.getEditora(),
                new AutorResponseDTO(
                        livro.getAutor().getId(),
                        livro.getAutor().getNome(),
                        livro.getAutor().getNacionalidade(),
                        livro.getAutor().getDataNascimento()
                )

        );
    }
}
