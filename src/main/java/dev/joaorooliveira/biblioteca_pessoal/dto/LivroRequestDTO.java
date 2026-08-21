package dev.joaorooliveira.biblioteca_pessoal.dto;

import dev.joaorooliveira.biblioteca_pessoal.domain.Livro;
import dev.joaorooliveira.biblioteca_pessoal.enums.GeneroLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public record LivroRequestDTO(

        @Size(max = 20, message = "O ISBN deve ter no máximo 20 caracteres")
        String isbn,

        @Size(max = 255, message = "O título deve ter no máximo 255 caracteres")
        @NotBlank(message = "O título não pode ser nulo ou vazio")
        String titulo,

        @Past(message = "O ano de publicação deve ser uma data passada")
        Integer anoPublicacao,

        @Size(max = 100, message = "O gênero deve ter no máximo 100 caracteres")
        GeneroLivro genero,

        @Size(max = 255, message = "A editora deve ter no máximo 255 caracteres")
        String editora,

        @NotNull(message = "O ID do autor não pode ser nulo")
        Long autorId
) {

    public Livro toEntity() {
        Livro livro = new Livro();
        livro.setIsbn(this.isbn);
        livro.setTitulo(this.titulo);
        livro.setAnoPublicacao(this.anoPublicacao);
        livro.setGenero(this.genero);
        livro.setEditora(this.editora);
        return livro;
    }


}
