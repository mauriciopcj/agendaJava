package aplicacaoSwing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Dimension;

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
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class AplicacaoSwing {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;

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
		
        int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int heigth = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds((width-541)/2, (heigth-473)/2, 541, 473);
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
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 47, 535, 397);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panelListarContatos = new JPanel();			// PANEL LISTAR CONTATOS E TELEFONES
		panelListarContatos.setBackground(new Color(255, 255, 255));
		panelListarContatos.setBounds(10, 11, 515, 374);
		panel_1.add(panelListarContatos);
		panelListarContatos.setLayout(null);
		panelListarContatos.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 11, 357, 352);
		panelListarContatos.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton button = new JButton("Listar Contatos");
		button.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button.setForeground(new Color(102, 153, 153));
		button.setBackground(new Color(255, 255, 255));
		button.setBounds(377, 11, 128, 55);
		button.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(102, 153, 153)));
		panelListarContatos.add(button);
		
		JButton button_1 = new JButton("Listar Telefones");
		button_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button_1.setForeground(new Color(102, 153, 153));
		button_1.setBackground(new Color(255, 255, 255));
		button_1.setBounds(377, 77, 128, 55);
		button_1.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(102, 153, 153)));
		panelListarContatos.add(button_1);
		
		JPanel panelCadContato = new JPanel();
		panelCadContato.setBounds(10, 11, 515, 375);
		panel_1.add(panelCadContato);
		panelCadContato.setBackground(new Color(255, 255, 255));
		panelCadContato.setLayout(null);
		panelCadContato.setVisible(false);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome.setBounds(10, 11, 75, 30);
		panelCadContato.add(lblNome);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(95, 11, 251, 30);
		panelCadContato.add(textField);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblEmail.setBounds(10, 52, 75, 30);
		panelCadContato.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(95, 52, 251, 30);
		panelCadContato.add(textField_1);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCep.setBounds(10, 93, 75, 30);
		panelCadContato.add(lblCep);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(95, 93, 251, 30);
		panelCadContato.add(textField_2);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblEndereco.setBounds(10, 134, 75, 30);
		panelCadContato.add(lblEndereco);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(95, 134, 251, 30);
		panelCadContato.add(textField_3);
		
		JLabel lblFacebook = new JLabel("Número:");
		lblFacebook.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblFacebook.setBounds(10, 175, 75, 30);
		panelCadContato.add(lblFacebook);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(95, 175, 251, 30);
		panelCadContato.add(textField_4);
		
		JLabel label_3 = new JLabel("Facebook:");
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label_3.setBounds(10, 216, 75, 30);
		panelCadContato.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(95, 216, 251, 30);
		panelCadContato.add(textField_5);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fachada.cadastrarContato(textField.getText(),textField_1.getText(), textField_2.getText(),textField_3.getText(),
							textField_4.getText(), textField_5.getText(), 1, Integer.parseInt(textField_7.getText()), 
							Integer.parseInt(textField_8.getText()));
					JOptionPane.showMessageDialog(null,"Cadastrar Contato >> Contato cadastrado com sucesso!");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_7.setText("");
					textField_8.setText("");
				} catch (Exception a){
					JOptionPane.showMessageDialog(null,a.getMessage());
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(377, 11, 128, 55);
		btnNewButton.setForeground(new Color(102, 153, 153));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(102, 153, 153)));
		panelCadContato.add(btnNewButton);
		
		JLabel lblProximidade = new JLabel("Anivers\u00E1rio (Dia/M\u00EAs):");
		lblProximidade.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblProximidade.setBounds(10, 257, 157, 30);
		panelCadContato.add(lblProximidade);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(177, 259, 75, 30);
		panelCadContato.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(271, 257, 75, 30);
		panelCadContato.add(textField_8);
		
		JLabel lblProximidade_1 = new JLabel("Proximidade:");
		lblProximidade_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblProximidade_1.setBounds(10, 298, 96, 30);
		panelCadContato.add(lblProximidade_1);
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					ArrayList<Telefone> lista = Fachada.listarTelefones();
					String texto = "Listagem de telefones: \n----\n";
					for(Telefone p: lista) {
						texto +=  p + "\n----\n";
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
					ArrayList<Contato> lista = Fachada.listarContatosPorNome("");
					String texto = "Lista de Contatos: \n----\n";
					for(Contato c: lista) {
						texto +=  c + "\n----\n";
						//texto +=  c.getNome() + " - " + c.getTelefones() + "\n----\n";
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
		menuBar.setBorderPainted(false);
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(new Color(102, 153, 153));
		menuBar.setBounds(0, 0, 535, 48);
		frame.getContentPane().add(menuBar);
		
		JMenu mnContatos = new JMenu("Contatos");
		mnContatos.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		mnContatos.setBackground(new Color(0, 102, 102));
		mnContatos.setForeground(new Color(255, 255, 255));
		menuBar.add(mnContatos);
		
		JMenuItem cadastrarContato = new JMenuItem("Cadastrar");		// CADASTRAR CONTATO
		cadastrarContato.setBackground(new Color(255, 255, 255));
		cadastrarContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelListarContatos.setVisible(false);
				panelCadContato.setVisible(true);
			}
		});
		cadastrarContato.setHorizontalAlignment(SwingConstants.LEFT);
		mnContatos.add(cadastrarContato);
		
		JMenuItem removerContato = new JMenuItem("Remover");			// REMOVER CONTATO
		removerContato.setBackground(new Color(255, 255, 255));
		removerContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		removerContato.setHorizontalAlignment(SwingConstants.LEFT);
		mnContatos.add(removerContato);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.setBackground(new Color(255, 255, 255));
		mntmListar.setHorizontalAlignment(SwingConstants.LEFT);
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelListarContatos.setVisible(true);
				panelCadContato.setVisible(false);
			}
		});
		mnContatos.add(mntmListar);
		
		JMenu mnTelefones = new JMenu("Telefones");
		mnTelefones.setBackground(new Color(255, 255, 255));
		mnTelefones.setForeground(new Color(255, 255, 255));
		mnTelefones.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		menuBar.add(mnTelefones);
		
		JMenuItem mntmAdicionarAContato = new JMenuItem("Adicionar");
		mntmAdicionarAContato.setBackground(new Color(255, 255, 255));
		mnTelefones.add(mntmAdicionarAContato);
		
		JMenuItem mntmRemover_1 = new JMenuItem("Remover");
		mntmRemover_1.setBackground(new Color(255, 255, 255));
		mnTelefones.add(mntmRemover_1);
		
		JMenuItem mntmPesquisar = new JMenuItem("Pesquisar");
		mntmPesquisar.setBackground(new Color(255, 255, 255));
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
