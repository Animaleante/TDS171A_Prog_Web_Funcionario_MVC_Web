package com.diogo.funcionariomvc.models;

import java.util.List;

import com.diogo.funcionariomvc.vos.Funcionario;

public interface IFuncionarioDAO {
	public boolean incluir(Funcionario funcionario);
	public List<Funcionario> listar();
    public List<Funcionario> listar(String nome);
}
