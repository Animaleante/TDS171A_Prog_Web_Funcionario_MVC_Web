package com.diogo.funcionariomvc.vos;

public abstract class Funcionario
{
    private double salario;
    private String nome;

    public Funcionario(String nome, double salario)
    {
        this.nome = nome;
        this.salario = salario;
    }

    public abstract double pagarBonus();

    /**
     * @return the salario
     */
    public double getSalario()
    {
        return salario;
    }

    /**
     * @param pSalario the salario to set
     */
    public void setSalario(double pSalario)
    {
        salario = pSalario;
    }

    /**
     * @return the nome
     */
    public String getNome()
    {
        return nome;
    }

    /**
     * @param pNome the nome to set
     */
    public void setNome(String pNome)
    {
        nome = pNome;
    }
}
