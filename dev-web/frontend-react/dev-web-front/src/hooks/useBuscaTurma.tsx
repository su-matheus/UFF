import { useQuery } from '@tanstack/react-query';
import { buscarTurmas } from '../services/api';


const useBuscaTurma = (nomeDisciplina: string) => {
  return useQuery({
    queryKey: ['turmas', { nomeDisciplina }],

    queryFn: () => buscarTurmas(nomeDisciplina),

    enabled: nomeDisciplina.length > 0,

    placeholderData: (previousData) => previousData,

    refetchOnWindowFocus: false,

    staleTime: 1000 * 60 * 5,
  });
};

export default useBuscaTurma