import { useState, useMemo, useEffect } from 'react';
// import { Link } from 'react-router-dom';
import { debounce } from 'lodash';

// import { useBuscaTurmas } from '../hooks/useBuscaTurmas';
import useBuscaTurmas from '../hooks/useBuscaTurma';
import useBuscaTurmaDetalhada from '../hooks/useBuscaTurmaDetalhada';
import Paginacao from '../components/Paginacao';
import type { Aluno } from '../interfaces/Aluno';

function DetalhesTurmaView({ turmaId }: { turmaId: number }) {
  const [pagina, setPagina] = useState(0);

  const { data, isLoading, isError, error, isFetching } = useBuscaTurmaDetalhada(
    turmaId,
    pagina,
  );

  useEffect(() => {
    setPagina(0);
  }, [turmaId]);

  if (isLoading) return <p>Carregando dados da turma...</p>;
  if (isError) return <p className="text-danger">{error.message}</p>;
  if (!data) return <p>Dados não encontrados.</p>;

  return (
    <div className="card shadow-sm mb-3">
      <div className="card-header">
        <h2 className="mb-0">{data.disciplina.nome}</h2>
      </div>
      <div className="card-body">
        <h5 className="card-title">Dados da Turma</h5>
        <ul className="list-group list-group-flush mb-4">
          <li className="list-group-item">
            <strong>Código:</strong> {data.id}
          </li>
          <li className="list-group-item">
            <strong>Professor:</strong> {data.professor.nome}
          </li>
          <li className="list-group-item">
            <strong>Ano/Período:</strong> {`${data.ano}.${data.periodo}`}
          </li>
        </ul>

        <h5 className="card-title mt-4">
          Alunos Inscritos: ({data.alunos.totalElements})
        </h5>
        {data.alunos.content.length > 0 ? (
          <>
            <div className="table-responsive">
              <table className="table table-bordered table-hover mb-0">
                <thead className="table-light">
                  <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Email</th>
                  </tr>
                </thead>
                <tbody>
                  {data.alunos.content.map((aluno: Aluno) => (
                    <tr key={aluno.id}>
                      <td>{aluno.id}</td>
                      <td>{aluno.nome}</td>
                      <td>{aluno.email}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
            <Paginacao
              paginaAtual={pagina}
              totalPaginas={data.alunos.totalPages}
              onPageChange={setPagina}
              esta_buscando={isFetching}
            />
          </>
        ) : (
          <p>Não há alunos inscritos nesta turma.</p>
        )}
      </div>
    </div>
  );
}

const ListarTurmaDetalhada = () => {
  const [termoBusca, setTermoBusca] = useState('');
  const [turmaSelecionadaId, setTurmaSelecionadaId] = useState<number | null>(null);

  const { data: turmasData, isLoading, isError } = useBuscaTurmas(termoBusca);

  const debouncedChangeHandler = useMemo(
    () =>
      debounce((value: string) => {
        setTermoBusca(value);
        setTurmaSelecionadaId(null);
      }, 500),
    [],
  );

  const carregarListaTurmas = () => {
    if (termoBusca.length === 0) {
      return <p className="text-muted">Pesquise no filtro acima para iniciar a busca...</p>;
    }

    if (isLoading) {
      return <p>Buscando...</p>;
    }

    if (isError) {
      return <p className="text-danger">Falha ao buscar turmas.</p>;
    }

    if (turmasData?.empty) {
      return <p>Nenhuma turma foi encontrada.</p>;
    }

    if (turmasData?.content) {
      return (
        <div className="list-group">
          {turmasData.content.map((turma) => (
            <button
              key={turma.id}
              type="button"
              className={`list-group-item list-group-item-action ${turma.id === turmaSelecionadaId ? 'active' : ''
                }`}
              onClick={() => setTurmaSelecionadaId(turma.id)}
            >
              Turma {turma.id}: {turma.disciplina.nome} ({turma.ano}.{turma.periodo})
            </button>
          ))}
        </div>
      );
    }
    return null;
  };

  return (
    <div>
      <div className="card shadow-sm mb-4">
        <div className="card-header">
          <h2 className="mb-0">Pesquisar Turmas</h2>
        </div>
        <div className="card-body">
          <input
            type="text"
            className="form-control"
            placeholder="Digite o nome da turma"
            onChange={(e) => debouncedChangeHandler(e.target.value)}
            aria-label="Pesquisar por nome da disciplina"
          />
        </div>
      </div>

      <div className="row">
        <div className="col-md-4">
          <div className="card shadow-sm">
            <div className="card-header">
              <h4 className="mb-0">Turmas Encontradas</h4>
            </div>
            <div className="card-body">
              {carregarListaTurmas()}
            </div>
          </div>
          {/* <Link to="/" className="btn btn-success mt-3">
            <i className="bi bi-arrow-left"></i> Voltar para o Início
          </Link> */}
        </div>

        <div className="col-md-8">
          {turmaSelecionadaId ? (
            <DetalhesTurmaView turmaId={turmaSelecionadaId} />
          ) : (
            <div className="card shadow-sm">
              <div
                className="card-body d-flex align-items-center justify-content-center"
                style={{ minHeight: '200px' }}
              >
                <p className="text-center text-muted"> 
                  Digite o código da disciplina na barra de busca.
                </p>
              </div>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}

export default ListarTurmaDetalhada;