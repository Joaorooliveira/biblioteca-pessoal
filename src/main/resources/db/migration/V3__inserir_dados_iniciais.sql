-- 1. Fiódor Dostoiévski
INSERT INTO autores (nome, nacionalidade, data_nascimento, criado_em, atualizado_em)
VALUES ('Fiódor Dostoiévski', 'Russo', '1821-11-11', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO livros (titulo, ano_publicacao, isbn, editora, genero, autor_id, criado_em, atualizado_em)
VALUES
('Crime e Castigo', 1866, '9788572325372', 'Editora 34', 'ROMANCE', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Os Irmãos Karamázov', 1880, '9788573264098', 'Editora 34', 'ROMANCE', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('O Idiota', 1869, '9788573262551', 'Editora 34', 'ROMANCE', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Memórias do Subsolo', 1864, '9788573261547', 'Editora 34', 'FICCAO', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 2. Sigmund Freud
INSERT INTO autores (nome, nacionalidade, data_nascimento, criado_em, atualizado_em)
VALUES ('Sigmund Freud', 'Austríaco', '1856-05-06', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO livros (titulo, ano_publicacao, isbn, editora, genero, autor_id, criado_em, atualizado_em)
VALUES
('A Interpretação dos Sonhos', 1899, '9788535920369', 'Companhia das Letras', 'CIENCIA', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('O Mal-Estar na Civilização', 1930, '9788535917642', 'Companhia das Letras', 'FILOSOFIA', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Totem e Tabu', 1913, '9788535922004', 'Companhia das Letras', 'CIENCIA', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 3. Homero
INSERT INTO autores (nome, nacionalidade, data_nascimento, criado_em, atualizado_em)
VALUES ('Homero', 'Grego', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO livros (titulo, ano_publicacao, isbn, editora, genero, autor_id, criado_em, atualizado_em)
VALUES
('Ilíada', -750, '9788534612470', 'Penguin', 'POESIA', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Odisseia', -700, '9788535919639', 'Penguin', 'POESIA', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 4. Franz Kafka
INSERT INTO autores (nome, nacionalidade, data_nascimento, criado_em, atualizado_em)
VALUES ('Franz Kafka', 'Tcheco', '1883-07-03', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO livros (titulo, ano_publicacao, isbn, editora, genero, autor_id, criado_em, atualizado_em)
VALUES
('A Metamorfose', 1915, '9788535900590', 'Companhia das Letras', 'FICCAO', 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('O Processo', 1925, '9788535907407', 'Companhia das Letras', 'FICCAO', 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('O Castelo', 1926, '9788535911121', 'Companhia das Letras', 'FICCAO', 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 5. George Orwell
INSERT INTO autores (nome, nacionalidade, data_nascimento, criado_em, atualizado_em)
VALUES ('George Orwell', 'Britânico', '1903-06-25', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO livros (titulo, ano_publicacao, isbn, editora, genero, autor_id, criado_em, atualizado_em)
VALUES
('1984', 1949, '9788535914849', 'Companhia das Letras', 'FICCAO_CIENTIFICA', 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('A Revolução dos Bichos', 1945, '9788535909555', 'Companhia das Letras', 'FICCAO', 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Na Pior em Paris e Londres', 1933, '9788535908220', 'Companhia das Letras', 'BIOGRAFIA', 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 6. Machado de Assis
INSERT INTO autores (nome, nacionalidade, data_nascimento, criado_em, atualizado_em)
VALUES ('Machado de Assis', 'Brasileiro', '1839-06-21', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO livros (titulo, ano_publicacao, isbn, editora, genero, autor_id, criado_em, atualizado_em)
VALUES
('Dom Casmurro', 1899, '9788563560278', 'Nova Aguilar', 'ROMANCE', 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Memórias Póstumas de Brás Cubas', 1881, '9788525413155', 'L&PM', 'ROMANCE', 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('O Alienista', 1882, '9788576161112', 'Martin Claret', 'FICCAO', 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 7. Agatha Christie
INSERT INTO autores (nome, nacionalidade, data_nascimento, criado_em, atualizado_em)
VALUES ('Agatha Christie', 'Britânica', '1890-09-15', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO livros (titulo, ano_publicacao, isbn, editora, genero, autor_id, criado_em, atualizado_em)
VALUES
('E Não Sobrou Nenhum', 1939, '9788525055973', 'Globo Livros', 'MISTERIO', 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Assassinato no Expresso do Oriente', 1934, '9788525056000', 'Globo Livros', 'MISTERIO', 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 8. J.R.R. Tolkien
INSERT INTO autores (nome, nacionalidade, data_nascimento, criado_em, atualizado_em)
VALUES ('J.R.R. Tolkien', 'Britânico', '1892-01-03', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO livros (titulo, ano_publicacao, isbn, editora, genero, autor_id, criado_em, atualizado_em)
VALUES
('O Hobbit', 1937, '9788578274191', 'HarperCollins', 'FANTASIA', 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('A Sociedade do Anel', 1954, '9788578274207', 'HarperCollins', 'FANTASIA', 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('O Silmarillion', 1977, '9788578273644', 'HarperCollins', 'FANTASIA', 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 9. Isaac Asimov
INSERT INTO autores (nome, nacionalidade, data_nascimento, criado_em, atualizado_em)
VALUES ('Isaac Asimov', 'Americano', '1920-01-02', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO livros (titulo, ano_publicacao, isbn, editora, genero, autor_id, criado_em, atualizado_em)
VALUES
('Fundação', 1951, '9788576570653', 'Aleph', 'FICCAO_CIENTIFICA', 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Eu, Robô', 1950, '9788576571735', 'Aleph', 'FICCAO_CIENTIFICA', 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 10. Stephen King
INSERT INTO autores (nome, nacionalidade, data_nascimento, criado_em, atualizado_em)
VALUES ('Stephen King', 'Americano', '1947-09-21', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO livros (titulo, ano_publicacao, isbn, editora, genero, autor_id, criado_em, atualizado_em)
VALUES
('O Iluminado', 1977, '9788581050485', 'Suma de Letras', 'TERROR', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('It: A Coisa', 1986, '9788581050492', 'Suma de Letras', 'TERROR', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 11. Jane Austen
INSERT INTO autores (nome, nacionalidade, data_nascimento, criado_em, atualizado_em)
VALUES ('Jane Austen', 'Britânica', '1775-12-16', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO livros (titulo, ano_publicacao, isbn, editora, genero, autor_id, criado_em, atualizado_em)
VALUES
('Orgulho e Preconceito', 1813, '9788525410970', 'L&PM', 'ROMANCE', 11, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Razão e Sensibilidade', 1811, '9788525411007', 'L&PM', 'ROMANCE', 11, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);