import useRecuperarDisciplina from "../hooks/useDisciplina";
import type { Disciplina } from "../interfaces/Disciplina";

interface Props {
  value: number | null;
  onChange: (id: number | null) => void;
}

export default function DisciplinaComboBox({ value, onChange }: Props) {
  const { data: disciplinas = [], isLoading } = useRecuperarDisciplina();

  return (
    <select
      disabled={isLoading}
      value={value ?? ""}
      onChange={(e) => onChange(e.target.value ? Number(e.target.value) : null)}
      className="form-select"
    >
      <option value="">-- Selecione disciplina --</option>
      {disciplinas.map((d: Disciplina) => (
        <option key={d.id} value={d.id}>
          {d.nome}
        </option>
      ))}
    </select>
  );
}
