package classes.br.com.supermarket;

public class Product {

	public Product(){
		//
	}
	public Product(int cod_bar, int qnt, String nome_prod, double vlr) {
		this.cod_bar = cod_bar;
		this.qnt = qnt;
		this.nome_prod = nome_prod;
		this.vlr = vlr;
	}

	//attribs
	private int cod_bar, qnt;
	private String nome_prod;
	private double vlr;
	
	
	//getters-setters
	public int getCod_bar() {
		return cod_bar;
	}
	public void setCod_bar(int cod_bar) {
		this.cod_bar = cod_bar;
	}
	public int getQnt() {
		return qnt;
	}
	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	public String getNome_prod() {
		return nome_prod;
	}
	public void setNome_prod(String nome_prod) {
		this.nome_prod = nome_prod;
	}
	public double getVlr() {
		return vlr;
	}
	public void setVlr(double vlr) {
		this.vlr = vlr;
	}
	@Override
	public String toString() {
		return "Product [cod_bar=" + cod_bar + ", qnt=" + qnt + ", nome_prod="
				+ nome_prod + ", vlr=" + vlr + "]";
	}
	
	//methods	
}
