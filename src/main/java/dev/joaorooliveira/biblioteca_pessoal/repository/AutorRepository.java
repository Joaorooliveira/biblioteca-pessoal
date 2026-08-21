package dev.joaorooliveira.biblioteca_pessoal.repository;

import dev.joaorooliveira.biblioteca_pessoal.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
