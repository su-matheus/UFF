import type { Aluno } from './Aluno';
import type { Turma } from './Turma';
import type { Page } from './Page';

export interface TurmaAlunosPaginados extends Turma {
  alunos: Page<Aluno>;
}