package dev.joaorooliveira.biblioteca_pessoal.dto;

import java.time.LocalDate;

public record AutorFiltroRequestDTO(

        String nome,
        String nacionalidade,
        LocalDate dataNascimento
) {
}
