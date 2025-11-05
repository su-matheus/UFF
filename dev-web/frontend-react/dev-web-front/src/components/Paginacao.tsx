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


// import type { ReactNode } from 'react';

// interface PaginacaoProps {
//   paginaAtual: number;
//   totalPaginas: number;
//   esta_buscando: boolean;
//   onPageChange: (page: number) => void;
// }

// const Paginacao = ({
//   paginaAtual,
//   totalPaginas,
//   onPageChange,
//   esta_buscando,
// }: PaginacaoProps) => {
//   const arrayDePaginas: ReactNode[] = [];

//   for (let i = 0; i < totalPaginas; i++) {
//     arrayDePaginas.push(
//       <li
//         key={i}
//         className={`page-item ${paginaAtual === i ? 'active' : ''} ${esta_buscando ? 'disabled' : ''
//           }`}
//       >
//         <button
//           onClick={() => onPageChange(i)}
//           className="page-link"
//           disabled={esta_buscando}
//         >
//           {i + 1}
//         </button>
//       </li>,
//     );
//   }
//   return (
//     <nav className="mt-3">
//       <ul className="pagination justify-content-center">
//         <li
//           className={`page-item ${paginaAtual === 0 ? 'disabled' : ''} ${esta_buscando ? 'disabled' : ''
//             }`}
//         >
//           <button
//             className="page-link"
//             onClick={() => onPageChange(paginaAtual - 1)}
//             disabled={paginaAtual === 0 || esta_buscando}
//           >
//             Anterior
//           </button>
//         </li>

//         {arrayDePaginas}

//         <li
//           className={`page-item ${paginaAtual === totalPaginas - 1 ? 'disabled' : ''
//             } ${esta_buscando ? 'disabled' : ''}`}
//         >
//           <button
//             className="page-link"
//             onClick={() => onPageChange(paginaAtual + 1)}
//             disabled={paginaAtual === totalPaginas - 1 || esta_buscando}
//           >
//             Próximo
//           </button>
//         </li>
//       </ul>
//     </nav>
//   );
// }

// export default Paginacao