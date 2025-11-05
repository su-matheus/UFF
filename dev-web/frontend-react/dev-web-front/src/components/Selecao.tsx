import React from "react";
import type { Turma } from "../interfaces/Turma";

interface Props {
  turmas: Turma[];
  turmaSelecionadaId: number | null;
  onSelecionarTurma: (id: number) => void;
}

const Selecao: React.FC<Props> = ({ turmas, turmaSelecionadaId, onSelecionarTurma }) => {
  return (
    <select
      value={turmaSelecionadaId ?? ""}
      onChange={(e) => onSelecionarTurma(Number(e.target.value))}
      className="border rounded p-2 mb-4 w-full"
    >
      <option value="">Selecione uma turma...</option>
      {turmas.map((t) => (
        <option key={t.id} value={t.id}>
          {t.nome}
        </option>
      ))}
    </select>
  );
};

export default Selecao;
