import type { Aluno } from "../interfaces/Aluno";

interface Props {
  alunos: Aluno[];
}

  const TabelaDeAlunos = ({alunos} : Props) => {

  return (
    <div className="table-responsive">
      <table className="table table-bordered table-striped table-hover table-sm">
        <thead>
          <tr>
            <th className="text-center align-middle">Id</th>
            <th className="text-center align-middle">Nome</th>
            <th className="text-center align-middle">Email</th>
          </tr>
        </thead>
        <tbody>
          {alunos.length === 0 ? (
            <tr>
              <td colSpan={4} className="text-center p-3">
                Nenhum aluno encontrado
              </td>
            </tr>
          ) : (
            alunos.map((aluno) => (
              <tr key={aluno.id}>
                <td className="p-2 border">{aluno.id}</td>
                <td className="p-2 border">{aluno.nome}</td>
                <td className="p-2 border">{aluno.email}</td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
};
export default TabelaDeAlunos;