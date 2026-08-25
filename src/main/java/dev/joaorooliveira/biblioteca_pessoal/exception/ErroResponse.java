package dev.joaorooliveira.biblioteca_pessoal.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErroResponse(

        LocalDateTime timestamp,
        Integer status,
        String erro,
        List<String> mensagens
) {
}
