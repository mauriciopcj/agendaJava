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

import modelo.Compromisso;
import modelo.Contato;
import modelo.Telefone;
import repositorio.Agenda;

public class Fachada {
	
	public static Agenda agenda = new Agenda();
	private static int idcompromisso = 0;
	
	// retorna todos os objetos Contato (se termo for “”) ou retorna apenas aqueles cujos nome contém o termo
	
	public static ArrayList<Contato> listarContatosPorNome(String termo) throws Exception {
		
		ArrayList<Contato> contatos = agenda.getContatos();
		ArrayList<Contato> resultado = new ArrayList<Contato>();
		if (!contatos.isEmpty()) {
			for (Contato c: contatos) {
				if(c.getNome().equals(termo) || c.getNome().contains(termo)) {
					resultado.add(c);
				}
			}
			return resultado;
		}
		throw new Exception("Listar Contatos >> Nenhum contato encontrado!");
		
	}
	
	// retorna os objetos cujos números de telefone (sem ddd) contém os digitos
	
	public static ArrayList<Contato> listarContatosPorTelefone(String digitos){
		
	}
	
	// retorna os objetos cujos graus de proximidade são iguais ao valor
	
	public static ArrayList<Contato> listarContatosPorProximidade(int valor){
		
	}
	
	// retorna todos os objetos (se termo for “”) ou retorna apenas aqueles cujos titulos contém o termo
	
	public static ArrayList<Compromisso> listarCompromissosPorTitulo(String termo){
		
	}
	
	// retorna objetos cujas datahora estejam dentro do intervalo data1 e data2
	
	public static ArrayList<Compromisso> listarCompromissosPorDatas(LocalDateTime data1, LocalDateTime data2){
		
	}
	
	// retorna objetos do tipo solicitado
	
	public static ArrayList<Compromisso> listarCompromissosPorTipo(String tipo){
		
	}
	
	// retorna todos os objetos Telefone da agenda
	
	public static ArrayList<Telefone> listarTelefones(){
		return agenda.getTelefones();
		
	}
	
	// cria um objeto Contato e adiciona na Agenda
	
	public static Contato cadastrarContato(String nome, String email, String cep, String endereco, String numero, String link, int grau, int dia, int mes) throws Exception {
		Contato contato = agenda.localizarContato(nome);
		if(contato != null) {
			throw new Exception("Cadastrar Contato >> Contato já existe! >> " + nome);
		}
		contato = new Contato(nome, email, cep, endereco, numero, link, grau, mes, dia);
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
			Telefone telefone = contato.localizarTelefone(numero);
			if(telefone != null) {
				throw new Exception("Adicionar Telefone >> Contato já possui este número! >> " + numero);
			}
			contato.adicionar(telefone);
			telefone.adicionar(contato);
		}
		
	}
	
	// remove um objeto Telefone de um objeto Contato (e vice-versa), mas não o remove da Agenda
	
	public static void removerTelefone(String nome, String numero) throws Exception {
		
		Contato contato = agenda.localizarContato(nome);
		if (contato == null) {
			throw new Exception("Remover Telefone >> Contato não cadastrado! >> " + nome);
		}
		Telefone t = contato.localizarTelefone(numero);
		if (t == null) {
			throw new Exception("Remover Telefone >> Contato não possui este número >> " + numero);
		}
		contato.remover(t);
		
	}
	
	// cria um objeto Compromisso e adiciona na Agenda
	
	public static Compromisso cadastrarCompromisso(String titulo, int dia, int mês, int ano, int hora, int minuto, String tipo) {
		
	}
	
	// retorna o nome dos contatos que tem 2 telefones ou mais
	
	public static ArrayList<String> consulta1(){
		
	}
	
	// retorna o numero de telefone que tem 2 contatos ou mais
	
	public static ArrayList<String> consulta2(){
		
	}
	
}
