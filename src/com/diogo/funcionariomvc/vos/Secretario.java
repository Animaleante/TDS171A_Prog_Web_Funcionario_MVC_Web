package com.diogo.funcionariomvc.vos;

public class Secretario extends Funcionario
{
    private static final double BONUS = 0.1;

    public Secretario(String pNome, double pSalario)
    {
        super(pNome, pSalario);
    }

    @Override
    public double pagarBonus()
    {
        return getSalario() * BONUS;
    }
}
