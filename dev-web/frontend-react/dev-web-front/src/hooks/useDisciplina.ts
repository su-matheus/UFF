import { useQuery } from "@tanstack/react-query";
import type { Disciplina } from "../interfaces/Disciplina";

const recuperarDisciplinas = async () => {
  const resposta = await fetch("http://localhost:8080/disciplinas")
  if (!resposta.ok) {
    throw new Error(
      "Ocorreu um erro ao recuperar disciplinas. Status code: " + resposta.status
    )
  }
  return await resposta.json()
}


const useRecuperarDisciplina = () => {
  return useQuery<Disciplina[]>({
    queryKey: ["disciplinas"],
    queryFn: () => recuperarDisciplinas(),
    staleTime: 10_000,
  })
}

export default useRecuperarDisciplina