package com.diogo.funcionariomvc.vos;

public class Diretor extends Funcionario
{
    private static final double BONUS = 0.25;

    public Diretor(String pNome, double pSalario)
    {
        super(pNome, pSalario);
    }

    @Override
    public double pagarBonus()
    {
        return getSalario() * BONUS;
    }
}
