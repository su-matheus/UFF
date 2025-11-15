import type { Disciplina } from "./Disciplina"
import type { Professor } from "./Professor"


export interface Turma {
  id: number
  nome: string
  ano: number
  periodo: string
  professor: Professor
  disciplina: Disciplina
}