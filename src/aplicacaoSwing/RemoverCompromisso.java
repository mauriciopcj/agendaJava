
/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */
package aplicacaoSwing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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

import fachada.Fachada;

public class RemoverCompromisso extends JFrame {
	private JPanel contentPane;
	private JPanel panelAdicionarCompromisso;
	private JTextField textField_18;

	/**
	 * Create the application.
	 */
	public RemoverCompromisso() {
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
		setBounds((width-248)/2, (heigth-229)/2, 248, 229);
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
		panelAdicionarCompromisso.setBounds(10, 11, 222, 178);
		contentPane.add(this.panelAdicionarCompromisso);
		panelAdicionarCompromisso.setLayout(null);
		
		JLabel lblAdicionarCompromisso = new JLabel("Remover Compromisso");
		lblAdicionarCompromisso.setOpaque(true);
		lblAdicionarCompromisso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarCompromisso.setForeground(new Color(102, 102, 102));
		lblAdicionarCompromisso.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblAdicionarCompromisso.setBackground(new Color(204, 204, 204));
		lblAdicionarCompromisso.setBounds(0, 0, 222, 50);
		panelAdicionarCompromisso.add(lblAdicionarCompromisso);
		
		textField_18 = new JTextField();
		textField_18.setForeground(UIManager.getColor("Button.foreground"));
		textField_18.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_18.setColumns(10);
		textField_18.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_18.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_18.setBounds(10, 93, 202, 30);
		panelAdicionarCompromisso.add(textField_18);
		
		JButton btnCadastrar_1 = new JButton("Remover");
		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Fachada.removerCompromisso(Integer.parseInt(textField_18.getText()));
					JOptionPane.showMessageDialog(null,"Compromisso removido!","Remover Compromisso",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,a.getMessage(),"Cadastrar Compromisso",JOptionPane.INFORMATION_MESSAGE);
				}
				textField_18.setText("");
			}
		});
		btnCadastrar_1.setForeground(Color.WHITE);
		btnCadastrar_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnCadastrar_1.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		btnCadastrar_1.setBackground(new Color(102, 102, 102));
		btnCadastrar_1.setBounds(56, 134, 110, 30);
		panelAdicionarCompromisso.add(btnCadastrar_1);
		
		JLabel lblTtulo = new JLabel("ID:");
		lblTtulo.setForeground(Color.WHITE);
		lblTtulo.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTtulo.setBounds(10, 61, 75, 20);
		panelAdicionarCompromisso.add(lblTtulo);

	}
}
