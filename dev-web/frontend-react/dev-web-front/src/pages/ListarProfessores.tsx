import { useState, useEffect } from "react";
import TabelaDeProfessores from "../components/TabelaDeProfessores";
// import type { Professor } from "../interfaces/Professor";

const ListarProfessores = () => {
//   let professores: Professor[] = [];
//   let erro: string = "";

//   fetch("http://localhost:8080/professores")
//     .then((response) => {
//       if (!response.ok) {
//         throw new Error(
//           "Ocorreu um erro ao recuperar produtos. Status code: " +
//             response.status
//         );
//       }
//       console.log("entrou no primeiro then");
//       console.log(response)
//       return response.json();
//     })
//     .then((profs) => {
//       professores = profs;
//       console.log("entrou no segundo then", professores);
//     })
//     .catch((error) => {
//       if (error instanceof Error) {
//         erro = error.message;
//       } else {
//         erro = "Ocorreu um erro desconhecido. Msg: " + error;
//       }
//     });

//   if (erro) return <p>{erro}</p>;
//   if (professores.length === 0) return <p>Recuperando professores...</p>;

    const[professores, setProfessores] = useState([])
    const [erros, setErros] = useState("")

    console.log("1, 9")
    useEffect(() => {
        console.log("4");
        const getProfessores = async () => {
        console.log("6");
        try {
            const response = await fetch("http://localhost:8080/professores");
            if (!response.ok) {
            throw new Error(
                "Ocorreu um erro ao recuperar produtos. Status code: " +
                response.status
            );
            }
            console.log("8");
            setProfessores(await response.json());
        } catch (error) {
            if (error instanceof Error) {
            setErros(error.message);
            } else {
            setErros("Ocorreu um erro desconhecido. Msg: " + error);
            }
        }
        };
        console.log("5");
        getProfessores();
        console.log("7");
    }, []);
    console.log("2, 10");
    
    if (erros) return <p>{erros}</p>;
    if (professores.length === 0) {
        console.log("3");
        return <p>Recuperando professores...</p>;
    }
    console.log("11");
    return (
        <>
        <h5>Lista de Professores</h5>
        <hr className="mt-1" />

        <TabelaDeProfessores professores={professores} />
        </>
    );



//   return (
//     <>
//       <h5>Lista de Professores</h5>
//       <hr className="mt-1" />

//       {/* <TabelaDeProfessores professores={professores} /> */}
//     </>
//   );
}



export default ListarProfessores
