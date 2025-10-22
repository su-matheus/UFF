package com.matheus;

import com.matheus.model.*;
import com.matheus.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class Application implements CommandLineRunner {

    private final AlunoRepository alunoRepository;
    private final ProfessorRepository professorRepository;
    private final TurmaRepository turmaRepository;
    private final InscricaoReposiroty inscricaoReposiroty;

    private final DisciplinaRepository disciplinaRepository;

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
        Aluno naruto = new Aluno("Naruto", "naruto", "naruto@id.uff");
        alunoRepository.save(naruto);

        Aluno sasuke = new Aluno("Sasuke", "sasuke", "sasuke@id.uff");
        alunoRepository.save(sasuke);

        Aluno sakura = new Aluno("Sakura", "sakura", "sakura@id.uff");
        alunoRepository.save(sakura);

        Professor professor = new Professor("Kakashi", "kakashi", "kakashi@id.uff");
        professorRepository.save(professor);

        Professor iruka = new Professor("Iruka", "iruka", "iruka@id.uff");
        professorRepository.save(iruka);


        Disciplina disciplina1 = new Disciplina("Bando de dados", "68H");
        disciplinaRepository.save(disciplina1);

        Disciplina disciplina2 = new Disciplina("Programaçao orientada a objetos", "68H");
        disciplinaRepository.save(disciplina2);

        Disciplina disciplina3 = new Disciplina("Calculo", "68H");
        disciplinaRepository.save(disciplina3);

        Disciplina disciplina4 = new Disciplina("Computaçao e sociedade", "34H");
        disciplinaRepository.save(disciplina4);



        Turma turma = new Turma(2025,"01",professor, disciplina2);
        turmaRepository.save(turma);

        Turma turma2 = new Turma(2025,"02",professor, disciplina4);
        turmaRepository.save(turma2);

        Inscricao inscricaoNaruto = new Inscricao(naruto, turma);
        inscricaoReposiroty.save(inscricaoNaruto);

        Inscricao inscricaoSakura = new Inscricao(sakura, turma);
        inscricaoReposiroty.save(inscricaoSakura);

        Inscricao inscricaoSakura2 = new Inscricao(sakura, turma2);
        inscricaoReposiroty.save(inscricaoSakura2);

    }
}
