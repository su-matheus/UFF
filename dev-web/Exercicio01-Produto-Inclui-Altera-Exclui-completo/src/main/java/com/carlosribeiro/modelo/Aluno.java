package com.carlosribeiro.modelo;

import javax.persistence.*;

@Entity
@Table(name="aluno")

public class Aluno
{
    private Long id;
    private String nome;
    private String email;
    private String matricula ;


    public Aluno()
    {
    }

    public Aluno(String nome, String email, String matricula)
    {	this.nome = nome;
        this.email = email;
        this.matricula = matricula;
    }


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    public Long getId()
    {	return id;
    }

    @Column(name="nome")
    public String getNome()
    {	return nome;
    }

    @Column(name="email")
    public String getEmail()
    {   return email;
    }

    @Column(name="matricula")
    public String getMatricula()
    {   return matricula;
    }


    private void setId(Long id)
    {	this.id = id;
    }

    public void setNome(String nome)
    {	this.nome = nome;
    }

    public void setMatricula(String matricula)
    {	this.matricula = matricula;
    }

    public void setEmail(String email)
    {	this.email = email;
    }
}


