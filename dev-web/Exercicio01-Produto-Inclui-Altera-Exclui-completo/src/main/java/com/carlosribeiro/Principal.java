package com.carlosribeiro;

import com.carlosribeiro.dao.AlunoDAO;

import com.carlosribeiro.excecao.AlunoNaoEncontradoException;

import com.carlosribeiro.modelo.Aluno;

import com.carlosribeiro.util.FabricaDeDAOs;
import com.carlosribeiro.util.Util;
import corejava.Console;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Consumer;

public class Principal
{	public static void main (String[] args) 
	{
//		Logger logger = LoggerFactory.getLogger(Principal.class);
//		logger.error("Mensagem de log emitida utilizando o LOG4J");
		// fatal - error - warning - info - debug

        String alunoNome;
        String alunosEmail;
        String alunoMatricula;
        Aluno umAluno;

        AlunoDAO alunoDAO = FabricaDeDAOs.getDAO(AlunoDAO.class);

		boolean continua = true;
		while (continua)
		{	System.out.println('\n' + "O que você deseja fazer?");
			System.out.println('\n' + "1. Cadastrar um aluno");
			System.out.println("2. Alterar um aluno");
			System.out.println("3. Remover um aluno");
			System.out.println("4. Listar todos os alunos");
			System.out.println("5. Sair");
						
			int opcao = Console.readInt('\n' + 
							"Digite um número entre 1 e 5:");
					
			switch (opcao)
			{	case 1:
				{
					alunoNome = Console.readLine('\n' +
						"Informe o nome do aluno: ");
                    alunosEmail = Console.readLine("\n" +
                            "Informe o email do aluno: ");
                    alunoMatricula = Console.readLine("\n" +
                            "Informe a matricula do aluno: ");

                    umAluno = new Aluno(alunoNome, alunosEmail, alunoMatricula);
					
                    alunoDAO.inclui(umAluno);
					
					System.out.println('\n' + "Aluno número " +
					    umAluno.getId() + " incluído com sucesso!");

					break;
				}

				case 2:
				{	int resposta = Console.readInt('\n' + 
						"Digite o número do aluno que você deseja alterar: ");
										
					try
					{
                        umAluno = alunoDAO.recuperaUmAluno(resposta);
					}
					catch(AlunoNaoEncontradoException e)
					{	System.out.println('\n' + e.getMessage());
						break;
					}
										
					System.out.println('\n' + 
						"Número = " + umAluno.getId() +
						"    Nome = " + umAluno.getNome() +
						"    Email = " + umAluno.getEmail() +
                        "    Matrícula = " + umAluno.getMatricula());
												
					System.out.println('\n' + "O que você deseja alterar?");
					System.out.println('\n' + "1. Nome");
					System.out.println("2. Email");

					int opcaoAlteracao = Console.readInt('\n' + 
											"Digite um número de 1 a 2:");

					switch (opcaoAlteracao)
					{	case 1:
							String novoNome = Console.
								readLine("Digite o novo nome: ");

                            umAluno.setNome(novoNome);

							try
							{
								alunoDAO.altera(umAluno);

								System.out.println('\n' +
									"Alteração de nome efetuada com sucesso!");
							}
							catch(AlunoNaoEncontradoException e)
							{	System.out.println('\n' + e.getMessage());
							}

							break;

						case 2:
							String novoEmail = Console.
									readLine("Digite o novo email: ");

							umAluno.setEmail(novoEmail);

							try
							{
                                alunoDAO.altera(umAluno);

								System.out.println('\n' +
									"Alteração de email " +
									"com sucesso!");
							}
							catch(AlunoNaoEncontradoException e)
							{	System.out.println('\n' + e.getMessage());
							}

							break;

						default:
							System.out.println('\n' + "Opção inválida!");
					}

					break;
				}

				case 3:
				{	int resposta = Console.readInt('\n' + 
						"Digite o número do aluno que você deseja remover: ");
									
					try
					{
                        umAluno = alunoDAO.recuperaUmAluno(resposta);
					}
					catch(AlunoNaoEncontradoException e)
					{	System.out.println('\n' + e.getMessage());
						break;
					}
										
					System.out.println('\n' + 
						"Número = " + umAluno.getId() +
						"    Nome = " + umAluno.getNome());
														
					String resp = Console.readLine('\n' + 
						"Confirma a remoção do aluno? (s/n)");

					if(resp.equals("s"))
					{	try
						{
							alunoDAO.exclui (umAluno.getId());
							System.out.println('\n' + 
								"Aluno removido com sucesso!");
						}
						catch(AlunoNaoEncontradoException e)
						{	System.out.println('\n' + e.getMessage());
						}
					}
					else
					{	System.out.println('\n' + "Aluno não removido.");
					}
					
					break;
				}

				case 4:
				{
                    List<Aluno> alunos = alunoDAO.recuperaAlunos();

					for (Aluno aluno : alunos)
					{
						System.out.println('\n' +
							"Id = " + aluno.getId() +
							"  Nome = " + aluno.getNome() +
							"  Email = " + aluno.getEmail() +
							"  Matricula = " + aluno.getMatricula());
					}

					break;
				}

				case 5:
				{	continua = false;
					break;
				}

				default:
					System.out.println('\n' + "Opção inválida!");
			}
		}		
	}
}
