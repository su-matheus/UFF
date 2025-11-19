import type { Aluno } from "../interfaces/Aluno";

interface Props {
  alunos: Aluno[];
  value: number | null;
  onChange: (id: number | null) => void;
}

export default function AlunoComboBox({ alunos = [], value, onChange }: Props) {
    console.log(alunos)
  return (
    <select
      value={value ?? ""}
      onChange={(e) => onChange(e.target.value ? Number(e.target.value) : null)}
      className="form-select"
    >
      <option value="">-- selecione aluno --</option>
      {alunos.map((a) => (
        <option key={a.id} value={a.id}>
          {a.nome}
        </option>
      ))}
    </select>
  );
}
