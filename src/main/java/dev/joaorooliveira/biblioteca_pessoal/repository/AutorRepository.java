package dev.joaorooliveira.biblioteca_pessoal.repository;

import dev.joaorooliveira.biblioteca_pessoal.domain.Autor;
import dev.joaorooliveira.biblioteca_pessoal.projection.QuantidadeLivrosPorAutorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long>, JpaSpecificationExecutor<Autor> {


    @Query(value = """
            SELECT a.nome,count(l.id) AS quantidade
            FROM livros l
            LEFT JOIN autores a
            ON l.autor_id = a.id
            GROUP BY nome
            ORDER BY quantidade DESC
            """,
            nativeQuery = true
    )
    List<QuantidadeLivrosPorAutorProjection> quantidadeLivrosPorAutor();

    @Query(value = """
            SELECT a.nome, COUNT(l.id) AS quantidade
            FROM autores a
            LEFT JOIN livros l ON a.id = l.autor_id
            WHERE a.id = :autorId
            GROUP BY a.nome
            """,
            nativeQuery = true
    )
    Optional<QuantidadeLivrosPorAutorProjection> quantidadeLivrosPorAutorId(@Param("autorId") Long id);


}
