package dev.joaorooliveira.biblioteca_pessoal.dto;

import dev.joaorooliveira.biblioteca_pessoal.domain.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AutorRequestDTO(

        @NotBlank(message = "O nome do autor é obrigatório")
        String nome,

        @Size(max = 100, message = "A nacionalidade do autor deve ter no máximo 100 caracteres")
        String nacionalidade,

        @Past(message = "A data de nascimento do autor deve ser uma data passada")
        LocalDate dataNascimento
) {

    public Autor toEntity() {
        Autor autor = new Autor();
        preencher(autor);
        return autor;
    }

    private void preencher(Autor autor) {
        autor.setNome(this.nome);
        autor.setNacionalidade(this.nacionalidade);
        autor.setDataNascimento(this.dataNascimento);
    }
}
