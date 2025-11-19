import React, { useEffect, useMemo, useState } from "react";
import DisciplinaComboBox from "./DisciplinaComboBox";
import TurmaComboBox from "./TurmaComboBox";
import AlunoComboBox from "./AlunoComboBox";
import useInscritosPorTurma from "../hooks/useInscritosPorTurma";
import useAlunosDisponiveis from "../hooks/useAlunosDisponiveis";
import useCriarInscricao from "../hooks/useCriarInscricao";
import useRemoverInscricao from "../hooks/useRemoverInscricao";
import TabelaInscricoes from "./TabelaInscricoes";
import type { Aluno } from "../interfaces/Aluno";
// import type { Inscricao } from "../interfaces/Inscricao";

export default function InscricaoForm() {
  const [disciplinaId, setDisciplinaId] = useState<number | null>(null);
  const [turmaId, setTurmaId] = useState<number | null>(null);
  const [alunoIdSelecionado, setAlunoIdSelecionado] = useState<number | null>(null);

  // 1) disciplina combo — já puxa todas
  // 2) turma combo atualiza automaticamente via hook useTurmasPorDisciplina interno

  // inscritos e alunos disponíveis para a turma
  const { data: inscritos = [], isLoading: carregandoInscritos } = useInscritosPorTurma(turmaId);
  const { data: alunosDisponiveis = [], isLoading: carregandoDisponiveis } = useAlunosDisponiveis(turmaId);

  const criarInscricao = useCriarInscricao(turmaId);
  const removerInscricao = useRemoverInscricao(turmaId);

  // paging for inscritos client-side
  const [page, setPage] = useState(0);
  const perPage = 4;

  // quando a disciplina muda -> limpar turma, alunos selecionados e inscritos exibidos (comportamento 5)
  useEffect(() => {
    setTurmaId(null);
    setAlunoIdSelecionado(null);
    setPage(0);
  }, [disciplinaId]);

  // quando a turma muda -> limpar aluno selecionado e page 0
  useEffect(() => {
    setAlunoIdSelecionado(null);
    setPage(0);
  }, [turmaId]);

  // alunosDisponiveis já deve vir do backend com apenas os não inscritos; se não, podemos filtrar localmente:
  const alunosParaCombo = useMemo(() => {
    if (!turmaId) return [];
    // alunosDisponiveis may already be correct; but if it's not, filter:
    const inscritosIds = new Set(inscritos.map((i) => i.aluno.id));
    return alunosDisponiveis.filter((a: Aluno) => !inscritosIds.has(a.id));
  }, [alunosDisponiveis, inscritos, turmaId]);

  const handleInscrever = async () => {
    if (!turmaId || !alunoIdSelecionado) return;
    try {
      await criarInscricao.mutateAsync(alunoIdSelecionado);
      setAlunoIdSelecionado(null);
      setPage(0);
    } catch (e) {
      console.error(e);
    }
  };

  const handleRemover = async (inscricaoId: number) => {
    try {
      await removerInscricao.mutateAsync(inscricaoId);
    } catch (e) {
      console.error(e);
    }
  };

  return (
    <div className="p-3 border rounded">
      <h3>Inscrição</h3>

      <div className="mb-3">
        <label>Disciplina</label>
        <DisciplinaComboBox value={disciplinaId} onChange={setDisciplinaId} />
      </div>

      <div className="mb-3">
        <label>Turma</label>
        <TurmaComboBox disciplinaId={disciplinaId} value={turmaId} onChange={setTurmaId} />
      </div>

      <div className="mb-3">
        <label>Aluno</label>
        <AlunoComboBox alunos={alunosParaCombo} value={alunoIdSelecionado} onChange={setAlunoIdSelecionado} />
      </div>

      <div className="mb-3">
        <button
          className="btn btn-primary"
          onClick={handleInscrever}
          disabled={!turmaId || !alunoIdSelecionado || criarInscricao.isLoading}
        >
          {criarInscricao.isLoading ? "Inscrevendo..." : "Inscrever Aluno"}
        </button>
      </div>
     
      <div className="mt-4">
        <h4>Alunos Inscritos</h4>
        <TabelaInscricoes inscritos={inscritos} page={page} perPage={perPage} setPage={setPage} onRemover={handleRemover} />
      </div>
    </div>
  );
}
