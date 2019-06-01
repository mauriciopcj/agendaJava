/**
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 * 
 * Desenvolvido por:
 * 	Mauricio Pereira da Costa Junior | 2019-05-30
 **/

package aplicacaoConsole;

import fachada.Fachada;
import modelo.Contato;
import modelo.Telefone;

public class AplicacaoConsole {

	public static void main(String[] args) {

		try {
			Fachada.cadastrarContato("Mauricio", "mauricio@mauricio", "58052", "nome da rua", "115", "mauriciojunior", 1, 9, 22);
			System.out.println("Cadastrar Contato >> Contato cadastrado com sucesso!");
		} catch (Exception a){
			System.out.println(a.getMessage());
		}
		
		try {
			Fachada.cadastrarContato("Mauro", "mauricio@mauricio", "58052", "nome da rua", "115", "mauriciojunior", 1, 9, 22);
			System.out.println("Cadastrar Contato >> Contato cadastrado com sucesso!");
		} catch (Exception a){
			System.out.println(a.getMessage());
		}
		
		try {
			Fachada.cadastrarContato("Jose", "mauricio@mauricio", "58052", "nome da rua", "115", "mauriciojunior", 1, 9, 22);
			System.out.println("Cadastrar Contato >> Contato cadastrado com sucesso!");
		} catch (Exception a){
			System.out.println(a.getMessage());
		}
		
		try {
			Fachada.adicionarTelefone("Mauricio", "83", "999803355");
			System.out.println("Adicionar Telefone >> Telefone adicionado com sucesso!");
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		System.out.println(Fachada.listarTelefones());
		
		try {
			Fachada.adicionarTelefone("Mauricio", "83", "999803355");
			System.out.println("Adicionar Telefone >> Telefone adicionado com sucesso!");
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		System.out.println(Fachada.listarTelefones());
		
		try {
			Fachada.adicionarTelefone("Mauro", "83", "986803355");
			System.out.println("Adicionar Telefone >> Telefone adicionado com sucesso!");
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		System.out.println(Fachada.listarTelefones());
		
		try {
			Fachada.adicionarTelefone("Mauro", "83", "999803577");
			System.out.println("Adicionar Telefone >> Telefone adicionado com sucesso!");
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		System.out.println(Fachada.listarTelefones());
		
		try {
			Fachada.removerTelefone("Mauricio", "986803355");
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		System.out.println(Fachada.listarTelefones());
		
		System.out.println("\n1 - A partir daqui!\n");
		
		try {
			System.out.println(Fachada.listarContatosPorNome(""));
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		try {
			System.out.println("\n2 - A partir daqui!\n");
			System.out.println(Fachada.listarContatosPorTelefone("9780"));
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		try {
			System.out.println("\n3 - A partir daqui!\n");
			System.out.println(Fachada.listarContatosPorProximidade(1));
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		try {
			System.out.println("\n4 - A partir daqui!\n");
			System.out.println(Fachada.consulta2());
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}

	}

}
