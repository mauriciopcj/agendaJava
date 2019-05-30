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
	
	public Telefone(String ddd, String numero, ArrayList<Contato> contatos) {
		this.ddd = ddd;
		this.numero = numero;
		this.contatos = contatos;
	}
	
	public Telefone(String ddd, String numero) {
		this.ddd = ddd;
		this.numero = numero;
	}
	
	/* UTILITARIOS */
	
	public void adicionar(Contato c) {
		contatos.add(c);
	}
	
	/* METODOS GET */
	
	public String getDDD() {		// DDD
		return ddd;
	}
	public String getNumero() {		// NUMERO
		return numero;
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
		return "(" + ddd + ") " + numero;
	}
}
