/**
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 * 
 * Desenvolvido por:
 * Mauricio Pereira da Costa Junior | 2019-05-30
 **/

package fachada;

import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import modelo.Compromisso;
import modelo.CompromissoGrupo;
import modelo.Contato;
import modelo.Telefone;
import repositorio.Agenda;

public class Fachada {
	
	public static Agenda agenda = new Agenda();
	private static int idcompromisso = 0;
	private static String email = "mauriciojuniordesigner@gmail.com";
	
	// EXPRESSOES REGULARES //
	
	private static Pattern padraoEmail = Pattern.compile(
			"^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9a-zA-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$");
	private static Pattern padraoNome = Pattern.compile("^[[ ]|\\p{L}*]+$");
	private static Pattern padraoNumero = Pattern.compile("[0-9]+");
	
	//=============================================
	// cria um objeto Contato e adiciona na Agenda 
	//=============================================
	
	public static Contato cadastrarContato(String nome,String email,String cep,String numero,
			String link,int grau,int dia,int mes) throws Exception {
		
		Matcher alvoEmail = padraoEmail.matcher(email); 					// VALIDANDO EMAIL
		if(!alvoEmail.matches())
			throw new Exception("Cadastrar Contato >> Email inválido!");
		Matcher alvoNome = padraoNome.matcher(nome);						// VALIDANDO NOME
		if(!alvoNome.matches())
			throw new Exception("Cadastrar Contato >> Nome inválido!");
		Matcher alvoNnumero = padraoNumero.matcher(numero);					// VALIDANDO NUMERO
		if(!alvoNnumero.matches())
			throw new Exception("Cadastrar Contato >> Número inválido!");
		Contato contato = agenda.localizarContato(nome);					// VERIFICA SE O CONTATO JÁ EXISTE
		if(contato != null)
			throw new Exception("Cadastrar Contato >> Contato já existe! >> " + nome);
		if(cep.length() != 8)												// VERIFICA SE O CEP ESTÁ COMPLETO
			throw new Exception("Cadastrar Contato >> CEP incorreto! >> " + cep);
		
		String endereco = endereco(cep);
		
		contato = new Contato(nome, email,cep, endereco, numero, link, grau, dia, mes);
		agenda.adicionar(nome,contato);
		
		return contato;
	}
	
	//================================================================
	// remove o contato da agenda bem como os seus telefones "orfaos" 
	//================================================================
	
	public static void removerContato(String nome) throws Exception{
		
		Contato contato = agenda.localizarContato(nome);
		if(contato != null) {
			ArrayList<Telefone> telefones = contato.getTelefones();
			if(telefones.isEmpty()) {
				agenda.remover(nome);
			} else {
				String[] numeros = new String[telefones.size()];
				for(Telefone t: telefones) {
					if(t.getContatos().size() > 1) {
						t.getContatos().remove(contato);
					} else {
						adicionar(numeros, t.getNumero());
					}
				}
				for(String n: numeros) {
					agenda.remover(agenda.localizarTelefone(n));
				}
				agenda.remover(nome);
			}
			throw new Exception("Contato " + nome + " removido com sucesso!");
		} else {
			throw new Exception("Remover Contato >> Contato não encontrado! >> " + nome);
		}
	}
	
	public static void adicionar(String[] numeros, String n){
		int k = 0;	
		for(int i=0; i < numeros.length; i++){
			if(numeros[i] != null){
				k += 1;
			}
		}
		numeros[k] = n;
	}

	
	//==========================================================================================
	// cria um objeto Telefone e adiciona ao objeto Contato (e vice-versa) e adiciona na Agenda 
	//==========================================================================================
	
	public static void adicionarTelefone(String nome, String ddd, String numero) throws  Exception {
		
		Contato contato = agenda.localizarContato(nome);
		if (contato == null)
			throw new Exception("Adicionar Telefone >> Contato não cadastrado! >> " + nome);
		
		Telefone telefone1 = agenda.localizarTelefone(numero);
		if (telefone1 == null) {
			telefone1 = new Telefone(ddd,numero);
			agenda.adicionar(telefone1);
			contato.adicionar(telefone1);
			telefone1.adicionar(contato);
		} else {
			Telefone telefone2 = contato.localizarTelefone(numero);
			if(telefone2 != null)
				throw new Exception("Adicionar Telefone >> Contato já possui este número! >> " + numero);
			
			contato.adicionar(telefone1);
			telefone1.adicionar(contato);
		}
	}
	
	//===========================================================================================
	// remove um objeto Telefone de um objeto Contato (e vice-versa), mas não o remove da Agenda 
	//===========================================================================================
	
	public static void removerTelefone(String nome, String numero) throws Exception {
		
		Contato contato = agenda.localizarContato(nome);
		if (contato == null)
			throw new Exception("Remover Telefone >> Contato não cadastrado! >> " + nome);
		
		Telefone telefone = contato.localizarTelefone(numero);
		if (telefone == null)
			throw new Exception("Remover Telefone >> Contato não possui este número >> " + numero);
		
		contato.remover(telefone);
		Contato c2 = telefone.localizarContato(nome);
		if (c2 == null)
			throw new Exception("Remover Telefone >> Telefone não possui este contato >> " + nome);
		
		telefone.remover(c2);
		
		if(telefone.getContatos().isEmpty()) {
			agenda.remover(telefone);
		}
	}
	
	//=================================================
	// cria um objeto Compromisso e adiciona na Agenda 
	//=================================================
	
	public static Compromisso cadastrarCompromisso(String titulo, int dia, int mes, int ano, int hora, int minuto, String tipo) throws Exception {
		idcompromisso++;
		LocalDateTime data = LocalDateTime.of(ano, mes, dia, hora, minuto);
		ArrayList<Compromisso> compromissos = agenda.getCompromissos();
		for(Compromisso c: compromissos) {
			if(c.getDatahora().equals(data))
				throw new Exception("Já existe um compromisso para esta data!");
		}
		Compromisso compromisso = new Compromisso(idcompromisso, titulo, data , tipo);
		agenda.adicionar(compromisso);
		return compromisso;
	}
	
	//=================================================
	// remove o compromisso da Agenda
	//=================================================
	
	public static void removerCompromisso(int id) throws Exception {
		
		Compromisso c = agenda.localizarCompromisso(id);
		if(c == null)
			throw new Exception("Remover Compromisso >> Compromisso não encontrado!");
		
		agenda.remover(c);
		
	}
	
	//========================================================================================
	// cria um objeto CompromissoGrupo com os dados, incluindo a lista de nomes dos contatos, 
	// e o adiciona na lista de compromissos da Agenda
	//========================================================================================

	public static Compromisso cadastrarCompromissoGrupo(String titulo, int dia, int mes, int ano, int hora, int minuto, String tipo, String... nomes) throws Exception{
		
		idcompromisso++;
		LocalDateTime data = LocalDateTime.of(ano,mes,dia,hora,minuto);
		ArrayList<Compromisso> compromissos = agenda.getCompromissos();
		for(Compromisso c: compromissos) {
			if(c.getDatahora().equals(data))
				throw new Exception("Já existe um compromisso para esta data!");
		}
		ArrayList<Contato> contatos = new ArrayList<>();
		for(String n: nomes) {
			contatos.add(agenda.localizarContato(n));
		}
		CompromissoGrupo c = new CompromissoGrupo(idcompromisso, titulo, data, tipo,contatos);
		agenda.adicionar(c);
		return c;
	}
	
	//==============================================================================================================
	// envia um email de aviso para cada contato participante do compromisso (id), usando o email e senha do sistema
	//==============================================================================================================
			
	public static void notificarCompromissoGrupo(int id, String senha) {
		DateTimeFormatter formatador1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatador2 = DateTimeFormatter.ofPattern("HH:mm");
		
		CompromissoGrupo compromisso = (CompromissoGrupo) agenda.localizarCompromisso(id);
		ArrayList<Contato> contatos = compromisso.getContatos();
		String dados = "\nTítulo: "+compromisso.getTitulo() + 
				"\nData:   "+compromisso.getDatahora().format(formatador1) + 
				"\nHora:   "+compromisso.getDatahora().format(formatador2) + 
				"\nTipo:   "+compromisso.getTipo();
		for(Contato c: contatos) {
			String mensagem = "\nBom dia " + c.getNome() + ",\n"
					+ "\nVocê foi adicionado à um compromisso. Dados do compromisso:\n" + dados;
			System.out.println(mensagem);
		}
	}

	//========================================================================================================
	// retorna todos os objetos Contato (se termo for “”) ou retorna apenas aqueles cujos nome contém o termo 
	//========================================================================================================
	
	public static TreeMap<String,Contato> listarContatosPorNome(String termo) throws Exception {
		
		TreeMap<String,Contato> contatos = agenda.getContatos();
		TreeMap<String,Contato> resultado = new TreeMap<>();
		if (!contatos.isEmpty()) {
			if(termo.equals(""))
				return contatos;
			for (String nome: contatos.keySet()) {
				if(nome.toLowerCase().contains(termo.toLowerCase()))
					resultado.put(nome, contatos.get(nome));
			}
			if(resultado.isEmpty())
				throw new Exception("Listar Contatos >> Nenhum contato encontrado!");
			return resultado;
		}
		throw new Exception("Listar Contatos >> Nenhum contato encontrado!");
	};
	
	//==========================================================================
	// retorna os objetos cujos números de telefone (sem ddd) contém os digitos
	//==========================================================================
	
	public static TreeMap<String,Contato> listarContatosPorTelefone(String numero) throws Exception {
		
		TreeMap<String,Contato> contatos = agenda.getContatos();
		TreeMap<String,Contato> resultado = new TreeMap<>();
		if (!contatos.isEmpty()) {
			for (Contato c: contatos.values()) {
				if (!c.getTelefones().isEmpty()) {
					for (Telefone t: c.getTelefones()) {
						if(t.getNumero().contains(numero))
							resultado.put(c.getNome(), c);
					}
				}
			}
			if(resultado.isEmpty()) {
				throw new Exception("Listar Contatos >> Nenhum contato encontrado!");
			}
			return resultado;
		}
		throw new Exception("Listar Contatos >> Nenhum contato encontrado!");
	};
	
	//===================================================================
	// retorna os objetos cujos graus de proximidade são iguais ao valor
	//===================================================================
	
	public static TreeMap<String,Contato> listarContatosPorProximidade(int grau) throws Exception {
		
		TreeMap<String,Contato> contatos = agenda.getContatos();
		TreeMap<String,Contato> resultado = new TreeMap<>();
		if (!contatos.isEmpty()) {
			for (Contato c: contatos.values()) {
				if(c.getGrauproximidade() == grau)
					resultado.put(c.getNome(),c);
			}
			if(resultado.isEmpty())
				throw new Exception("Listar Contatos >> Nenhum contato encontrado!");
			return resultado;
		}
		throw new Exception("Listar Contatos >> Nenhum contato encontrado!");
	};
	
	//===================================================================================================
	// retorna todos os objetos (se termo for “”) ou retorna apenas aqueles cujos titulos contém o termo
	//===================================================================================================
	
	public static ArrayList<Compromisso> listarCompromissosPorTitulo(String termo) throws Exception {
		
		ArrayList<Compromisso> compromissos = agenda.getCompromissos();
		ArrayList<Compromisso> resultado = new ArrayList<Compromisso>();
		if (!compromissos.isEmpty()) {
			for (Compromisso c: compromissos) {
				if (c.getTitulo().toLowerCase().contains(termo.toLowerCase())) {
					resultado.add(c);
				}
			}
			if(resultado.isEmpty()) {
				throw new Exception("Listar Compromissos >> Nenhum compromisso encontrado!");
			}
			return resultado;
		}
		throw new Exception("Listar Compromissos >> Nenhum compromisso encontrado!");
		
	}
	
	//==========================================================================
	// retorna objetos cujas datahora estejam dentro do intervalo data1 e data2
	//==========================================================================
	
	public static ArrayList<Compromisso> listarCompromissosPorDatas(LocalDateTime data1, LocalDateTime data2) throws Exception {
		
		ArrayList<Compromisso> compromissos = agenda.getCompromissos();
		ArrayList<Compromisso> resultado = new ArrayList<Compromisso>();
		if (!compromissos.isEmpty()) {
			for (Compromisso c: compromissos) {
				if ((c.getDatahora().isAfter(data1) && c.getDatahora().isBefore(data2)) || c.getDatahora().equals(data1) || c.getDatahora().equals(data2)) {
					resultado.add(c);
				}
			}
			if(resultado.isEmpty()) {
				throw new Exception("Listar Compromissos >> Nenhum compromisso encontrado!");
			}
			return resultado;
		}
		throw new Exception("Listar Compromissos >> Nenhum compromisso encontrado!");
		
	}
	
	//====================================
	// retorna objetos do tipo solicitado
	//====================================
	
	public static ArrayList<Compromisso> listarCompromissosPorTipo(String tipo) throws Exception{
		
		ArrayList<Compromisso> compromissos = agenda.getCompromissos();
		ArrayList<Compromisso> resultado = new ArrayList<Compromisso>();
		if (!compromissos.isEmpty()) {
			for (Compromisso c: compromissos) {
				if (c.getTipo().equals(tipo)) {
					resultado.add(c);
				}
			}
			if(resultado.isEmpty()) {
				throw new Exception("Listar Compromissos >> Nenhum compromisso encontrado!");
			}
			return resultado;
		}
		throw new Exception("Listar Compromissos >> Nenhum compromisso encontrado!");
		
	}
	
	//=============================================
	// retorna todos os objetos Telefone da agenda
	//=============================================
	
	public static ArrayList<Telefone> listarTelefones() throws Exception {
		if(agenda.getTelefones().isEmpty())
			throw new Exception("Nenhum telefone encontrado!");
		return agenda.getTelefones();
		
	}
	
	//=========================================================
	// retorna o nome dos contatos que tem 2 telefones ou mais
	//=========================================================
	
	public static ArrayList<String> consulta1() throws Exception {
		
		TreeMap<String,Contato> contatos = agenda.getContatos();
		ArrayList<String> resultado = new ArrayList<String>();
		if (!contatos.isEmpty()) {
			for (Contato c: contatos.values()) {
				if(c.getTelefones().size() >= 2) {
					resultado.add(c.getNome());
				}
			}
			if(resultado.isEmpty()) {
				throw new Exception("Consulta 1 >> Nenhum contato encontrado!");
			}
			return resultado;
		}
		throw new Exception("Consulta 1 >> Nenhum contato encontrado!");
	}
	
	//=========================================================
	// retorna o numero de telefone que tem 2 contatos ou mais
	//=========================================================
	
	public static ArrayList<String> consulta2() throws Exception {
		
		ArrayList<Telefone> telefones = agenda.getTelefones();
		ArrayList<String> resultado = new ArrayList<String>();
		if (!telefones.isEmpty()) {
			for (Telefone t: telefones) {
				if(t.getContatos().size() >= 2) {
					resultado.add(t.getNumero());
				}
			}
			if(resultado.isEmpty()) {
				throw new Exception("Consulta 2 >> Nenhum contato encontrado!");
			}
			return resultado;
		}
		throw new Exception("Consulta 2 >> Nenhum contato encontrado!");
		
	}
	
	//=======================================
	// MAPA - CEP - ENDERECO - ALTERAR DADOS
	//=======================================
	
	public static Contato cadastrarContatoNome(String nome) throws Exception {
		
		Matcher alvoNome = padraoNome.matcher(nome);
		if(!alvoNome.matches())
			throw new Exception("Cadastrar Contato >> Nome inválido!");
		
		Contato contato = agenda.localizarContato(nome);
		if(contato != null)
			throw new Exception("Cadastrar Contato >> Contato já existe! >> " + nome);
			
		contato = new Contato(nome);
		agenda.adicionar(nome,contato);
		return contato;
	}
	
	public static Contato alterarDados(String nome) throws Exception {
		if(nome.contentEquals("")) {
			throw new Exception("Campo nome vazio!");
		}
		Contato contato = agenda.localizarContato(nome);
		if(contato == null) {
			throw new Exception("Contato não encontrado!");
		}
		return contato;
	}
	
	public static void alterarTipoCompromisso(String titulo, String tipo) throws Exception {
		if(tipo.equals("")) {
			throw new Exception("Campo nome vazio!");
		} else if (titulo.equals("")) {
			throw new Exception("Campo titulo vazio!");
		}
		ArrayList<Compromisso> compromissos = listarCompromissosPorTitulo(titulo);
		if(compromissos.isEmpty()) {
			throw new Exception("Contato não encontrado!");
		} else if(compromissos.size() == 1) {
			Compromisso compromisso = compromissos.get(0);
			compromisso.setTipo(tipo);
		}
	}
	
	public static void alterarDataCompromisso(String titulo, LocalDate data) throws Exception {
		if(data.equals("")) {
			throw new Exception("Campo data vazio!");
		} else if (titulo.equals("")) {
			throw new Exception("Campo titulo vazio!");
		}
		ArrayList<Compromisso> compromissos = listarCompromissosPorTitulo(titulo);
		if(compromissos.isEmpty()) {
			throw new Exception("Contato não encontrado!");
		} else if(compromissos.size() == 1) {
			Compromisso compromisso = compromissos.get(0);
			LocalDateTime dataantiga = compromisso.getDatahora();
			LocalDateTime novadata = LocalDateTime.of(data.getYear(),data.getMonth().getValue(),data.getDayOfMonth(),dataantiga.getHour(),dataantiga.getMinute(),dataantiga.getSecond());
			compromisso.setDatahora(novadata);
		}
	}
	
	public static void alterarHoraCompromisso(String titulo, LocalTime hora) throws Exception {
		if(hora.equals("")) {
			throw new Exception("Campo hora vazio!");
		} else if (titulo.equals("")) {
			throw new Exception("Campo titulo vazio!");
		}
		ArrayList<Compromisso> compromissos = listarCompromissosPorTitulo(titulo);
		if(compromissos.isEmpty()) {
			throw new Exception("Contato não encontrado!");
		} else if(compromissos.size() == 1) {
			Compromisso compromisso = compromissos.get(0);
			LocalDateTime dataantiga = compromisso.getDatahora();
			LocalDateTime novadata = LocalDateTime.of(dataantiga.getYear(),dataantiga.getMonth().getValue(),dataantiga.getDayOfMonth(),hora.getHour(),hora.getMinute(),hora.getSecond());
			compromisso.setDatahora(novadata);
		}
	}
	
	public static String Cep(String cep) {
        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            //URL url = new URL("http://ifpb.edu.br");
            URLConnection conexao = url.openConnection();
            InputStream input = conexao.getInputStream();
            Scanner scan = new Scanner(input);
            String result = "";
            String linha;
            while (scan.hasNext())  {
                linha = scan.nextLine();
                linha = linha.trim();       //remover brancos externos
                result += linha;
            }
            scan.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
 
    }
	
	public static String endereco(String cep) {
		String jsonCEP = "";
		try {
			jsonCEP = Fachada.Cep(cep);
		} catch (Exception a) {
			JOptionPane.showMessageDialog(null,a.getMessage(),"Cadastrar Contato", JOptionPane.INFORMATION_MESSAGE);
		}
		String[] array = jsonCEP.replace("{", "").replace("}", "").split(",");
		String texto2 = "";
		for(String i: array) {
			if(i.contains("logradouro")) {
				texto2 += i.substring(15,i.length()-1);
			} else if(i.contains("localidade")) {
				texto2 += ", " + i.substring(15,i.length()-1);
			} else if(i.contains("uf")) {
				texto2 += ", " + i.substring(7,i.length()-1);
			}
		}
		return texto2;
	}
	
	public static void pesquisaMaps(String endereco, String numero) throws Exception {
		String url = "https://www.google.com/maps/place/" + endereco.replace(" ","+") + "+" + numero;
		try {
			Desktop.getDesktop().browse(new URL(url).toURI());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}