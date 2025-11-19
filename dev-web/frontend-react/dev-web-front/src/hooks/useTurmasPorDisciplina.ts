import { useQuery } from "@tanstack/react-query";
import type { Turma } from "../interfaces/Turma";

interface Disciplina {
  id: number;
  nome: string;
  cargaHoraria: number;
  turma: Turma[];
}


// Função utilitária para fetch com checagem de erro e parse do JSON
async function fetchJson<T>(url: string) {
  const res = await fetch(url);
  if (!res.ok) {
    throw new Error(`[${res.status}] ${res.statusText}`);
  }
  return (await res.json()) as T;
}

export default function useTurmasPorDisciplina(disciplinaId: number | null) {
  return useQuery<Disciplina[]>({
    queryKey: ["turmas", disciplinaId],
    queryFn: async () => {
      if (!disciplinaId) return [];
      return await fetchJson<Disciplina[]>(`http://localhost:8080/disciplinas/${disciplinaId}/turmas`);
    },
    enabled: !!disciplinaId,
  });
}
