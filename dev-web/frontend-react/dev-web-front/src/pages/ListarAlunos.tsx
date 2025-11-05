import { useState, useEffect } from "react"
import TabelaDeAlunos from "../components/TabelaDeAlunos"

const ListarAlunos = () => {
    const [alunos, setAlunos] = useState([])
    const [erros, setErros] = useState("")

    console.log("1, 9")
    useEffect(() => {
        console.log("4");
        const getProfessores = async () => {
        console.log("6");
        try {
            const response = await fetch("http://localhost:8080/alunos");
            if (!response.ok) {
            throw new Error(
                "Ocorreu um erro ao recuperar produtos. Status code: " +
                response.status
            );
            }
            console.log("8");
            setAlunos(await response.json());
        } catch (error) {
            if (error instanceof Error) {
            setErros(error.message);
            } else {
            setErros("Ocorreu um erro desconhecido. Msg: " + error);
            }
        }
        };
        console.log("5");
        getProfessores();
        console.log("7");
    }, []);
    console.log("2, 10");
    
    if (erros) return <p>{erros}</p>;
    if (alunos.length === 0) {
        console.log("3");
        return <p>Recuperando alunos...</p>;
    }
    console.log("11");
    return (
        <>
        <h5>Lista de Alunos</h5>
        <hr className="mt-1" />

        <TabelaDeAlunos alunos={alunos} />
        </>
    );
}
export default ListarAlunos