import { keepPreviousData, useQuery } from "@tanstack/react-query";
import type { Turma } from "../interfaces/Turma";
import type { ResultadoPaginado } from "../interfaces/ResultadoPaginado";


const recuperarTurmaComPaginacao = async (queryString: QueryString): Promise<ResultadoPaginado<Turma>> => {
  
  const response = await fetch(
    "http://localhost:8080/turmas/paginacao?" + new URLSearchParams({...queryString}));
  if (!response.ok) {
    throw new Error(
      "Ocorreu um erro ao recuperar turmas com paginação. Status code: " + response.status
    );
  }
  return await response.json();
};

interface QueryString {
  pagina: string;
  tamanho: string;
  nome: string;
}

const useBuscaTurmaPaginacao = (queryString: QueryString) => {
  return useQuery({
    queryKey: ["turmas", "paginacao", queryString],
    queryFn: () => recuperarTurmaComPaginacao(queryString),
    placeholderData: keepPreviousData
  });
};
export default useBuscaTurmaPaginacao;