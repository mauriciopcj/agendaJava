
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

public class RemoverTelefone extends JFrame {
	private JPanel contentPane;
	private MaskFormatter dddMask;
	private MaskFormatter foneMask;
	private JPanel panelAdicionarRemoverTelefone2;
	private JTextField textField_14;
	private JFormattedTextField txPhonePRT;

	/**
	 * Create the application.
	 */
	public RemoverTelefone() {
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
		setBounds((width-272)/2, (heigth-347)/2, 269, 353);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setOpaque(true);
		contentPane.setLayout(null);
		
		panelAdicionarRemoverTelefone2 = new JPanel();
		panelAdicionarRemoverTelefone2.setBorder(null);
		panelAdicionarRemoverTelefone2.setBackground(new Color(153, 153, 153));
		panelAdicionarRemoverTelefone2.setBounds(10, 11, 243, 304);
		panelAdicionarRemoverTelefone2.setLayout(null);
		panelAdicionarRemoverTelefone2.setVisible(true);
		contentPane.add(this.panelAdicionarRemoverTelefone2);
		
		JLabel lblRemoverTelefone = new JLabel("Remover Telefone ");
		lblRemoverTelefone.setBounds(0, 0, 243, 50);
		panelAdicionarRemoverTelefone2.add(lblRemoverTelefone);
		lblRemoverTelefone.setBackground(new Color(204, 204, 204));
		lblRemoverTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverTelefone.setForeground(new Color(102, 102, 102));
		lblRemoverTelefone.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblRemoverTelefone.setOpaque(true);
		
		JLabel label_2 = new JLabel("Nome:");
		label_2.setBounds(10, 61, 75, 20);
		panelAdicionarRemoverTelefone2.add(label_2);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		textField_14 = new JTextField();
		textField_14.setBounds(10, 92, 222, 30);
		panelAdicionarRemoverTelefone2.add(textField_14);
		textField_14.setForeground(new Color(51, 51, 51));
		textField_14.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_14.setColumns(10);
		textField_14.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_14.setBackground(new Color(204, 204, 204));
		
		JLabel label_4 = new JLabel("N\u00FAmero:");
		label_4.setBounds(10, 137, 75, 20);
		panelAdicionarRemoverTelefone2.add(label_4);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		txPhonePRT = new JFormattedTextField(foneMask); 							// textField TELEFONE
		txPhonePRT.setBounds(10, 164, 222, 30);
		panelAdicionarRemoverTelefone2.add(txPhonePRT);
		txPhonePRT.setForeground(new Color(51, 51, 51));
		txPhonePRT.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txPhonePRT.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txPhonePRT.setBackground(new Color(204, 204, 204));
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(65, 236, 110, 30);
		panelAdicionarRemoverTelefone2.add(btnRemover);
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
	}	
}
