package aplicacaoSwing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;

import fachada.Fachada;
import modelo.Contato;
import modelo.Telefone;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AplicacaoSwing {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacaoSwing window = new AplicacaoSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AplicacaoSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 541, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		try {
			Fachada.cadastrarContato("Mauricio", "mauricio@mauricio", "58052", "nome da rua", "115", "mauriciojunior", 1, 9, 22);
		} catch (Exception a){
			System.out.println(a.getMessage());
		}		
		try {
			Fachada.cadastrarContato("Mauro", "mauricio@mauricio", "58052", "nome da rua", "115", "mauriciojunior", 1, 9, 22);
		} catch (Exception a){
			System.out.println(a.getMessage());
		}		
		try {
			Fachada.cadastrarContato("Jose", "mauricio@mauricio", "58052", "nome da rua", "115", "mauriciojunior", 1, 9, 22);
		} catch (Exception a){
			System.out.println(a.getMessage());
		}		
		try {
			Fachada.adicionarTelefone("Mauricio", "83", "999803355");
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}		
		try {
			Fachada.adicionarTelefone("Mauricio", "83", "986803355");
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		/* TODOS OS PAINEIS */
		
		JPanel panel_1 = new JPanel();			// PANEL PRINCIPAL
		panel_1.setBounds(0, 47, 535, 397);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();			// PANEL CADASTRAR
		panel_2.setBounds(10, 11, 515, 375);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 86, 20);
		panel_2.add(lblNome);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(106, 11, 86, 20);
		panel_2.add(textField);
		
		JButton button_2 = new JButton("Cadastrar");
		button_2.setBounds(390, 10, 115, 23);
		panel_2.add(button_2);
		
		JPanel panel = new JPanel();			// PANEL LISTAR CONTATOS E TELEFONES
		panel.setBounds(10, 11, 515, 374);
		panel_1.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 11, 495, 286);
		panel.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton button = new JButton("Listar Contatos");
		button.setBounds(10, 308, 128, 55);
		panel.add(button);
		
		JButton button_1 = new JButton("Listar Telefones");
		button_1.setBounds(377, 308, 128, 55);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					ArrayList<Telefone> lista = Fachada.listarTelefones();
					String texto = "Listagem de produtos: \n";
					for(Telefone p: lista) {
						texto +=  p + "\n";
					}
					textArea.setText(texto);
				}
				catch (Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					ArrayList<Contato> lista = Fachada.listarContatosPorNome("Maur");
					String texto = "Lista de Contatos: \n";
					for(Contato c: lista) {
							texto +=  c + "\n";
					}
					textArea.setText(texto);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		
		/* MENU PRINCIPAL */
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 535, 48);
		frame.getContentPane().add(menuBar);
		
		JMenu mnContatos = new JMenu("Contatos");
		menuBar.add(mnContatos);
		
		JMenuItem cadastrarContato = new JMenuItem("Cadastrar");		// CADASTRAR CONTATO
		cadastrarContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_2.setVisible(false);
			}
		});
		cadastrarContato.setHorizontalAlignment(SwingConstants.CENTER);
		mnContatos.add(cadastrarContato);
		
		JMenuItem removerContato = new JMenuItem("Remover");			// REMOVER CONTATO
		removerContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		removerContato.setHorizontalAlignment(SwingConstants.CENTER);
		mnContatos.add(removerContato);
		
		JMenu mnTelefones = new JMenu("Telefones");
		menuBar.add(mnTelefones);
		
		JMenuItem mntmAdicionarAContato = new JMenuItem("Adicionar a contato");
		mnTelefones.add(mntmAdicionarAContato);
		
		JMenuItem mntmRemover_1 = new JMenuItem("Remover");
		mnTelefones.add(mntmRemover_1);
		
		JMenuItem mntmPesquisar = new JMenuItem("Pesquisar");
		mnTelefones.add(mntmPesquisar);
		
		
		
		
		
		
		
/*
1. Listar contatos por nome 
Dados: nome (parcial ou completo)
Resultados: contatos e telefones que contenham o nome pedido

2. Listar contatos por telefone
Dados: numero de telefone (parcial ou completo)
Resultados: contatos e telefones que contenham o numero pedido

3. Listar contatos por proximidade
Dados: grau de proximidade
Resultados: contatos e telefones do grau pedido

4. Listar compromissos por nome
Dados: titulo (parcial ou completo)
Resultados: compromissos que contenham o título pedido

5. Listar compromissos por data
Dados: data1(dia,mês,ano) as 0hs e data2 (dia,mês,ano) as 23:59hs
Resultados: compromissos que ocorrerão no intervalo de datas pedido

6. Listar compromissos portipo
Dados: tipo de compromisso
Resultados: compromissos do tipo pedido

7. Listar telefones 
Resultados: telefones da agenda com os nomes dos respectivos contatos

8. Cadastrar contato 
Dados: dados do contato (não inclui telefone)
Resultados: mensagem de confirmação

9. Adicionar telefone 
Dados: nome do contato, ddd e numero de telefone
Resultados: mensagem de confirmação

10. Remover telefone 
Dados: nome do contato, numero de telefone
Resultados: mensagem de confirmação

11. Cadastrar compromisso 
Dados: dados do compromisso 
Resultados: id do compromisso

12. Consulta1 
Resultado: nome dos contatos que tem 2 telefones ou mais

13. Consulta2 
Resultado: numero dos telefones que tem 2 contatos ou mai
 */
	}
}
