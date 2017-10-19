package com.diogo.funcionariomvc.views;

import java.util.List;

import com.diogo.funcionariomvc.controllers.FuncionarioController;
import com.diogo.funcionariomvc.utils.Leitor;
import com.diogo.funcionariomvc.vos.Diretor;
import com.diogo.funcionariomvc.vos.Funcionario;
import com.diogo.funcionariomvc.vos.Professor;
import com.diogo.funcionariomvc.vos.Secretario;

public class FuncionarioView {
	private FuncionarioController funcionarioController;

	public FuncionarioView() {
		funcionarioController = new FuncionarioController();
		
		while (menu() != 9) {
		}
	}

	private int menu() {
		System.out.println(" --- Menu ---");

		System.out.println("1 - Incluir Funcionario");
		System.out.println("2 - Listar Funcionarios");
		System.out.println("9 - Sair");

		int op = -1;
		op = Leitor.readInt();

		switch (op) {
			case 1:
				incluir();
				break;
			case 2:
				listar();
				break;
			case 9:
				System.out.println("At� mais!");
				break;
			default:
				System.out.println("Opcao escolhida invalida!\n");
				break;
		}

		return op;
	}

	private void incluir() {
		String nome = "";
		Double salario = 0.0;
		int tipo = -1;
		
		nome = Leitor.readString("Digite o nome do funcionario: ");
		salario = Leitor.readDouble("Digite o valor do salario do funcionario: ");
		tipo = Leitor.readInt("Digite o tipo desse funcionario(1-Diretor, 2-Secretario, 3-Professor): ", new int[] {1,2,3}); 
		
		Funcionario funcionario = null;
		switch(tipo) {
			case 1:
				funcionario = new Diretor(nome, salario);
				break;
			case 2:
				funcionario = new Secretario(nome, salario);
				break;
			case 3:
				funcionario = new Professor(nome, salario);
				break;
		}
		
		System.out.println("Incluindo...");
		if(funcionarioController.incluir(funcionario))
			System.out.println("Funcionario incluido com sucesso!");
		else 
			System.out.println("N�o foi possivel inserir esse funcionario.");
	}

	private void listar() {
		List<Funcionario> list = funcionarioController.listarAll();
		
		if(list == null) {
			System.out.println("Houve um erro ao tentar listar os funcionarios.");
		} else if(list.isEmpty()) {
			System.out.println("A lista de funcionarios esta vazia.");
		} else {
			System.out.println("Lista de funcionarios:");
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println("Funcionario: " + list.get(i).getNome() + ", Salario: " + list.get(i).getSalario() + ", Tipo: " + (list.get(i) instanceof Diretor ? "Diretor" : (list.get(i) instanceof Secretario ? "Secretario" : "Professor")));
			}
			
			System.out.println("");
		}
	}
}
