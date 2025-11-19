import { useQuery } from "@tanstack/react-query";
import type { Aluno } from "../interfaces/Aluno";

// const recuperarAlunosDisponiveis = async (turmaId: number | null) => {
//     const data = await fetch(`/turmas/${turmaId}/alunos-disponiveis`)
//     if (!data.ok){
//         throw new Error(
//             "Ocorreu um erro ao recuperar alunos disponíveis. Status code: " + data.status
//         )
//     }
//     return await data.json()
// }

// const recuperarAlunosDisponiveis = async (turmaId: number | null) => {
//     const resAlunos = await fetch("/alunos");
//     const resInscricoes = fetch(`/turmas/${turmaId}/inscritos`);
//     // const inscritosIds = (inscritos as any[]).map((i) => i.aluno.id);
//     const inscricaoId = (resInscricoes as unknown as unknown[]).map((i) => i.aluno.id)
//     // const inscricaoId = (await resInscricoes).arrayBuffer
//     return todos.filter((a) => !inscritosIds.includes(a.id));
// }

// const useRecuperarAlunosDisponiveis = (turmaId: number | null) => {
//     return useQuery<Aluno[]>({
//         queryKey: ["turmas", turmaId],
//         queryFn: () => recuperarAlunosDisponiveis(turmaId),
//         enabled: !!turmaId
//     })
// }
// import { useQuery } from "@tanstack/react-query";
// import type { Aluno } from "../interfaces/Aluno";

async function fetchJson<T>(url: string) {
  const res = await fetch(url);
  if (!res.ok) {
    throw new Error(`[${res.status}] ${res.statusText}`);
  }
  return (await res.json()) as T;
}

export default function useAlunosDisponiveis(turmaId: number | null) {
  return useQuery<Aluno[]>({
    queryKey: ["alunosDisponiveis", turmaId],
    queryFn: async () => {
      if (!turmaId) return [];
      try {
        // tenta buscar pelo endpoint específico
        return await fetchJson<Aluno[]>(`http://localhost:8080/turmas/${turmaId}/alunos-disponiveis`);
      } catch {
        // fallback: busca todos e filtra manualmente
        const todos = await fetchJson<Aluno[]>("http://localhost:8080/alunos");
        const inscritos = await fetchJson<any[]>(`http://localhost:8080/turmas/${turmaId}/inscricoes`);
        const inscritosIds = inscritos.map((i) => i.aluno.id);
        return todos.filter((a) => !inscritosIds.includes(a.id));
      }
    },
    enabled: !!turmaId,
  });
}

