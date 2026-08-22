package dev.joaorooliveira.biblioteca_pessoal.repository;

import dev.joaorooliveira.biblioteca_pessoal.domain.Autor;
import dev.joaorooliveira.biblioteca_pessoal.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LivroRepository extends JpaRepository<Livro, Long> , JpaSpecificationExecutor<Livro> {
}
