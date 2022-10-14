package com.ti2cc;

import java.sql.*;

public class DAO {
	private Connection conexao;

	public DAO() {
		conexao = null;
	}

	public boolean conectar() {
		String driverName = "org.postgresql.Driver";
		String serverName = "tibdsi.postgres.database.azure.com";
		String mydatabase = "azure_sys";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + mydatabase;
		String username = "adm@tibdsi";
		String password = "justBusiness!";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}

	public boolean close() {
		boolean status = false;

		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}

	public boolean inserirUsuario(Usuario usuario) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO usuario (codigo, login, senha, sexo) "
					+ "VALUES (" + usuario.getCodigo() + ", '" + usuario.getLogin() + "', '"
					+ usuario.getSenha() + "', '" + usuario.getSexo() + "');");
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean atualizarUsuario(Usuario usuario) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE usuario SET login = '" + usuario.getLogin() + "', senha = '"
					+ usuario.getSenha() + "', sexo = '" + usuario.getSexo() + "'"
					+ " WHERE codigo = " + usuario.getCodigo();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean excluirUsuario(int codigo) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM usuario WHERE codigo = " + codigo);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public Usuario[] getUsuarios() {
		Usuario[] usuarios = null;

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM usuario");
			if (rs.next()) {
				rs.last();
				usuarios = new Usuario[rs.getRow()];
				rs.beforeFirst();

				for (int i = 0; rs.next(); i++) {
					usuarios[i] = new Usuario(rs.getInt("codigo"), rs.getString("login"),
							rs.getString("senha"), rs.getString("sexo").charAt(0));
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuarios;
	}

	public Usuario[] getUsuariosMasculinos() {
		Usuario[] usuarios = null;

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE usuario.sexo LIKE 'M'");
			if (rs.next()) {
				rs.last();
				usuarios = new Usuario[rs.getRow()];
				rs.beforeFirst();

				for (int i = 0; rs.next(); i++) {
					usuarios[i] = new Usuario(rs.getInt("codigo"), rs.getString("login"),
							rs.getString("senha"), rs.getString("sexo").charAt(0));
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuarios;
	}

	public boolean inserirGrade(Grade grade) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO Grade (id) "
					+ "VALUES (" + grade.getId() + ");");
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean atualizarGrade(Grade grade) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE Grade SET id = " + grade.getId() + "WHERE id = " + grade.getId();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean excluirGrade(int id) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM Grade WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean inserirAluno(Aluno aluno) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO Aluno (id, id_objetivo) "
					+ "VALUES (" + aluno.getId() + ", " + aluno.getid_objetivo() + ");");
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean atualizarAluno(Aluno aluno) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE Aluno SET id = " + aluno.getId() + ", id_objetivo = " + aluno.getid_objetivo()
					+ "WHERE id = " + aluno.getId();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean excluirAluno(int id) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM Aluno WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean inserirCompromisso(Compromisso compromisso) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO Compromisso (id, Nome, Tipo) "
					+ "VALUES (" + compromisso.getId() + ", '" + compromisso.getNome() + "', '" + compromisso.getText()
					+ "');");
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean atualizarCompromisso(Compromisso compromisso) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE Compromisso SET id = " + compromisso.getId() + ", Nome = '" + compromisso.getNome()
					+ "', Tipo = '" + compromisso.getText() + "' WHERE id = " + compromisso.getId();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean excluirCompromisso(int id) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM Compromisso WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean inserirImprevistos(Imprevistos imprevistos) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO Imprevistos (id, Motivos, Historico, Consequencias) "
					+ "VALUES (" + imprevistos.getid() + ", '" + imprevistos.getMotivos() + "', '"
					+ imprevistos.getHistorico() + "', '" + imprevistos.getConsequencias() + "');");
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean atualizarImprevistos(Imprevistos imprevistos) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE Imprevistos SET id = " + imprevistos.getid() + ", Motivos = '"
					+ imprevistos.getMotivos() + "', Historico = " + imprevistos.getHistorico() + "', Consequencias = '"
					+ imprevistos.getConsequencias() + "' WHERE id = " + imprevistos.getid();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean excluirImprevistos(int id) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM Imprevistos WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean inserirObjetivos(Objetivos objetivo) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO Objetivos (id, Projetos, Disciplina) "
					+ "VALUES (" + objetivo.getid() + ", '" + objetivo.getProjetos() + "', '"
					+ objetivo.getDisciplinas()
					+ "');");
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean atualizarObjetivos(Objetivos objetivo) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE Objetivos SET id = " + objetivo.getid() + ", Projetos = '" + objetivo.getProjetos()
					+ "', Disciplinas = '" + objetivo.getDisciplinas() + "' WHERE id = " + objetivo.getid();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean excluirObjetivos(int id) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM Objetivos WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean inserirRotina(Rotina rotina) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO Rotina (id, Habitos) "
					+ "VALUES (" + rotina.getId() + ", '" + rotina.getHabitos() + "');");
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean atualizarRotina(Rotina rotina) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE Rotina SET id = " + rotina.getId() + ", Habitos = '" + rotina.getHabitos()
					+ "' WHERE id = " + rotina.getId();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean excluirRotina(int id) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM Rotina WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

}