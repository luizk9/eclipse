package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	// modulo de conexão com o bd
	
	// parámetros
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url =
	"jdbc:mysql://127.0.0.1:3307/dbpanificadora?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "123456";
	
	// metodos
	private Connection conectar() {
			Connection con = null;
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user,password );
				return con;
				} catch (Exception e) {
					System.out.println(e);
					return null;			
				}
		} 
		/** CRUD CREATE **/
		public void inserirCadastroBd(JavaBeans cadastroBd) {
			String create = "insert into tbcadastro (nome,descricao,preco)values(?,?,?)";
			try {// abrir o bd 
					Connection con = conectar();
					//preparar a query fazer o bd
					PreparedStatement pst = con.prepareStatement(create);
					// substituindo as ? ? ? pelo q tem no JavaBeans
					pst.setString(1,cadastroBd.getNome());
					pst.setString(2,cadastroBd.getDescricao());
					pst.setString(3,cadastroBd.getPreco());
					// execuntando a query
					pst.executeUpdate();
					// fecha p Bd
					con.close();
					
										
				} catch (Exception e) {
					System.out.println(e);
				}			
		}
		/** CRUD PARA LER OS DADOS **/
		
		public ArrayList<JavaBeans>listarCadastro() {
			// objeto para acessar o JavaBeans
			ArrayList<JavaBeans> contatos = new ArrayList<>();
			
			String read = "Select*from tbcadastro order by nome";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(read);
				ResultSet rs = pst.executeQuery();
				// laço para exibir os dados 
				while(rs.next()) {
					// variaveis para receber dados do bd
					String idcon = rs.getString(1);
					String nome = rs.getString(2);
					String Descricao = rs.getString(3);
					String preco = rs.getString(4);
					// colocando no arrey
					contatos.add(new JavaBeans(idcon,nome,Descricao,preco));									
				}//fim do while
				con.close();
				return contatos;
				
			} catch (Exception e) {
				System.out.println(e);
				return null;
				
				
			}
		}
}
