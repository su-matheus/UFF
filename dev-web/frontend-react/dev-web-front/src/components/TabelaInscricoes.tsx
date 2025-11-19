import type { Inscricao } from "../interfaces/Inscricao";

interface Props {
  inscritos: Inscricao[];
  page: number;
  perPage: number;
  setPage: (p: number) => void;
  onRemover?: (inscricaoId: number) => void;
}

export default function TabelaInscricoes({ inscritos, page, perPage, setPage, onRemover }: Props) {
  const total = inscritos.length;
  const totalPages = Math.max(1, Math.ceil(total / perPage));
  const start = page * perPage;
  const pageItems = inscritos.slice(start, start + perPage);

  return (
    <>
      <table className="table table-sm">
        <thead>
          <tr>
            <th>Inscrição</th>
            <th>Aluno</th>
            <th>Matrícula</th>
            <th>Ação</th>
          </tr>
        </thead>
        <tbody>
          {pageItems.map((ins) => (
            <tr key={ins.id}>
              <td>{ins.aluno.id}</td>
              <td>{ins.aluno.nome}</td>
              <td>{ins.aluno.email ?? "-"}</td>
              <td>
                {onRemover && (
                  <button className="btn btn-sm btn-danger" onClick={() => onRemover(ins.aluno.id)}>
                    Remover
                  </button>
                )}
              </td>
            </tr>
          ))}
          {pageItems.length === 0 && (
            <tr><td colSpan={4} className="text-center">Nenhum inscrito</td></tr>
          )}
        </tbody>
      </table>

      <nav>
        <ul className="pagination">
          <li className={`page-item ${page === 0 ? "disabled" : ""}`}>
            <button className="page-link" onClick={() => setPage(Math.max(0, page - 1))}>Anterior</button>
          </li>
          {Array.from({ length: totalPages }, (_, i) => (
            <li key={i} className={`page-item ${page === i ? "active" : ""}`}>
              <button className="page-link" onClick={() => setPage(i)}>{i + 1}</button>
            </li>
          ))}
          <li className={`page-item ${page === totalPages - 1 ? "disabled" : ""}`}>
            <button className="page-link" onClick={() => setPage(Math.min(totalPages - 1, page + 1))}>Próxima</button>
          </li>
        </ul>
      </nav>
    </>
  );
}
