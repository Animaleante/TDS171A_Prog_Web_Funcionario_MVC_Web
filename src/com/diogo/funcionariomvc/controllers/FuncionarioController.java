package com.diogo.funcionariomvc.controllers;

import java.util.List;

import com.diogo.funcionariomvc.models.FuncionarioModel;
import com.diogo.funcionariomvc.vos.Funcionario;

public class FuncionarioController {
	private FuncionarioModel funcionarioModel;
	
	public FuncionarioController() {
		funcionarioModel = new FuncionarioModel();
	}
	
	public boolean incluir(Funcionario funcionario) {
		return funcionarioModel.incluir(funcionario);
	}
	
	public List<Funcionario> listar() {
		return funcionarioModel.listar();
	}
}
