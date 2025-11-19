import { useMutation } from "@tanstack/react-query";
// import type { Aluno } from "../interfaces/Aluno";
import type { AlunoTurma } from "../interfaces/AlunoTurma";
import { queryClient } from "../main";

const alterarAluno = async (aluno: AlunoTurma) => {
  const response = await fetch("http://localhost:8080/alunos", {
    method: "PUT",
    headers: {
        "Content-type": "Application/json"
    },
    body: JSON.stringify(aluno)
  });
  if (!response.ok) {
    throw new Error(
      "Ocorreu um erro ao alterar um aluno. Status code: " + response.status
    );
  }
  return await response.json();
};

const useAlterarAluno = () => {
  return useMutation({
    mutationFn: (aluno: AlunoTurma) => alterarAluno(aluno),
    onSuccess: () => {
      queryClient.invalidateQueries({
        queryKey: ["alunos"],
        exact: false
      })      
    }
  });
};
export default useAlterarAluno;