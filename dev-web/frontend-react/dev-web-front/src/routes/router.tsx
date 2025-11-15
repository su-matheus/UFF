import { createBrowserRouter } from "react-router-dom";
import Layout from "./Layout";
import Home from "../pages/Home"
import ListarProfessores from "../pages/ListarProfessores";
import ListarTurmas from "../pages/ListarTurmas";
import ListarTurmaComAlunos from "../pages/ListarTurmaAlunos";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Layout/>,
        children: [
            { path:"", element: <Home/> },
            { path: "alunos", element: <ListarTurmaComAlunos />},
            { path: "professores", element: <ListarProfessores/>},
            { path: "turmas", element: <ListarTurmas/>},
        ]
    }
])

export default router