
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

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;

import fachada.Fachada;

public class AdicionarTelefone extends JFrame {
	private JPanel contentPane;
	private JPanel panelAdicionarRemoverTelefone;
	private JTextField textField_11;
	private JFormattedTextField txDddPAT;
	private MaskFormatter dddMask;
	private JFormattedTextField txPhonePAT;
	private MaskFormatter foneMask;

	/**
	 * Create the application.
	 */
	public AdicionarTelefone() {
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
		
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int heigth = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		setTitle("Apagar Produto");
		setBounds((width-272)/2, (heigth-347)/2, 272, 347);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setOpaque(true);
		contentPane.setLayout(null);
		
		panelAdicionarRemoverTelefone = new JPanel();
		panelAdicionarRemoverTelefone.setBorder(null);
		panelAdicionarRemoverTelefone.setBackground(new Color(153, 153, 153));
		panelAdicionarRemoverTelefone.setBounds(10, 11, 246, 295);
		panelAdicionarRemoverTelefone.setLayout(null);
		panelAdicionarRemoverTelefone.setVisible(true);
		contentPane.add(this.panelAdicionarRemoverTelefone);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_1.setBounds(10, 61, 75, 20);
		panelAdicionarRemoverTelefone.add(label_1);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_11.setColumns(10);
		textField_11.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_11.setBackground(new Color(204, 204, 204));
		textField_11.setBounds(10, 92, 223, 30);
		panelAdicionarRemoverTelefone.add(textField_11);
		
		txDddPAT = new JFormattedTextField(dddMask); 							// textField DDD
		txDddPAT.setForeground(new Color(51, 51, 51));
		txDddPAT.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txDddPAT.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txDddPAT.setBackground(new Color(204, 204, 204));
		txDddPAT.setBounds(10, 164, 63, 30);
		panelAdicionarRemoverTelefone.add(txDddPAT);
		
		JLabel lblDdd = new JLabel("DDD:");
		lblDdd.setForeground(Color.WHITE);
		lblDdd.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDdd.setBounds(10, 137, 75, 20);
		panelAdicionarRemoverTelefone.add(lblDdd);
		
		txPhonePAT = new JFormattedTextField(foneMask); 							// textField TELEFONE
		txPhonePAT.setForeground(new Color(51, 51, 51));
		txPhonePAT.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txPhonePAT.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txPhonePAT.setBackground(new Color(204, 204, 204));
		txPhonePAT.setBounds(83, 164, 150, 30);
		panelAdicionarRemoverTelefone.add(txPhonePAT);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setForeground(Color.WHITE);
		lblNmero.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNmero.setBounds(83, 137, 75, 20);
		panelAdicionarRemoverTelefone.add(lblNmero);
		
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
		btnAdicionar.setBounds(68, 231, 110, 30);
		panelAdicionarRemoverTelefone.add(btnAdicionar);
		
		JLabel lblAdicionarTelefone = new JLabel("Adicionar Telefone ");
		lblAdicionarTelefone.setOpaque(true);
		lblAdicionarTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarTelefone.setForeground(new Color(102, 102, 102));
		lblAdicionarTelefone.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblAdicionarTelefone.setBackground(new Color(204, 204, 204));
		lblAdicionarTelefone.setBounds(0, 0, 246, 50);
		panelAdicionarRemoverTelefone.add(lblAdicionarTelefone);
	}
}
