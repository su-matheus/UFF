import { createBrowserRouter } from "react-router-dom";
import Layout from "./Layout";
import Home from "../pages/Home"
import ListarAlunos from "../pages/ListarAlunos";
import ListarProfessores from "../pages/ListarProfessores";
import ListarTurmas from "../pages/ListarTurmas";
import ListarTurmaDetalhada from "../pages/ListarTurmaDetalhada";
import ListarTurmaPaginada from "../pages/ListarTurmaPaginada";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Layout/>,
        children: [
            { path:"", element: <Home/> },
            { path: "alunos", element: <ListarAlunos/> },
            { path: "professores", element: <ListarProfessores/>},
            { path: "turmas", element: <ListarTurmas/>},
            { path: "turma-detalhada", element: <ListarTurmaDetalhada />},
            { path: "turma-paginada", element: <ListarTurmaPaginada />}
        ]
    }
])

export default router