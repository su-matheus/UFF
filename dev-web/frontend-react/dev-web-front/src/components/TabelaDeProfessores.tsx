import type { Professor } from "../interfaces/Professor";

interface Props {
  professores: Professor[];
}

const TabelaDeProfessores = ({ professores }: Props) => {
  console.log(professores);
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
          {professores.map((professor) => (
            <tr key={professor.id}>
              <td className="text-center align-middle">{professor.id}</td>
              <td className="text-center align-middle">{professor.nome}</td>
              <td className="text-center align-middle">{professor.email}</td>
              <td className="text-center align-middle"><button type="button" className="btn btn-sm btn-danger">Remover</button></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
export default TabelaDeProfessores;