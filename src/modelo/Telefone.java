/**
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 * 
 * Desenvolvido por:
 * 	Mauricio Pereira da Costa Junior | 2019-05-30
 **/

package modelo;

import java.util.ArrayList;

public class Telefone {
	
	private String ddd;
	private String numero;
	private ArrayList<Contato> contatos = new ArrayList<>();
	
	/* CONSTRUTORES */
	
	public Telefone(String ddd, String numero) {
		this.ddd = ddd;
		this.numero = numero;
	}
	
	/* UTILITARIOS */
	
	public void adicionar(Contato c) {
		contatos.add(c);
	}
	public void remover(Contato c) {
		contatos.remove(c);
	}
	public Contato localizarContato(String nome){
		for(Contato c : contatos){
			if(c.getNome().equals(nome)) {
				return c;
			}
		}
		return null;
	}
	
	/* METODOS GET */
	
	public String getDDD() {		// DDD
		return ddd;
	}
	public String getNumero() {		// NUMERO
		return numero;
	}
	public ArrayList<Contato> getContatos() { // CONTATOS
		return contatos;
	}
	
	/* METODOS SET */
	
	public void setDDD(String texto) {		// DDD
		ddd = texto;
	}
	public void setNumero(String texto) {	// NUMERO
		numero = texto;
	}
	
	/* METODO toString */
	
	public String toString() {
		return "(" + ddd + ") " + numero.substring(0,5) + "-" + numero.substring(5);
	}
}
