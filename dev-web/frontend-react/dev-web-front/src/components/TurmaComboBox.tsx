import useTurmasPorDisciplina from "../hooks/useTurmasPorDisciplina";

interface Props {
  disciplinaId: number | null;
  value: number | null;
  onChange: (id: number | null) => void;
}

export default function TurmaComboBox({ disciplinaId, value, onChange }: Props) {
  const {data, isLoading} = useTurmasPorDisciplina(disciplinaId)
  const turmas = data?.[0]?.turma ?? []

  return (
    <select
      disabled={isLoading || !disciplinaId}
      value={value ?? ""}
      onChange={(e) => onChange(e.target.value ? Number(e.target.value) : null)}
      className="form-select"
    >
      <option value="">-- selecione turma --</option>
      {turmas.map((t) => (
        <option key={t.id} value={t.id}>
          {t.nome ?? `Turma ${t.id}`}
        </option>
      ))}
    </select>
  );
}
