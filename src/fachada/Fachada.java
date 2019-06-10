/**
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 * 
 * Desenvolvido por:
 * 	Mauricio Pereira da Costa Junior | 2019-05-30
 **/

package fachada;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import modelo.Compromisso;
import modelo.Contato;
import modelo.Telefone;
import repositorio.Agenda;

public class Fachada {
	
	public static Agenda agenda = new Agenda();
	private static int idcompromisso = 0;
	private static Pattern padraoEmail = Pattern.compile(
			"^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9a-zA-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$");
	private static Pattern padraoNome = Pattern.compile("^[[ ]|\\p{L}*]+$");
	
	// retorna todos os objetos Contato (se termo for “”) ou retorna apenas aqueles cujos nome contém o termo
	
	public static ArrayList<Contato> listarContatosPorNome(String termo) throws Exception {
		
		ArrayList<Contato> contatos = agenda.getContatos();
		ArrayList<Contato> resultado = new ArrayList<Contato>();
		if (!contatos.isEmpty()) {
			if(termo.equals("")) {
				return contatos;
			}
			for (Contato c: contatos) {
				if(c.getNome().toLowerCase().equals(termo.toLowerCase()) || c.getNome().toLowerCase().contains(termo.toLowerCase())) {
					resultado.add(c);
				}
			}
			if(resultado.isEmpty()) {
				throw new Exception("Listar Contatos >> Nenhum contato encontrado!");
			}
			return resultado;
		}
		throw new Exception("Listar Contatos >> Nenhum contato encontrado!");
		
	};
	
	// retorna os objetos cujos números de telefone (sem ddd) contém os digitos
	
	public static ArrayList<Contato> listarContatosPorTelefone(String numero) throws Exception {
		
		ArrayList<Contato> contatos = agenda.getContatos();
		ArrayList<Contato> resultado = new ArrayList<Contato>();
		if (!contatos.isEmpty()) {
			for (Contato c: contatos) {
				if (!c.getTelefones().isEmpty()) {
					for (Telefone t: c.getTelefones()) {
						if(t.getNumero().equals(numero) || t.getNumero().contains(numero)) {
							resultado.add(c);
						}
					}
				}
			}
			if(resultado.isEmpty()) {
				throw new Exception("Listar Contatos >> Nenhum contato encontrado!");
			}
			return resultado;
		}
		throw new Exception("Listar Contatos >> Nenhum contato encontrado!");
		
	};
	
	// retorna os objetos cujos graus de proximidade são iguais ao valor
	
	public static ArrayList<Contato> listarContatosPorProximidade(int grau) throws Exception {
		
		ArrayList<Contato> contatos = agenda.getContatos();
		ArrayList<Contato> resultado = new ArrayList<Contato>();
		if (!contatos.isEmpty()) {
			for (Contato c: contatos) {
				if(c.getGrauproximidade() == grau) {
					resultado.add(c);
				}
			}
			if(resultado.isEmpty()) {
				throw new Exception("Listar Contatos >> Nenhum contato encontrado!");
			}
			return resultado;
		}
		throw new Exception("Listar Contatos >> Nenhum contato encontrado!");
		
	};
	
	// retorna todos os objetos (se termo for “”) ou retorna apenas aqueles cujos titulos contém o termo
	
	public static ArrayList<Compromisso> listarCompromissosPorTitulo(String termo) throws Exception {
		
		ArrayList<Compromisso> compromissos = agenda.getCompromissos();
		ArrayList<Compromisso> resultado = new ArrayList<Compromisso>();
		if (!compromissos.isEmpty()) {
			for (Compromisso c: compromissos) {
				if (c.getTitulo().toLowerCase().equals(termo.toLowerCase()) || c.getTitulo().toLowerCase().contains(termo.toLowerCase())) {
					resultado.add(c);
				}
			}
			if(resultado.isEmpty()) {
				throw new Exception("Listar Compromissos >> Nenhum compromisso encontrado!");
			}
			return resultado;
		}
		throw new Exception("Listar Compromissos >> Nenhum compromisso encontrado!");
		
	}
	
	// retorna objetos cujas datahora estejam dentro do intervalo data1 e data2
	
	public static ArrayList<Compromisso> listarCompromissosPorDatas(LocalDateTime data1, LocalDateTime data2) throws Exception {
		
		ArrayList<Compromisso> compromissos = agenda.getCompromissos();
		ArrayList<Compromisso> resultado = new ArrayList<Compromisso>();
		if (!compromissos.isEmpty()) {
			for (Compromisso c: compromissos) {
				if ((c.getDatahora().isAfter(data1) && c.getDatahora().isBefore(data2)) || c.getDatahora().equals(data1) || c.getDatahora().equals(data2)) {
					resultado.add(c);
				}
			}
			if(resultado.isEmpty()) {
				throw new Exception("Listar Compromissos >> Nenhum compromisso encontrado!");
			}
			return resultado;
		}
		throw new Exception("Listar Compromissos >> Nenhum compromisso encontrado!");
		
	}
	
	// retorna objetos do tipo solicitado
	
	public static ArrayList<Compromisso> listarCompromissosPorTipo(String tipo) throws Exception{
		
		ArrayList<Compromisso> compromissos = agenda.getCompromissos();
		ArrayList<Compromisso> resultado = new ArrayList<Compromisso>();
		if (!compromissos.isEmpty()) {
			for (Compromisso c: compromissos) {
				if (c.getTipo().equals(tipo)) {
					resultado.add(c);
				}
			}
			if(resultado.isEmpty()) {
				throw new Exception("Listar Compromissos >> Nenhum compromisso encontrado!");
			}
			return resultado;
		}
		throw new Exception("Listar Compromissos >> Nenhum compromisso encontrado!");
		
	}
	
	// retorna todos os objetos Telefone da agenda
	
	public static ArrayList<Telefone> listarTelefones(){
		return agenda.getTelefones();
		
	}
	
	// cria um objeto Contato e adiciona na Agenda
	
	public static Contato cadastrarContato(String nome,String email,String cep,String endereco, String numero,
			String link,int grau,int dia,int mes) throws Exception {
		
		///////////////////////////////////////////////////////////// VALIDACOES

		Matcher alvoEmail = padraoEmail.matcher(email);
		if(!alvoEmail.matches())
			throw new Exception("Email inválido!");
		
		Matcher alvoNome = padraoNome.matcher(nome);
		if(!alvoNome.matches())
			throw new Exception("Nome inválido!");
		
		///////////////////////////////////////////////////////// FIM VALIDACOES
		
		Contato contato = agenda.localizarContato(nome);
		if(contato != null) {
			throw new Exception("Cadastrar Contato >> Contato já existe! >> " + nome);
		}
		contato = new Contato(nome, email,cep, endereco, numero, link, grau, dia, mes);
		agenda.adicionar(contato);
		return contato;
	}
	
	public static Contato cadastrarContatoNome(String nome) throws Exception {
		
		Matcher alvoNome = padraoNome.matcher(nome);
		if(!alvoNome.matches())
			throw new Exception("Nome inválido!");
		
		Contato contato = agenda.localizarContato(nome);
		if(contato != null) {
			throw new Exception("Cadastrar Contato >> Contato já existe! >> " + nome);
		}
		contato = new Contato(nome);
		agenda.adicionar(contato);
		return contato;
	}
	
	// cria um objeto Telefone e adiciona ao objeto Contato (e vice-versa) e adiciona na Agenda
	
	public static void adicionarTelefone(String nome, String ddd, String numero) throws  Exception {
		
		Contato contato = agenda.localizarContato(nome);
		if (contato == null) {
			throw new Exception("Adicionar Telefone >> Contato não cadastrado! >> " + nome);
		}
		
		Telefone telefone1 = agenda.localizarTelefone(numero);
		if (telefone1 == null) {
			telefone1 = new Telefone(ddd,numero);
			agenda.adicionar(telefone1);
			contato.adicionar(telefone1);
			telefone1.adicionar(contato);
		} else {
			Telefone telefone2 = contato.localizarTelefone(numero);
			if(telefone2 != null) {
				throw new Exception("Adicionar Telefone >> Contato já possui este número! >> " + numero);
			}
			contato.adicionar(telefone1);
			telefone1.adicionar(contato);
		}
		
	}
	
	// remove um objeto Telefone de um objeto Contato (e vice-versa), mas não o remove da Agenda
	
	public static void removerTelefone(String nome, String numero) throws Exception {
		
		Contato contato = agenda.localizarContato(nome);
		if (contato == null) {
			throw new Exception("Remover Telefone >> Contato não cadastrado! >> " + nome);
		}
		Telefone telefone = contato.localizarTelefone(numero);
		if (telefone == null) {
			throw new Exception("Remover Telefone >> Contato não possui este número >> " + numero);
		}
		contato.remover(telefone);
		Contato c2 = telefone.localizarContato(nome);
		if (c2 == null) {
			throw new Exception("Remover Telefone >> Telefone não possui este contato >> " + nome);
		}
		telefone.remover(c2);
	}
	
	// cria um objeto Compromisso e adiciona na Agenda
	
	public static Compromisso cadastrarCompromisso(String titulo, int dia, int mes, int ano, int hora, int minuto, String tipo) {
		idcompromisso++;
		LocalDateTime data = LocalDateTime.of(ano, mes, dia, hora, minuto);
		Compromisso compromisso = new Compromisso(idcompromisso, titulo, data , tipo);
		agenda.adicionar(compromisso);
		return compromisso;
	}
	
	// retorna o nome dos contatos que tem 2 telefones ou mais
	
	public static ArrayList<String> consulta1() throws Exception {
		
		ArrayList<Contato> contatos = agenda.getContatos();
		ArrayList<String> resultado = new ArrayList<String>();
		if (!contatos.isEmpty()) {
			for (Contato c: contatos) {
				if(c.getTelefones().size() >= 2) {
					resultado.add(c.getNome());
				}
			}
			if(resultado.isEmpty()) {
				throw new Exception("Consulta 1 >> Nenhum contato encontrado!");
			}
			return resultado;
		}
		throw new Exception("Consulta 1 >> Nenhum contato encontrado!");
		
	}
	
	// retorna o numero de telefone que tem 2 contatos ou mais
	
	public static ArrayList<String> consulta2() throws Exception {
		
		ArrayList<Telefone> telefones = agenda.getTelefones();
		ArrayList<String> resultado = new ArrayList<String>();
		if (!telefones.isEmpty()) {
			for (Telefone t: telefones) {
				if(t.getContatos().size() >= 2) {
					resultado.add(t.getNumero());
				}
			}
			if(resultado.isEmpty()) {
				throw new Exception("Consulta 2 >> Nenhum contato encontrado!");
			}
			return resultado;
		}
		throw new Exception("Consulta 2 >> Nenhum contato encontrado!");
		
	}
	
	
	public static Contato alterarDados(String nome) throws Exception {
		if(nome.contentEquals("")) {
			throw new Exception("Campo nome vazio!");
		}
		Contato contato = agenda.localizarContato(nome);
		if(contato == null) {
			throw new Exception("Contato não encontrado!");
		}
		return contato;
	}
	
}