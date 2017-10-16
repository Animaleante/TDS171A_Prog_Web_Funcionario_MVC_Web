package com.diogo.funcionariomvc.main;

import com.diogo.funcionariomvc.controllers.FuncionarioController;
import com.diogo.funcionariomvc.vos.Diretor;
import com.diogo.funcionariomvc.vos.Funcionario;

public class MainTeste {

	public static void main(String[] args) {
		System.out.println("Inicio");

		Funcionario f = new Diretor("Fulano",10);
		
//		FuncionarioDAO fDao = new FuncionarioDAO(); 
		
//		fDao.incluir(f);
		
//		FuncionarioModel fm = new FuncionarioModel(); 
		
//		fm.incluir(f);
		
		FuncionarioController fc = new FuncionarioController();
		
		fc.incluir(f);
		
		System.out.println("Fim");
	}

}
