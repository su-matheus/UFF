import { useForm } from "react-hook-form";

// import type { Aluno } from "../interfaces/Aluno";
import type { Turma } from "../interfaces/Turma";
// import type { TurmaAlunosPaginados } from "../interfaces/TurmaAlunosPaginados";
import type { AlunoTurma } from "../interfaces/AlunoTurma";
import slugify from "slugify";
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import useCadastrarAluno from "../hooks/useCadastrarAluno";
import useAlterarAluno from "../hooks/useAlterarAluno";
import useAlunoStore from "../store/alunoStore";
import useRecuperarTurmas from "../hooks/useTurmas";
import Selecao from "./Selecao";
import DisciplinaComboBox from "./DisciplinaComboBox";


interface FormAluno {
    nome: string,
    email: string,
    slug: string,
    turma: string
}

const AlunoForm = () => {
    const [turmaSelecionada, setTurmaSelecionada] = useState<Turma | null>(null);

    const { data: turmas,
        isLoading: carregandoTurmas,
        error: erroTurmas
    } = useRecuperarTurmas();

    const setMensagem = useAlunoStore((s) => s.setMensagem);
    const alunoSelecionado = useAlunoStore((s) => s.alunoSelecionado);

    const navigate = useNavigate();
    const { register, handleSubmit, reset, setValue } = useForm<FormAluno>();
    const { mutate: cadastrarAluno, error: errorCadastrarAluno } = useCadastrarAluno();
    const { mutate: alterarAluno, error: errorAlterarAluno } = useAlterarAluno();

    // if (carregandoTurmas) return <p>Carregando turmas...</p>;
    if (erroTurmas) throw erroTurmas;
    if (errorCadastrarAluno) throw errorCadastrarAluno;
    if (errorAlterarAluno) throw errorAlterarAluno;


    const inicializaForm = () => {
        if (alunoSelecionado.id) {
            setValue("nome", alunoSelecionado.nome);
            setValue("email", alunoSelecionado.email);
            setValue("turma", alunoSelecionado.turma.id.toString())
        } else {
            reset();
        }
    };

    useEffect(() => {
        inicializaForm();
    }, [alunoSelecionado]);

    const submit = ({
        nome,
        email,
        turma
    }: FormAluno) => {
        const aluno: AlunoTurma = {
            nome: nome,
            email: email,
            slug: slugify(nome, {
                lower: true,
                strict: true,
            }),
            turma: { id: +turma } as Turma,
        };
        if (alunoSelecionado.id) {
            aluno.id = alunoSelecionado.id;
            alterarAluno(aluno, {
                onSuccess: (alunoAlterado: AlunoTurma) => {
                    setMensagem("Aluno alterado com sucesso!");
                    navigate("/alunos/" + alunoAlterado.id);
                },
            });
        } else {
            cadastrarAluno(aluno, {
                onSuccess: (alunoCadastrado: AlunoTurma) => {
                    setMensagem("Aluno cadastrado com sucesso!");
                    navigate("/alunos/" + alunoCadastrado.id);
                },
            });
        }
    };


    return (
        <form onSubmit={handleSubmit(submit)} autoComplete="off">
            <div className="row">
                <div className="col-xl-6">
                    <div className="row mb-2">
                        <label htmlFor="nome" className="col-xl-2 fw-bold">
                            Nome
                        </label>
                        <div className="col-xl-10">
                            <input
                                {...register("nome")}
                                type="text"
                                id="nome"
                                className="form-control form-control-sm"
                            />
                        </div>
                    </div>
                </div>
                <div className="col-xl-6">
                    <div className="row mb-2">
                        <label htmlFor="descricao" className="col-xl-3 fw-bold">
                            Email
                        </label>
                        <div className="col-xl-9">
                            <input
                                {...register("email")}
                                type="text"
                                id="descricao"
                                className="form-control form-control-sm"
                            />
                        </div>
                    </div>
                </div>
            </div>

            <div className="row mb-1">
                <div className="col-xl-6">
                    <div className="row mb-2">
                        <label htmlFor="categoria" className="col-xl-2 fw-bold">
                            Turma
                        </label>
                        <div className="col-xl-10">
                            {/* {turmas && (
                                <Selecao
                                    turmas={turmas}
                                    turmaSelecionadaId={turmaSelecionada?.id ?? null}
                                    onSelecionarTurma={(id) => {
                                        const turma = turmas.find((t) => t.id === id) || null
                                        setTurmaSelecionada(turma)
                                    }}
                                />
                            )} */}
                            <DisciplinaComboBox value={turmaSelecionada?.id}/>
                        </div>
                    </div>
                </div>
            </div>


            <div className="row mb-5">
                <div className="col-xl-6">
                    <div className="row">
                        <div className="col-xl-10 offset-xl-2 d-flex">
                            <button
                                type="submit"
                                className="btn btn-success btn-sm d-flex align-items-center me-3"
                            >
                                {alunoSelecionado.id ? (
                                    <>
                                        {/* <img src={databaseEdit} className="me-1" /> Alterar */}
                                        Alterar
                                    </>
                                ) : (
                                    <>
                                        {/* <img src={databaseAdd} className="me-1" /> Cadastrar */}
                                        Cadastrar
                                    </>
                                )}
                            </button>
                            <button
                                onClick={() => inicializaForm()}
                                type="button"
                                className="btn btn-secondary btn-sm d-flex align-items-center"
                            >
                                {/* <img src={databaseCancel} className="me-1" /> Cancelar */}
                                Cancelar
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    );
};
export default AlunoForm;
