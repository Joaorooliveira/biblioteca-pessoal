package dev.joaorooliveira.biblioteca_pessoal.specification;

import dev.joaorooliveira.biblioteca_pessoal.domain.Autor;
import dev.joaorooliveira.biblioteca_pessoal.dto.AutorFiltroRequestDTO;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class AutorSpecification {

    public static Specification<Autor> comFiltros(AutorFiltroRequestDTO filtro){
        return Specification
                .where(nomeContem(filtro.nome()))
                .and(nacionalidadeContem(filtro.nacionalidade()))
                .and(dataNascimentoIgual(filtro.dataNascimento()));
    }

    private static Specification<Autor> nomeContem(String nome) {
        return (root, query, cb) -> {
            if (nome == null || nome.isBlank()) {
                return null;
            }
            return cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
        };
    }
    private static Specification<Autor> nacionalidadeContem(String nacionalidade) {
        return (root, query, cb) -> {
            if (nacionalidade == null || nacionalidade.isBlank()) {
                return null;
            }
            return cb.like(cb.lower(root.get("nacionalidade")), "%" + nacionalidade.toLowerCase() + "%");
        };
    }

    private static Specification<Autor> dataNascimentoIgual(LocalDate data) {
        return (root, query, cb) -> {
            if (data == null) {
                return null;
            }
            return cb.equal(root.get("dataNascimento"), data);
        };
    }
}
