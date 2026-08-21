package dev.joaorooliveira.biblioteca_pessoal.service;

import dev.joaorooliveira.biblioteca_pessoal.repository.LivroRepository;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }


}
