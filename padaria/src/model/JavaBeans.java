package model;

public class JavaBeans {
	
	private String idcon;
	private String nome;
	private String descricao;
	private String preco;
		
	
	public JavaBeans() {
		super();
		// construtor padrão
	}
	
		
	public JavaBeans(String idcon, String nome, String descricao, String preco) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		
	} // construtor por variaveis



	public String getIdcon() {
		return idcon;
	}
	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
		
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getPreco() {
		return preco;
	}
	public void setPreco(String string) {
		this.preco = string;
	}
}
