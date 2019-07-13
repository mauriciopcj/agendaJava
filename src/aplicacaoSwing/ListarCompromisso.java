
/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */
package aplicacaoSwing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;

import fachada.Fachada;
import modelo.Compromisso;
import modelo.CompromissoGrupo;
import modelo.Contato;

public class ListarCompromisso extends JFrame {
	private JPanel contentPane;
	private MaskFormatter dddMask;
	private MaskFormatter foneMask;
	private MaskFormatter cepMask;
	private JTextField textField_19;
	private JPanel panelListarCompromisso;
	private MaskFormatter dataMask;
	private MaskFormatter horaMask;

	/**
	 * Create the application.
	 */
	public ListarCompromisso() {
		setResizable(false);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
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
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		DefaultListModel<String> model4 = new DefaultListModel<String>();
		
		String[] itens3 = {"", "reunião","festa","aniversário"};
		DefaultComboBoxModel<String> model3 = new DefaultComboBoxModel<String>(itens3);
		
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int heigth = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		setTitle("Apagar Produto");
		setBounds((width-552)/2, (heigth-438)/2, 552, 438);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setOpaque(true);
		contentPane.setLayout(null);
		
		panelListarCompromisso = new JPanel();
		panelListarCompromisso.setVisible(true);
		
		panelListarCompromisso.setBorder(null);
		panelListarCompromisso.setBackground(new Color(153, 153, 153));
		panelListarCompromisso.setBounds(10, 11, 525, 390);
		contentPane.add(this.panelListarCompromisso);
		panelListarCompromisso.setLayout(null);
		
		JLabel lblListarCompromisso = new JLabel("Listar Compromisso");
		lblListarCompromisso.setOpaque(true);
		lblListarCompromisso.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarCompromisso.setForeground(new Color(102, 102, 102));
		lblListarCompromisso.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblListarCompromisso.setBackground(new Color(204, 204, 204));
		lblListarCompromisso.setBounds(0, 0, 525, 50);
		panelListarCompromisso.add(lblListarCompromisso);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_19.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_19.setBounds(10, 93, 128, 30);
		panelListarCompromisso.add(textField_19);
		
		JButton btnTtulo = new JButton("T\u00EDtulo");
		btnTtulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model4.clear();
					ArrayList<Compromisso> compromissos = Fachada.listarCompromissosPorTitulo(textField_19.getText());
					String texto = "";
					for(Compromisso c: compromissos) {
						if(c instanceof CompromissoGrupo) {
							texto = c.getId() + " - " + c.getTitulo() + " - " + c.getDatahora().format(formatter) + " - " + c.getTipo();
							CompromissoGrupo cg = (CompromissoGrupo) c;
							for(Contato con : cg.getContatos()) {
								texto = texto + " | " + con.getNome();
							}
						} else {
							texto = c.getId() + " - " + c.getTitulo() + " - " + c.getDatahora().format(formatter) + " - " + c.getTipo();
						}
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
		btnTtulo.setBounds(148, 92, 110, 30);
		panelListarCompromisso.add(btnTtulo);
		
		
		JList<String> list_1 = new JList<String>();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setSelectionBackground(new Color(255, 204, 102));
		list_1.setForeground(UIManager.getColor("Button.foreground"));
		list_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		list_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list_1.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		list_1.setBounds(10, 208, 504, 171);
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
		formattedTextField_1.setBounds(268, 93, 73, 30);
		panelListarCompromisso.add(formattedTextField_1);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField(horaMask);
		formattedTextField_2.setForeground(UIManager.getColor("Button.foreground"));
		formattedTextField_2.setFont(new Font("Century Gothic", Font.BOLD, 13));
		formattedTextField_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		formattedTextField_2.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		formattedTextField_2.setBounds(353, 93, 41, 30);
		panelListarCompromisso.add(formattedTextField_2);
		
		JLabel lblDatahorainicio = new JLabel("Data/Hora: (inicio)");
		lblDatahorainicio.setForeground(Color.WHITE);
		lblDatahorainicio.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDatahorainicio.setBounds(268, 61, 131, 20);
		panelListarCompromisso.add(lblDatahorainicio);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField(dataMask);
		formattedTextField_3.setForeground(UIManager.getColor("Button.foreground"));
		formattedTextField_3.setFont(new Font("Century Gothic", Font.BOLD, 13));
		formattedTextField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		formattedTextField_3.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		formattedTextField_3.setBounds(268, 167, 73, 30);
		panelListarCompromisso.add(formattedTextField_3);
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField(horaMask);
		formattedTextField_4.setForeground(UIManager.getColor("Button.foreground"));
		formattedTextField_4.setFont(new Font("Century Gothic", Font.BOLD, 13));
		formattedTextField_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		formattedTextField_4.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		formattedTextField_4.setBounds(353, 167, 41, 30);
		panelListarCompromisso.add(formattedTextField_4);
		
		JLabel lblDatahorafim = new JLabel("Data/Hora: (fim)");
		lblDatahorafim.setForeground(Color.WHITE);
		lblDatahorafim.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDatahorafim.setBounds(268, 135, 126, 20);
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
						if(c instanceof CompromissoGrupo) {
							texto = c.getId() + " - " + c.getTitulo() + " - " + c.getDatahora().format(formatter) + " - " + c.getTipo();
							CompromissoGrupo cg = (CompromissoGrupo) c;
							for(Contato con : cg.getContatos()) {
								texto = texto + " | " + con.getNome();
							}
						} else {
							texto = c.getId() + " - " + c.getTitulo() + " - " + c.getDatahora().format(formatter) + " - " + c.getTipo();
						}
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
		btnIntervalo.setBounds(404, 92, 110, 30);
		panelListarCompromisso.add(btnIntervalo);
		
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox_3.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		comboBox_3.setBounds(10, 166, 128, 30);
		panelListarCompromisso.add(comboBox_3);
		
		comboBox_3.setModel(model3);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTipo.setBounds(10, 134, 126, 20);
		panelListarCompromisso.add(lblTipo);
		
		JButton btnTipo = new JButton("Tipo");
		btnTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model4.clear();
					ArrayList<Compromisso> compromissos = Fachada.listarCompromissosPorTipo(comboBox_3.getSelectedItem().toString());
					String texto = "";
					for(Compromisso c: compromissos) {
						if(c instanceof CompromissoGrupo) {
							texto = c.getId() + " - " + c.getTitulo() + " - " + c.getDatahora().format(formatter) + " - " + c.getTipo();
							CompromissoGrupo cg = (CompromissoGrupo) c;
							for(Contato con : cg.getContatos()) {
								texto = texto + " | " + con.getNome();
							}
						} else {
							texto = c.getId() + " - " + c.getTitulo() + " - " + c.getDatahora().format(formatter) + " - " + c.getTipo();
						}
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
		btnTipo.setBounds(148, 165, 110, 30);
		panelListarCompromisso.add(btnTipo);
	
	}
}
