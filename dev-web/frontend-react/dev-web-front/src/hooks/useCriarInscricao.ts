import { useMutation, useQueryClient } from "@tanstack/react-query";

export default function useCriarInscricao(turmaId: number | null) {
    const qc = useQueryClient();

    return useMutation({
        mutationFn: async (alunoId: number) => {
            if (!turmaId) throw new Error("turmaId inválido!");

            const response = await fetch(`http://localhost:8080/turmas/${turmaId}/inscricoes`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({ alunoId }),
            });

            if (!response.ok) {
                throw new Error("Erro ao criar inscrição");
            }

            return response.json();
        },

        onSuccess: () => {
            qc.invalidateQueries({ queryKey: ["inscricoes", turmaId] });
        },
    });
}


// import { useMutation, useQueryClient } from "@tanstack/react-query";

// export default function useCriarInscricao(turmaId: number | null) {
//     const qc = useQueryClient();
//     return useMutation({
//         mutationFn: async (alunoId: number) => {
//             const { data } = await api.post(`/turmas/${turmaId}/inscricoes`, { alunoId });
//             return data;
//         },
//         onSuccess: () => {
//             qc.invalidateQueries({ queryKey: ["inscricoes", turmaId] })
//         },
//     });
// }

