/**
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 * 
 * Desenvolvido por:
 * 	Mauricio Pereira da Costa Junior | 2019-05-30
 **/

package aplicacaoConsole;

import java.util.ArrayList;

import fachada.Fachada;
import modelo.Compromisso;
import modelo.Telefone;

public class AplicacaoConsole {

	public static void main(String[] args) {

		// CADASTRANDO CONTATOS
		
		try { Fachada.cadastrarContato("Mauricio", "mauricio@mauricio", "58052280", "115", "mauriciojunior", 1, 9, 22);
		} catch (Exception a){ System.out.println(a.getMessage()); }
		
		try { Fachada.cadastrarContato("Mauro", "mauro@mauro", "58052280", "115", "mauriciojunior", 1, 9, 22);
		} catch (Exception a){ System.out.println(a.getMessage()); }
		
		try { Fachada.cadastrarContato("Jose", "jose@jose", "58052280", "115", "mauriciojunior", 1, 9, 22);
		} catch (Exception a){ System.out.println(a.getMessage()); }
		
		// ADICIONANDO TELEFONES AOS CONTATOS
		
		try { Fachada.adicionarTelefone("Mauricio", "83", "111111111");
		} catch (Exception a) { System.out.println(a.getMessage()); }
		
		try { Fachada.adicionarTelefone("Mauricio", "83", "222222222");
		} catch (Exception a) { System.out.println(a.getMessage()); }
		
		try { Fachada.adicionarTelefone("Mauricio", "83", "222224444");
		} catch (Exception a) { System.out.println(a.getMessage()); }
		
		try { Fachada.adicionarTelefone("Mauro", "83", "333333333");
		} catch (Exception a) { System.out.println(a.getMessage()); }
		
		try { Fachada.adicionarTelefone("Mauro", "83", "444444444");
		} catch (Exception a) { System.out.println(a.getMessage()); }
		
		try { Fachada.adicionarTelefone("Jose", "83", "555555555");
		} catch (Exception a) { System.out.println(a.getMessage()); }
		
		// CADASTRANDO COMPROMISSOS
		
		try { Fachada.cadastrarCompromisso("Casa de jéssica",10,2,2019,10,00,"aniversário");
		} catch (Exception a) { System.out.println(a.getMessage()); }
		
		try { Fachada.cadastrarCompromisso("Barzinho",20,5,2019,10,00,"festa");
		} catch (Exception a) { System.out.println(a.getMessage()); }
		
		try { Fachada.cadastrarCompromisso("Restaurante na praia",1,7,2019,10,00,"festa");
		} catch (Exception a) { System.out.println(a.getMessage()); }
		
		try { Fachada.cadastrarCompromisso("Faculdade",30,1,2019,10,00,"reunião");
		} catch (Exception a) { System.out.println(a.getMessage()); }
		
		try { Fachada.cadastrarCompromisso("Trabalho",22,4,2019,10,00,"reunião");
		} catch (Exception a) { System.out.println(a.getMessage()); }
		
		// REMOVENDO TELEFONE
		System.out.println(""
				+ "\n==================================================="
				+ "\nRemovendo o telefone 222222222 do contato Mauricio"
				+ "\n===================================================\n");
		
		try { Fachada.removerTelefone("Mauricio", "222222222");
		} catch (Exception a) { System.out.println(a.getMessage()); }
		
		try { System.out.println(Fachada.listarTelefones());
		} catch (Exception a) { System.out.println(a.getMessage()); }
		
		
		System.out.println(""
				+ "\n========================="
				+ "\nListar todos os contatos"
				+ "\n=========================\n");
		
		try {
			System.out.println(Fachada.listarContatosPorNome(""));
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		try {
			System.out.println(""
					+ "\n============================================"
					+ "\nListar contatos por parte de telefone: 3333"
					+ "\n============================================\n");
			System.out.println(Fachada.listarContatosPorTelefone("3333"));
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		try {
			System.out.println(""
					+ "\n============================================"
					+ "\nListar contatos por parte de telefone: 3355"
					+ "\n============================================\n");
			System.out.println(Fachada.listarContatosPorTelefone("3355"));
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		try {
			System.out.println(""
					+ "\n===================================="
					+ "\nListando contatos por proximidade 1!"
					+ "\n====================================\n");
			System.out.println(Fachada.listarContatosPorProximidade(1));
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		try {
			System.out.println(""
					+ "\n================================="
					+ "\nContatos com 2 telefones ou mais"
					+ "\n=================================\n");
			System.out.println(Fachada.consulta2());
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}

		try {
			System.out.println(""
					+ "\n=========================="
					+ "\nRemovendo contato Mauricio"
					+ "\n==========================\n");
			Fachada.removerContato("Mauricio");
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
//		try {
//			System.out.println(Fachada.listarContatosPorNome(""));
//		} catch (Exception a) {
//			System.out.println(a.getMessage());
//		}
		
		System.out.println(""
				+ "\n====================================="
				+ "\nListando telefone e os contatos dele"
				+ "\n=====================================");
		try {
			ArrayList<Telefone> telefones = Fachada.listarTelefones();
			for(Telefone t: telefones) {
				System.out.println("\n");
				System.out.println(t);
				System.out.println(t.getContatos());
			}
			
			System.out.println("\n"+telefones);
		} catch (Exception a) { System.out.println(a.getMessage()); }
		
		
		System.out.println(""
				+ "\n================================"
				+ "\nRemovendo compromisso da agenda"
				+ "\n================================");
		
		try {
			ArrayList<Compromisso> compromissos = Fachada.listarCompromissosPorTitulo("");
			String texto = "";
			for(Compromisso c: compromissos) {
				texto += "\n" + c.getId() + " - " + c.getTitulo() + " - " + c.getDatahora() + " - " + c.getTipo();
			}
			System.out.println(texto);
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		System.out.println(""
				+ "\n==============="
				+ "\nRemovendo Id 1"
				+ "\n===============");
		try {
			Fachada.removerCompromisso(1);
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		try {
			ArrayList<Compromisso> compromissos = Fachada.listarCompromissosPorTitulo("");
			String texto = "";
			for(Compromisso c: compromissos) {
				texto += "\n" + c.getId() + " - " + c.getTitulo() + " - " + c.getDatahora() + " - " + c.getTipo();
			}
			System.out.println(texto);
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		System.out.println(""
				+ "\n==============="
				+ "\nRemovendo Id 2"
				+ "\n===============");
		try {
			Fachada.removerCompromisso(2);
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		try {
			ArrayList<Compromisso> compromissos = Fachada.listarCompromissosPorTitulo("");
			String texto = "";
			for(Compromisso c: compromissos) {
				texto += "\n" + c.getId() + " - " + c.getTitulo() + " - " + c.getDatahora() + " - " + c.getTipo();
			}
			System.out.println(texto);
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		System.out.println(""
				+ "\n==============="
				+ "\nRemovendo Id 4"
				+ "\n===============");
		try {
			Fachada.removerCompromisso(4);
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		try {
			ArrayList<Compromisso> compromissos = Fachada.listarCompromissosPorTitulo("");
			String texto = "";
			for(Compromisso c: compromissos) {
				texto += "\n" + c.getId() + " - " + c.getTitulo() + " - " + c.getDatahora() + " - " + c.getTipo();
			}
			System.out.println(texto);
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		
		System.out.println(""
				+ "\n================================="
				+ "\nCadastrando compromisso em grupo"
				+ "\n=================================");
		try {
			System.out.println(Fachada.cadastrarCompromissoGrupo("Faculdade",30,1,2019,10,00,"reunião","Mauro", "Jose"));
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		try {
			ArrayList<Compromisso> compromissos = Fachada.listarCompromissosPorTitulo("");
			String texto = "";
			for(Compromisso c: compromissos) {
				texto += "\n" + c.getId() + " - " + c.getTitulo() + " - " + c.getDatahora() + " - " + c.getTipo();
			}
			System.out.println(texto);
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		Fachada.notificarCompromissoGrupo(6,"senha");
		
	}

}