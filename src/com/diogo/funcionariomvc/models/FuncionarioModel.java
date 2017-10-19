package com.diogo.funcionariomvc.models;

import java.util.List;

import com.diogo.funcionariomvc.vos.Funcionario;

public class FuncionarioModel implements IFuncionarioDAO {
	private FuncionarioDAO funcionarioDAO;

	public FuncionarioModel() {
		funcionarioDAO = new FuncionarioDAO();
	}

	@Override
	public boolean incluir(Funcionario funcionario) {
		return funcionarioDAO.incluir(funcionario);
	}

	@Override
	public List<Funcionario> listar() {
		return funcionarioDAO.listar();
	}

    @Override
    public List<Funcionario> listar(String nome)
    {
        return funcionarioDAO.listar(nome);
    }

}
