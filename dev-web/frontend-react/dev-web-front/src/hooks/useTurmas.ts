import { useQuery } from "@tanstack/react-query";
import type { Turma } from "../interfaces/Turma";


const recuperarTurmas = async () => {
  const resposta = await fetch("http://localhost:8080/turmas")
  if (!resposta.ok) {
    throw new Error(
      "Ocorreu um erro ao recuperar turmas. Status code: " + resposta.status
    )
  }
  return await resposta.json()
}


const useRecuperarTurmas = () => {
  return useQuery<Turma[]>({
    queryKey: ["turmas"],
    queryFn: () => recuperarTurmas(),
    staleTime: 10_000,
  })
}

export default useRecuperarTurmas