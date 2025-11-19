import AlunoForm from "../components/AlunoForm"
import InscricaoForm from "../components/InscricaoForm"

const CadastraAluno = () => {


  return (
    <>
      <div className="mb-4">
        <h5>Cadastro de Alunos</h5>
        <hr className="mt-1" />
      </div>

      {/* <AlunoForm /> */}
      <InscricaoForm/>
    </>
  )
}
export default CadastraAluno