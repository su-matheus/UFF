import type { Aluno } from "../interfaces/Aluno";

interface Props {
  alunos: Aluno[];
}

const TabelaDeAlunos = ({ alunos }: Props) => {
  console.log(alunos);
  return (
    <div className="table-responsive">
      <table className="table table-bordered table-striped table-hover table-sm">
        <thead>
          <tr>
            <th className="text-center align-middle">Id</th>
            <th className="text-center align-middle">Nome</th>
            <th className="text-center align-middle">Email</th>
            <th className="text-center align-middle">Ação</th>
          </tr>
        </thead>
        <tbody>
          {alunos.map((aluno) => (
            <tr key={aluno.id}>
              <td className="text-center align-middle">{aluno.id}</td>
              <td className="text-center align-middle">{aluno.nome}</td>
              <td className="text-center align-middle">{aluno.email}</td>
              <td className="text-center align-middle"><button type="button" className="btn btn-sm btn-danger">Remover</button></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
export default TabelaDeAlunos;