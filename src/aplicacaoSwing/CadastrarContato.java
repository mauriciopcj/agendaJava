
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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;

import fachada.Fachada;

public class CadastrarContato extends JFrame {
	
	private JPanel contentPane;
	private JPanel panelCadContato;
	private MaskFormatter dddMask;
	private MaskFormatter foneMask;
	private MaskFormatter cepMask;
	private JFormattedTextField txCepPCC;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txEndereco;
	private JTextField txNumeroPCC;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JComboBox<String> comboBox;
	

	/**
	 * Create the application.
	 */
	public CadastrarContato() {
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
		DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<String>(itens);
		
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int heigth = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		setTitle("Apagar Produto");
		setBounds((width-520)/2, (heigth-438)/2, 520, 438);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setOpaque(true);
		contentPane.setLayout(null);
		
		panelCadContato = new JPanel();
		panelCadContato.setBorder(null);
		panelCadContato.setBounds(10, 11, 495, 390);
		panelCadContato.setBackground(new Color(153, 153, 153));
		panelCadContato.setLayout(null);
		panelCadContato.setVisible(true);
		contentPane.add(this.panelCadContato);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNome.setBounds(20, 79, 75, 20);
		panelCadContato.add(lblNome);
		
		textField = new JTextField();
		textField.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setBackground(new Color(204, 204, 204));
		textField.setColumns(10);
		textField.setBounds(20, 110, 157, 30);
		panelCadContato.add(textField);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblEmail.setBounds(187, 79, 75, 20);
		panelCadContato.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_1.setBackground(new Color(204, 204, 204));
		textField_1.setColumns(10);
		textField_1.setBounds(187, 110, 157, 30);
		panelCadContato.add(textField_1);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setForeground(new Color(255, 255, 255));
		lblCep.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblCep.setBounds(354, 79, 75, 20);
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
		txCepPCC.setBounds(354, 110, 115, 30);
		panelCadContato.add(txCepPCC);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setForeground(new Color(255, 255, 255));
		lblEndereco.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblEndereco.setBounds(20, 152, 75, 20);
		panelCadContato.add(lblEndereco);
		
		txEndereco = new JTextField();
		txEndereco.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txEndereco.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txEndereco.setBackground(new Color(204, 204, 204));
		txEndereco.setColumns(10);
		txEndereco.setBounds(20, 183, 358, 30);
		panelCadContato.add(txEndereco);
		
		JLabel lblFacebook = new JLabel("Número:");
		lblFacebook.setForeground(new Color(255, 255, 255));
		lblFacebook.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblFacebook.setBounds(388, 152, 75, 20);
		panelCadContato.add(lblFacebook);
		
		txNumeroPCC = new JTextField(5);
		txNumeroPCC.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txNumeroPCC.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txNumeroPCC.setBackground(new Color(204, 204, 204));
		txNumeroPCC.setColumns(10);
		txNumeroPCC.setBounds(388, 183, 81, 30);
		panelCadContato.add(txNumeroPCC);
		
		JLabel label_3 = new JLabel("Facebook:");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_3.setBounds(20, 225, 75, 20);
		panelCadContato.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_5.setBackground(new Color(204, 204, 204));
		textField_5.setColumns(10);
		textField_5.setBounds(20, 256, 157, 30);
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
								txCepPCC.getText().trim().replace(".", "").replace("-", ""),
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
		btnCadastrar.setBounds(192, 319, 110, 30);
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(102, 102, 102));
		btnCadastrar.setBorder(new MatteBorder(1, 1, 2, 3, (Color) new Color(255, 255, 255)));
		panelCadContato.add(btnCadastrar);
		
		JLabel lblProximidade = new JLabel("Anivers\u00E1rio (Dia/M\u00EAs):");
		lblProximidade.setForeground(new Color(255, 255, 255));
		lblProximidade.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblProximidade.setBounds(187, 225, 157, 20);
		panelCadContato.add(lblProximidade);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_7.setBackground(new Color(204, 204, 204));
		textField_7.setColumns(10);
		textField_7.setBounds(187, 256, 69, 30);
		panelCadContato.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Century Gothic", Font.BOLD, 13));
		textField_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_8.setBackground(new Color(204, 204, 204));
		textField_8.setColumns(10);
		textField_8.setBounds(266, 256, 75, 30);
		panelCadContato.add(textField_8);
		
		JLabel lblProximidade_1 = new JLabel("Proximidade:");
		lblProximidade_1.setForeground(new Color(255, 255, 255));
		lblProximidade_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblProximidade_1.setBounds(354, 224, 96, 20);
		panelCadContato.add(lblProximidade_1);
		
		JLabel lblCadastrarContato = new JLabel("Cadastrar Contato");
		lblCadastrarContato.setOpaque(true);
		lblCadastrarContato.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarContato.setForeground(new Color(102, 102, 102));
		lblCadastrarContato.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblCadastrarContato.setBackground(new Color(204, 204, 204));
		lblCadastrarContato.setBounds(0, 0, 495, 50);
		panelCadContato.add(lblCadastrarContato);
		
		
		
		comboBox = new JComboBox<String>();
		comboBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox.setBackground(new Color(204, 204, 204));
		comboBox.setBounds(354, 256, 118, 30);
		panelCadContato.add(comboBox);
		comboBox.setModel(model1);
	
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
