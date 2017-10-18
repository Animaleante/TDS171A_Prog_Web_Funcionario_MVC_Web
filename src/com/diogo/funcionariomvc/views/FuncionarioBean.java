package com.diogo.funcionariomvc.views;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.diogo.funcionariomvc.controllers.FuncionarioController;
import com.diogo.funcionariomvc.vos.Diretor;
import com.diogo.funcionariomvc.vos.Funcionario;
import com.diogo.funcionariomvc.vos.Professor;
import com.diogo.funcionariomvc.vos.Secretario;

@Named("funcionarioBean")
@SessionScoped
public class FuncionarioBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1336439914421050049L;

	private FuncionarioController controller;

	private String nomeFuncionario;
	private double salarioFuncionario;
    private String tipoFuncionario;

	public FuncionarioBean() {
	    controller = new FuncionarioController();

	    setNomeFuncionario("");
	    setSalarioFuncionario(0d);
	    setTipoFuncionario("");
	}

	public String incluir() {
	    Funcionario funcionario = null;
	    FacesContext context = FacesContext.getCurrentInstance();

	    switch(getTipoFuncionario()) {
	        case "1":
	            funcionario = new Diretor(getNomeFuncionario(), getSalarioFuncionario());
	            break;
	        case "2":
                funcionario = new Secretario(getNomeFuncionario(), getSalarioFuncionario());
	            break;
	        case "3":
                funcionario = new Professor(getNomeFuncionario(), getSalarioFuncionario());
	            break;
	        default:
	            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tipo de funcionario invalido!", null));
	            return "/funcionario/cadastroFuncionario";
	    }

	    if(controller.incluir(funcionario)) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Foi incluido!", null));
	    } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi incluido!", null));
	    }

        setNomeFuncionario("");
        setSalarioFuncionario(0d);
        setTipoFuncionario("");

		return "/funcionario/resultadoCadastroFuncionario";
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

    /**
     * @return the nomeFuncionario
     */
    public String getNomeFuncionario()
    {
        return nomeFuncionario;
    }

    /**
     * @param pNomeFuncionario the nomeFuncionario to set
     */
    public void setNomeFuncionario(String pNomeFuncionario)
    {
        nomeFuncionario = pNomeFuncionario;
    }

    /**
     * @return the salarioFuncionario
     */
    public double getSalarioFuncionario()
    {
        return salarioFuncionario;
    }

    /**
     * @param pSalarioFuncionario the salarioFuncionario to set
     */
    public void setSalarioFuncionario(double pSalarioFuncionario)
    {
        salarioFuncionario = pSalarioFuncionario;
    }
}
