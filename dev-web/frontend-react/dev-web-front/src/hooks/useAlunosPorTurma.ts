import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import type { Aluno } from "../interfaces/Aluno";


const useAlunosPorTurma = (turmaId : number | null) => {
  return useQuery<Aluno[]>({
    queryKey: ["alunos", turmaId],
    queryFn: async () => {
      if (!turmaId) return []
      const { data } = await axios.get(`http://localhost:8080/turmas/${turmaId}/alunos`)
      return data
    },
    enabled: !!turmaId
  });
}

export default useAlunosPorTurma