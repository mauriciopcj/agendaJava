
/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */
package aplicacaoSwing;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import fachada.Fachada;
import modelo.Contato;
import modelo.Telefone;

public class ListarContatos extends JFrame {
	private JPanel contentPane;
	private DefaultListModel<String> model = new DefaultListModel<String>();
	private JPanel panelListarContatos;
	private JTextField textField_6;

	/**
	 * Create the application.
	 */
	public ListarContatos() {
		setResizable(false);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int heigth = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		setTitle("Apagar Produto");
		setBounds((width-455)/2, (heigth-479)/2, 455, 479);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setOpaque(true);
		contentPane.setLayout(null);
		
		panelListarContatos = new JPanel();
		panelListarContatos.setBorder(null);
		panelListarContatos.setBackground(new Color(153, 153, 153));
		panelListarContatos.setBounds(10, 11, 429, 428);
		panelListarContatos.setLayout(null);
		panelListarContatos.setVisible(true);
		contentPane.add(this.panelListarContatos);
//		
		JButton btnNome = new JButton("Nome");
		btnNome.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnNome.setForeground(new Color(255, 255, 255));
		btnNome.setBackground(new Color(102, 102, 102));
		btnNome.setBounds(10, 143, 110, 30);
		btnNome.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		panelListarContatos.add(btnNome);
//		
		JButton btnTelefone = new JButton("Telefone");
		btnTelefone.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnTelefone.setForeground(new Color(255, 255, 255));
		btnTelefone.setBackground(new Color(102, 102, 102));
		btnTelefone.setBounds(161, 143, 110, 30);
		btnTelefone.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		panelListarContatos.add(btnTelefone);
//		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_6.setBackground(new Color(204, 204, 204));
		textField_6.setColumns(10);
		textField_6.setBounds(10, 102, 409, 30);
		panelListarContatos.add(textField_6);
		
		JLabel lblListarContatos = new JLabel("Listar Contatos e Telefones");
		lblListarContatos.setOpaque(true);
		lblListarContatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarContatos.setForeground(new Color(102, 102, 102));
		lblListarContatos.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblListarContatos.setBackground(new Color(204, 204, 204));
		lblListarContatos.setBounds(0, 0, 429, 50);
		panelListarContatos.add(lblListarContatos);
//		
		JList<String> list = new JList<String>();
		list.setSelectionBackground(new Color(255, 204, 102));
		list.setBackground(new Color(204, 204, 204));
		list.setForeground(new Color(51, 51, 51));
		list.setFont(new Font("Courier New", Font.BOLD, 14));
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBounds(10, 225, 409, 192);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelListarContatos.add(list);
		list.setModel(model);
//		
		JLabel lblNomeTelefone = new JLabel("Nome / Telefone:");
		lblNomeTelefone.setForeground(Color.WHITE);
		lblNomeTelefone.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNomeTelefone.setBounds(10, 65, 128, 20);
		panelListarContatos.add(lblNomeTelefone);
//		
		JButton btnMaps = new JButton("Mapa");
		btnMaps.setVisible(false);
//		
		btnTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					ArrayList<Telefone> lista = Fachada.listarTelefones();
					String texto = "Listagem de telefones: \n----\n";
					model.clear();
					for(Telefone t: lista) {
						texto =  t + " - ";
						if(t.getNumero().contains(textField_6.getText())) {
							for(Contato c: t.getContatos()) {
								texto +=  c.getNome() +"; ";
							}
							model.addElement(texto);
						}
					}
					btnMaps.setVisible(false);
				}
				catch (Exception erro){
					model.clear();
					JOptionPane.showMessageDialog(null,erro.getMessage(),"Listar Telefones", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
//		
		btnNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					TreeMap<String,Contato> lista = Fachada.listarContatosPorNome(textField_6.getText());
					String texto = "";
					model.clear();
					int maior = 0;
					for(Contato n: lista.values()) {
						int tn = n.getNome().length();
						if(tn >= maior) {
							maior = tn;
						}
					}
					for(Contato c: lista.values()) {
						if(!c.getTelefones().isEmpty()) {
							texto =  c.getNome() + preencher(maior - c.getNome().length());
							for(Telefone t : c.getTelefones()) {
								texto += " | ("+t.getDDD()+") "+t.getNumero();
							}
						} else {
							texto =  c.getNome() + preencher(maior - c.getNome().length()) + " | não possui telefone";
						}
						model.addElement(texto);
					}
					btnMaps.setVisible(true);
				}
				catch(Exception erro){
					model.clear();
					JOptionPane.showMessageDialog(null,erro.getMessage(),"Listar Contatos", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
//		
		btnMaps.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		btnMaps.setForeground(new Color(255, 255, 255));
		btnMaps.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnMaps.setBackground(new Color(102, 102, 102));
		btnMaps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				if(index == -1) {
					JOptionPane.showMessageDialog(null,"Nenhum item selecionado!","Listar Contatos", JOptionPane.INFORMATION_MESSAGE);
				} else {
					String item = model.get(index);
					String[] nome = item.trim().split(" | ");
					try {
						TreeMap<String,Contato> contatos = Fachada.listarContatosPorNome(nome[0]);
						Contato c = contatos.get(nome[0]);
						try {
							pesquisaMaps(c.getEndereco(),c.getNumero());
						} catch (Exception a) {
							JOptionPane.showMessageDialog(null,a.getMessage(),"Listar Contatos", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (Exception a) {
						JOptionPane.showMessageDialog(null,a.getMessage(),"Listar Contatos", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnMaps.setLocation(309, 184);
		btnMaps.setSize(110, 30);
		panelListarContatos.add(btnMaps);
		
		JButton btnListarPorProximidade = new JButton("Proximidade");
		btnListarPorProximidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField_6.getText().equals("")) {
						throw new Exception("Grau não digitado!");
					}
					TreeMap<String,Contato> lista = Fachada.listarContatosPorProximidade(Integer.parseInt(textField_6.getText()));
					String texto = "";
					model.clear();
					int maior = 0;
					for(Contato n: lista.values()) {
						int tn = n.getNome().length();
						if(tn >= maior) {
							maior = tn;
						}
					}
					for(Contato c: lista.values()) {
						if(!c.getTelefones().isEmpty()) {
							texto =  c.getNome() + preencher(maior-c.getNome().length()) + " | " + c.getTelefones();
						} else {
							texto =  c.getNome() + preencher(maior-c.getNome().length()) + " | não possui telefone";
						}
						model.addElement(texto);
						//texto +=  c + "\n----\n";
					}
					btnMaps.setVisible(true);
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Listar Contatos", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnListarPorProximidade.setForeground(Color.WHITE);
		btnListarPorProximidade.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnListarPorProximidade.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		btnListarPorProximidade.setBackground(new Color(102, 102, 102));
		btnListarPorProximidade.setBounds(309, 143, 110, 30);
		panelListarContatos.add(btnListarPorProximidade);
//		
		JButton btnConsulta = new JButton("Consulta 1");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.clear();
					ArrayList<String> lista = Fachada.consulta1();
					String texto = "";
					model.clear();
					for(String c: lista) {
						if(!c.isEmpty()) {
							texto =  c;
						}
						model.addElement(texto);
					}
					btnMaps.setVisible(false);
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Listar Contatos", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnConsulta.setForeground(Color.WHITE);
		btnConsulta.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnConsulta.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		btnConsulta.setBackground(new Color(102, 102, 102));
		btnConsulta.setBounds(10, 184, 110, 30);
		panelListarContatos.add(btnConsulta);
//		
		JButton btnConsulta_1 = new JButton("Consulta 2");
		btnConsulta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.clear();
					ArrayList<String> lista = Fachada.consulta2();
					String texto = "";
					model.clear();
					for(String c: lista) {
						if(!c.isEmpty()) {
							texto =  c;
						}
						model.addElement(texto);
					}
					btnMaps.setVisible(false);
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Listar Contatos", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnConsulta_1.setForeground(Color.WHITE);
		btnConsulta_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnConsulta_1.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		btnConsulta_1.setBackground(new Color(102, 102, 102));
		btnConsulta_1.setBounds(161, 184, 110, 30);
		panelListarContatos.add(btnConsulta_1);

	}
	public String Cep(String cep) {
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
	
	public void pesquisaMaps(String rua, String numero) throws Exception {
		String url = "https://www.google.com/maps/place/" + rua.replace(" ","+") + "+" + numero;
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
	
	public String preencher(int quant) {
		String result = "";
		for(int i = 0; i < quant; i++) {
			result += " ";
		}
		return result;
	}
}
