import type { ReactNode } from "react";

interface Props {
  paginaAtual: number;
  totalPaginas: number;
  tratarPaginacao: (paginaAtual: number) => void;
}
const Paginacao = ({ paginaAtual, totalPaginas, tratarPaginacao }: Props) => {
  const arrayDePaginas: ReactNode[] = [];

  if (totalPaginas < 2) return;

  for (let i = 0; i < totalPaginas; i++) {
    arrayDePaginas.push(
      <li key={i} className={paginaAtual === i ? "page-item active" : "page-item"}>
        <a onClick={() => tratarPaginacao(i)} className="page-link" aria-current="page">
          {i+1}
        </a>
      </li>
    );
  }
  return (
    <nav aria-label="paginação">
      <ul className="pagination">
        <li onClick={() => tratarPaginacao(paginaAtual-1)} className={paginaAtual === 0 ? "page-item disabled" : "page-item"}>
          <a className="page-link">Anterior</a>
        </li>
        {arrayDePaginas}
        <li className={paginaAtual === (totalPaginas-1) ? "page-item disabled" : "page-item"}>
          <a onClick={() => tratarPaginacao(paginaAtual+1)} className="page-link">
            Próxima
          </a>
        </li>
      </ul>
    </nav>
  );
};
export default Paginacao;

