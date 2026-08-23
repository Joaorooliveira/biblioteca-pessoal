package dev.joaorooliveira.biblioteca_pessoal.dto;

import dev.joaorooliveira.biblioteca_pessoal.domain.Autor;
import dev.joaorooliveira.biblioteca_pessoal.domain.Livro;
import dev.joaorooliveira.biblioteca_pessoal.enums.GeneroLivro;
import jakarta.validation.constraints.Size;

public record LivroAtualizarDTO(

        @Size(min = 1, max = 20, message = "O ISBN deve ter entre 1 e 20 caracteres")
        String isbn,

        @Size(min = 1, max = 255, message = "O título deve ter entre 1 e 255 caracteres")
        String titulo,

        @Size(max = 4, message = "O ano de publicação deve ter no máximo 4 caracteres")
        Integer anoPublicacao,

        @Size(max = 255, message = "A editora deve ter no máximo 255 caracteres")
        String editora,

        Long autorId,

        @Size(max = 100, message = "O gênero deve ter no máximo 100 caracteres")
        GeneroLivro genero
) {

    public void preencher(Livro livro){
        if (this.isbn != null) {
            livro.setIsbn(this.isbn);
        }
        if (this.titulo != null) {
            livro.setTitulo(this.titulo);
        }
        if (this.anoPublicacao != null) {
            livro.setAnoPublicacao(this.anoPublicacao);
        }
        if (this.editora != null) {
            livro.setEditora(this.editora);
        }
        if (this.genero != null) {
            livro.setGenero(this.genero);
        }
    }
}
