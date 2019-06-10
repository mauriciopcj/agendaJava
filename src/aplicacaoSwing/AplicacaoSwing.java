package aplicacaoSwing;

import fachada.Fachada;
import modelo.Compromisso;
import modelo.Contato;
import modelo.Telefone;
import java.util.ArrayList;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class AplicacaoSwing {

	private JFrame frame;
	
	private ArrayList<JPanel> telas = new ArrayList<>();
	private ArrayList<JMenuItem> menus = new ArrayList<>();
	
	private JFormattedTextField txCepPCC;
	private JFormattedTextField txPhonePRT;
	private JFormattedTextField txPhonePAT;
	private JFormattedTextField txDddPAT;
	
	private JTextField txEndereco;
	private JTextField txNumeroPCC;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_6;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	
	private MaskFormatter foneMask;
	private MaskFormatter dddMask;
	private MaskFormatter cepMask;
	private MaskFormatter numeroMask;
	private MaskFormatter dataMask;
	private MaskFormatter horaMask;
	
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	
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
		
		frame = new JFrame("Agenda - Mauricio Pereira");
		frame.setResizable(false);
		frame.setBounds((width-706)/2, (heigth-480)/2, 706, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		try {
			Fachada.cadastrarContato("Mauricio", "mauricio@mauricio", "58052280", "Jornalista Genésio Gambarra Filho", "115", "mauriciojunior", 1, 9, 22);
			Fachada.cadastrarContato("Mauro", "mauro@mauro", "58052021", "R. Borja Peregrino", "357", "mauro", 2, 8, 24);
			Fachada.cadastrarContato("Jose", "jose@mjose", "58052546", "Av. Cônego Matias Freire", "2", "josejose", 3, 3, 10);
			Fachada.cadastrarContato("Jair", "jair@jair", "58052123", "Av. Cônego Matias Freire", "2", "jairjair", 3, 3, 10);
		} catch (Exception a){
			System.out.println(a.getMessage());
		}		
			
		try {
			Fachada.adicionarTelefone("Mauricio", "83", "999803355");
			Fachada.adicionarTelefone("Mauricio", "83", "986803355");
			Fachada.adicionarTelefone("Mauro", "83", "987784512");
			Fachada.adicionarTelefone("Jose", "83", "999546581");
			Fachada.adicionarTelefone("Jose", "83", "987453215");
			Fachada.adicionarTelefone("Mauro", "83", "986803355");
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		try {												// mask DDD
			dddMask = new MaskFormatter(" ##");
			dddMask.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			// NAO FACA NADA
		}
		
		try {												// mask TELEFONE
			foneMask = new MaskFormatter(" #####-####");
			foneMask.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			// NAO FACA NADA
		}
		
		try {												// mask CEP
			cepMask = new MaskFormatter(" ##.###-###");
			cepMask.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			// NAO FACA NADA
		}
				
		try {												// mask DATA
			dataMask = new MaskFormatter("##/##/####");
			dataMask.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			// NAO FACA NADA
		}
		
		try {												// mask HORA
			horaMask = new MaskFormatter("##:##");
			horaMask.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			// NAO FACA NADA
		}
		

		/////////////////////////////////////////////////////////////////////////////////////////////////
																					  // TODOS OS PAINEIS
		
		JPanel panel_1 = new JPanel();			// PANEL PRINCIPAL
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(102, 102, 102));
		panel_1.setBounds(0, 47, 700, 414);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		String[] itens2 = {"","1 - baixo", "2 - médio", "3 - alto"};
		DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<String>(itens2);
		
		String[] itens = {"","1 - baixo", "2 - médio", "3 - alto"};
		DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<String>(itens);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		
		DefaultListModel<String> model4 = new DefaultListModel<String>();
		
		String[] itens3 = {"", "reunião","festa","aniversário"};
		DefaultComboBoxModel<String> model3 = new DefaultComboBoxModel<String>(itens3);
				
					
		/////////////////////////////////////////////////////////////////////////////////////////////////
																		   // PANEL ADICIONAR COMPROMISSO
		JPanel panelAdicionarCompromisso = new JPanel();
		panelAdicionarCompromisso.setVisible(false);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
																			  // PANEL LISTAR COMPROMISSO
		JPanel panelListarCompromisso = new JPanel();
		panelListarCompromisso.setVisible(false);
		
		
		
		JPanel panelInicial = new JPanel();
		panelInicial.setBorder(null);
		panelInicial.setBounds(10, 11, 678, 381);
		panel_1.add(panelInicial);
		panelInicial.setBackground(new Color(153, 153, 153));
		panelInicial.setLayout(null);
		panelInicial.setVisible(true);
		telas.add(panelInicial);
		
		JLabel lblMauricioPereira = new JLabel("Mauricio Pereira");
		lblMauricioPereira.setBackground(new Color(51, 51, 51));
		lblMauricioPereira.setForeground(new Color(255, 153, 0));
		lblMauricioPereira.setHorizontalAlignment(SwingConstants.CENTER);
		lblMauricioPereira.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblMauricioPereira.setBounds(12, 269, 293, 100);
		panelInicial.add(lblMauricioPereira);
		lblMauricioPereira.setOpaque(true);
		
		JLabel lblNewLabel = new JLabel("Agenda");
		lblNewLabel.setForeground(new Color(204, 204, 204));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(102, 102, 102));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 12, 293, 261);
		panelInicial.add(lblNewLabel);
		
		JLabel lblContatos = new JLabel("Contatos");
		lblContatos.setOpaque(true);
		lblContatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblContatos.setForeground(new Color(102, 102, 102));
		lblContatos.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblContatos.setBackground(new Color(204, 204, 204));
		lblContatos.setBounds(317, 12, 349, 100);
		panelInicial.add(lblContatos);
		
		JLabel lblCompromissos = new JLabel("Compromissos");
		lblCompromissos.setOpaque(true);
		lblCompromissos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompromissos.setForeground(new Color(102, 102, 102));
		lblCompromissos.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblCompromissos.setBackground(new Color(204, 204, 204));
		lblCompromissos.setBounds(317, 269, 349, 100);
		panelInicial.add(lblCompromissos);
		
		JLabel lblTelefones = new JLabel("Telefones");
		lblTelefones.setOpaque(true);
		lblTelefones.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefones.setForeground(new Color(102, 102, 102));
		lblTelefones.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblTelefones.setBackground(new Color(204, 204, 204));
		lblTelefones.setBounds(317, 141, 349, 100);
		panelInicial.add(lblTelefones);
		
				
				
		/////////////////////////////////////////////////////////////////////////////////////////////////
																	 // PANEL LISTAR CONTATOS E TELEFONES
		JPanel panelListarContatos = new JPanel();
		panelListarContatos.setBorder(null);
		panelListarContatos.setBackground(new Color(153, 153, 153));
		panelListarContatos.setBounds(10, 11, 678, 381);
		panel_1.add(panelListarContatos);
		panelListarContatos.setLayout(null);
		panelListarContatos.setVisible(false);
		telas.add(panelListarContatos);
				
		JButton btnNome = new JButton("Nome");
		btnNome.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnNome.setForeground(new Color(255, 255, 255));
		btnNome.setBackground(new Color(102, 102, 102));
		btnNome.setBounds(10, 135, 128, 50);
		btnNome.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		panelListarContatos.add(btnNome);
		
		JButton btnTelefone = new JButton("Telefone");
		btnTelefone.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnTelefone.setForeground(new Color(255, 255, 255));
		btnTelefone.setBackground(new Color(102, 102, 102));
		btnTelefone.setBounds(197, 135, 128, 50);
		btnTelefone.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		panelListarContatos.add(btnTelefone);
		
		textField_6 = new JTextField();
		textField_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_6.setBackground(new Color(204, 204, 204));
		textField_6.setColumns(10);
		textField_6.setBounds(10, 93, 315, 30);
		panelListarContatos.add(textField_6);
		
		JLabel lblListarContatos = new JLabel("Listar Contatos e Telefones");
		lblListarContatos.setOpaque(true);
		lblListarContatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarContatos.setForeground(new Color(102, 102, 102));
		lblListarContatos.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblListarContatos.setBackground(new Color(204, 204, 204));
		lblListarContatos.setBounds(0, 0, 678, 50);
		panelListarContatos.add(lblListarContatos);
		
		JList<String> list = new JList();
		list.setSelectionBackground(new Color(255, 204, 102));
		list.setBackground(new Color(204, 204, 204));
		list.setForeground(new Color(51, 51, 51));
		list.setFont(new Font("Century Gothic", Font.BOLD, 14));
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBounds(337, 62, 329, 307);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelListarContatos.add(list);
		list.setModel(model);
		
		JLabel lblNomeTelefone = new JLabel("Nome / Telefone:");
		lblNomeTelefone.setForeground(Color.WHITE);
		lblNomeTelefone.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNomeTelefone.setBounds(13, 62, 128, 20);
		panelListarContatos.add(lblNomeTelefone);
		
		JButton btnMaps = new JButton("Mapa");
		btnMaps.setVisible(false);
		
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
					JOptionPane.showMessageDialog(null,erro.getMessage(),"Listar Telefones", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		btnNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					ArrayList<Contato> lista = Fachada.listarContatosPorNome(textField_6.getText());
					String texto = "";
					model.clear();
					for(Contato c: lista) {
						if(!c.getTelefones().isEmpty()) {
							texto =  c.getNome() + " - " + c.getTelefones() + " - " + c.getEndereco() + " - " + c.getNumero();
						} else {
							texto =  c.getNome() + " - não possui telefone" + " - " + c.getEndereco() + " - " + c.getNumero();
						}
						model.addElement(texto);
						//texto +=  c + "\n----\n";
					}
					btnMaps.setVisible(true);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage(),"Listar Contatos", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
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
					String[] endereco = item.split(" - ");
					try {
						pesquisaMaps(endereco[2],endereco[3]);
					} catch (Exception a) {
						JOptionPane.showMessageDialog(null,a.getMessage(),"Listar Contatos", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnMaps.setLocation(197, 319);
		btnMaps.setSize(128, 50);
		panelListarContatos.add(btnMaps);
		
		JButton btnListarPorProximidade = new JButton("Proximidade");
		btnListarPorProximidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField_6.getText().equals("")) {
						throw new Exception("Grau não digitado!");
					}
					ArrayList<Contato> lista = Fachada.listarContatosPorProximidade(Integer.parseInt(textField_6.getText()));
					String texto = "";
					model.clear();
					for(Contato c: lista) {
						if(!c.getTelefones().isEmpty()) {
							texto =  c.getNome() + " - " + c.getTelefones() + " - " + c.getEndereco() + " - " + c.getNumero();
						} else {
							texto =  c.getNome() + " - não possui telefone" + " - " + c.getEndereco() + " - " + c.getNumero();
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
		btnListarPorProximidade.setBounds(10, 197, 128, 50);
		panelListarContatos.add(btnListarPorProximidade);
		
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
		btnConsulta.setBounds(10, 259, 128, 50);
		panelListarContatos.add(btnConsulta);
		
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
		btnConsulta_1.setBounds(10, 319, 128, 50);
		panelListarContatos.add(btnConsulta_1);
		
		panelListarCompromisso.setBorder(null);
		panelListarCompromisso.setBackground(new Color(153, 153, 153));
		panelListarCompromisso.setBounds(10, 11, 678, 381);
		panel_1.add(panelListarCompromisso);
		telas.add(panelListarCompromisso);
		panelListarCompromisso.setLayout(null);
		
		JLabel lblListarCompromisso = new JLabel("Listar Compromisso");
		lblListarCompromisso.setOpaque(true);
		lblListarCompromisso.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarCompromisso.setForeground(new Color(102, 102, 102));
		lblListarCompromisso.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblListarCompromisso.setBackground(new Color(204, 204, 204));
		lblListarCompromisso.setBounds(0, 0, 678, 50);
		panelListarCompromisso.add(lblListarCompromisso);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_19.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_19.setBounds(10, 93, 160, 30);
		panelListarCompromisso.add(textField_19);
		
		JButton btnTtulo = new JButton("T\u00EDtulo");
		btnTtulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model4.clear();
					ArrayList<Compromisso> compromissos = Fachada.listarCompromissosPorTitulo(textField_19.getText());
					String texto = "";
					for(Compromisso c: compromissos) {
						texto = c.getId() + " - " + c.getTitulo() + " - " + c.getDatahora() + " - " + c.getTipo();
						model4.addElement(texto);
					}
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Listar Compromissos",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnTtulo.setForeground(Color.WHITE);
		btnTtulo.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnTtulo.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		btnTtulo.setBackground(new Color(102, 102, 102));
		btnTtulo.setBounds(197, 93, 128, 30);
		panelListarCompromisso.add(btnTtulo);
		
		
		JList list_1 = new JList();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setSelectionBackground(new Color(255, 204, 102));
		list_1.setForeground(UIManager.getColor("Button.foreground"));
		list_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		list_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list_1.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		list_1.setBounds(337, 62, 329, 307);
		panelListarCompromisso.add(list_1);
		
		list_1.setModel(model4);
		
		JLabel label_12 = new JLabel("Nome / Telefone:");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_12.setBounds(13, 62, 128, 20);
		panelListarCompromisso.add(label_12);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField(dataMask);
		formattedTextField_1.setForeground(UIManager.getColor("Button.foreground"));
		formattedTextField_1.setFont(new Font("Century Gothic", Font.BOLD, 13));
		formattedTextField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		formattedTextField_1.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		formattedTextField_1.setBounds(10, 167, 73, 30);
		panelListarCompromisso.add(formattedTextField_1);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField(horaMask);
		formattedTextField_2.setForeground(UIManager.getColor("Button.foreground"));
		formattedTextField_2.setFont(new Font("Century Gothic", Font.BOLD, 13));
		formattedTextField_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		formattedTextField_2.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		formattedTextField_2.setBounds(95, 167, 41, 30);
		panelListarCompromisso.add(formattedTextField_2);
		
		JLabel lblDatahorainicio = new JLabel("Data/Hora: (inicio)");
		lblDatahorainicio.setForeground(Color.WHITE);
		lblDatahorainicio.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDatahorainicio.setBounds(10, 135, 131, 20);
		panelListarCompromisso.add(lblDatahorainicio);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField(dataMask);
		formattedTextField_3.setForeground(UIManager.getColor("Button.foreground"));
		formattedTextField_3.setFont(new Font("Century Gothic", Font.BOLD, 13));
		formattedTextField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		formattedTextField_3.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		formattedTextField_3.setBounds(10, 241, 73, 30);
		panelListarCompromisso.add(formattedTextField_3);
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField(horaMask);
		formattedTextField_4.setForeground(UIManager.getColor("Button.foreground"));
		formattedTextField_4.setFont(new Font("Century Gothic", Font.BOLD, 13));
		formattedTextField_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		formattedTextField_4.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		formattedTextField_4.setBounds(95, 241, 41, 30);
		panelListarCompromisso.add(formattedTextField_4);
		
		JLabel lblDatahorafim = new JLabel("Data/Hora: (fim)");
		lblDatahorafim.setForeground(Color.WHITE);
		lblDatahorafim.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDatahorafim.setBounds(10, 209, 126, 20);
		panelListarCompromisso.add(lblDatahorafim);
		
		JButton btnIntervalo = new JButton("Intervalo");
		btnIntervalo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model4.clear();
					int dia1 = Integer.parseInt(formattedTextField_1.getText().substring(0, 2));
					int mes1 = Integer.parseInt(formattedTextField_1.getText().substring(3, 5));
					int ano1 = Integer.parseInt(formattedTextField_1.getText().substring(6));
					int hora1 = Integer.parseInt(formattedTextField_2.getText().substring(0, 2));
					int minuto1 = Integer.parseInt(formattedTextField_2.getText().substring(3));
					
					int dia2 = Integer.parseInt(formattedTextField_3.getText().substring(0, 2));
					int mes2 = Integer.parseInt(formattedTextField_3.getText().substring(3, 5));
					int ano2 = Integer.parseInt(formattedTextField_3.getText().substring(6));
					int hora2 = Integer.parseInt(formattedTextField_4.getText().substring(0, 2));
					int minuto2 = Integer.parseInt(formattedTextField_4.getText().substring(3));
					
					ArrayList<Compromisso> compromissos = Fachada.listarCompromissosPorDatas(
							LocalDateTime.of(ano1,mes1,dia1,hora1,minuto1), LocalDateTime.of(ano2,mes2,dia2,hora2,minuto2));
					String texto = "";
					for(Compromisso c: compromissos) {
						texto = c.getId() + " - " + c.getTitulo() + " - " + c.getDatahora() + " - " + c.getTipo();
						model4.addElement(texto);
					}
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Listar Compromissos",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnIntervalo.setForeground(Color.WHITE);
		btnIntervalo.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnIntervalo.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		btnIntervalo.setBackground(new Color(102, 102, 102));
		btnIntervalo.setBounds(197, 199, 128, 30);
		panelListarCompromisso.add(btnIntervalo);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox_3.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		comboBox_3.setBounds(10, 315, 143, 30);
		panelListarCompromisso.add(comboBox_3);
		
		comboBox_3.setModel(model3);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTipo.setBounds(10, 283, 126, 20);
		panelListarCompromisso.add(lblTipo);
		
		JButton btnTipo = new JButton("Tipo");
		btnTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model4.clear();
					ArrayList<Compromisso> compromissos = Fachada.listarCompromissosPorTipo(comboBox_3.getSelectedItem().toString());
					String texto = "";
					for(Compromisso c: compromissos) {
						texto = c.getId() + " - " + c.getTitulo() + " - " + c.getDatahora() + " - " + c.getTipo();
						model4.addElement(texto);
					}
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Listar Compromissos",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnTipo.setForeground(Color.WHITE);
		btnTipo.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnTipo.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		btnTipo.setBackground(new Color(102, 102, 102));
		btnTipo.setBounds(197, 315, 128, 30);
		panelListarCompromisso.add(btnTipo);
		panelAdicionarCompromisso.setBorder(null);
		panelAdicionarCompromisso.setBackground(new Color(153, 153, 153));
		panelAdicionarCompromisso.setBounds(10, 11, 678, 381);
		panel_1.add(panelAdicionarCompromisso);
		telas.add(panelAdicionarCompromisso);
		panelAdicionarCompromisso.setLayout(null);
		
		JLabel lblAdicionarCompromisso = new JLabel("Adicionar Compromisso");
		lblAdicionarCompromisso.setOpaque(true);
		lblAdicionarCompromisso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarCompromisso.setForeground(new Color(102, 102, 102));
		lblAdicionarCompromisso.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblAdicionarCompromisso.setBackground(new Color(204, 204, 204));
		lblAdicionarCompromisso.setBounds(0, 0, 678, 50);
		panelAdicionarCompromisso.add(lblAdicionarCompromisso);
		
		textField_18 = new JTextField();
		textField_18.setForeground(UIManager.getColor("Button.foreground"));
		textField_18.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_18.setColumns(10);
		textField_18.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_18.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_18.setBounds(178, 123, 322, 30);
		panelAdicionarCompromisso.add(textField_18);
		
		JFormattedTextField txDataPAC = new JFormattedTextField(dataMask);
		txDataPAC.setForeground(UIManager.getColor("Button.foreground"));
		txDataPAC.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txDataPAC.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txDataPAC.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		txDataPAC.setBounds(178, 197, 73, 30);
		panelAdicionarCompromisso.add(txDataPAC);
		
		JFormattedTextField txHoraPAC = new JFormattedTextField(horaMask);
		txHoraPAC.setForeground(UIManager.getColor("Button.foreground"));
		txHoraPAC.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txHoraPAC.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txHoraPAC.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		txHoraPAC.setBounds(263, 197, 66, 30);
		panelAdicionarCompromisso.add(txHoraPAC);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox_2.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		comboBox_2.setBounds(357, 197, 143, 30);
		panelAdicionarCompromisso.add(comboBox_2);
		
		comboBox_2.setModel(model3);
		
		JButton btnCadastrar_1 = new JButton("Cadastrar");
		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dia = Integer.parseInt(txDataPAC.getText().substring(0, 2));
				int mes = Integer.parseInt(txDataPAC.getText().substring(3, 5));
				int ano = Integer.parseInt(txDataPAC.getText().substring(6));
				int hora = Integer.parseInt(txHoraPAC.getText().substring(0, 2));
				int minuto = Integer.parseInt(txHoraPAC.getText().substring(3));
				try {
					Fachada.cadastrarCompromisso(textField_18.getText(), dia, mes, ano, hora, minuto, comboBox_2.getSelectedItem().toString());
					
					JOptionPane.showMessageDialog(null,"Compromisso Cadastrado!","Cadastrar Compromisso",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Cadastrar Compromisso",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCadastrar_1.setForeground(Color.WHITE);
		btnCadastrar_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnCadastrar_1.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		btnCadastrar_1.setBackground(new Color(102, 102, 102));
		btnCadastrar_1.setBounds(280, 262, 128, 55);
		panelAdicionarCompromisso.add(btnCadastrar_1);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setForeground(Color.WHITE);
		lblTtulo.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTtulo.setBounds(178, 91, 75, 20);
		panelAdicionarCompromisso.add(lblTtulo);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblData.setBounds(178, 165, 75, 20);
		panelAdicionarCompromisso.add(lblData);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setForeground(Color.WHITE);
		lblHora.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblHora.setBounds(263, 165, 75, 20);
		panelAdicionarCompromisso.add(lblHora);
		
		JLabel lblTipo_1 = new JLabel("Tipo:");
		lblTipo_1.setForeground(Color.WHITE);
		lblTipo_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTipo_1.setBounds(357, 165, 75, 20);
		panelAdicionarCompromisso.add(lblTipo_1);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
//																				 // PANEL REMOVER CONTATO
//		JPanel panelRemoverContato = new JPanel();
//		panelRemoverContato.setVisible(false);
//		panelRemoverContato.setBorder(null);
//		panelRemoverContato.setBackground(new Color(153, 153, 153));
//		panelRemoverContato.setBounds(10, 11, 515, 603);
//		panel_1.add(panelRemoverContato);
//		telas.add(panelRemoverContato);
//		panelRemoverContato.setLayout(null);
//		
//		textField_9 = new JTextField();
//		textField_9.setColumns(10);
//		textField_9.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
//		textField_9.setBackground(new Color(204, 204, 204));
//		textField_9.setBounds(108, 175, 296, 30);
//		panelRemoverContato.add(textField_9);
//		
//		textField_10 = new JTextField();
//		textField_10.setColumns(10);
//		textField_10.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
//		textField_10.setBackground(new Color(204, 204, 204));
//		textField_10.setBounds(108, 257, 296, 30);
//		panelRemoverContato.add(textField_10);
//		
//		JButton btnListarContato = new JButton("Remover Contato");
//		btnListarContato.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					Fachada.removerTelefone(textField_9.getText(),textField_10.getText());
//					textField_9.setText("");
//					textField_10.setText("");
//					JOptionPane.showMessageDialog(null,"Telefone removido com sucesso!");
//				} catch (Exception a) {
//					JOptionPane.showMessageDialog(null,a.getMessage());
//				}
//			}
//		});
//		btnListarContato.setForeground(Color.WHITE);
//		btnListarContato.setFont(new Font("Century Gothic", Font.BOLD, 14));
//		btnListarContato.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
//		btnListarContato.setBackground(new Color(102, 102, 102));
//		btnListarContato.setBounds(190, 342, 128, 55);
//		panelRemoverContato.add(btnListarContato);
//		
//		JLabel label = new JLabel("Nome:");
//		label.setForeground(Color.WHITE);
//		label.setFont(new Font("Century Gothic", Font.BOLD, 14));
//		label.setBounds(108, 134, 75, 30);
//		panelRemoverContato.add(label);
//		
//		JLabel lblTelefone = new JLabel("Telefone:");
//		lblTelefone.setForeground(Color.WHITE);
//		lblTelefone.setFont(new Font("Century Gothic", Font.BOLD, 14));
//		lblTelefone.setBounds(108, 216, 75, 30);
//		panelRemoverContato.add(lblTelefone);
//		
//		JLabel lblRemoverContato = new JLabel("Remover Contato");
//		lblRemoverContato.setOpaque(true);
//		lblRemoverContato.setHorizontalAlignment(SwingConstants.CENTER);
//		lblRemoverContato.setForeground(new Color(102, 102, 102));
//		lblRemoverContato.setFont(new Font("Century Gothic", Font.BOLD, 18));
//		lblRemoverContato.setBackground(new Color(204, 204, 204));
//		lblRemoverContato.setBounds(0, 0, 515, 50);
//		panelRemoverContato.add(lblRemoverContato);
				
		/////////////////////////////////////////////////////////////////////////////////////////////////
																				// PANEL REMOVER TELEFONE
		
		JPanel panelRemoverTelefone = new JPanel();
		panelRemoverTelefone.setBorder(null);
		panelRemoverTelefone.setBackground(new Color(153, 153, 153));
		panelRemoverTelefone.setBounds(10, 11, 678, 381);
		panel_1.add(panelRemoverTelefone);
		panelRemoverTelefone.setLayout(null);
		panelRemoverTelefone.setVisible(false);
		telas.add(panelRemoverTelefone);
		
		JLabel label_2 = new JLabel("Nome:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_2.setBounds(178, 91, 75, 20);
		panelRemoverTelefone.add(label_2);
		
		textField_14 = new JTextField();
		textField_14.setForeground(new Color(51, 51, 51));
		textField_14.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_14.setColumns(10);
		textField_14.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_14.setBackground(new Color(204, 204, 204));
		textField_14.setBounds(178, 122, 322, 30);
		panelRemoverTelefone.add(textField_14);
		
		txPhonePRT = new JFormattedTextField(foneMask); 							// textField TELEFONE
		txPhonePRT.setForeground(new Color(51, 51, 51));
		txPhonePRT.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txPhonePRT.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txPhonePRT.setBackground(new Color(204, 204, 204));
		txPhonePRT.setBounds(178, 194, 322, 30);
		panelRemoverTelefone.add(txPhonePRT);
		
		JLabel label_4 = new JLabel("N\u00FAmero:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_4.setBounds(178, 163, 75, 20);
		panelRemoverTelefone.add(label_4);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fachada.removerTelefone(textField_14.getText(),txPhonePRT.getText().trim().replace("-", ""));
					textField_14.setText("");
					txPhonePRT.setText("");
					JOptionPane.showMessageDialog(null,"Telefone removido com sucesso!","Remover Telefone",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Remover Telefone",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnRemover.setForeground(Color.WHITE);
		btnRemover.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnRemover.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		btnRemover.setBackground(new Color(102, 102, 102));
		btnRemover.setBounds(275, 275, 128, 55);
		panelRemoverTelefone.add(btnRemover);
		
		JLabel lblRemoverTelefone = new JLabel("Remover Telefone ");
		lblRemoverTelefone.setBackground(new Color(204, 204, 204));
		lblRemoverTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverTelefone.setForeground(new Color(102, 102, 102));
		lblRemoverTelefone.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblRemoverTelefone.setBounds(0, 0, 678, 50);
		lblRemoverTelefone.setOpaque(true);
		panelRemoverTelefone.add(lblRemoverTelefone);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
																			  // PANEL ADICIONAR TELEFONE
		JPanel panelAdicionarTelefone = new JPanel();
		panelAdicionarTelefone.setBorder(null);
		panelAdicionarTelefone.setBackground(new Color(153, 153, 153));
		panelAdicionarTelefone.setBounds(10, 11, 678, 381);
		panel_1.add(panelAdicionarTelefone);
		panelAdicionarTelefone.setLayout(null);
		panelAdicionarTelefone.setVisible(false);
		telas.add(panelAdicionarTelefone);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_1.setBounds(178, 91, 75, 20);
		panelAdicionarTelefone.add(label_1);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_11.setColumns(10);
		textField_11.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_11.setBackground(new Color(204, 204, 204));
		textField_11.setBounds(178, 122, 322, 30);
		panelAdicionarTelefone.add(textField_11);
		
		txDddPAT = new JFormattedTextField(dddMask); 							// textField DDD
		txDddPAT.setForeground(new Color(51, 51, 51));
		txDddPAT.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txDddPAT.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txDddPAT.setBackground(new Color(204, 204, 204));
		txDddPAT.setBounds(178, 194, 75, 30);
		panelAdicionarTelefone.add(txDddPAT);
		
		JLabel lblDdd = new JLabel("DDD:");
		lblDdd.setForeground(Color.WHITE);
		lblDdd.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDdd.setBounds(178, 167, 75, 20);
		panelAdicionarTelefone.add(lblDdd);
		
		txPhonePAT = new JFormattedTextField(foneMask); 							// textField TELEFONE
		txPhonePAT.setForeground(new Color(51, 51, 51));
		txPhonePAT.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txPhonePAT.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txPhonePAT.setBackground(new Color(204, 204, 204));
		txPhonePAT.setBounds(263, 194, 237, 30);
		panelAdicionarTelefone.add(txPhonePAT);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setForeground(Color.WHITE);
		lblNmero.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNmero.setBounds(263, 167, 75, 20);
		panelAdicionarTelefone.add(lblNmero);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Fachada.adicionarTelefone(textField_11.getText(),txDddPAT.getText().trim(),txPhonePAT.getText().trim().replace("-",""));
					JOptionPane.showMessageDialog(null,"Telefone adicionado com sucesso!", "Adicionar Telefone", JOptionPane.INFORMATION_MESSAGE);
					textField_11.setText("");
					txDddPAT.setText("");
					txPhonePAT.setText("");
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Adicionar Telefone", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnAdicionar.setForeground(Color.WHITE);
		btnAdicionar.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnAdicionar.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		btnAdicionar.setBackground(new Color(102, 102, 102));
		btnAdicionar.setBounds(275, 275, 128, 55);
		panelAdicionarTelefone.add(btnAdicionar);
		
		JLabel lblAdicionarTelefone = new JLabel("Adicionar Telefone ");
		lblAdicionarTelefone.setOpaque(true);
		lblAdicionarTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarTelefone.setForeground(new Color(102, 102, 102));
		lblAdicionarTelefone.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblAdicionarTelefone.setBackground(new Color(204, 204, 204));
		lblAdicionarTelefone.setBounds(0, 0, 678, 50);
		panelAdicionarTelefone.add(lblAdicionarTelefone);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
		 															 			 // PANEL ALTERAR CONTATO
		
		JPanel panelAlterarContato = new JPanel();
		panelAlterarContato.setBorder(null);
		panelAlterarContato.setBackground(new Color(153, 153, 153));
		panelAlterarContato.setBounds(10, 11, 678, 381);
		panel_1.add(panelAlterarContato);
		panelAlterarContato.setLayout(null);
		panelAlterarContato.setVisible(false);
		telas.add(panelAlterarContato);
		
		JLabel lblAlterarContato = new JLabel("Alterar Dados do Contato");
		lblAlterarContato.setOpaque(true);
		lblAlterarContato.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterarContato.setForeground(new Color(102, 102, 102));
		lblAlterarContato.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblAlterarContato.setBackground(new Color(204, 204, 204));
		lblAlterarContato.setBounds(0, 0, 678, 50);
		panelAlterarContato.add(lblAlterarContato);
		
		JLabel lblNomeobrigatrio = new JLabel("Nome: (obrigat\u00F3rio)");
		lblNomeobrigatrio.setForeground(Color.WHITE);
		lblNomeobrigatrio.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNomeobrigatrio.setBounds(48, 62, 157, 20);
		panelAlterarContato.add(lblNomeobrigatrio);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_2.setColumns(10);
		textField_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_2.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_2.setBounds(48, 93, 288, 30);
		panelAlterarContato.add(textField_2);
		
		JLabel label_5 = new JLabel("E-mail:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_5.setBounds(348, 208, 75, 20);
		panelAlterarContato.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_3.setColumns(10);
		textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_3.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_3.setBounds(348, 239, 176, 30);
		panelAlterarContato.add(textField_3);
		
		JLabel label_6 = new JLabel("CEP:");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_6.setBounds(48, 135, 75, 20);
		panelAlterarContato.add(label_6);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(cepMask);
		formattedTextField.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				String texto = formattedTextField.getText().trim().replace(".", "").replace("-", "").replace("_", "");
				if(texto.length() == 8) {
					String jsonCEP = Cep(texto);
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
						textField_4.setText(texto2);
					}					
				} else {
					JOptionPane.showMessageDialog(null,"CEP incompleto","Alterar Dados de Contato", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		formattedTextField.setFont(new Font("Century Gothic", Font.BOLD, 13));
		formattedTextField.setColumns(10);
		formattedTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		formattedTextField.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		formattedTextField.setBounds(48, 166, 115, 30);
		panelAlterarContato.add(formattedTextField);
		
		JLabel label_7 = new JLabel("Endereco:");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_7.setBounds(175, 135, 75, 20);
		panelAlterarContato.add(label_7);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_4.setColumns(10);
		textField_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_4.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_4.setBounds(175, 166, 349, 30);
		panelAlterarContato.add(textField_4);
		
		JLabel label_8 = new JLabel("N\u00FAmero:");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_8.setBounds(443, 62, 75, 20);
		panelAlterarContato.add(label_8);
		
		textField_13 = new JTextField(10);
		textField_13.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_13.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_13.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_13.setBounds(443, 93, 81, 30);
		panelAlterarContato.add(textField_13);
		
		JLabel label_9 = new JLabel("Facebook:");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_9.setBounds(48, 208, 75, 20);
		panelAlterarContato.add(label_9);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_15.setColumns(10);
		textField_15.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_15.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_15.setBounds(48, 239, 176, 30);
		panelAlterarContato.add(textField_15);
		
		JLabel label_10 = new JLabel("Anivers\u00E1rio (Dia/M\u00EAs):");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_10.setBounds(48, 281, 157, 20);
		panelAlterarContato.add(label_10);
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_16.setColumns(10);
		textField_16.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_16.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_16.setBounds(48, 312, 68, 30);
		panelAlterarContato.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_17.setColumns(10);
		textField_17.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_17.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_17.setBounds(128, 312, 96, 30);
		panelAlterarContato.add(textField_17);
		
		JLabel label_11 = new JLabel("Proximidade:");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_11.setBounds(381, 281, 96, 20);
		panelAlterarContato.add(label_11);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox_1.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		comboBox_1.setBounds(348, 312, 176, 30);
		panelAlterarContato.add(comboBox_1);
		comboBox_1.setModel(model2);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Contato contato = Fachada.alterarDados(textField_2.getText());
					contato.setCep(formattedTextField.getText().trim().replace(".", "").replace("-", ""));
					contato.setEndereco(textField_4.getText());
					JOptionPane.showMessageDialog(null,"CEP e Endereço alterados com sucesso!","Alterar Dados de Contato", JOptionPane.INFORMATION_MESSAGE);
					textField_2.setText("");
					formattedTextField.setText("");
					textField_4.setText("");
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Alterar Dados de Contato", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnAlterar.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		btnAlterar.setBackground(new Color(102, 102, 102));
		btnAlterar.setBounds(542, 166, 100, 30);
		panelAlterarContato.add(btnAlterar);
		
		JButton button_3 = new JButton("Alterar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Contato contato = Fachada.alterarDados(textField_2.getText());
					contato.setNumero(textField_13.getText());
					JOptionPane.showMessageDialog(null,"Número alterado com sucesso!","Alterar Dados de Contato", JOptionPane.INFORMATION_MESSAGE);
					textField_2.setText("");
					textField_13.setText("");
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Alterar Dados de Contato", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Century Gothic", Font.BOLD, 14));
		button_3.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		button_3.setBackground(new Color(102, 102, 102));
		button_3.setBounds(542, 93, 100, 30);
		panelAlterarContato.add(button_3);
		
		JButton button_4 = new JButton("Alterar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Contato contato = Fachada.alterarDados(textField_2.getText());
					contato.setNumero(textField_3.getText());
					JOptionPane.showMessageDialog(null,"E-mail alterado com sucesso!","Alterar Dados de Contato", JOptionPane.INFORMATION_MESSAGE);
					textField_2.setText("");
					textField_3.setText("");
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Alterar Dados de Contato", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Century Gothic", Font.BOLD, 14));
		button_4.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		button_4.setBackground(new Color(102, 102, 102));
		button_4.setBounds(542, 239, 100, 30);
		panelAlterarContato.add(button_4);
		
		JButton button_2 = new JButton("Alterar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Contato contato = Fachada.alterarDados(textField_2.getText());
					contato.setGrauproximidade(comboBox_1.getSelectedIndex());
					JOptionPane.showMessageDialog(null,"Grau de proximidade alterado com sucesso!","Alterar Dados de Contato", JOptionPane.INFORMATION_MESSAGE);
					textField_2.setText("");
					comboBox_1.setSelectedIndex(0);;
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Alterar Dados de Contato", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		button_2.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		button_2.setBackground(new Color(102, 102, 102));
		button_2.setBounds(542, 312, 100, 30);
		panelAlterarContato.add(button_2);
		
		JButton button_5 = new JButton("Alterar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Contato contato = Fachada.alterarDados(textField_2.getText());
					contato.setMesaniversario(Integer.parseInt(textField_17.getText()));
					contato.setDiaaniversario(Integer.parseInt(textField_16.getText()));
					JOptionPane.showMessageDialog(null,"Dia e mês do aniversário alterados com sucesso!","Alterar Dados de Contato", JOptionPane.INFORMATION_MESSAGE);
					textField_2.setText("");
					textField_16.setText("");
					textField_17.setText("");
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Alterar Dados de Contato", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Century Gothic", Font.BOLD, 14));
		button_5.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		button_5.setBackground(new Color(102, 102, 102));
		button_5.setBounds(236, 312, 100, 30);
		panelAlterarContato.add(button_5);
		
		JButton button_6 = new JButton("Alterar");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Contato contato = Fachada.alterarDados(textField_2.getText());
					contato.setLinkfacebook(textField_15.getText());
					JOptionPane.showMessageDialog(null,"Facebook alterado com sucesso!","Alterar Dados de Contato", JOptionPane.INFORMATION_MESSAGE);
					textField_2.setText("");
					textField_15.setText("");
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Alterar Dados de Contato", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Century Gothic", Font.BOLD, 14));
		button_6.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		button_6.setBackground(new Color(102, 102, 102));
		button_6.setBounds(236, 239, 100, 30);
		panelAlterarContato.add(button_6);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
																			   // PANEL CADASTRAR CONTATO
		JPanel panelCadContato = new JPanel();
		panelCadContato.setBorder(null);
		panelCadContato.setBounds(10, 11, 678, 381);
		panel_1.add(panelCadContato);
		panelCadContato.setBackground(new Color(153, 153, 153));
		panelCadContato.setLayout(null);
		panelCadContato.setVisible(false);
		telas.add(panelCadContato);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNome.setBounds(50, 62, 75, 20);
		panelCadContato.add(lblNome);
		
		textField = new JTextField();
		textField.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setBackground(new Color(204, 204, 204));
		textField.setColumns(10);
		textField.setBounds(50, 93, 322, 30);
		panelCadContato.add(textField);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblEmail.setBounds(384, 62, 75, 20);
		panelCadContato.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_1.setBackground(new Color(204, 204, 204));
		textField_1.setColumns(10);
		textField_1.setBounds(384, 93, 256, 30);
		panelCadContato.add(textField_1);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setForeground(new Color(255, 255, 255));
		lblCep.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblCep.setBounds(50, 135, 75, 20);
		panelCadContato.add(lblCep);
		
		txCepPCC = new JFormattedTextField(cepMask);
		txCepPCC.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				String texto = txCepPCC.getText().trim().replace(".", "").replace("-", "").replace("_", "");
				if(texto.length() == 8) {
					String jsonCEP = Cep(texto);
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
						txEndereco.setText(texto2);
					}					
				} else {
					JOptionPane.showMessageDialog(null,"CEP incompleto","Cadastrar Contato", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		txCepPCC.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txCepPCC.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txCepPCC.setBackground(new Color(204, 204, 204));
		txCepPCC.setColumns(10);
		txCepPCC.setBounds(50, 166, 115, 30);
		panelCadContato.add(txCepPCC);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setForeground(new Color(255, 255, 255));
		lblEndereco.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblEndereco.setBounds(177, 135, 75, 20);
		panelCadContato.add(lblEndereco);
		
		txEndereco = new JTextField();
		txEndereco.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txEndereco.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txEndereco.setBackground(new Color(204, 204, 204));
		txEndereco.setColumns(10);
		txEndereco.setBounds(177, 166, 370, 30);
		panelCadContato.add(txEndereco);
		
		JLabel lblFacebook = new JLabel("Número:");
		lblFacebook.setForeground(new Color(255, 255, 255));
		lblFacebook.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblFacebook.setBounds(559, 135, 75, 20);
		panelCadContato.add(lblFacebook);
		
		txNumeroPCC = new JTextField(5);
		txNumeroPCC.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txNumeroPCC.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txNumeroPCC.setBackground(new Color(204, 204, 204));
		txNumeroPCC.setColumns(10);
		txNumeroPCC.setBounds(559, 166, 81, 30);
		panelCadContato.add(txNumeroPCC);
		
		JLabel label_3 = new JLabel("Facebook:");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_3.setBounds(50, 208, 75, 20);
		panelCadContato.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_5.setBackground(new Color(204, 204, 204));
		textField_5.setColumns(10);
		textField_5.setBounds(50, 239, 266, 30);
		panelCadContato.add(textField_5);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_1.getText().equals("")) {
					try {
						Fachada.cadastrarContatoNome(textField.getText());
						JOptionPane.showMessageDialog(null,"Contato cadastrado com sucesso!","Cadastrar Contato", JOptionPane.INFORMATION_MESSAGE);
						textField.setText("");
						textField_1.setText("");
						txCepPCC.setText("");
						txEndereco.setText("");
						txNumeroPCC.setText("");
						textField_5.setText("");
						textField_7.setText("");
						textField_8.setText("");
						comboBox.setSelectedIndex(0);
					} catch (Exception a){
						JOptionPane.showMessageDialog(null,a.getMessage(),"Cadastrar Contato", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					try {
						Fachada.cadastrarContato(textField.getText(),textField_1.getText(), 
								txCepPCC.getText().trim().replace(".", "").replace("-", ""), txEndereco.getText(),
								txNumeroPCC.getText(), textField_5.getText(), comboBox.getSelectedIndex(), Integer.parseInt(textField_7.getText()), 
								Integer.parseInt(textField_8.getText()));
						JOptionPane.showMessageDialog(null,"Contato cadastrado com sucesso!","Cadastrar Contato", JOptionPane.INFORMATION_MESSAGE);
						textField.setText("");
						textField_1.setText("");
						txCepPCC.setText("");
						txEndereco.setText("");
						txNumeroPCC.setText("");
						textField_5.setText("");
						textField_7.setText("");
						textField_8.setText("");
						comboBox.setSelectedIndex(0);
					} catch (Exception a){
						JOptionPane.showMessageDialog(null,a.getMessage(),"Cadastrar Contato", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnCadastrar.setBounds(275, 300, 128, 55);
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(102, 102, 102));
		btnCadastrar.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		panelCadContato.add(btnCadastrar);
		
		JLabel lblProximidade = new JLabel("Anivers\u00E1rio (Dia/M\u00EAs):");
		lblProximidade.setForeground(new Color(255, 255, 255));
		lblProximidade.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblProximidade.setBounds(328, 208, 157, 20);
		panelCadContato.add(lblProximidade);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_7.setBackground(new Color(204, 204, 204));
		textField_7.setColumns(10);
		textField_7.setBounds(328, 239, 48, 30);
		panelCadContato.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_8.setBackground(new Color(204, 204, 204));
		textField_8.setColumns(10);
		textField_8.setBounds(386, 239, 96, 30);
		panelCadContato.add(textField_8);
		
		JLabel lblProximidade_1 = new JLabel("Proximidade:");
		lblProximidade_1.setForeground(new Color(255, 255, 255));
		lblProximidade_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblProximidade_1.setBounds(497, 208, 96, 20);
		panelCadContato.add(lblProximidade_1);
		
		JLabel lblCadastrarContato = new JLabel("Cadastrar Contato");
		lblCadastrarContato.setOpaque(true);
		lblCadastrarContato.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarContato.setForeground(new Color(102, 102, 102));
		lblCadastrarContato.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblCadastrarContato.setBackground(new Color(204, 204, 204));
		lblCadastrarContato.setBounds(0, 0, 678, 50);
		panelCadContato.add(lblCadastrarContato);
		
		
		
		comboBox = new JComboBox();
		comboBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox.setBackground(new Color(204, 204, 204));
		comboBox.setBounds(497, 239, 143, 30);
		panelCadContato.add(comboBox);
		comboBox.setModel(model1);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
																						// MENU PRINCIPAL
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(null);
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(new Color(255, 153, 51));
		menuBar.setBounds(0, 0, 700, 48);
		frame.getContentPane().add(menuBar);
		
		JMenu mnContatos = new JMenu("                           Contatos                           ");
		mnContatos.setBounds(new Rectangle(0, 0, 100, 0));
		mnContatos.setBorder(null);
		mnContatos.setFont(new Font("Century Gothic", Font.BOLD, 18));
		mnContatos.setBackground(new Color(255, 153, 51));
		mnContatos.setForeground(new Color(255, 255, 255));
		mnContatos.setOpaque(true);
		menus.add(mnContatos);
		menuBar.add(mnContatos);
		
		JMenuItem cadastrarContato = new JMenuItem("Cadastrar Contato");
		cadastrarContato.setFont(new Font("Century Gothic", Font.BOLD, 14));
		cadastrarContato.setForeground(new Color(102, 102, 102));
		cadastrarContato.setBackground(new Color(255, 255, 255));
		cadastrarContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evidenciarPanel(panelCadContato);
				evidenciarMenu(mnContatos);
			}
		});
		cadastrarContato.setHorizontalAlignment(SwingConstants.LEFT);
		mnContatos.add(cadastrarContato);
		
		JMenuItem mntmContatos = new JMenuItem("Adicionar Telefone");
		mntmContatos.setFont(new Font("Century Gothic", Font.BOLD, 14));
		mntmContatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evidenciarPanel(panelAdicionarTelefone);
				evidenciarMenu(mnContatos);
			}
		});
		
		JMenuItem mntmAlterarDadosDe = new JMenuItem("Alterar Dados do Contato");
		mntmAlterarDadosDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evidenciarPanel(panelAlterarContato);
				evidenciarMenu(mnContatos);
			}
		});
		mntmAlterarDadosDe.setHorizontalAlignment(SwingConstants.LEFT);
		mntmAlterarDadosDe.setForeground(new Color(102, 102, 102));
		mntmAlterarDadosDe.setFont(new Font("Century Gothic", Font.BOLD, 14));
		mntmAlterarDadosDe.setBackground(Color.WHITE);
		mnContatos.add(mntmAlterarDadosDe);
		mntmContatos.setHorizontalAlignment(SwingConstants.LEFT);
		mntmContatos.setForeground(new Color(102, 102, 102));
		mntmContatos.setBackground(new Color(255, 255, 255));
		mnContatos.add(mntmContatos);
		
		JMenuItem mntmRemoverTelefone = new JMenuItem("Remover Telefone");
		mntmRemoverTelefone.setFont(new Font("Century Gothic", Font.BOLD, 14));
		mntmRemoverTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				evidenciarPanel(panelRemoverTelefone);
				evidenciarMenu(mnContatos);
			}
		});
		mntmRemoverTelefone.setHorizontalAlignment(SwingConstants.LEFT);
		mntmRemoverTelefone.setForeground(new Color(102, 102, 102));
		mnContatos.add(mntmRemoverTelefone);
		mntmRemoverTelefone.setBackground(new Color(255, 255, 255));
		
		JMenuItem mntmListar = new JMenuItem("Listar Contatos e Telefones");
		mntmListar.setFont(new Font("Century Gothic", Font.BOLD, 14));
		mnContatos.add(mntmListar);
		mntmListar.setForeground(new Color(102, 102, 102));
		mntmListar.setBackground(new Color(255, 255, 255));
		mntmListar.setHorizontalAlignment(SwingConstants.LEFT);
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evidenciarPanel(panelListarContatos);
				evidenciarMenu(mnContatos);
			}
		});
		
		JMenu mnCompromissos = new JMenu("                      Compromissos                    ");
		mnCompromissos.setOpaque(true);
		mnCompromissos.setBackground(new Color(255, 153, 51));
		mnCompromissos.setForeground(new Color(255, 255, 255));
		mnCompromissos.setFont(new Font("Century Gothic", Font.BOLD, 18));
		menuBar.add(mnCompromissos);
		menus.add(mnCompromissos);
		
		JMenuItem mntmAdicionarCompromisso = new JMenuItem("Adicionar");
		mntmAdicionarCompromisso.setFont(new Font("Century Gothic", Font.BOLD, 14));
		mntmAdicionarCompromisso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evidenciarPanel(panelAdicionarCompromisso);
				evidenciarMenu(mnCompromissos);
			}
		});
		mntmAdicionarCompromisso.setHorizontalAlignment(SwingConstants.LEFT);
		mntmAdicionarCompromisso.setForeground(new Color(102, 102, 102));
		mntmAdicionarCompromisso.setBackground(new Color(255, 255, 255));
		mnCompromissos.add(mntmAdicionarCompromisso);
		
		JMenuItem mntmCompromissos = new JMenuItem("Listar Compromissos");				// PESQUISAR COMPROMISSOS
		mntmCompromissos.setFont(new Font("Century Gothic", Font.BOLD, 14));
		mntmCompromissos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evidenciarPanel(panelListarCompromisso);
				evidenciarMenu(mnCompromissos);
			}
		});
		mnCompromissos.add(mntmCompromissos);
		mntmCompromissos.setHorizontalAlignment(SwingConstants.LEFT);
		mntmCompromissos.setForeground(new Color(102, 102, 102));
		mntmCompromissos.setBackground(new Color(255, 255, 255));
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
/*
1. Listar contatos por nome 												<< 1. OK
Dados: nome (parcial ou completo)
Resultados: contatos e telefones que contenham o nome pedido

2. Listar contatos por telefone												<< 2. OK
Dados: numero de telefone (parcial ou completo)
Resultados: contatos e telefones que contenham o numero pedido

3. Listar contatos por proximidade											<< 3. OK
Dados: grau de proximidade
Resultados: contatos e telefones do grau pedido

4. Listar compromissos por nome												<< 4. OK
Dados: titulo (parcial ou completo)
Resultados: compromissos que contenham o título pedido

5. Listar compromissos por data												<< 5. OK
Dados: data1(dia,mês,ano) as 0hs e data2 (dia,mês,ano) as 23:59hs
Resultados: compromissos que ocorrerão no intervalo de datas pedido

6. Listar compromissos portipo												<< 6. OK
Dados: tipo de compromisso
Resultados: compromissos do tipo pedido

7. Listar telefones															<< 7. OK
Resultados: telefones da agenda com os nomes dos respectivos contatos

8. Cadastrar contato 														<< 8. OK
Dados: dados do contato (não inclui telefone)
Resultados: mensagem de confirmação

9. Adicionar telefone 														<< 9. OK
Dados: nome do contato, ddd e numero de telefone
Resultados: mensagem de confirmação

10. Remover telefone 														<< 10. OK
Dados: nome do contato, numero de telefone
Resultados: mensagem de confirmação

11. Cadastrar compromisso 													<< 11. OK
Dados: dados do compromisso 
Resultados: id do compromisso

12. Consulta1 																<< 12.
Resultado: nome dos contatos que tem 2 telefones ou mais

13. Consulta2 																<< 13.
Resultado: numero dos telefones que tem 2 contatos ou mai
 */
	}
	
	/* METODO PARA DEIXAR VISIVEL APENAS UMA DAS JANELAS DE ACORDO COM A OPÇÃO ESCOLHIDA NO MENU */
	
	public void evidenciarPanel(JPanel tela) {
		for (JPanel p: telas) {
			if(p == tela) {
				p.setVisible(true);
			} else {
				p.setVisible(false);
			}
		}
	}
	
	public void evidenciarMenu(JMenuItem menu) {
		for (JMenuItem m: menus) {
			if(m == menu) {
				m.setBackground(new Color(104, 104, 104));
				m.setForeground(new Color(255, 255, 255));
			} else {
				m.setForeground(new Color(255, 255, 255));
				m.setBackground(new Color(255, 153, 51));
			}
		}
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
}