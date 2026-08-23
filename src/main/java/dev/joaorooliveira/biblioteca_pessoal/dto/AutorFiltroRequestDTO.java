package dev.joaorooliveira.biblioteca_pessoal.dto;

import java.time.LocalDate;

public record AutorFiltroRequest(

        String nome,
        String nacionalidade,
        LocalDate dataNascimento
) {
}
