import { useState } from "react";
import TabelaDeTurmas from "../components/TabelaDeTurmas";
// import useRecuperarTurmaComPaginacao from "../hooks/useBuscaTurmaPaginada";
import useBuscaTurmaPaginacao from "../hooks/useBuscaTurmaPaginada";
import type { Turma } from "../interfaces/Turma";
import Paginacao from "../components/Paginacao";
import Pesquisa from "../components/Pesquisa";



const ListarTurmaPaginada = () => {
  const [pagina, setPagina] = useState(0);
  const [nome, setNome] = useState("");
  const tamanho: number = 5;

  const {
    data: resultadoPaginado,
    isPending: recuperandoTurmaComPaginacao,
    error: errorBuscarTurmaComPaginacao,
  } = useBuscaTurmaPaginacao({pagina: pagina.toString(),
                                        tamanho: tamanho.toString(),
                                        nome: nome});

  // const {
  //   mutate: removerProduto,
  //   // isPending: removendoProduto,
  //   error: errorRemocaoProduto} = useRemoverProdutoPorId(); 

//   const tratarRemocao = (id: number) => {
//     removerProduto(id);
//     setPagina(0);
//   };

  const tratarPesquisa = (nome: string) => {
    setNome(nome);
    setPagina(0);
  };

  const tratarPaginacao = (pagina: number) => {
    setPagina(pagina);
  };

  if (errorBuscarTurmaComPaginacao) throw errorBuscarTurmaComPaginacao;
  // if (errorRemocaoProduto) throw errorRemocaoProduto;
  if (recuperandoTurmaComPaginacao) return <p>Recuperando turma...</p>;
  // if (removendoProduto) return <p>Removendo um produto...</p>;

  const turmas: Turma[] = resultadoPaginado.itens;
  const totalDePaginas: number = resultadoPaginado.totalDePaginas;

  return (
    <>
      <h5>Lista de Turmas</h5>
      <hr className="mt-1" />

      <Pesquisa tratarPesquisa={tratarPesquisa} />
      <TabelaDeTurmas turmas={turmas} />
      <Paginacao
        paginaAtual={pagina}
        totalPaginas={totalDePaginas}
        tratarPaginacao={tratarPaginacao}
      />
    </>
  );
};
export default ListarTurmaPaginada;