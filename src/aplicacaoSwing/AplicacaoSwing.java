package aplicacaoSwing;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class AplicacaoSwing {

	private JFrame frame;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
/*
1. Listar contatos por nome 
Dados: nome (parcial ou completo)
Resultados: contatos e telefones que contenham o nome pedido

2. Listar contatos por telefone
Dados: numero de telefone (parcial ou completo)
Resultados: contatos e telefones que contenham o numero pedido

3. Listar contatos por proximidade
Dados: grau de proximidade
Resultados: contatos e telefones do grau pedido

4. Listar compromissos por nome
Dados: titulo (parcial ou completo)
Resultados: compromissos que contenham o título pedido

5. Listar compromissos por data
Dados: data1(dia,mês,ano) as 0hs e data2 (dia,mês,ano) as 23:59hs
Resultados: compromissos que ocorrerão no intervalo de datas pedido

6. Listar compromissos portipo
Dados: tipo de compromisso
Resultados: compromissos do tipo pedido

7. Listar telefones 
Resultados: telefones da agenda com os nomes dos respectivos contatos

8. Cadastrar contato 
Dados: dados do contato (não inclui telefone)
Resultados: mensagem de confirmação

9. Adicionar telefone 
Dados: nome do contato, ddd e numero de telefone
Resultados: mensagem de confirmação

10. Remover telefone 
Dados: nome do contato, numero de telefone
Resultados: mensagem de confirmação

11. Cadastrar compromisso 
Dados: dados do compromisso 
Resultados: id do compromisso

12. Consulta1 
Resultado: nome dos contatos que tem 2 telefones ou mais

13. Consulta2 
Resultado: numero dos telefones que tem 2 contatos ou mai
 */
	}

}
