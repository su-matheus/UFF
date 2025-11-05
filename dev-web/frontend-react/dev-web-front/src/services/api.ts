// import type { Page } from '../';
// import type { Turma } from '../types/Turma';
// import type { TurmaComAlunosPaginados } from '../types/TurmaComAlunosPaginados';
// import type { Aluno } from '../types/Aluno';
import type { Page } from '../interfaces/Page';
import type { Aluno } from '../interfaces/Aluno';
import type { Turma } from '../interfaces/Turma';
import type { TurmaAlunosPaginados } from '../interfaces/TurmaAlunosPaginados';


const URL_API = '/api';

export const buscarAlunos = (): Promise<Aluno[]> => {
  return fetch(`${URL_API}/alunos`).then((res) => {
    if (!res.ok) {
      console.error('Erro ao buscar alunos:', res);
      throw new Error('Erro ao buscar alunos');
    }
    return res.json();
  });
};

export const buscarTurmas = (nomeDisciplina: string): Promise<Page<Turma>> => {
  const params = new URLSearchParams({
    nomeDisciplina: nomeDisciplina,
    page: '0',
    size: '20',
  });

  // const url = `http://localhost:8080/turmas?${params.toString()}`;
  const url = `http://localhost:8080/turmas`;

  return fetch(url).then((res) => {
    if (!res.ok) {
      console.error(`Erro ao buscar as turmas (${url}):`, res.status, res.statusText);
      throw new Error('Erro ao buscar as turmas');
    }
    return res.json();
  });
};

export const buscarTurmaAlunosPaginados = (turmaId: number, page = 0, size = 5,): Promise<TurmaAlunosPaginados> => {
  const params = new URLSearchParams({
    page: String(page),
    size: String(size),
  });

  const url = `${URL_API}/turmas/${turmaId}?${params.toString()}`;

  return fetch(url).then((res) => {
    if (!res.ok) {
      console.error(`Erro ao buscar dados da turma (${url}):`, res.status, res.statusText);
      throw new Error('Erro ao buscar dados da turma');
    }
    return res.json();
  });
};