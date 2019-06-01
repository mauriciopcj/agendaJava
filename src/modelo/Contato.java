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

public class Contato {
	
	private String nome, email, cep, endereco, numero, linkfacebook;
	private int grauproximidade, mesaniversario, diaaniversario;
	private ArrayList<Telefone> telefones = new ArrayList<>();
	
	/* CONSTRUTORES */
	
	public Contato (String nome, String email, String cep, String endereco, String numero, String linkfacebook,
			int grauproximidade, int mesaniversario, int diaaniversario) {
		this.nome = nome;
		this.email = email;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.linkfacebook = linkfacebook;
		this.grauproximidade = grauproximidade;
		this.mesaniversario = mesaniversario;
		this.diaaniversario = diaaniversario;
	}
	
	public Contato (String nome) {
		this.nome = nome;
	}
	
	/* UTILITARIOS */
	
	public void adicionar(Telefone t) {
		telefones.add(t);
	}
	public void remover(Telefone t) {
		telefones.remove(t);
	}
	public Telefone localizarTelefone(String numero){
		for(Telefone t : telefones){
			if(t.getNumero().equals(numero)) {
				return t;
			}
		}
		return null;
	}
	
	/* METODOS GET*/
	
	public String getNome() { 						// NOME
		return nome;
	}
	public String getEmail() { 						// EMAIL
		return email;
	}	
	public String getCep() {						// CEP
		return cep;
	}
	public String getEndereco() {					// ENDERECO
		return endereco;
	}
	public String getNumero() {						// NUMERO
		return numero;
	}
	public String getLinkfacebook() {				// FACEBOOK
		return linkfacebook;
	}
	public int getGrauproximidade() {				// PROXIMIDADE
		return grauproximidade;
	}
	public int getMesaniversario() {				// MES
		return mesaniversario;
	}
	public int getDiaaniversario() {				// DIA
		return diaaniversario;
	}
	public ArrayList<Telefone> getTelefones() {		// TELEFONES
		return telefones;
	}
	
	/* METODOS SET */
	
	public void setNome(String nome) {							// NOME
		this.nome = nome;
	}
	public void setEmail(String email) {						// EMAIL
		this.email = email;
	}
	public void setCep(String cep) {							// CEP
		this.cep = cep;
	}
	public void setEndereco(String endereco) {					// ENDERECO
		this.endereco = endereco;
	}
	public void setNumero(String numero) {						// NUMERO
		this.numero = numero;
	}
	public void setLinkfacebook(String linkfacebook) {			// FACEBOOK
		this.linkfacebook = linkfacebook;
	}
	public void setGrauproximidade(int grauproximidade) {		// PROXIMIDADE
		this.grauproximidade = grauproximidade;
	}
	public void setMesaniversario(int mesaniversario) {			// MES
		this.mesaniversario = mesaniversario;
	}
	public void setDiaaniversario(int diaaniversario) {			// DIA
		this.diaaniversario = diaaniversario;
	}

	/* METODO toString */
	
	public String toString() {
		return "Contato\n------\nnome: " + nome + "\nemail: " + email + "\ncep: " + cep + "\nendereco: " + endereco + "\nnumero: "
				+ numero + "\nlinkfacebook: " + linkfacebook + "\ngrauproximidade: " + grauproximidade
				+ "\nmesaniversario: " + mesaniversario + "\ndiaaniversario: " + diaaniversario + "\ntelefones: "
				+ telefones ;
	}

}
