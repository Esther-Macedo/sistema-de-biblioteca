package base;
import java.util.ArrayList;
import java.util.List;

import regras.RegraAluno;
import regras.RegraProfessor;
import regras.IRegraEmprestimo;
import usuarios.AlunoGraduacao;
import usuarios.AlunoPosGraduacao;
import usuarios.Usuario;
import usuarios.Professor;

public class Repositorio {
	
	private static Repositorio instancia;
	
	private List<Usuario> usuarios = new ArrayList<>();
	private List<Livro> livros = new ArrayList<Livro>();
	
	private Repositorio() {};
	
	public static Repositorio obterInstancia() {
		if (instancia == null)
			instancia = new Repositorio();
		return instancia;
	}
	
	public Usuario obterUsuarioPorCodigo(String codigo) {
		for (Usuario usuario  : this.usuarios) {
			if(usuario.getCodigo().equals(codigo)) {
				return usuario;
			}
		}
		return null;
	}
	
	public Livro obterLivroPorCodigo(String codigo) {
		for(Livro livro : this.livros) {
			if(livro.getCodigo().equals(codigo)) {
				return livro;
			}
		}
		return null;
	}

	public void carregarMemoria(){
		IRegraEmprestimo regraGraduacao = new RegraAluno(2);
		IRegraEmprestimo regraPos = new RegraAluno(3);
		IRegraEmprestimo regraProfessor = new RegraProfessor();
		
		usuarios.add(new AlunoGraduacao("123", "João da Silva", regraGraduacao));
		usuarios.add(new AlunoPosGraduacao("456", "Luiz Fernando Rodrigues", regraPos));
		usuarios.add(new AlunoGraduacao("789", "Pedro Paulo", regraGraduacao));
		usuarios.add(new Professor("100", "Carlos Lucena", regraProfessor));

		String[] autoresPercy = {"Rick Riordan"};
		Livro percyJackson = new Livro("123", "Percy Jackson", "Intrinseca", "2ª", autoresPercy, 1999);
		percyJackson.adicionarExemplar(new Exemplar("01", percyJackson));
		livros.add(percyJackson);

		String[] autores100 = {"Ian Sommervile"};
		Livro engenhariaSoftware = new Livro("100", "Engenharia de Software", "Addison Wesley", "6ª", autores100, 2000);
		engenhariaSoftware.adicionarExemplar(new Exemplar("01", engenhariaSoftware));
		engenhariaSoftware.adicionarExemplar(new Exemplar("02", engenhariaSoftware));
		livros.add(engenhariaSoftware);

		String[] autores101 = {"Grady Booch", "James Rumbaugh", "Ivar Jacobson"};
		Livro umlGuiaUsuario = new Livro("101", "UML - Guia do Usuário", "Campus", "7ª", autores101, 2000);
		umlGuiaUsuario.adicionarExemplar(new Exemplar("03", umlGuiaUsuario));
		livros.add(umlGuiaUsuario);

		String[] autores200 = {"Steve McConnell"};
		Livro codeComplete = new Livro("200", "Code Complete", "Microsoft Press", "2ª", autores200, 2014);
		codeComplete.adicionarExemplar(new Exemplar("04", codeComplete));
		livros.add(codeComplete);

		String[] autores201 = {"Robert Martin"};
		Livro agileSoftwareDev = new Livro("201", "Agile Software Development, Principles, Patterns and Practices", "Prentice Hall", "1ª", autores201, 2002);
		agileSoftwareDev.adicionarExemplar(new Exemplar("05", agileSoftwareDev));
		livros.add(agileSoftwareDev);

		String[] autores300 = {"Martin Fowler"};
		Livro refactoring = new Livro("300", "Refactoring: Improving the Design of Existing Code", "Addison Wesley Professional", "1ª", autores300, 1999);
		refactoring.adicionarExemplar(new Exemplar("06", refactoring));
		refactoring.adicionarExemplar(new Exemplar("07", refactoring));
		livros.add(refactoring);

		String[] autores301 = {"Norman Fenton", "James Bieman"};
		Livro softwareMetrics = new Livro("301", "Software Metrics: A rigorous and Practical Approach", "CRC Press", "3ª", autores301, 2014);
		// Sem exemplares
		livros.add(softwareMetrics);

		String[] autores400 = {"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"};
		Livro designPatterns = new Livro("400", "Design Patterns: Element of Reusable Object-Oriented Software", "Addison Wesley Professional", "1ª", autores400, 1994);
		designPatterns.adicionarExemplar(new Exemplar("08", designPatterns));
		designPatterns.adicionarExemplar(new Exemplar("09", designPatterns));
		livros.add(designPatterns);

		String[] autores401 = {"Martin Fowler"};
		Livro umlDistilled = new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison Wesley Professional", "3ª", autores401, 2003);
		// Sem exemplares
		livros.add(umlDistilled);
	}
}
