import type { Turma } from "./Turma";

export interface AlunoTurma {
  id?: number;
  nome: string;
  email: string;
  slug: string;
  turma: Turma;
}