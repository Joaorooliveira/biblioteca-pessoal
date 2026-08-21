package dev.joaorooliveira.biblioteca_pessoal.dto;

import dev.joaorooliveira.biblioteca_pessoal.domain.Autor;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AutorAtualizarDTO(

        String nome,
        @Size(max = 100, message = "A nacionalidade deve ter no máximo 100 caracteres")
        String nacionalidade,
        @Past(message = "A data de nascimento deve ser uma data passada")
        LocalDate dataNascimento
) {

    public Autor toEntity(AutorAtualizarDTO dto) {
        Autor autor = new Autor();
        preencher(autor);
        return autor;
    }

    private void preencher(Autor autor) {
        if (nome != null) {
            autor.setNome(nome);
        }
        if (nacionalidade != null) {
            autor.setNacionalidade(nacionalidade);
        }
        if (dataNascimento != null) {
            autor.setDataNascimento(dataNascimento);
        }
    }
}
