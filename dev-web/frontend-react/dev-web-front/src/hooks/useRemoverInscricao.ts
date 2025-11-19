import { useMutation, useQueryClient } from "@tanstack/react-query";

export default function useRemoverInscricao(turmaId: number | null) {
    const qc = useQueryClient();

    return useMutation({
        mutationFn: async (inscricaoId: number) => {
            const res = await fetch(`http://localhost:8080/inscricoes/${inscricaoId}`, {
                method: "DELETE",
            });
            if (!res.ok) {
                throw new Error(`[${res.status}] ${res.statusText}`);
            }
        },
        onSuccess: () => {
            if (turmaId) {
                qc.invalidateQueries({ queryKey: ["inscricoes", turmaId] })
                // qc.invalidateQueries({ queryKey: ["alunos-disponiveis", turmaId] })
            }
        },
    });
}
