import { useMutation } from "@tanstack/react-query";
// import type { Aluno } from "../interfaces/Aluno";
// import type { TurmaAlunosPaginados } from "../interfaces/TurmaAlunosPaginados";
import type { AlunoTurma } from "../interfaces/AlunoTurma";
import { queryClient } from "../main";

const cadastrarAluno = async (aluno: AlunoTurma) => {
  const response = await fetch("http://localhost:8080/alunos", {
    method: "POST",
    headers: {
        "Content-type": "Application/json"
    },
    body: JSON.stringify(aluno)
  });
  if (!response.ok) {
    throw new Error(
      "Ocorreu um erro ao cadastrar um aluno. Status code: " + response.status
    );
  }
  return await response.json();
};

const useCadastrarAluno = () => {
  return useMutation({
    mutationFn: (aluno: AlunoTurma) => cadastrarAluno(aluno),
    onSuccess: () => {
      queryClient.invalidateQueries({
        queryKey: ["aluno"],
        exact: false
      })      
    }
  });
};
export default useCadastrarAluno;