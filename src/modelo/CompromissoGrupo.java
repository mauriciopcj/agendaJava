package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CompromissoGrupo extends Compromisso {
	
	private ArrayList<Contato> contatos = new ArrayList<Contato>();
	
	/* CONSTRUTORES */
	public CompromissoGrupo(int id) {
		super(id);
	}
	public CompromissoGrupo(int id, String titulo, LocalDateTime datahora, String tipo, ArrayList<Contato> contatos) {
		super(id, titulo, datahora, tipo);
		this.contatos = contatos;
	}
	
	/* METODOS GET */
	public ArrayList<Contato> getContatos() {
		return contatos;
	}
	
	/* METODSO SET */
	public void setContatos(ArrayList<Contato> contatos) {
		this.contatos = contatos;
	}
	
	/* UTEIS */
	public void adicionarContato(Contato novoContato) {
		contatos.add(novoContato);
	}
	
	/* METODO toString */
	public String toString() {
		return super.toString() + "Contatos: " + contatos;
	}

}
