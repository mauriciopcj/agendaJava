
/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */
package aplicacaoSwing;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.Scanner;

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
import modelo.Contato;

public class AlterarContato extends JFrame {
	private JPanel contentPane;
	private JPanel panelAlterarContato;
	private MaskFormatter dddMask;
	private MaskFormatter foneMask;
	private MaskFormatter cepMask;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_13;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JComboBox<String> comboBox_1;

	/**
	 * Create the application.
	 */
	public AlterarContato() {
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
		
		String[] itens = {"","1 - baixo", "2 - médio", "3 - alto"};
		DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<String>(itens);
		
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int heigth = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		setTitle("Apagar Produto");
		setBounds((width-520)/2, (heigth-414)/2, 520, 414);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setOpaque(true);
		contentPane.setLayout(null);
		
		panelAlterarContato = new JPanel();
		panelAlterarContato.setBorder(null);
		panelAlterarContato.setBackground(new Color(153, 153, 153));
		panelAlterarContato.setBounds(10, 11, 495, 363);
		panelAlterarContato.setLayout(null);
		panelAlterarContato.setVisible(true);
		contentPane.add(this.panelAlterarContato);
		
		JLabel lblAlterarContato = new JLabel("Alterar Dados do Contato");
		lblAlterarContato.setOpaque(true);
		lblAlterarContato.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterarContato.setForeground(new Color(102, 102, 102));
		lblAlterarContato.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblAlterarContato.setBackground(new Color(204, 204, 204));
		lblAlterarContato.setBounds(0, 0, 495, 50);
		panelAlterarContato.add(lblAlterarContato);
		
		JLabel lblNomeobrigatrio = new JLabel("Nome: (obrigat\u00F3rio)");
		lblNomeobrigatrio.setForeground(Color.WHITE);
		lblNomeobrigatrio.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNomeobrigatrio.setBounds(10, 60, 157, 20);
		panelAlterarContato.add(lblNomeobrigatrio);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_2.setColumns(10);
		textField_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_2.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_2.setBounds(10, 90, 176, 30);
		panelAlterarContato.add(textField_2);
		
		JLabel label_5 = new JLabel("E-mail:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_5.setBounds(196, 61, 75, 20);
		panelAlterarContato.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_3.setColumns(10);
		textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_3.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_3.setBounds(196, 90, 176, 30);
		panelAlterarContato.add(textField_3);
		
		JLabel label_6 = new JLabel("CEP:");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_6.setBounds(10, 130, 75, 20);
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
		formattedTextField.setBounds(10, 160, 115, 30);
		panelAlterarContato.add(formattedTextField);
		
		JLabel label_7 = new JLabel("Endereco:");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_7.setBounds(135, 131, 75, 20);
		panelAlterarContato.add(label_7);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_4.setColumns(10);
		textField_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_4.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_4.setBounds(135, 160, 237, 30);
		panelAlterarContato.add(textField_4);
		
		JLabel label_8 = new JLabel("N\u00FAmero:");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_8.setBounds(287, 201, 75, 20);
		panelAlterarContato.add(label_8);
		
		textField_13 = new JTextField(10);
		textField_13.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_13.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_13.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_13.setBounds(287, 230, 85, 30);
		panelAlterarContato.add(textField_13);
		
		JLabel label_9 = new JLabel("Facebook:");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_9.setBounds(10, 200, 75, 20);
		panelAlterarContato.add(label_9);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_15.setColumns(10);
		textField_15.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_15.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_15.setBounds(10, 230, 157, 30);
		panelAlterarContato.add(textField_15);
		
		JLabel label_10 = new JLabel("Anivers\u00E1rio (Dia/M\u00EAs):");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_10.setBounds(10, 271, 157, 20);
		panelAlterarContato.add(label_10);
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_16.setColumns(10);
		textField_16.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_16.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_16.setBounds(10, 302, 68, 30);
		panelAlterarContato.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_17.setColumns(10);
		textField_17.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_17.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		textField_17.setBounds(90, 302, 77, 30);
		panelAlterarContato.add(textField_17);
		
		JLabel label_11 = new JLabel("Proximidade:");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_11.setBounds(287, 271, 96, 20);
		panelAlterarContato.add(label_11);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox_1.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		comboBox_1.setBounds(287, 303, 85, 30);
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
		btnAlterar.setBounds(382, 160, 100, 30);
		panelAlterarContato.add(btnAlterar);
		
		JButton button_3 = new JButton("Alterar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Contato contato = Fachada.alterarDados(textField_2.getText());
					contato.setNumero(textField_13.getText());
					JOptionPane.showMessageDialog(null,"N�mero alterado com sucesso!","Alterar Dados de Contato", JOptionPane.INFORMATION_MESSAGE);
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
		button_3.setBounds(382, 230, 100, 30);
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
		button_4.setBounds(382, 90, 100, 30);
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
		button_2.setBounds(382, 302, 100, 30);
		panelAlterarContato.add(button_2);
		
		JButton button_5 = new JButton("Alterar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Contato contato = Fachada.alterarDados(textField_2.getText());
					contato.setMesaniversario(Integer.parseInt(textField_17.getText()));
					contato.setDiaaniversario(Integer.parseInt(textField_16.getText()));
					JOptionPane.showMessageDialog(null,"Dia e m�s do anivers�rio alterados com sucesso!","Alterar Dados de Contato", JOptionPane.INFORMATION_MESSAGE);
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
		button_5.setBounds(177, 302, 100, 30);
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
		button_6.setBounds(177, 230, 100, 30);
		panelAlterarContato.add(button_6);
	
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
	
	public String preencher(int quant) {
		String result = "";
		for(int i = 0; i < quant; i++) {
			result += " ";
		}
		return result;
	}
}
