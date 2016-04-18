package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import control.ClienteController;
import control.evBuscaCEP;
import entity.ClienteEntity;
import entity.EnderecoEntity;

public class CadastroClienteBoundary implements ActionListener {
	private JLabel lblNome, lblCPF, lblRg, lblCep, lblLogradouro, lblNumero, lblComplemento, lblBairro, lblUf,
			lblCidade, lblEmail, lblTelefone, lblCelular;
	private JTextField nome;
	private JFormattedTextField cpf;
	private JFormattedTextField rg;
	private JFormattedTextField cep;
	private JTextField complemento;
	private JTextField logradouro;
	private JTextField bairro;
	private JTextField uf;
	private JTextField cidade;
	private JTextField email;
	private JFormattedTextField telefone;
	private JFormattedTextField celular;
	private JTextField numero;
	private JPasswordField senha;
	private JComboBox cbSexo;
	private JPanel panel = new JPanel(new BorderLayout());
	
	

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public CadastroClienteBoundary() {
		// TODO Auto-generated constructor stub

		panel.add(Norte(), BorderLayout.NORTH);
		panel.add(Centro(), BorderLayout.CENTER);
		panel.add(Sul(), BorderLayout.SOUTH);
		// panel.add(Esquerdo(), BorderLayout.WEST);

	}

	public JComponent Norte() {
		JPanel panelNorte = new JPanel(new BorderLayout());
		panelNorte.setBackground(Color.WHITE);
		JLabel lblTitulo = new JLabel("Identifica�ao - Faaa seu cadastro");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		JLabel obrigatorio = new JLabel("Os campos com * sao obrigatarios");
		obrigatorio.setForeground(Color.red);
		obrigatorio.setFont(new Font("Tahoma",Font.PLAIN,16));
		
		panelNorte.add(obrigatorio,BorderLayout.SOUTH);
		
		JLabel lblLogin = new JLabel("Ja tem cadastro? Faaa o login");

		panelNorte.add(lblLogin, BorderLayout.EAST);
		panelNorte.add(lblTitulo, BorderLayout.CENTER);

		return panelNorte;

	}

	public JComponent Centro() {
		JPanel panelCentro = new JPanel(new GridLayout(15, 1, 10, 10));

		panelCentro.setBackground(Color.WHITE);

		lblNome = new JLabel("*Nome Completo: ");
		panelCentro.add(lblNome);
		nome = new JTextField();

		panelCentro.add(nome);

		lblCPF = new JLabel("*CPF: ");
		panelCentro.add(lblCPF);

		cpf = new JFormattedTextField();
		try {
			MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
			maskCpf.install(cpf);
		} catch (ParseException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		cpf.setPreferredSize(new Dimension(5, 2));
		// cpf.setMinimumSize(new Dimension(1,2));
		panelCentro.add(cpf);

		lblRg = new JLabel("*RG: ");
		panelCentro.add(lblRg);
		rg = new JFormattedTextField();
		try {
			MaskFormatter maskRg = new MaskFormatter("##.###.###-#");
			maskRg.install(rg);
		} catch (ParseException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		panelCentro.add(rg);

		lblCep = new JLabel("*CEP: ");
		panelCentro.add(lblCep);
		cep = new JFormattedTextField();
		try {
			MaskFormatter maskCep = new MaskFormatter("#####-###");
			maskCep.install(cep);

		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		panelCentro.add(cep);

		final evBuscaCEP buscacep = new evBuscaCEP();

		FocusListener focoCep = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (validaCEP() == true) {

					List<EnderecoEntity> end = new ArrayList<EnderecoEntity>();
					end = buscacep.buscaPorCep(cep.getText().replace("-", ""));

					if (end == null) {

						logradouro.setEditable(true);
						bairro.setEditable(true);
						cidade.setEditable(true);
						uf.setEditable(true);

					} else {

						for (EnderecoEntity endereco : end) {

							bairro.setText(endereco.getBairro());

							uf.setText(endereco.getUf());

							cidade.setText(endereco.getCidade());
							logradouro.setText(endereco.getLogradouro());
						}
					}
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		};
		cep.addFocusListener(focoCep);

		lblLogradouro = new JLabel("*Logradouro: ");
		panelCentro.add(lblLogradouro);
		logradouro = new JTextField(30);
		logradouro.setEditable(false);
		panelCentro.add(logradouro);

		lblNumero = new JLabel("*Namero: ");
		panelCentro.add(lblNumero);
		numero = new JTextField(30);
		panelCentro.add(numero);

		lblComplemento = new JLabel("Complemento: ");
		panelCentro.add(lblComplemento);
		complemento = new JTextField(30);
		panelCentro.add(complemento);

		lblBairro = new JLabel("*Bairro: ");
		panelCentro.add(lblBairro);
		bairro = new JTextField(30);
		bairro.setEditable(false);
		panelCentro.add(bairro);

		lblUf = new JLabel("*UF");
		panelCentro.add(lblUf);
		uf = new JTextField(2);
		uf.setEditable(false);
		panelCentro.add(uf);

		lblCidade = new JLabel("*Cidade: ");
		panelCentro.add(lblCidade);
		cidade = new JTextField(30);
		cidade.setEditable(false);
		panelCentro.add(cidade);

		JLabel lblSexo = new JLabel("*Sexo");
		panelCentro.add(lblSexo);
		cbSexo = new JComboBox();
		Vector Sexo = new Vector();
		Sexo.add("");
		Sexo.add("Masculino");
		Sexo.add("Feminino");
		Sexo.add("Nao informado");
		for (int i = 0; i < Sexo.size(); i++) {
			cbSexo.addItem(Sexo.get(i));

		}

		panelCentro.add(cbSexo);

		lblEmail = new JLabel("*Email: ");
		panelCentro.add(lblEmail);
		email = new JTextField(30);
		panelCentro.add(email);

		JLabel lblSenha = new JLabel("*Senha: ");
		panelCentro.add(lblSenha);
		senha = new JPasswordField();
		panelCentro.add(senha);

		lblTelefone = new JLabel("*Telefone: ");
		panelCentro.add(lblTelefone);
		telefone = new JFormattedTextField();
		MaskFormatter maskTel;
		try {
			maskTel = new MaskFormatter("(##) ####-####");
			maskTel.install(telefone);

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		panelCentro.add(telefone);

		JLabel lblCelular = new JLabel("*Celular: ");
		panelCentro.add(lblCelular);
		celular = new JFormattedTextField();
		try {
			MaskFormatter maskCel = new MaskFormatter("(##) #####-####");
			maskCel.install(celular);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		panelCentro.add(celular);

		return panelCentro;
	}

	public JComponent Esquerdo() {

		JPanel panelEsquerdo = new JPanel(new FlowLayout());
		panelEsquerdo.setBackground(Color.WHITE);
		JLabel myAcc = new JLabel("Minha Conta");

		panelEsquerdo.add(myAcc);

		return panelEsquerdo;
	}

	public JComponent Sul() {
		JPanel PanelSul = new JPanel();
		PanelSul.setBackground(Color.WHITE);
		PanelSul.setLayout(new BorderLayout());

		JButton btnCadastrar = new JButton("Concluir Cadastro");
		PanelSul.add(btnCadastrar, BorderLayout.EAST);
		btnCadastrar.setBackground(Color.GREEN);
		btnCadastrar.setForeground(Color.WHITE);

		btnCadastrar.addActionListener(this);

		return PanelSul;
	}

	@SuppressWarnings("deprecation")
	public ClienteEntity EventoConcluirCadastro() {

		ClienteEntity clt = new ClienteEntity();
		clt.setNome(nome.getText());

		clt.setCpf(cpf.getText().replace("-", "").replace(".", ""));

		clt.setRg(rg.getText().replace("-", "").replace(".", ""));
		clt.setCep(cep.getText().replace("-", ""));
		clt.setLogradouro(logradouro.getText());
		clt.setNumero(Integer.parseInt(numero.getText()));
		clt.setComplemento(complemento.getText());
		clt.setBairro(bairro.getText());
		clt.setUf(uf.getText());
		clt.setCidade(cidade.getText());
		clt.setEmail(email.getText());
		clt.setTelefone(telefone.getText());
		clt.setCelular(celular.getText());
		clt.setSexo(cbSexo.getSelectedItem().toString());
		clt.setSenha(senha.getText());

		if (clt != null)
			limpaCampos();

		return clt;

	}

	public void limpaCampos() {
		nome.setText("");
		cpf.setText("");
		rg.setText("");
		cep.setText("");
		logradouro.setText("");
		logradouro.setEditable(false);
		numero.setText("");
		complemento.setText("");
		bairro.setText("");
		bairro.setEditable(false);
		cidade.setText("");
		cidade.setEditable(false);
		email.setText("");
		telefone.setText("");
		celular.setText("");
		uf.setText("");
		uf.setEditable(false);
		cbSexo.setSelectedIndex(0);
		senha.setText("");

	}

	public static void main(String[] args) {

		new CadastroClienteBoundary();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		

		ClienteController cc = new ClienteController();

		cc.ConcluirCadastro(EventoConcluirCadastro());

	}

	public boolean validaCEP() {
		if (cep.getText().replace("-", "").replace(" ", "").length() <= 0) {
			JOptionPane.showMessageDialog(null, "O CEP deve ser informado", "Aten�ao", JOptionPane.WARNING_MESSAGE);
			cep.requestFocus();
			return false;
		} else {

			return true;
		}

	}

	public boolean ValidaCampos() {

		if (nome.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "O Nome completo deve ser informado", "Aten�ao",
					JOptionPane.WARNING_MESSAGE);
			nome.requestFocus();
			return false;
		} else if (cpf.getText().replace("-", "").replace(".", "").replace(" ", "").length() <= 0) {
			System.out.println(cpf.getText().replace("-", "").replace(".", ""));
			cpf.requestFocus();
			JOptionPane.showMessageDialog(null, "O CPF deve ser informado", "Aten�ao", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (rg.getText().replace("-", "").replace(".", "").replace(" ", "").length() <= 0) {
			rg.requestFocus();
			JOptionPane.showMessageDialog(null, "O RG deve ser informado", "Aten�ao", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (logradouro.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "O Logradouro deve ser informado", "Aten�ao",
					JOptionPane.WARNING_MESSAGE);
			logradouro.requestFocus();
			return false;
		} else if (numero.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "O Numero deve ser informado, caso ao contrario informe S/N", "Aten�ao",
					JOptionPane.WARNING_MESSAGE);
			numero.requestFocus();
			return false;
		} else if (bairro.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "O Bairro ser informado", "Aten�ao", JOptionPane.WARNING_MESSAGE);
			bairro.requestFocus();
			return false;
		} else if (uf.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "O UF deve ser informado", "Aten�ao", JOptionPane.WARNING_MESSAGE);
			uf.requestFocus();
			return false;
		} else if (cidade.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "O Cidade deve ser informado", "Aten�ao", JOptionPane.WARNING_MESSAGE);
			cidade.requestFocus();
			return false;
		} else if (!email.getText().contains("@")) {

			JOptionPane.showMessageDialog(null, "Digite um e-mail valido", "Aten�ao", JOptionPane.WARNING_MESSAGE);

			return false;
		} else if (email.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "O E-mail deve ser informado", "Aten�ao", JOptionPane.WARNING_MESSAGE);
			email.requestFocus();
			return false;
		} else if (senha.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "O senha deve ser informado", "Aten�ao", JOptionPane.WARNING_MESSAGE);
			senha.requestFocus();
			return false;
		} else if (telefone.getText().replace("-", "").replace("(", "").replace(")", "").replace(" ", "")
				.length() <= 0) {
			JOptionPane.showMessageDialog(null, "O Telefone deve ser informado", "Aten�ao",
					JOptionPane.WARNING_MESSAGE);
			telefone.requestFocus();
			return false;
		} else if (celular.getText().replace("-", "").replace("(", "").replace(")", "").replace(" ", "")
				.length() <= 0) {
			JOptionPane.showMessageDialog(null, "O Celular deve ser informado", "Aten�ao", JOptionPane.WARNING_MESSAGE);
			celular.requestFocus();
			return false;
		} else {
			return true;
		}

	}

}