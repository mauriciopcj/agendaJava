/**
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 * 
 * Desenvolvido por:
 * 	Mauricio Pereira da Costa Junior | 2019-05-30
 **/

package repositorio;

import java.util.ArrayList;
import java.util.TreeMap;

import modelo.Compromisso;
import modelo.Contato;
import modelo.Telefone;

public class Agenda {
	
	private TreeMap<String,Contato> contatos = new TreeMap<>();
	private ArrayList<Telefone> telefones = new ArrayList<Telefone>();
	private ArrayList<Compromisso> compromissos = new ArrayList<Compromisso>();
	
	/* METODOS ADICIONAR */
	
	public void adicionar(String nome, Contato c) {
		contatos.put(nome,c);
	}
	public void adicionar(Telefone t) {
		telefones.add(t);
	}
	public void adicionar(Compromisso c) {
		compromissos.add(c);
	}
	
	/* METODOS REMOVER */
	
	public void remover(String nome) {
		contatos.remove(nome);
	}
	public void remover(Telefone t) {
		telefones.remove(t);
	}
	public void remover(Compromisso c) {
		compromissos.remove(c);
	}
	
	/* METODOS LOCALIZAR */
	
	public Contato localizarContato(String nome){
		return contatos.get(nome);
	}
	public Telefone localizarTelefone(String numero){
		for(Telefone t : telefones){
			if(t.getNumero().equals(numero)) {
				return t;
			}
		}
		return null;
	}
	public Compromisso localizarCompromisso(int id){
		for(Compromisso c : compromissos){
			if(c.getId() == id) {
				return c;
			}
		}
		return null;
	}
	
	/* METODOS GET */
	
	public TreeMap<String,Contato> getContatos() {
		return contatos;
	}
	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}
	public ArrayList<Compromisso> getCompromissos() {
		return compromissos;
	}
	
	/* METODOS GET TOTAL OBJETOS NA LISTA*/
	
	public int getTotalContatos() {
		return contatos.size();
	}
	public int getTotalTelefones() {
		return telefones.size();
	}
	public int getTotalCompromissos() {
		return compromissos.size();
	}

}
