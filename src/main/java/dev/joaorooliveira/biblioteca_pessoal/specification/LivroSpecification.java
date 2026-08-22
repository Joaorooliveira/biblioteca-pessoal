package dev.joaorooliveira.biblioteca_pessoal.specification;

import dev.joaorooliveira.biblioteca_pessoal.domain.Livro;
import dev.joaorooliveira.biblioteca_pessoal.dto.LivroFiltroRequest;
import dev.joaorooliveira.biblioteca_pessoal.enums.GeneroLivro;
import org.springframework.data.jpa.domain.Specification;

public class LivroSpecification {

    public static Specification<Livro> comFiltros(LivroFiltroRequest filtro) {
        return Specification
                .where(tituloContem(filtro.titulo()))
                .and(generoIgual(filtro.genero()))
                .and(editoraContem(filtro.editora()))
                .and(anoPublicacaoIgual(filtro.anoPublicacao()))
                .and(isbnContem(filtro.isbn()));
    }

    private static Specification<Livro> isbnContem(String isbn) {
        return (root, query, cb) -> {
            if (isbn == null || isbn.isBlank()) {
                return null;
            }
            return cb.like(cb.lower(root.get("isbn")), "%" + isbn.toLowerCase() + "%");
        };
    }

    private static Specification<Livro> anoPublicacaoIgual(Integer anoPublicacao) {
        return (root, query, cb) -> {
            if (anoPublicacao == null) {
                return null;
            }
            return cb.equal(root.get("anoPublicacao"), anoPublicacao);
        };
    }

    private static Specification<Livro> editoraContem(String editora) {
        return (root, query, cb) -> {
            if (editora == null || editora.isBlank()) {
                return null;
            }
            return cb.like(cb.lower(root.get("editora")), "%" + editora.toLowerCase() + "%");
        };
    }

    private static Specification<Livro> generoIgual(GeneroLivro genero) {
        return (root, query, cb) -> {
            if (genero == null) {
                return null;
            }
            return cb.equal(root.get("genero"), genero);
        };
    }

    private static Specification<Livro> tituloContem(String titulo) {
        return (root, query, cb) -> {
            if (titulo == null || titulo.isBlank()) {
                return null;
            }
            return cb.like(cb.lower(root.get("titulo")), "%" + titulo.toLowerCase() + "%");
        };
    }


}
