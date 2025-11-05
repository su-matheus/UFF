import type { Disciplina } from "./Disciplina"
import type { Professor } from "./Professor"

// export interface Turma {
//   id: number;
//   ano: number
//   periodo: string;
//   professor: {
//     id: number,
//     nome: string,
//     slug: string,
//     email: string
//     }
//   disciplina: {
//     id: number,
//     nome: string,
//     cargaHoraria: number
//     };
// }

export interface Turma {
  id: number
  nome: String
  ano: number
  periodo: string
  professor: Professor
  disciplina: Disciplina
}