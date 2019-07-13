
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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;

import fachada.Fachada;

public class AdicionarCompromisso extends JFrame {
	private JPanel contentPane;
	private JPanel panelAdicionarCompromisso;
	private JTextField textField_18;
	private MaskFormatter dataMask;
	private MaskFormatter horaMask;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaApagarProduto window = new TelaApagarProduto();
//					window.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public AdicionarCompromisso() {
		setResizable(false);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
				
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
		
		String[] itens3 = {"", "reunião","festa","aniversário"};
		DefaultComboBoxModel<String> model3 = new DefaultComboBoxModel<String>(itens3);
		
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int heigth = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		setTitle("Apagar Produto");
		setBounds((width-370)/2, (heigth-397)/2, 370, 397);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setOpaque(true);
		contentPane.setLayout(null);
		
		panelAdicionarCompromisso = new JPanel();
		panelAdicionarCompromisso.setVisible(true);
		panelAdicionarCompromisso.setBorder(null);
		panelAdicionarCompromisso.setBackground(new Color(153, 153, 153));
		panelAdicionarCompromisso.setBounds(10, 11, 344, 346);
		contentPane.add(this.panelAdicionarCompromisso);
		panelAdicionarCompromisso.setLayout(null);
		
		JLabel lblAdicionarCompromisso = new JLabel("Adicionar Compromisso");
		lblAdicionarCompromisso.setOpaque(true);
		lblAdicionarCompromisso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarCompromisso.setForeground(new Color(102, 102, 102));
		lblAdicionarCompromisso.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblAdicionarCompromisso.setBackground(new Color(204, 204, 204));
		lblAdicionarCompromisso.setBounds(0, 0, 344, 50);
		panelAdicionarCompromisso.add(lblAdicionarCompromisso);
		
		textField_18 = new JTextField();
		textField_18.setForeground(UIManager.getColor("Button.foreground"));
		textField_18.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_18.setColumns(10);
		textField_18.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_18.setBackground(new Color(204, 204, 204));
		textField_18.setBounds(10, 93, 322, 30);
		panelAdicionarCompromisso.add(textField_18);
		
		JFormattedTextField txDataPAC = new JFormattedTextField(dataMask);
		txDataPAC.setForeground(UIManager.getColor("Button.foreground"));
		txDataPAC.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txDataPAC.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txDataPAC.setBackground(new Color(204, 204, 204));
		txDataPAC.setBounds(10, 167, 73, 30);
		panelAdicionarCompromisso.add(txDataPAC);
		
		JFormattedTextField txHoraPAC = new JFormattedTextField(horaMask);
		txHoraPAC.setForeground(UIManager.getColor("Button.foreground"));
		txHoraPAC.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txHoraPAC.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txHoraPAC.setBackground(new Color(204, 204, 204));
		txHoraPAC.setBounds(95, 167, 66, 30);
		panelAdicionarCompromisso.add(txHoraPAC);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox_2.setBackground(new Color(204, 204, 204));
		comboBox_2.setBounds(189, 167, 143, 30);
		panelAdicionarCompromisso.add(comboBox_2);
		
		comboBox_2.setModel(model3);
		
		JButton btnCadastrar_1 = new JButton("Cadastrar");
		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_18.getText().contentEquals("")) {
					JOptionPane.showMessageDialog(null,"Campo em branco!","Cadastrar Compromisso",JOptionPane.INFORMATION_MESSAGE);
				} else {
					int dia = Integer.parseInt(txDataPAC.getText().substring(0, 2));
					int mes = Integer.parseInt(txDataPAC.getText().substring(3, 5));
					int ano = Integer.parseInt(txDataPAC.getText().substring(6));
					int hora = Integer.parseInt(txHoraPAC.getText().substring(0, 2));
					int minuto = Integer.parseInt(txHoraPAC.getText().substring(3));
					try {
						if(textField.getText().equals("")) {
							Fachada.cadastrarCompromisso(textField_18.getText(), dia, mes, ano, hora, minuto, comboBox_2.getSelectedItem().toString());
						} else {
							Fachada.cadastrarCompromissoGrupo(textField_18.getText(), dia, mes, ano, hora, minuto, 
									comboBox_2.getSelectedItem().toString(),
									textField.getText().split(","));
						}
						JOptionPane.showMessageDialog(null,"Compromisso Cadastrado!","Cadastrar Compromisso",JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception a) {
						JOptionPane.showMessageDialog(null,a.getMessage(),"Cadastrar Compromisso",JOptionPane.INFORMATION_MESSAGE);
					}
					textField_18.setText(""); txDataPAC.setText(""); txHoraPAC.setText(""); comboBox_2.setSelectedIndex(0); textField.setText("");
				}
			}
		});
		btnCadastrar_1.setForeground(Color.WHITE);
		btnCadastrar_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnCadastrar_1.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		btnCadastrar_1.setBackground(new Color(102, 102, 102));
		btnCadastrar_1.setBounds(115, 294, 110, 30);
		panelAdicionarCompromisso.add(btnCadastrar_1);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setForeground(Color.WHITE);
		lblTtulo.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTtulo.setBounds(10, 61, 75, 20);
		panelAdicionarCompromisso.add(lblTtulo);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblData.setBounds(10, 135, 75, 20);
		panelAdicionarCompromisso.add(lblData);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setForeground(Color.WHITE);
		lblHora.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblHora.setBounds(95, 135, 75, 20);
		panelAdicionarCompromisso.add(lblHora);
		
		JLabel lblTipo_1 = new JLabel("Tipo:");
		lblTipo_1.setForeground(Color.WHITE);
		lblTipo_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTipo_1.setBounds(189, 135, 75, 20);
		panelAdicionarCompromisso.add(lblTipo_1);
		
		JLabel lblContatosseparadosPor = new JLabel("Contatos (separados por v\u00EDrgula):");
		lblContatosseparadosPor.setForeground(Color.WHITE);
		lblContatosseparadosPor.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblContatosseparadosPor.setBounds(10, 208, 322, 20);
		panelAdicionarCompromisso.add(lblContatosseparadosPor);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField.setColumns(10);
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setBackground(new Color(204, 204, 204));
		textField.setBounds(10, 240, 322, 30);
		panelAdicionarCompromisso.add(textField);

	}
}
