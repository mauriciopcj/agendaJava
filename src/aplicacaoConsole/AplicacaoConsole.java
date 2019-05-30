/**
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 * 
 * Desenvolvido por:
 * 	Mauricio Pereira da Costa Junior | 2019-05-30
 **/

package aplicacaoConsole;

import modelo.Contato;
import modelo.Telefone;

public class AplicacaoConsole {

	public static void main(String[] args) {

		Telefone t1 = new Telefone("83","999803355");
		Telefone t2 = new Telefone("83","986072950");
		System.out.println(t1);
		
		Contato c1 = new Contato("Mauricio", "mauricio@mauricio", "58052", "nome da rua", "115", "mauriciojunior", 1, 9, 22);
		System.out.println(c1);
		
		c1.adicionar(t1);
		c1.adicionar(t2);
		System.out.println(c1);

	}

}
