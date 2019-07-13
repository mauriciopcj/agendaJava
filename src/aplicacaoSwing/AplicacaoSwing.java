package aplicacaoSwing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import fachada.Fachada;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class AplicacaoSwing {

	private JFrame frame;
	private ArrayList<JPanel> telas = new ArrayList<>();

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
		frame.setBounds((width-428)/2, (heigth-386)/2, 428, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		try {
			Fachada.cadastrarContato("Mauricio", "mauricio@mauricio", "58052280", "115", "mauriciojunior", 1, 9, 22);
			Fachada.cadastrarContato("Renato", "mauro@mauro", "58052280", "357", "mauro", 2, 8, 24);
			Fachada.cadastrarContato("Rafael", "jose@mjose", "58052280", "2", "josejose", 3, 3, 10);
			Fachada.cadastrarContato("Francisco", "jair@jair", "58052280", "2", "jairjair", 3, 3, 10);
			Fachada.cadastrarContato("Romero","romero@romero","58052280","218", "romero",3,12,5);
		} catch (Exception a){
			System.out.println(a.getMessage());
		}		
			
		try {
			Fachada.adicionarTelefone("Mauricio", "83", "999803355");
			Fachada.adicionarTelefone("Mauricio", "83", "986803355");
			Fachada.adicionarTelefone("Renato", "83", "987784512");
			Fachada.adicionarTelefone("Rafael", "83", "999546581");
			Fachada.adicionarTelefone("Rafael", "83", "987453215");
			Fachada.adicionarTelefone("Renato", "83", "986803355");
			Fachada.adicionarTelefone("Romero", "83", "965497512");
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		try {
			Fachada.cadastrarCompromisso("Casa de jéssica",10,2,2019,10,00,"aniversário");
			Fachada.cadastrarCompromisso("Barzinho",20,5,2019,10,00,"festa");
			Fachada.cadastrarCompromisso("Restaurante na praia",1,7,2019,10,00,"festa");
			Fachada.cadastrarCompromisso("Faculdade",30,1,2019,10,00,"reunião");
			Fachada.cadastrarCompromisso("Trabalho",22,4,2019,10,00,"reunião");
			Fachada.cadastrarCompromissoGrupo("Churrasco",10,8,2019,10,00,"festa","Mauricio","Rafael","Romero");
		} catch (Exception a) {
			System.out.println(a.getMessage());
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
																					  // TODOS OS PAINEIS
		
		JPanel panel_1 = new JPanel();			// PANEL PRINCIPAL
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(102, 102, 102));
		panel_1.setBounds(0, 0, 422, 357);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panelInicial = new JPanel();
		panelInicial.setBounds(10, 11, 403, 336);
		panel_1.add(panelInicial);
		panelInicial.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(204, 204, 204)));
		panelInicial.setBackground(new Color(153, 153, 153));
		panelInicial.setLayout(null);
		panelInicial.setVisible(true);
		telas.add(panelInicial);
		
		JLabel lblMauricioPereira = new JLabel("Mauricio Pereira");
		lblMauricioPereira.setBackground(new Color(51, 51, 51));
		lblMauricioPereira.setForeground(new Color(255, 153, 51));
		lblMauricioPereira.setHorizontalAlignment(SwingConstants.CENTER);
		lblMauricioPereira.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblMauricioPereira.setBounds(231, 33, 162, 29);
		panelInicial.add(lblMauricioPereira);
		lblMauricioPereira.setOpaque(true);
		
		JLabel lblNewLabel = new JLabel("  Agenda");
		lblNewLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(51, 51, 51)));
		lblNewLabel.setForeground(new Color(204, 204, 204));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(102, 102, 102));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 10, 383, 74);
		panelInicial.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(102, 102, 102)));
		panel.setBackground(new Color(255, 153, 51));
		panel.setBounds(141, 95, 121, 229);
		panelInicial.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdicionar = new JLabel("adicionar");
		lblAdicionar.setToolTipText("adicionar telefone a contato");
		lblAdicionar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		lblAdicionar.setBounds(10, 122, 100, 25);
		panel.add(lblAdicionar);
		lblAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AdicionarTelefone j = new AdicionarTelefone();
				j.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblAdicionar.setForeground(new Color(102,102,102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblAdicionar.setForeground(new Color(255,255,255));
			}
		});
		lblAdicionar.setOpaque(true);
		lblAdicionar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionar.setForeground(new Color(255, 255, 255));
		lblAdicionar.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblAdicionar.setBackground(new Color(255, 153, 51));
		
		JLabel lblRemover = new JLabel("remover");
		lblRemover.setToolTipText("remover telefone do contato");
		lblRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RemoverTelefone j = new RemoverTelefone();
				j.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblRemover.setForeground(new Color(102,102,102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblRemover.setForeground(new Color(255,255,255));
			}
		});
		lblRemover.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		lblRemover.setOpaque(true);
		lblRemover.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemover.setForeground(new Color(255, 255, 255));
		lblRemover.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblRemover.setBackground(new Color(255, 153, 51));
		lblRemover.setBounds(10, 157, 100, 25);
		panel.add(lblRemover);
		
		JLabel lblContatos = new JLabel("");
		lblContatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblContatos.setForeground(Color.WHITE);
		lblContatos.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblContatos.setBorder(null);
		lblContatos.setBackground(new Color(255, 153, 51));
		lblContatos.setBounds(10, 11, 100, 100);
		panel.add(lblContatos);
		
		ImageIcon icon = new ImageIcon(AplicacaoSwing.class.getResource("/img/img_322946.png"));
		icon.setImage(icon.getImage().getScaledInstance(lblContatos.getWidth(),lblContatos.getHeight(), Image.SCALE_DEFAULT));
		lblContatos.setIcon(icon);
		
		JLabel lblListar = new JLabel("listar");
		lblListar.setToolTipText("listar contatos e telefones");
		lblListar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ListarContatos j = new ListarContatos();
				j.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblListar.setForeground(new Color(102,102,102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblListar.setForeground(new Color(255,255,255));
			}
		});
		lblListar.setOpaque(true);
		lblListar.setHorizontalAlignment(SwingConstants.CENTER);
		lblListar.setForeground(Color.WHITE);
		lblListar.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblListar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		lblListar.setBackground(new Color(255, 153, 51));
		lblListar.setBounds(10, 193, 100, 25);
		
		panel.add(lblListar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(102, 102, 102)));
		panel_2.setBackground(new Color(255, 153, 51));
		panel_2.setBounds(10, 95, 121, 229);
		panelInicial.add(panel_2);
		
		JLabel label = new JLabel("adicionar");
		label.setToolTipText("adicionar contato");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CadastrarContato j = new CadastrarContato();
				j.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				label.setForeground(new Color(102,102,102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				label.setForeground(new Color(255,255,255));
			}
		});
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		label.setBackground(new Color(255, 153, 51));
		label.setBounds(10, 119, 100, 25);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("remover");
		label_1.setToolTipText("remover contato");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RemoverContato j = new RemoverContato();
				j.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				label_1.setForeground(new Color(102,102,102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				label_1.setForeground(new Color(255,255,255));
			}
		});
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		label_1.setBackground(new Color(255, 153, 51));
		label_1.setBounds(10, 191, 100, 25);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("alterar");
		label_2.setToolTipText("alterar dados de contato");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AlterarContato j = new AlterarContato();
				j.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				label_2.setForeground(new Color(102,102,102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				label_2.setForeground(new Color(255,255,255));
			}
		});
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		label_2.setBackground(new Color(255, 153, 51));
		label_2.setBounds(10, 155, 100, 25);
		panel_2.add(label_2);
		
		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_4.setBorder(null);
		label_4.setBackground(new Color(255, 153, 51));
		label_4.setBounds(10, 10, 100, 100);
		panel_2.add(label_4);
		
		ImageIcon icon3 = new ImageIcon(AplicacaoSwing.class.getResource("/img/585e4beacb11b227491c3399.png"));
		icon3.setImage(icon3.getImage().getScaledInstance(label_4.getWidth(),label_4.getHeight(), Image.SCALE_DEFAULT));
		label_4.setIcon(new ImageIcon(AplicacaoSwing.class.getResource("/img/585e4beacb11b227491c3399.png")));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(102, 102, 102)));
		panel_3.setBackground(new Color(255, 153, 51));
		panel_3.setBounds(272, 97, 121, 229);
		panelInicial.add(panel_3);
		
		JLabel label_14 = new JLabel("adicionar");
		label_14.setToolTipText("adicionar compromisso");
		label_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdicionarCompromisso j = new AdicionarCompromisso();
				j.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				label_14.setForeground(new Color(102,102,102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				label_14.setForeground(new Color(255,255,255));
			}
		});
		label_14.setOpaque(true);
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_14.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		label_14.setBackground(new Color(255, 153, 51));
		label_14.setBounds(10, 122, 100, 25);
		panel_3.add(label_14);
		
		JLabel label_15 = new JLabel("remover");
		label_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemoverCompromisso j = new RemoverCompromisso();
				j.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				label_15.setForeground(new Color(102,102,102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				label_15.setForeground(new Color(255,255,255));
			}
		});
		label_15.setToolTipText("remover compromisso");
		label_15.setOpaque(true);
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_15.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		label_15.setBackground(new Color(255, 153, 51));
		label_15.setBounds(10, 158, 100, 25);
		panel_3.add(label_15);
		
		JLabel lblListar_1 = new JLabel("listar");
		lblListar_1.setToolTipText("listar compromissos");
		lblListar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ListarCompromisso j = new ListarCompromisso();
				j.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblListar_1.setForeground(new Color(102,102,102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblListar_1.setForeground(new Color(255,255,255));
			}
		});
		lblListar_1.setOpaque(true);
		lblListar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblListar_1.setForeground(Color.WHITE);
		lblListar_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblListar_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		lblListar_1.setBackground(new Color(255, 153, 51));
		lblListar_1.setBounds(10, 194, 100, 25);
		panel_3.add(lblListar_1);
		
		JLabel lblCompromissos = new JLabel("");
		lblCompromissos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompromissos.setForeground(Color.WHITE);
		lblCompromissos.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblCompromissos.setBackground(new Color(255, 153, 51));
		lblCompromissos.setBounds(10, 11, 100, 100);
		
		ImageIcon icon2 = new ImageIcon(AplicacaoSwing.class.getResource("/img/2163-512.png"));
		icon2.setImage(icon2.getImage().getScaledInstance(lblCompromissos.getWidth(),lblCompromissos.getHeight(), Image.SCALE_DEFAULT));
		
		lblCompromissos.setIcon(icon2);
		
		panel_3.add(lblCompromissos);
	}
}