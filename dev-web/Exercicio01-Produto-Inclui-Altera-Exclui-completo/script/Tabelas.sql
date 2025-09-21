-- Conecte-se ao banco "dev-web-trabalho1"
-- CREATE DATABASE dev_web_trabalho1; -- só se não existir

-- Drop table se existir
--DROP TABLE IF EXISTS produto;
DROP TABLE IF EXISTS aluno;

-- Criação da tabela
CREATE TABLE aluno (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    matricula VARCHAR(10) NOT NULL,
    email VARCHAR(50) NOT NULL,
);

-- Inserindo dados
INSERT INTO aluno(nome, matricula, email)
VALUES ("Jubileu", "111111111", "jubileu@id.uff.br")

INSERT INTO aluno(nome, matricula, email)
VALUES ("Jusara", "000000000", "jusara@id.uff.br")