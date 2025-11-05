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
    private final InscricaoRepository inscricaoRepository;

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

        Aluno ino = new Aluno("Ino", "ino", "ino@id.uff");
        alunoRepository.save(ino);

        Aluno shikamaru = new Aluno("Shikamaru", "shikamaru", "shikamaru@id.uff");
        alunoRepository.save(shikamaru);

        Aluno chochi = new Aluno("Chochi", "chochi", "chochi@id.uff");
        alunoRepository.save(chochi);

        Aluno kiba = new Aluno("Kiba", "kiba", "kiba@id.uff");
        alunoRepository.save(kiba);

        Aluno hinata = new Aluno("Hinata", "hinata", "hinata@id.uff");
        alunoRepository.save(hinata);

        Aluno shino = new Aluno("Shino", "shino", "shino@id.uff");
        alunoRepository.save(shino);

        Aluno tenten = new Aluno("Tenten", "tenten", "tenten@id.uff");
        alunoRepository.save(tenten);

        Aluno neji = new Aluno("Neji", "neji", "neji@id.uff");
        alunoRepository.save(neji);

        Aluno rocklee = new Aluno("Rock lee", "rocklee", "rocklee@id.uff");
        alunoRepository.save(rocklee);

        Professor kakashi = new Professor("Kakashi", "kakashi", "kakashi@id.uff");
        professorRepository.save(kakashi);

        Professor iruka = new Professor("Iruka", "iruka", "iruka@id.uff");
        professorRepository.save(iruka);

        Professor kurenai = new Professor("Kurenai", "kurenai", "kurenai@id.uff");
        professorRepository.save(kurenai);

        Disciplina disciplina1 = new Disciplina("Bando de dados", 68);
        disciplinaRepository.save(disciplina1);

        Disciplina disciplina2 = new Disciplina("Programaçao orientada a objetos", 68);
        disciplinaRepository.save(disciplina2);

        Disciplina disciplina3 = new Disciplina("Calculo", 68);
        disciplinaRepository.save(disciplina3);

        Disciplina disciplina4 = new Disciplina("Computaçao e sociedade", 34);
        disciplinaRepository.save(disciplina4);


        Turma turma = new Turma("A1", 2025,"01",kakashi, disciplina1);
        turmaRepository.save(turma);

        Turma turma2 = new Turma("B2", 2025,"02",kakashi, disciplina2);
        turmaRepository.save(turma2);

        Turma turma3 = new Turma("C3", 2025,"02",iruka, disciplina3);
        turmaRepository.save(turma3);

        Turma turma4 = new Turma("D4", 2025,"02",kurenai, disciplina4);
        turmaRepository.save(turma4);

        Turma turma5 = new Turma("E5", 2025,"02",kurenai, disciplina4);
        turmaRepository.save(turma5);

        Inscricao inscricaoNaruto = new Inscricao(naruto, turma);
        inscricaoRepository.save(inscricaoNaruto);

        Inscricao inscricaoSakura = new Inscricao(sakura, turma);
        inscricaoRepository.save(inscricaoSakura);

        Inscricao inscricaoSakura2 = new Inscricao(sakura, turma2);
        inscricaoRepository.save(inscricaoSakura2);

        Inscricao inscricaoSakura3 = new Inscricao(sakura, turma3);
        inscricaoRepository.save(inscricaoSakura3);

        Inscricao inscricaoShikamaru = new Inscricao(shikamaru, turma3);
        inscricaoRepository.save(inscricaoShikamaru);

        Inscricao inscricaoNeji = new Inscricao(neji, turma3);
        inscricaoRepository.save(inscricaoNeji);

        Inscricao inscricaoSasuke = new Inscricao(sasuke, turma3);
        inscricaoRepository.save(inscricaoSasuke);

        Inscricao inscricaoHinata = new Inscricao(hinata, turma3);
        inscricaoRepository.save(inscricaoHinata);

        Inscricao inscricaoShino = new Inscricao(shino, turma3);
        inscricaoRepository.save(inscricaoShino);

        Inscricao inscricaoIno = new Inscricao(ino, turma4);
        inscricaoRepository.save(inscricaoIno);

    }
}
