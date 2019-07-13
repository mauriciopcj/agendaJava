/**
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 * 
 * Desenvolvido por:
 * 	Mauricio Pereira da Costa Junior | 2019-05-30
 **/

package modelo;

import java.time.LocalDateTime;

public class Compromisso {

	private int id;
	private String titulo;
	private LocalDateTime datahora;
	private String tipo;
	
	/* CONSTRUTORES */
	public Compromisso (int id, String titulo, LocalDateTime datahora, String tipo) {
		this.id = id;
		this.titulo = titulo;
		this.datahora = datahora;
		this.tipo = tipo;
	}
	public Compromisso (int id) {
		this.id = id;
	}
	
	// METODOS GET
	public int getId() {					// ID
		return id;
	}
	public String getTitulo() {				// TITULO
		return titulo;
	}
	public LocalDateTime getDatahora() {	// DATA HORA
		return datahora;
	}
	public String getTipo() {				// TIPO
		return tipo;
	}
	
	/* METODOS SET */
	public void setId(int id) {							// ID
		this.id = id;
	}
	public void setTitulo(String titulo) {				// TITULO
		this.titulo = titulo;
	}
	public void setDatahora(LocalDateTime datahora) {	// DATA HORA
		this.datahora = datahora;
	}
	public void setTipo(String tipo) {					// TIPO
		this.tipo = tipo;
	}

	/* METODO toString */
	public String toString() {
		return "Compromisso [id=" + id + ", titulo=" + titulo + ", datahora=" + datahora + ", tipo=" + tipo + "]";
	}
	
}
