package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import control.EvBtnCarregaImagemLivro;
import control.LivroController;
import entity.Categoria;
import entity.LivroEntity;

public class LivroBoundary implements ActionListener, KeyListener{
	private JPanel tela = new JPanel(new BorderLayout());
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnAlterar = new JButton("Alterar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnNovo = new JButton("Novo");
	private JButton btnCarregaImagem = new JButton("Carregar Imagem");
	private JButton pesquisaEditora = new JButton();
	private JButton btnVoltar = new JButton("");
	private JButton pesquisaLivro = new JButton();
	private JButton pesquisaAutor = new JButton();
	private LivroController livroControl= new LivroController();
	private String livroPath;
	
	private JTextField txtIsbn = new JTextField(10);
	private JTextField txtTituloLivro = new JTextField(50);
	private JTextField txtNomeAutor = new JTextField(20);
	private JComboBox<String> cbCategoriaLivro = new JComboBox<String>();
	private JTextField txtEditora = new JTextField(20);
	private JDateChooser jcDataPublicacao = new JDateChooser();
	private JTextField txtFormato = new JTextField(10);
	private JTextField txtNumeroDePaginas = new JTextField(5);
	private JTextArea txtSumario = new JTextArea(5, 50);
	private JTextArea txtResumo = new JTextArea(5, 50);
	private JTextField txtPre�oCusto = new JTextField(10);
	private JTextField txtPrecoVenda = new JTextField(10);
	private JTextField txtMargemLucro = new JTextField(10);
	private JTextField txtQtdadeEstoque = new JTextField(5);
	
	private JLabel lblImagem = new JLabel("<<Selecione uma imagem>>");
	
	public String getLivroPath() {
		return livroPath;
	}

	public void setLivroPath(String livroPath) {
		this.livroPath = livroPath;
	}

	public LivroBoundary() {
		// declarando e inicializando os componentes de tela.
		JLabel lblIsbn = new JLabel("Isbn");
		JLabel lblTituloLivro = new JLabel("Titulo");
		JLabel lblNomeAutor = new JLabel("Autor");
		JLabel lblCategoriaLivro = new JLabel("Categoria");
		JLabel lblEditora = new JLabel("Editora");
		JLabel lblDataPublicacao = new JLabel("Data da Publica��o");
		JLabel lblFormato = new JLabel("Formato");
		JLabel lblNumeroDePaginas = new JLabel("N� Paginas");
		JLabel lblSumario = new JLabel("Sumario");
		JLabel lblResumo = new JLabel("Resumo");
		JLabel lblPre�oCusto = new JLabel("Pre�o de custo R$:");
		JLabel lblPrecoVenda = new JLabel("Pre�o de venda R$:");
		JLabel lblMargemLucro = new JLabel("Margem de lucro");
		JLabel lblQtdadeEstoque = new JLabel("Quantidade em estoque");
	
		JPanel painelLeste = new JPanel(new BorderLayout());
		
		JPanel painelCentro = new JPanel(new BorderLayout());
		JPanel painelCentroCentro = new JPanel(new BorderLayout());
        JPanel painelCentroGrid = new JPanel(new GridLayout(6, 1, 1, 1));
		
		// montando a tela / painel leste
		painelLeste.add(lblImagem, BorderLayout.CENTER);
		painelLeste.add(btnCarregaImagem, BorderLayout.SOUTH);

		// motando a tela / painel centro
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(5);
		JPanel linha1 = new JPanel(flowLayout);
		JPanel linha2 = new JPanel(flowLayout);
		JPanel linha3 = new JPanel(flowLayout);
		JPanel linha4 = new JPanel(flowLayout);
		JPanel linha5 = new JPanel(flowLayout);
		JPanel linha6 = new JPanel(flowLayout);
		JPanel linha7 = new JPanel(new BorderLayout());
		JPanel linha8 = new JPanel(new BorderLayout());
		
		linha1.add(lblIsbn);
		linha1.add(txtIsbn);
		pesquisaLivro.setIcon(
				new ImageIcon(LivroBoundary.class.getResource("/resource/search1.png"))
				);
		linha1.add(pesquisaLivro);
		pesquisaLivro.addActionListener(this);
		painelCentroGrid.add(linha1);
		
		linha2.add(lblTituloLivro);
		linha2.add(txtTituloLivro);
		painelCentroGrid.add(linha2);
		
		linha3.add(lblNomeAutor);
		linha3.add(txtNomeAutor);
		pesquisaAutor.setIcon(
				new ImageIcon(LivroBoundary.class.getResource("/resource/lupa.png"))
				);
		linha3.add(pesquisaAutor);		
		linha3.add(lblEditora);
		linha3.add(txtEditora);
		pesquisaEditora.setIcon(
				new ImageIcon(LivroBoundary.class.getResource("/resource/lupa.png"))
				);
		linha3.add(pesquisaEditora);
		painelCentroGrid.add(linha3);		

		linha4.add(lblCategoriaLivro);
		linha4.add(cbCategoriaLivro);
		linha4.add(lblDataPublicacao);
		linha4.add(jcDataPublicacao);
		linha4.add(lblFormato);
		linha4.add(txtFormato);
		painelCentroGrid.add(linha4);
		
		linha5.add(lblPre�oCusto);
		linha5.add(txtPre�oCusto);
		linha5.add(lblPrecoVenda);
		linha5.add(txtPrecoVenda);		
		linha5.add(lblMargemLucro);
		linha5.add(txtMargemLucro);
		painelCentroGrid.add(linha5);		
		
		linha6.add(lblNumeroDePaginas);
		linha6.add(txtNumeroDePaginas);
		linha6.add(lblQtdadeEstoque);
		linha6.add(txtQtdadeEstoque);
		painelCentroGrid.add(linha6);
		
		linha7.add(lblSumario, BorderLayout.NORTH);
		linha7.add(txtSumario, BorderLayout.CENTER);
		
		linha8.add(lblResumo, BorderLayout.NORTH);
		linha8.add(txtResumo, BorderLayout.CENTER);
		
		JPanel painelSetado = new JPanel(new BorderLayout());
		painelSetado.add(painelCentroGrid, BorderLayout.CENTER);
		
		JPanel painelTextAreas = new JPanel(new GridLayout(2, 1));
		painelTextAreas.add(linha7);
		painelTextAreas.add(linha8);
		
		painelSetado.add(painelTextAreas, BorderLayout.SOUTH);
		// populando a combobox
	   	 String[] values = new String[] {"<<Escolha a Categoria>>",
						"Administra\u00E7\u00E3o", "Agropecu\u00E1ria", 
						"Artes", "Audiolivro", "Autoajuda", 
						"Ci\u00EAncias Biol\u00F3gicas", 
						"Ci\u00EAncias Exatas", 
						"Ci\u00EAncias Humanas e Sociais", "Contabilidade",
						"Cursos e Idiomas", "Dicion\u00E1rios e Manuais Convers.", 
						"Did\u00E1ticos", "Direito", 
						"Economia", "Engenharia e Tecnologia", "Esoterismo", 
						"Esportes e Lazer", "Gastronomia", "Geografia e Historia", 
						"Inform\u00E1tica", "Lingu\u00EDstica", 
						"Literatura Estrangeira", "Literatura Infantojuvenil", 
						"Literatura Nacional", "Livros", "Medicina", "Religi\u00E3o", 
						"Turismo"}; 
	   	DefaultComboBoxModel<String> combomodel = 
	   			new DefaultComboBoxModel<String>(values);
	   	cbCategoriaLivro.setModel(combomodel);
	   	cbCategoriaLivro.setToolTipText("Escolha uma categoria");    	
	   	cbCategoriaLivro.setForeground(Color.BLACK);
	   	cbCategoriaLivro.setBackground(Color.WHITE);
	   	cbCategoriaLivro.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	cbCategoriaLivro.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	cbCategoriaLivro.setBorder(BorderFactory.createEtchedBorder());
	   	
	   	// montando o painel de botoes
		
		JPanel painelBotoes = new JPanel();
		FlowLayout layoutBotoes = new FlowLayout();
		layoutBotoes.setAlignment(FlowLayout.CENTER);
		layoutBotoes.setHgap(110);
		painelBotoes.setLayout(layoutBotoes);
		painelBotoes.add(btnNovo);
		painelBotoes.add(btnSalvar);
		painelBotoes.add(btnAlterar);
		painelBotoes.add(btnExcluir);
		painelBotoes.add(btnVoltar);
		
	   	// formatando os componentes
	   	btnCarregaImagem.setIcon(
	   			new ImageIcon(LivroBoundary.class.getResource("/resource/open.png"))
	   			);
	   	btnCarregaImagem.setToolTipText("clique para carregar a imagem do livro");    	
	   	btnCarregaImagem.setForeground(Color.BLACK);
	   	btnCarregaImagem.setBackground(Color.WHITE);
	   	btnCarregaImagem.setFont(new Font("Tahoma", Font.BOLD, 18));
	   	btnCarregaImagem.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	btnCarregaImagem.setBorder(BorderFactory.createEmptyBorder());
	   	EvBtnCarregaImagemLivro evcarrega = new EvBtnCarregaImagemLivro(lblImagem, this);
	   	btnCarregaImagem.addActionListener(evcarrega);
	   	
	   	btnSalvar.addActionListener(this);
	   	btnSalvar.setToolTipText("Salvar registro");    	
	   	btnSalvar.setForeground(Color.BLACK);
	   	btnSalvar.setBackground(Color.WHITE);
	   	btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 18));
	   	btnSalvar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	btnSalvar.setBorder(BorderFactory.createEmptyBorder());
	   	btnSalvar.setIcon(
				new ImageIcon(LivroBoundary.class.getResource("/resource/save.png"))
				);	   	
	   	
	   	btnVoltar.addActionListener(this);
	   	btnVoltar.setToolTipText("Salvar registro");    	
	   	btnVoltar.setForeground(Color.BLACK);
	   	btnVoltar.setBackground(Color.WHITE);
	   	btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 18));
	   	btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	btnVoltar.setBorder(BorderFactory.createEmptyBorder());
	   	btnVoltar.setIcon(
				new ImageIcon(LivroBoundary.class.getResource("/resource/back.png"))
				);	
	   	
	   	btnNovo.addActionListener(this);
	   	btnNovo.setToolTipText("Salvar registro");    	
	   	btnNovo.setForeground(Color.BLACK);
	   	btnNovo.setBackground(Color.WHITE);
	   	btnNovo.setFont(new Font("Tahoma", Font.BOLD, 18));
	   	btnNovo.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	btnNovo.setBorder(BorderFactory.createEmptyBorder());
	   	btnNovo.setIcon(
				new ImageIcon(LivroBoundary.class.getResource("/resource/novo.png"))
				);
	   	
	   	btnAlterar.addActionListener(this);
	   	btnAlterar.setToolTipText("alterar dados");    	
	   	btnAlterar.setForeground(Color.BLACK);
	   	btnAlterar.setBackground(Color.WHITE);
	   	btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 18));
	   	btnAlterar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	btnAlterar.setBorder(BorderFactory.createEmptyBorder());
	   	btnAlterar.setIcon(
				new ImageIcon(LivroBoundary.class.getResource("/resource/edit.png"))
				);
	   	
	   	btnExcluir.addActionListener(this);
	   	btnExcluir.setToolTipText("Exclui registro");    	
	   	btnExcluir.setForeground(Color.BLACK);
	   	btnExcluir.setBackground(Color.WHITE);
	   	btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 18));
	   	btnExcluir.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	btnExcluir.setBorder(BorderFactory.createEmptyBorder());
	   	btnExcluir.setIcon(
				new ImageIcon(LivroBoundary.class.getResource("/resource/delete.png"))
				);
	   	
	   	pesquisaAutor.setToolTipText("clique para pesquisar um autor");    	
	   	pesquisaAutor.setForeground(Color.BLACK);
	   	pesquisaAutor.setBackground(Color.WHITE);
	   	pesquisaAutor.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	pesquisaAutor.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	pesquisaAutor.setBorder(BorderFactory.createEmptyBorder());
	   	
	   	pesquisaEditora.setToolTipText("clique para pesquisar uma editora");    	
	   	pesquisaEditora.setForeground(Color.BLACK);
	   	pesquisaEditora.setBackground(Color.WHITE);
	   	pesquisaEditora.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	pesquisaEditora.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	pesquisaEditora.setBorder(BorderFactory.createEmptyBorder());
	   	
	   	pesquisaLivro.setToolTipText("clique para pesquisar um livro pelo isbn");    	
	   	pesquisaLivro.setForeground(Color.BLACK);
	   	pesquisaLivro.setBackground(Color.WHITE);
	   	pesquisaLivro.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	pesquisaLivro.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	pesquisaLivro.setBorder(BorderFactory.createEmptyBorder());
	   	
	   	jcDataPublicacao.setForeground(Color.BLUE);
	   	jcDataPublicacao.setBackground(Color.WHITE);
	   	jcDataPublicacao.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	Dimension d = new Dimension(200, 30);
	   	jcDataPublicacao.setPreferredSize(d);
	   	jcDataPublicacao.setBorder(BorderFactory.createEtchedBorder());
	   	
	   	lblImagem.setForeground(Color.GREEN);
	   	lblImagem.setBorder(new LineBorder(Color.BLACK));
	   	lblImagem.setBackground(Color.LIGHT_GRAY);
	   	lblImagem.setVerticalAlignment(JLabel.CENTER);
	   	lblImagem.setHorizontalAlignment(JLabel.CENTER);
	   	    	
	   	formataJlabel(lblQtdadeEstoque);
	   	formataJlabel(lblCategoriaLivro);
	   	formataJlabel(lblDataPublicacao);
	   	formataJlabel(lblEditora);
	   	formataJlabel(lblFormato);
	   	formataJlabel(lblIsbn);
	   	formataJlabel(lblMargemLucro);
	   	formataJlabel(lblNomeAutor);
	   	formataJlabel(lblNumeroDePaginas);
	   	formataJlabel(lblPrecoVenda);
	   	formataJlabel(lblPre�oCusto);
	   	formataJlabel(lblQtdadeEstoque);
	   	formataJlabel(lblResumo);
	   	formataJlabel(lblSumario);
	   	formataJlabel(lblTituloLivro);
	   	
	   	formataJtextField(txtEditora);
	   	formataJtextField(txtFormato);
	   	formataJtextField(txtIsbn);
	   	formataJtextField(txtMargemLucro);
	   	formataJtextField(txtNomeAutor);
	   	formataJtextField(txtNumeroDePaginas);
	   	formataJtextField(txtPrecoVenda);
	   	formataJtextField(txtPre�oCusto);
	   	formataJtextField(txtQtdadeEstoque);
	   	formataJtextField(txtTituloLivro);
	   	
	   	formataPainel(painelCentro);
	   	formataPainel(painelCentroCentro);
	   	formataPainel(painelCentroGrid);
	   	formataPainel(painelLeste);
	   	formataPainel(painelBotoes);
	   	formataPainel(linha1);
	   	formataPainel(linha2);
	   	formataPainel(linha3);
	   	formataPainel(linha4);
	   	formataPainel(linha5);
	   	formataPainel(linha6);
	   	formataPainel(linha7);
	   	formataPainel(linha8);
	   	
	   	lblIsbn.setPreferredSize(lblPre�oCusto.getPreferredSize());
	   	lblTituloLivro.setPreferredSize(lblPre�oCusto.getPreferredSize());
	   	lblNomeAutor.setPreferredSize(lblPre�oCusto.getPreferredSize());
	   	lblCategoriaLivro.setPreferredSize(lblPre�oCusto.getPreferredSize());
	   	lblNumeroDePaginas.setPreferredSize(lblPre�oCusto.getPreferredSize());
	   	
	   	lblIsbn.setHorizontalAlignment(JLabel.RIGHT);
	   	lblTituloLivro.setHorizontalAlignment(JLabel.RIGHT);
	   	lblNomeAutor.setHorizontalAlignment(JLabel.RIGHT);
	   	lblCategoriaLivro.setHorizontalAlignment(JLabel.RIGHT);
	   	lblNumeroDePaginas.setHorizontalAlignment(JLabel.RIGHT);
	   	lblSumario.setHorizontalAlignment(JLabel.CENTER);
	   	lblResumo.setHorizontalAlignment(JLabel.CENTER);
	   	
	   	txtResumo.setBorder(BorderFactory.createEtchedBorder());
	   	txtSumario.setBorder(BorderFactory.createEtchedBorder());
	   	
	   	txtIsbn.addKeyListener(this);
	   	txtPrecoVenda.addKeyListener(this);
	   	txtPre�oCusto.addKeyListener(this);
	   	txtNumeroDePaginas.addKeyListener(this);
	   	txtMargemLucro.addKeyListener(this);
	   	txtQtdadeEstoque.addKeyListener(this);
	   	
	   	// montando a tela de fato		
		painelCentroCentro.add(painelSetado, BorderLayout.CENTER);
		painelCentro.add(painelCentroCentro, BorderLayout.CENTER);
		
		tela.add(painelLeste, BorderLayout.WEST);
		tela.add(painelCentro, BorderLayout.CENTER);
		tela.add(painelBotoes, BorderLayout.SOUTH);
		telaDefault();
	}

	public JPanel getTela() {
		return tela;
	}

	public void setTela(JPanel tela) {
		this.tela = tela;
	}
	
	public void formataJlabel(JLabel label){
		label.setForeground(Color.GRAY);
	   	label.setBackground(Color.WHITE);
	   	label.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
	   	label.setBorder(BorderFactory.createEmptyBorder());
	}
	
	public void formataJtextField(JTextField txt){
		txt.setForeground(Color.BLUE);
		txt.setBackground(Color.white);
		txt.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		txt.setBorder(BorderFactory.createEtchedBorder());
	}
	public void formataPainel(JPanel painel){
		painel.setForeground(Color.WHITE);
		painel.setBackground(Color.WHITE);
		painel.setBorder(BorderFactory.createEmptyBorder());
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnSalvar){
			if(formToLivro()!= null){
				if (livroControl.salvar(formToLivro()) > 0 ){
					telaNovo();
				}
			}
		}
		else if(e.getSource() == pesquisaLivro){
			LivroEntity livro = livroControl.pesquisar(Integer.parseInt(txtIsbn.getText()));
			if (livro.getIsbn() > 0){
				livroToForm(
						livro
						);	
				telaAlterar();
			}
			
		}else if(e.getSource() == btnAlterar){
			if (formToLivro()!=null){
				livroControl.atualizar(formToLivro());
			}
		}else if(e.getSource() == btnExcluir){
			livroControl.deletar(formToLivro().getIsbn());
			telaDefault();
		}else if(e.getSource() == btnVoltar){
			telaDefault();
		}else if(e.getSource() == btnNovo){
			telaNovo();
		}
	}
	
	public LivroEntity formToLivro(){
		if(validaCampos()){
			LivroEntity livro = new LivroEntity();
			
			//consertar os ids
			livro.setIdAutor(Integer.parseInt(txtFormato.getText()));
			livro.setIdCategoriaLivro(Integer.parseInt(txtFormato.getText()));
			livro.setIdEditora(Integer.parseInt(txtFormato.getText()));
			
			
			livro.setCategoriaLivro(cbCategoriaLivro.getSelectedItem().toString());
			livro.setDataPublicacao(jcDataPublicacao.getDate());
			livro.setEditora(txtEditora.getText());
			livro.setFormato(Integer.parseInt(txtFormato.getText()));
			livro.setImagem((ImageIcon) lblImagem.getIcon());
			livro.setImagePath(livroPath);
			livro.setIsbn(Integer.parseInt(txtIsbn.getText()));
			livro.setMargemLucro(Double.parseDouble(txtMargemLucro.getText()));
			livro.setNomeAutor(txtNomeAutor.getText());
			livro.setNumeroPaginas(Integer.parseInt(txtNumeroDePaginas.getText()));
			livro.setPrecoCusto(Double.parseDouble(txtPre�oCusto.getText()));
			livro.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText()));
			livro.setQtdeEmEstoque(Integer.parseInt(txtQtdadeEstoque.getText()));
			livro.setResumo(txtResumo.getText());
			livro.setSumario(txtSumario.getText());
			livro.setTituloLivro(txtTituloLivro.getText());
			return livro;
		}else{
			JOptionPane.showMessageDialog(null, "Preencha corretamente todos os campo!",null,JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	public void livroToForm(LivroEntity livro){
		txtEditora.setText(livro.getEditora());
		txtFormato.setText("" +livro.getFormato());
		txtIsbn.setText("" + livro.getIsbn());
		txtMargemLucro.setText("" + livro.getMargemLucro());
		txtNomeAutor.setText(livro.getNomeAutor());
		txtNumeroDePaginas.setText("" + livro.getNumeroPaginas());
		txtPrecoVenda.setText("" + livro.getPrecoVenda());
		txtPre�oCusto.setText("" + livro.getPrecoCusto());
		txtQtdadeEstoque.setText("" + livro.getQtdeEmEstoque());
		txtResumo.setText("" + livro.getResumo());
		txtSumario.setText(livro.getSumario());
		txtTituloLivro.setText(livro.getTituloLivro());
		jcDataPublicacao.setDate(livro.getDataPublicacao());
		cbCategoriaLivro.setSelectedItem(livro.getCategoriaLivro());
		lblImagem.setText("");
		lblImagem.setIcon(livro.getImagem());		
	}
	
	public void telaDefault(){
		txtEditora.setEditable(false);
		txtFormato.setEditable(false);
		txtMargemLucro.setEditable(false);
		txtNomeAutor.setEditable(false);
		txtNumeroDePaginas.setEditable(false);
		txtPrecoVenda.setEditable(false);
		txtPre�oCusto.setEditable(false);
		txtQtdadeEstoque.setEditable(false);
		txtResumo.setEditable(false);
		txtSumario.setEditable(false);
		txtTituloLivro.setEditable(false);
		txtIsbn.setEditable(true);
		
		txtEditora.setEnabled(false);
		txtFormato.setEnabled(false);
		txtMargemLucro.setEnabled(false);
		txtNomeAutor.setEnabled(false);
		txtNumeroDePaginas.setEnabled(false);
		txtPrecoVenda.setEnabled(false);
		txtPre�oCusto.setEnabled(false);
		txtQtdadeEstoque.setEnabled(false);
		txtResumo.setEnabled(false);
		txtSumario.setEnabled(false);
		txtTituloLivro.setEnabled(false);
		txtIsbn.setEnabled(true);
		cbCategoriaLivro.setEditable(false);
		cbCategoriaLivro.setEnabled(false);
		
		jcDataPublicacao.setEnabled(false);
		
		btnAlterar.setEnabled(false);
		btnCarregaImagem.setEnabled(false);
		btnExcluir.setEnabled(false);
		btnNovo.setEnabled(true);
		btnSalvar.setEnabled(false);
		btnVoltar.setEnabled(false);
		pesquisaAutor.setEnabled(false);
		pesquisaEditora.setEnabled(false);
		pesquisaLivro.setEnabled(true);
		limpaCampos();
	}
	
	public void telaAlterar(){
		txtEditora.setEditable(true);
		txtFormato.setEditable(true);
		txtMargemLucro.setEditable(true);
		txtNomeAutor.setEditable(true);
		txtNumeroDePaginas.setEditable(true);
		txtPrecoVenda.setEditable(true);
		txtPre�oCusto.setEditable(true);
		txtQtdadeEstoque.setEditable(true);
		txtResumo.setEditable(true);
		txtSumario.setEditable(true);
		txtTituloLivro.setEditable(true);
		txtIsbn.setEditable(false);
		
		txtEditora.setEnabled(true);
		txtFormato.setEnabled(true);
		txtMargemLucro.setEnabled(true);
		txtNomeAutor.setEnabled(true);
		txtNumeroDePaginas.setEnabled(true);
		txtPrecoVenda.setEnabled(true);
		txtPre�oCusto.setEnabled(true);
		txtQtdadeEstoque.setEnabled(true);
		txtResumo.setEnabled(true);
		txtSumario.setEnabled(true);
		txtTituloLivro.setEnabled(true);
		txtIsbn.setEnabled(false);
		
		cbCategoriaLivro.setEditable(true);
		cbCategoriaLivro.setEnabled(true);
		
		jcDataPublicacao.setEnabled(true);
		
		btnAlterar.setEnabled(true);
		btnCarregaImagem.setEnabled(true);
		btnExcluir.setEnabled(true);
		btnNovo.setEnabled(false);
		btnSalvar.setEnabled(false);
		btnVoltar.setEnabled(true);
		pesquisaAutor.setEnabled(true);
		pesquisaEditora.setEnabled(true);
		pesquisaLivro.setEnabled(false);
		
	}
	
	public void telaNovo(){
		limpaCampos();
		txtEditora.setEditable(true);
		txtFormato.setEditable(true);
		txtMargemLucro.setEditable(true);
		txtNomeAutor.setEditable(true);
		txtNumeroDePaginas.setEditable(true);
		txtPrecoVenda.setEditable(true);
		txtPre�oCusto.setEditable(true);
		txtQtdadeEstoque.setEditable(true);
		txtResumo.setEditable(true);
		txtSumario.setEditable(true);
		txtTituloLivro.setEditable(true);
		txtIsbn.setEditable(true);
		
		txtEditora.setEnabled(true);
		txtFormato.setEnabled(true);
		txtMargemLucro.setEnabled(true);
		txtNomeAutor.setEnabled(true);
		txtNumeroDePaginas.setEnabled(true);
		txtPrecoVenda.setEnabled(true);
		txtPre�oCusto.setEnabled(true);
		txtQtdadeEstoque.setEnabled(true);
		txtResumo.setEnabled(true);
		txtSumario.setEnabled(true);
		txtTituloLivro.setEnabled(true);
		txtIsbn.setEnabled(true);
		
		cbCategoriaLivro.setEditable(true);
		cbCategoriaLivro.setEnabled(true);
		
		jcDataPublicacao.setEnabled(true);
		
		btnAlterar.setEnabled(false);
		btnCarregaImagem.setEnabled(true);
		btnExcluir.setEnabled(false);
		btnNovo.setEnabled(false);
		btnSalvar.setEnabled(true);
		btnVoltar.setEnabled(true);
		pesquisaAutor.setEnabled(true);
		pesquisaEditora.setEnabled(true);
		pesquisaLivro.setEnabled(false);
		
	}
	
	public void limpaCampos(){
		txtEditora.setText("");
		txtFormato.setText("");
		txtMargemLucro.setText("");
		txtNomeAutor.setText("");
		txtNumeroDePaginas.setText("");
		txtPrecoVenda.setText("");
		txtPre�oCusto.setText("");
		txtQtdadeEstoque.setText("");
		txtResumo.setText("");
		txtSumario.setText("");
		txtTituloLivro.setText("");
		txtIsbn.setText("");
		
		cbCategoriaLivro.setSelectedIndex(0);
		jcDataPublicacao.setDate(null);
		
		lblImagem.setIcon(null);
		lblImagem.setText("<<Selecione uma imagem>>");
		
	}
	
	public boolean validaCampos(){
		if(
		txtEditora.getText().length() == 0 ||
		txtFormato.getText().length() == 0 ||
		txtMargemLucro.getText().length() == 0 ||
		txtNomeAutor.getText().length() == 0 ||
		txtNumeroDePaginas.getText().length() == 0 ||
		txtPrecoVenda.getText().length() == 0 ||
		txtPre�oCusto.getText().length() == 0 ||
		txtQtdadeEstoque.getText().length() == 0 ||
		txtResumo.getText().length() == 0 ||
		txtSumario.getText().length() == 0 ||
		txtTituloLivro.getText().length() == 0 ||
		txtIsbn.getText().length() == 0 ||
		jcDataPublicacao.getDate() == null ||
		cbCategoriaLivro.getSelectedItem().toString().length() == 0 ||
		cbCategoriaLivro.getSelectedItem().toString() == "<<Escolha a Categoria>>"
				)
		{
			return false;
		}
			return true;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		String caracteres="0987654321";
		if(!caracteres.contains(arg0.getKeyChar()+"")){
			arg0.consume();
		}

		
	}
	
}
