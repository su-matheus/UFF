import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import type { Turma } from "../interfaces/Turma";


export default function useTurmas() {
  return useQuery<Turma[]>({
    queryKey: ["turmas"],
    queryFn: async () => {
      const { data } = await axios.get("http://localhost:8080/turmas");
      return data;
    },
  });
}
