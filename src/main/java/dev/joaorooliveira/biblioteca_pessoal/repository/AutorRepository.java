package dev.joaorooliveira.biblioteca_pessoal.repository;

import dev.joaorooliveira.biblioteca_pessoal.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AutorRepository extends JpaRepository<Autor, Long>, JpaSpecificationExecutor<Autor> {
}
