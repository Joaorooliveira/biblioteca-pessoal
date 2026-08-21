package dev.joaorooliveira.biblioteca_pessoal.domain;

import dev.joaorooliveira.biblioteca_pessoal.enums.GeneroLivro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "livros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String isbn;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(name = "ano_publicacao")
    private Integer anoPublicacao;

    @Enumerated(EnumType.STRING)
    @Column(length = 100)
    private GeneroLivro genero;

    @Column(length = 255)
    private String editora;

    @ManyToOne
    @JoinColumn(name = "autor_id",nullable = false)
    private Autor autor;

    @CreatedDate
    private LocalDateTime criadoEm;

    @LastModifiedDate
    private LocalDateTime atualizadoEm;
}
