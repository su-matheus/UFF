import { useState } from "react";
import useTurmas from "../hooks/useTurmas";
import useAlunosPorTurma from "../hooks/useAlunosPorTurma";
import Selecao from "../components/Selecao";
import TabelaDeAlunos from "../components/TabelaDeAlunos";

const ListarTurmaComAlunos = () => {
  const [turmaSelecionadaId, setTurmaSelecionadaId] = useState<number | null>(null);

  const { data: turmas,
    isLoading: carregandoTurmas,
    error: erroTurmas 
  } = useTurmas();
  const {
    data: alunos,
    isLoading: carregandoAlunos,
    error: erroAlunos,
  } = useAlunosPorTurma(turmaSelecionadaId);

  if (carregandoTurmas) return <p>Carregando turmas...</p>;
  if (erroTurmas) throw erroTurmas;

  return (
    <div className="p-4">
      <h2 className="text-xl font-semibold mb-3">Turmas e Alunos</h2>

      {turmas && (
        <Selecao
          turmas={turmas}
          turmaSelecionadaId={turmaSelecionadaId}
          onSelecionarTurma={setTurmaSelecionadaId}
        />
      )}

      {carregandoAlunos && turmaSelecionadaId && <p>Carregando alunos...</p>}
      {erroAlunos && <p>Erro ao carregar alunos.</p>}

      <TabelaDeAlunos alunos={alunos || []} />
    </div>
  );
};

export default ListarTurmaComAlunos;
