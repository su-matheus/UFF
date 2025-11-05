import type { Turma } from "../interfaces/Turma";

interface Props {
    turmas: Turma[];
}

const TabelaDeTurmas = ({ turmas }: Props) => {
    console.log(turmas);
    return (
        <div className="table-responsive">
            <table className="table table-bordered table-striped table-hover table-sm">
                <thead>
                    <tr>
                        <th className="text-center align-middle">Id</th>
                        <th className="text-center align-middle">Ano</th>
                        <th className="text-center align-middle">Período</th>
                        <th className="text-center align-middle">Disciplina</th>
                        <th className="text-center align-middle">Professor</th>
                    </tr>
                </thead>
                <tbody>
                    {turmas.map((turma) => (
                        <tr key={turma.id}>
                            <td className="text-center align-middle">{turma.id}</td>
                            <td className="text-center align-middle">{turma.ano}</td>
                            <td className="text-center align-middle">{turma.periodo}</td>
                            <td className="text-center align-middle">{typeof turma.disciplina === "object" ? turma.disciplina.nome : turma.disciplina}</td>
                            <td className="text-center align-middle">{typeof turma.professor === "object" ? turma.professor.nome : turma.professor}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};
export default TabelaDeTurmas;