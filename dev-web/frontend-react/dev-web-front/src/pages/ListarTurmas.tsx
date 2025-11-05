import { useState, useEffect } from "react"
import TabelaDeTurmas from "../components/TabelaDeTurmas"

const ListarTurmas = () => {
    const [turmas, setTurmas] = useState([])
    const [erros, setErros] = useState("")

    useEffect(() => {
        const getTurmas = async () => {
        try {
            const response = await fetch("http://localhost:8080/turmas");
            if (!response.ok) {
            throw new Error(
                "Ocorreu um erro ao recuperar turmas. Status code: " +
                response.status
            );
            }
            setTurmas(await response.json());
        } catch (error) {
            if (error instanceof Error) {
            setErros(error.message);
            } else {
            setErros("Ocorreu um erro desconhecido. Msg: " + error);
            }
        }
        };
        getTurmas();
    }, []);
    
    if (erros) return <p>{erros}</p>;
    if (turmas.length === 0) {
        return <p>Recuperando turmas...</p>;
    }
    return (
        <>
        <h5>Lista de Turmas</h5>
        <hr className="mt-1" />

        <TabelaDeTurmas turmas={turmas} />
        </>
    );
}
export default ListarTurmas