
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

public class RemoverContato extends JFrame {
	private JPanel contentPane;
	private MaskFormatter dddMask;
	private MaskFormatter foneMask;
	private JTextField textField_20;
	private JPanel panelRemoverContato;

	/**
	 * Create the application.
	 */
	public RemoverContato() {
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
		setBounds((width-310)/2, (heigth-239)/2, 310, 239);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setOpaque(true);
		contentPane.setLayout(null);
		
		panelRemoverContato = new JPanel();
		panelRemoverContato.setBorder(null);
		panelRemoverContato.setBackground(new Color(153, 153, 153));
		panelRemoverContato.setBounds(10, 11, 284, 188);
		panelRemoverContato.setLayout(null);
		panelRemoverContato.setVisible(true);
		contentPane.add(this.panelRemoverContato);
		
		textField_20 = new JTextField();
		textField_20.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_20.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_20.setBackground(new Color(204, 204, 204));
		textField_20.setBounds(10, 92, 264, 30);
		panelRemoverContato.add(textField_20);
		
		JLabel label_13 = new JLabel("Nome:");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_13.setBounds(10, 61, 75, 20);
		panelRemoverContato.add(label_13);
		
		JButton btnRemover_1 = new JButton("Remover");
		btnRemover_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					Fachada.removerContato(textField_20.getText());
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Remover Contato", JOptionPane.INFORMATION_MESSAGE);
					textField_20.setText("");
				}
			}
		});
		btnRemover_1.setForeground(Color.WHITE);
		btnRemover_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnRemover_1.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		btnRemover_1.setBackground(new Color(102, 102, 102));
		btnRemover_1.setBounds(86, 147, 110, 30);
		panelRemoverContato.add(btnRemover_1);
		
		JLabel lblRemoverContato = new JLabel("Remover Contato ");
		lblRemoverContato.setOpaque(true);
		lblRemoverContato.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverContato.setForeground(new Color(102, 102, 102));
		lblRemoverContato.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblRemoverContato.setBackground(new Color(204, 204, 204));
		lblRemoverContato.setBounds(0, 0, 284, 50);
		panelRemoverContato.add(lblRemoverContato);
	
	}
}
