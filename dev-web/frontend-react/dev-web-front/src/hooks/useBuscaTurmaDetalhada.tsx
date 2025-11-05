import { useQuery } from '@tanstack/react-query';
import { buscarTurmaAlunosPaginados } from '../services/api';

const useBuscaTurmaDetalhada = (turmaId: number | null, page: number) => {
  return useQuery({
    queryKey: ['turmaDetalhada', { turmaId, page }],

    queryFn: () => buscarTurmaAlunosPaginados(turmaId!, page, 1),

    enabled: !!turmaId, 

    placeholderData: (previousData) => previousData,

    refetchOnWindowFocus: false,

    staleTime: 1000 * 60 * 1,
  });
};

export default useBuscaTurmaDetalhada