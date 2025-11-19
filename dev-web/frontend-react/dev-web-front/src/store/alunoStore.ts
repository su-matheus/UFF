import { create } from "zustand";
// import type { Aluno } from "../interfaces/Aluno";
import type { AlunoTurma } from "../interfaces/AlunoTurma";

interface AlunoStore {
    pagina: number;
    tamanho: number;
    nome: string;
    mensagem: string;
    alunoSelecionado: AlunoTurma;

    setPagina: (novaPagina: number) => void;
    setNome: (novoNome: string) => void;
    setMensagem: (novaMensagem: string) => void;
    setAlunoSelecionado: (novoAlunoSelecionado: AlunoTurma) => void;
}

const useAlunoStore = create<AlunoStore>((set) => ({
    pagina: 0,
    tamanho: 5,
    nome: "",
    mensagem: "",
    alunoSelecionado: {} as AlunoTurma,

    setPagina: (novaPagina: number) => set(() => ({pagina: novaPagina})),
    setNome: (novoNome: string) => set(() => ({nome: novoNome})),
    setMensagem: (novaMensagem: string) => set(() => ({mensagem: novaMensagem})),
    setAlunoSelecionado: (novoAlunoSelecionado: AlunoTurma) => set(() => ({alunoSelecionado: novoAlunoSelecionado})),
}))
export default useAlunoStore;