import { useQuery } from "@tanstack/react-query";
import type { Inscricao } from "../interfaces/Inscricao";

const recuperarInscritosTurma = async (turmaId:number | null) => {
    const data = await fetch(`http://localhost:8080/turmas/${turmaId}/inscricoes`);
    if (!data.ok){
        throw new Error(
            "Ocorreu um erro ao recuperar inscrições. Status code: " + data.status
        )
    }
    return await data.json()
}

const useRecuperarInscritosTurma = (turmaId: number | null) => {
    return useQuery<Inscricao[]>({
        queryKey: ["inscricoes", turmaId],
        queryFn: () => recuperarInscritosTurma(turmaId),
        enabled: !!turmaId
    })
}

export default useRecuperarInscritosTurma