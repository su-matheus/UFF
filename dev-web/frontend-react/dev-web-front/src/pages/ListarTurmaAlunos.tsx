import { useState } from "react";
import useRecuperarAlunosTurma from "../hooks/useAlunosPorTurma";
import useRecuperarTurmas from "../hooks/useTurmas";
import type { Turma } from "../interfaces/Turma";
import Selecao from "../components/Selecao";
import TabelaDeAlunos from "../components/TabelaDeAlunos";

const ListarTurmaComAlunos = () => {
  const [turmaSelecionada, setTurmaSelecionada] = useState<Turma | null>(null);

  const { data: turmas,
    isLoading: carregandoTurmas,
    error: erroTurmas 
  } = useRecuperarTurmas();

  const {
    data: alunos,
    isLoading: carregandoAlunos,
    error: erroAlunos,
  } = useRecuperarAlunosTurma(turmaSelecionada?.id ?? null);

  if (carregandoTurmas) return <p>Carregando turmas...</p>;
  if (erroTurmas) throw erroTurmas;

  return (
    <div className="p-4">
      <h2 className="text-xl font-semibold mb-3">Turmas e Alunos</h2>

      {turmas && (
        <Selecao
          turmas={turmas}
          turmaSelecionadaId={turmaSelecionada?.id ?? null}
          onSelecionarTurma={(id) => {
            const turma = turmas.find((t) => t.id === id) || null
            setTurmaSelecionada(turma)
          }}
        />
      )}

      {carregandoAlunos && turmaSelecionada && <p>Carregando alunos...</p>}
      {erroAlunos && <p>Erro ao carregar alunos.</p>}

      <TabelaDeAlunos
        alunos= {alunos || []}
        codigoTurma={turmaSelecionada?.nome || null}  
      />
    </div>
  );
};

export default ListarTurmaComAlunos;