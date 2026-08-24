package dev.joaorooliveira.biblioteca_pessoal.repository;

import dev.joaorooliveira.biblioteca_pessoal.domain.Autor;
import dev.joaorooliveira.biblioteca_pessoal.projection.QuantidadeLivrosPorAutorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long>, JpaSpecificationExecutor<Autor> {


    @Query(value = """
            SELECT a.nome,count(l) AS quantidade
            FROM livros l
            JOIN autores a
            ON l.autor_id = a.id
            GROUP BY nome
            """,
            nativeQuery = true
    )
    List<QuantidadeLivrosPorAutorProjection> quantidadeLivrosPorAutor();
}
