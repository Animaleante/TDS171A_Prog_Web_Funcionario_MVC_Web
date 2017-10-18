package com.diogo.funcionariomvc.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diogo.funcionariomvc.vos.Diretor;
import com.diogo.funcionariomvc.vos.Funcionario;
import com.diogo.funcionariomvc.vos.Professor;
import com.diogo.funcionariomvc.vos.Secretario;

public class FuncionarioDAO implements IFuncionarioDAO {

	public FuncionarioDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean incluir(Funcionario funcionario) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "aluno", "aluno");

			PreparedStatement sttm = connection.prepareStatement("insert into funcionarios values(?,?,?)");
			sttm.setString(1, funcionario.getNome());
			sttm.setDouble(2, funcionario.getSalario());
			sttm.setInt(3, (funcionario instanceof Professor ? 3 : (funcionario instanceof Secretario ? 2 : 1)));

			sttm.executeUpdate();

			if (sttm != null)
				sttm.close();

			sttm = null;

			return true;
		} catch (SQLException Except) {
			Except.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return false;
	}

	@Override
	public List<Funcionario> listar() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "aluno", "aluno");

			PreparedStatement sttm = connection.prepareStatement("select * from funcionarios");

			ResultSet rs = sttm.executeQuery();

			List<Funcionario> list = new ArrayList<Funcionario>();
			while(rs.next()) {
				String nome = rs.getString("nome");
				double salario = rs.getDouble("salario");

				Funcionario f = null;

				switch(rs.getInt("tipo")) {
					case 1:
						f = new Diretor(nome, salario);
						break;
					case 2:
						f = new Secretario(nome, salario);
						break;
					case 3:
						f = new Professor(nome, salario);
						break;
				}

				list.add(f);
			}

			if (sttm != null)
				sttm.close();

			sttm = null;

			return list;
		} catch (SQLException Except) {
			Except.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return null;
	}

}
