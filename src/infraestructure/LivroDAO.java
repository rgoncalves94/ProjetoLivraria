package infraestructure;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import control.ImagemFormater;
import entity.LivroEntity;


public class LivroDAO {
	
	SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	
	public long insert(LivroEntity livro) throws SQLException{
		long idGerado = -1;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "INSERT INTO `Livro` "
					+ "(`CodAutor`,"
					+ " `CodCategoria`,"
					+ " `CodEditora`,"
					+ " `DataPublicacao`, "
					+ "`Formato`,"
					+ " `ISBN`,"
					+ " `MargemLucro`,"
					+ " `NumeroPaginas`,"
					+ " `PrecoCusto`,"
					+ " `PrecoVenda`,"
					+ " `QtdeEmEstoque`,"
					+ " `Resumo`,"
					+ " `Sumario`,"
					+ " `Titulo`,"
					+ " `Imagem`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, livro.getIdAutor());
			stmt.setInt(2, livro.getIdCategoriaLivro());
			stmt.setInt(3, livro.getIdEditora());
			stmt.setDate(4, new Date(livro.getDataPublicacao().getTime()));
			stmt.setInt(5, livro.getFormato() );
			stmt.setInt(6,livro.getIsbn());
			stmt.setDouble(7, livro.getMargemLucro());
			stmt.setInt(8,livro.getNumeroPaginas());
			stmt.setDouble(9,livro.getPrecoCusto());
			stmt.setDouble(10, livro.getPrecoVenda());
			stmt.setInt(11, livro.getQtdeEmEstoque());
			stmt.setString(12, livro.getResumo());
			stmt.setString(13,livro.getSumario());
			stmt.setString(14,livro.getTituloLivro());
			stmt.setBytes(15, ImagemFormater.imagemParaByte(livro.getImagePath()));
					


			
			stmt.executeUpdate();

			ResultSet r = stmt.getGeneratedKeys();
			r.next();
			idGerado = r.getLong(1);

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return idGerado;
	}
	
	
	
	public int update(LivroEntity livro) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "UPDATE "
					+ "`Livro` SET "
					+ "`CodAutor`=?, "
					+ "`CodCategoria`=?,  "
					+ "`CodEditora`=?, "
					+ "`DataPublicacao`=?, "
					+ "`Formato`=?, "
					+ "`ISBN`=?, "
					+ "`MargemLucro`=?, "
					+ "`NumeroPaginas`=?, "
					+ "`PrecoCusto`=?, "
					+ "`PrecoVenda`=?, "
					+ "`QtdeEmEstoque`=?, "
					+ "`Resumo`=?, "
					+ "`Sumario`=?, "
					+ "`Titulo`=? "
				//	+ "`Imagem`=? "
					+ "WHERE  `ISBN`=?;";

			
			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, livro.getIdAutor());
			stmt.setInt(2, livro.getIdCategoriaLivro());
			stmt.setInt(3, livro.getIdEditora());
			stmt.setDate(4, new Date(livro.getDataPublicacao().getTime()));
			stmt.setInt(5, livro.getFormato() );
			stmt.setInt(6,livro.getIsbn());
			stmt.setDouble(7, livro.getMargemLucro());
			stmt.setInt(8,livro.getNumeroPaginas());
			stmt.setDouble(9,livro.getPrecoCusto());
			stmt.setDouble(10, livro.getPrecoVenda());
			stmt.setInt(11, livro.getQtdeEmEstoque());
			stmt.setString(12, livro.getResumo());
			stmt.setString(13,livro.getSumario());
			stmt.setString(14,livro.getTituloLivro());
			//stmt.setBytes(15, ImagemFormater.imagemParaByte(livro.getImagem()));
			stmt.setInt(15,livro.getIsbn());
			
			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}
	
	
	public int delete(long id) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "DELETE FROM Livro WHERE ISBN = ?;";

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, id);

			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}
	
	
	public LivroEntity selectById(long codLivro) {
		LivroEntity livro = new LivroEntity();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM Livro WHERE CodLivro = ?;";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setLong(1, codLivro);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				stmt.setInt(1, livro.getIdAutor());
				stmt.setInt(2, livro.getIdCategoriaLivro());
				stmt.setInt(3, livro.getIdEditora());
				stmt.setDate(4, new Date(livro.getDataPublicacao().getTime()));
				stmt.setInt(5, livro.getFormato());
				stmt.setInt(6, livro.getIsbn());
				stmt.setDouble(7, livro.getMargemLucro());
				stmt.setInt(8, livro.getNumeroPaginas());
				stmt.setDouble(9, livro.getPrecoCusto());
				stmt.setDouble(10, livro.getPrecoVenda());
				stmt.setInt(11, livro.getQtdeEmEstoque());
				stmt.setString(12, livro.getResumo());
				stmt.setString(13, livro.getTituloLivro());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return livro;
	}
	
	public LivroEntity selectByIsbn(int isbn) {
		LivroEntity livro = new LivroEntity();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM Livro WHERE ISBN = ?;";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setLong(1, isbn);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
					livro.setIsbn(rs.getInt("ISBN"));
				    livro.setTituloLivro(rs.getString("Titulo"));
					livro.setIdAutor(rs.getInt("CodAutor"));
					livro.setIdCategoriaLivro(rs.getInt("CodCategoria"));
					livro.setIdEditora(rs.getInt("CodEditora"));
					livro.setNumeroPaginas(rs.getInt("NumeroPaginas"));
					livro.setResumo(rs.getString("Resumo"));
					livro.setSumario(rs.getString("Sumario"));
					livro.setFormato(rs.getInt("Formato"));
					livro.setDataPublicacao(rs.getDate("DataPublicacao"));
					livro.setPrecoVenda(rs.getDouble("PrecoVenda"));
					livro.setPrecoCusto(rs.getDouble("PrecoCusto"));
					livro.setMargemLucro(rs.getDouble("MargemLucro"));
					livro.setQtdeEmEstoque(rs.getInt("QtdeEmEstoque"));
					livro.setImagem(ImagemFormater.bytesParaImagem(rs.getBytes("Imagem")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return livro;
	}
	
	public List<LivroEntity> selectToFormPesquisa(int autor,
			String titulo, int editora, int categoria) {
		List<LivroEntity> books = new ArrayList<LivroEntity>();
		int validaAutor = 2147483646;
		int validaTitulo = 2147483646;
		int validaEditora = 2147483646;
		int validaCategoria = 2147483646;
		if(autor != 0) validaAutor = 0; 
		if(titulo.length()>0) validaTitulo = 0;	
		if(editora!=0) validaEditora = 0;
		if(categoria!=0) validaCategoria = 0;
		
		
		try {
			Connection con = JDBCUtil.getConnection();

			
			String query = "SELECT * FROM Livro "
					+ "WHERE ((Titulo LIKE ? OR ISBN < ?) AND "
					+ "(CodAutor = ? OR ISBN < ?) AND "
					+ "(CodEditora = ? OR ISBN < ?) AND "
					+ "(CodCategoria = ? OR ISBN < ?))";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, "%" + titulo + "%");
			stmt.setInt(2, validaTitulo);
			stmt.setInt(3, autor);
			stmt.setInt(4, validaAutor);
			stmt.setInt(5, editora);
			stmt.setInt(6, validaEditora);
			stmt.setInt(7, categoria);
			stmt.setInt(8, validaCategoria);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LivroEntity livro = new LivroEntity();
				
				livro.setIsbn(rs.getInt("ISBN"));
			    livro.setTituloLivro(rs.getString("Titulo"));
				livro.setIdAutor(rs.getInt("CodAutor"));
				livro.setIdCategoriaLivro(rs.getInt("CodCategoria"));
				livro.setIdEditora(rs.getInt("CodEditora"));
				livro.setNumeroPaginas(rs.getInt("NumeroPaginas"));
				livro.setResumo(rs.getString("Resumo"));
				livro.setSumario(rs.getString("Sumario"));
				livro.setFormato(rs.getInt("Formato"));
				livro.setDataPublicacao(rs.getDate("DataPublicacao"));
				livro.setPrecoVenda(rs.getDouble("PrecoVenda"));
				livro.setPrecoCusto(rs.getDouble("PrecoCusto"));
				livro.setMargemLucro(rs.getDouble("MargemLucro"));
				livro.setQtdeEmEstoque(rs.getInt("QtdeEmEstoque"));
				livro.setImagem(ImagemFormater.bytesParaImagem(rs.getBytes("Imagem")));
				
				books.add(livro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return books;
	}
	
	
	
	public List<LivroEntity> selectByAutor(String name) {
		List<LivroEntity> books = new ArrayList<LivroEntity>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM Livro WHERE CodAutor LIKE ?;";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, "%" + name + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				LivroEntity livro = new LivroEntity();
				
				stmt.setInt(1, livro.getIdAutor());
				stmt.setInt(2, livro.getIdCategoriaLivro());
				stmt.setInt(3, livro.getIdEditora());
				stmt.setDate(4, new Date(livro.getDataPublicacao().getTime()));
				stmt.setInt(5, livro.getFormato());
				stmt.setInt(6, livro.getIsbn());
				stmt.setDouble(7, livro.getMargemLucro());
				stmt.setInt(8, livro.getNumeroPaginas());
				stmt.setDouble(9, livro.getPrecoCusto());
				stmt.setDouble(10, livro.getPrecoVenda());
				stmt.setInt(11, livro.getQtdeEmEstoque());
				stmt.setString(12, livro.getResumo());
				stmt.setString(13, livro.getTituloLivro());
				
				books.add(livro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return books;
	}
	
	
	
	public List<LivroEntity> selectAll() {
		List<LivroEntity> books = new ArrayList<LivroEntity>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM Livro;";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				LivroEntity livro = new LivroEntity();
				
				stmt.setInt(1, livro.getIdAutor());
				stmt.setInt(2, livro.getIdCategoriaLivro());
				stmt.setInt(3, livro.getIdEditora());
				stmt.setDate(4, new Date(livro.getDataPublicacao().getTime()));
				stmt.setInt(5, livro.getFormato());
				stmt.setInt(6, livro.getIsbn());
				stmt.setDouble(7, livro.getMargemLucro());
				stmt.setInt(8, livro.getNumeroPaginas());
				stmt.setDouble(9, livro.getPrecoCusto());
				stmt.setDouble(10, livro.getPrecoVenda());
				stmt.setInt(11, livro.getQtdeEmEstoque());
				stmt.setString(12, livro.getResumo());
				stmt.setString(13, livro.getTituloLivro());

				books.add(livro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}
	
	


}
