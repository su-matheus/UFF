import { useEffect, useState } from "react";
import type { Aluno } from "../interfaces/Aluno";

interface Props {
  alunos: Aluno[]
  codigoTurma: string | null
}

  const TabelaDeAlunos = ({alunos, codigoTurma} : Props) => {
    const [grupoAlunos, setGrupoAlunos] = useState<Aluno[]>([])

    useEffect(() => {
      if (codigoTurma){
        const grupoSalvo = localStorage.getItem(codigoTurma)
        if (grupoSalvo) {
          setGrupoAlunos(JSON.parse(grupoSalvo))
        } else {
          setGrupoAlunos([])
        }
      }
    }, [codigoTurma])

    const salvarLocalStorage = (novosAlunos: Aluno[]) =>{
      if (codigoTurma) {
        localStorage.setItem(codigoTurma, JSON.stringify(novosAlunos))
      }
    }

    const botaoAlunoGrupo = (aluno: Aluno) => {
      const jaIncluido = grupoAlunos.some((a) => a.id === aluno.id)
      let novosAlunos : Aluno[]

      if (jaIncluido) {
        novosAlunos = grupoAlunos.filter((a) => a.id !== aluno.id)
      } else {
        novosAlunos = [...grupoAlunos, aluno]
      }

      setGrupoAlunos(novosAlunos)
      salvarLocalStorage(novosAlunos)
    }

    const estaNoGrupo = (alunoId: number) => 
      grupoAlunos.some((a) => a.id === alunoId)
    

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
          {alunos.length === 0 ? (
            <tr>
              <td colSpan={4} className="text-center p-3">
                Nenhum aluno encontrado
              </td>
            </tr>
          ) : (
            alunos.map((aluno) => (
              <tr key={aluno.id}>
                <td className="text-center align-middle">{aluno.id}</td>
                <td className="text-center align-middle">{aluno.nome}</td>
                <td className="text-center align-middle">{aluno.email}</td>
                <td className="text-center align-middle">
                  <button
                    className= {`btn btn-sm ${
                      estaNoGrupo(aluno.id)
                        ? "btn-danger"
                        : "btn-success"
                    }`}
                    onClick={()=> botaoAlunoGrupo(aluno)}
                  >
                    {estaNoGrupo(aluno.id) ? "Remover" : "Incluir"}
                  </button>
                </td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
};
export default TabelaDeAlunos;