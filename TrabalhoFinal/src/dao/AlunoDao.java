package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Aluno;

public class AlunoDao {
	
	public void create(Aluno aluno)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "insert into aluno(nome,sexo) values (?, ?)";
		
		try {
			
			
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			stmt.setString(1, aluno.getNome()); //primeiro parametro da query
			stmt.setString(2, aluno.getSexo()); //segundo parametro
			
			stmt.executeUpdate();
			System.out.println("[AlunoDAO] Aluno incluido com sucesso");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}
	
	//ler todos os registros da tabela aluno
	public List<Aluno> readAll()
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = " select matricula,nome,sexo from aluno";
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		try{
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Aluno aluno = new Aluno();
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setSexo(rs.getString("sexo"));
				
				alunos.add(aluno);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Erro ao tentar ler tabela aluno");
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
		return alunos;
		
	}
	
	public String testeValido (String mat){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select matricula from Aluno where matricula = (?)";
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, mat);
			
			rs = stmt.executeQuery();
			
			if(!rs.next())
			{
				mat = null;
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		
		return mat;
		
	}
	
	public String update(Aluno aluno, String mat)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String resp = null;
		
		String sql = "update Aluno set matricula = (?), nome = (?), sexo = (?) where matricula = (?) ";
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, aluno.getMatricula());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getSexo());
			stmt.setString(4, mat);
			
			stmt.executeUpdate();
			
			resp = "Aluno atualizado com sucesso";
		} catch (SQLException e) {
			e.printStackTrace();
			resp = "Aluno não atualizado";
		}
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		return resp;
	}
	

	public String delete(String mat)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String resp;
		
		String sql = "delete from Aluno where matricula = (?)";
		
		try {
			
			stmt = con.prepareStatement(sql); //instancia uma instrução sql
			stmt.setString(1, mat);//primeiro parametro da query
			
			stmt.executeUpdate();
			
			resp = "Aluno excluido com sucesso";
		} catch (SQLException e) {
			e.printStackTrace();
			resp = "Aluno não excluido com sucesso";
		}
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		
		return resp;
	}
	

}
