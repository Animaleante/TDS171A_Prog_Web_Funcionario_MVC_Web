package com.diogo.funcionariomvc.views;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.diogo.funcionariomvc.vos.Diretor;
import com.diogo.funcionariomvc.vos.Funcionario;

@Named("funcionarioBean")
@SessionScoped
public class FuncionarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1336439914421050049L;
	
	private Funcionario funcionario;
	
	private String tipoFuncionario;

	public FuncionarioBean() {
		funcionario = new Diretor("", 0);
		tipoFuncionario = "Diretor";
	}
	
	public String incluir() {
		
		// TODO
		return "/funcionario/resultadoCadastroFuncionario";
	}

	/**
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the tipoFuncionario
	 */
	public String getTipoFuncionario() {
		return tipoFuncionario;
	}

	/**
	 * @param tipoFuncionario the tipoFuncionario to set
	 */
	public void setTipoFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
}
