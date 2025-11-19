import { createBrowserRouter } from "react-router-dom";
import Layout from "./Layout";
import Home from "../pages/Home"
import ListarProfessores from "../pages/ListarProfessores";
import ListarTurmas from "../pages/ListarTurmas";
import ListarTurmaComAlunos from "../pages/ListarTurmaAlunos";
import CadastraAluno from "../pages/CadastrarAluno";
import ListarTurmaPaginada from "../pages/ListarTurmaPaginada";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Layout/>,
        children: [
            { path:"", element: <Home/> },
            { path: "alunos", element: <ListarTurmaComAlunos />},
            { path: "professores", element: <ListarProfessores/>},
            { path: "turmas", element: <ListarTurmas/>},
            { path: "turmas-barra", element: <ListarTurmaPaginada/>},
            { path: "cadastro-aluno", element: <CadastraAluno/>}
        ]
    }
])

export default router