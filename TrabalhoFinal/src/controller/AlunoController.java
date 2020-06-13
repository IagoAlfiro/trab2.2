package controller;

import java.util.ArrayList;
import java.util.List;

import dao.AlunoDao;
import model.Aluno;

public class AlunoController {
	
	public void create(Aluno aluno)
	{
		try {
			
			AlunoDao dao = new AlunoDao();

			dao.create(aluno);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro no Controller");
		}
		finally {
			System.out.println("Fim inserção");
		}
	}
	
	public List<Aluno> readAll()
	{
		List<Aluno> alunos = new ArrayList<Aluno>();
		try{
			AlunoDao dao = new AlunoDao();
			alunos = dao.readAll();		
		}
		finally {
			//System.out.println("Fim da leitura!");
		}
		
		return alunos;
	}
	
	public String testeValido(String matricula)
	{
		try {
			AlunoDao dao = new AlunoDao();
			
			matricula = dao.testeValido(matricula);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return matricula;
	}
	
	public String update(Aluno aluno, String matricula)
	{
		String resp = null;
		try {
			AlunoDao dao = new AlunoDao();
			
				resp = dao.update(aluno,matricula);
			
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return resp;
	}
	
	public String delete(String mat)
	{
		String resp = null;
		try {
			AlunoDao dao = new AlunoDao();
			
				resp = dao.delete(mat);
			
			return resp;
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
	}
	
	

}
