import { useQuery } from "@tanstack/react-query";
import type { Aluno } from "../interfaces/Aluno";


const recuperarAlunosTurma = async (turmaId : number | null) => {
  const resposta = await fetch(`http://localhost:8080/turmas/${turmaId}/alunos`)
  if (!resposta.ok) {
    throw new Error(
      "Ocorreu um erro ao recuperar alunos dessa turma. Status code: " + resposta.status
    )
  }
  return await resposta.json()
}

const useRecuperarAlunosTurma = (turmaId : number | null) => {
  return useQuery<Aluno[]>({
    queryKey: ["alunos", turmaId],
    queryFn: () => recuperarAlunosTurma(turmaId),
    enabled: !!turmaId
  })
}


export default useRecuperarAlunosTurma