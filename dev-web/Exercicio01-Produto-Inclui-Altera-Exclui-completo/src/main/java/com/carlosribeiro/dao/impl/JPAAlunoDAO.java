package com.carlosribeiro.dao.impl;

import com.carlosribeiro.dao.AlunoDAO;

import  com.carlosribeiro.excecao.AlunoNaoEncontradoException;

import com.carlosribeiro.modelo.Aluno;

import com.carlosribeiro.util.FabricaDeEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import java.util.List;

public class JPAAlunoDAO implements AlunoDAO
{	
	public long inclui(Aluno umAluno)
	{
		EntityManager em = null;
		EntityTransaction tx = null;

		try
		{
            em = FabricaDeEntityManager.criarEntityManager();

            tx = em.getTransaction();

            tx.begin();
            em.persist(umAluno);

            System.out.println("id = " + umAluno.getId());

            tx.commit();
			return umAluno.getId();
		}
		catch(RuntimeException e)
		{	if (tx != null)
			{
                tx.rollback();
			}
			throw e;
		}
		finally
		{
            em.close();
		}
	}

	public Aluno recuperaUmAluno(long numero) throws AlunoNaoEncontradoException
	{
		EntityManager em = null;

		try
		{
			em = FabricaDeEntityManager.criarEntityManager();
            Aluno umAluno = em.find(Aluno.class, numero);

			if(umAluno == null)
			{	throw new AlunoNaoEncontradoException("Aluno não encontrado");
			}
			return umAluno;
		}
		finally
		{   em.close();
		}
	}

	public void altera(Aluno umAluno) throws AlunoNaoEncontradoException
	{
		EntityManager em = null;
		EntityTransaction tx = null;
		Aluno aluno = null;
		try
		{
			em = FabricaDeEntityManager.criarEntityManager();
			tx = em.getTransaction();
			tx.begin();

            aluno = em.find(Aluno.class, umAluno.getId(), LockModeType.PESSIMISTIC_WRITE);

			if (aluno == null) {
                tx.rollback();
                throw new AlunoNaoEncontradoException(
                    "Aluno com id = " + umAluno.getId() + " não encontrado.");
			}
            em.merge(umAluno);

            tx.commit();
		}
		catch(RuntimeException e)
		{
			if (tx != null)
		    {   tx.rollback();
		    }
		    throw e;
		}
		finally
		{   em.close();
		}
	}

	public void exclui(long numero) throws AlunoNaoEncontradoException
	{
		EntityManager em = null;
		EntityTransaction tx = null;

		try
		{
			em = FabricaDeEntityManager.criarEntityManager();
			tx = em.getTransaction();
			tx.begin();

            Aluno aluno = em.find(Aluno.class, numero);

			if(aluno == null)
			{	tx.rollback();
				throw new AlunoNaoEncontradoException("Aluno não encontrado");
			}

            em.remove(aluno);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if (tx != null)
		    {   tx.rollback();
		    }
		    throw e;
		}
		finally
		{   em.close();
		}
	}

	public List<Aluno> recuperaAlunos()
	{
		EntityManager em = null;

		try
		{	em = FabricaDeEntityManager.criarEntityManager();

			List alunos = em
                .createQuery("select a from Aluno a order by a.id")
                .getResultList();

			return alunos;
		}
		finally
		{   em.close();
		}
	}
}