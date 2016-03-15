package backend.br.com.supermarket;
import gui.br.com.supermarket.MainWindow;

import java.sql.ResultSet;

import classes.br.com.supermarket.Product;

public class Functions {
	public Functions(){
		//
	}
	
	private ResultSet rs;
	private Product[] tempList = null;
		
	public Product getObjByCodBar(int cod_bar){
		String query = 
				"SELECT * "+
				"FROM tb_product "+
				"WHERE cod_bar = "+cod_bar;
		Product p = new Product();
		try{
			this.rs = DataAccess.dataAccessQuery(query);
			while(this.rs.next()){
				p.setCod_bar(this.rs.getInt("cod_bar"));
				p.setNome_prod(this.rs.getString("name_prod"));
				p.setQnt(this.rs.getInt("qnt"));
				p.setVlr(this.rs.getDouble("vlr"));
			}
		}catch(Exception e){
			e.getStackTrace();
		}
		return p;
	}
	
	public boolean remFromStock(int cod_bar, int qnt){
		String query = 
				"UPDATE tb_product "+
				"SET qnt = (qnt - "+qnt+")"+
				" WHERE cod_bar = "+cod_bar;
		try{
			DataAccess.nullDataAccessQuery(query);
			return true;
		}catch(Exception e){
			e.getStackTrace();
			return false;
		}
	}
	
	public double calculateTotal(Product[] L){
		double total = 0;
		for(int i = 0; i < L.length; i++){
			total += L[i].getVlr();
		}
		return total;
	}
	
	public Product[] Append(Product[] pList){
		tempList = new Product[pList.length+1];
		for(int i = 0; i < pList.length; i++){
			tempList[i] = pList[i];
		}
		return tempList;
	}
	
	public String refreshList(Product[] prodList){
		String s = "";
		for(int i = 0; i < prodList.length; i++){
			s += prodList[i].getNome_prod()+", ";
		}
		return s;
	}
	
	public void finalize(Product[] prodList){
		double total = 0;
		for(Product p : prodList){
			remFromStock(p.getCod_bar(), 1);
			total += p.getVlr();
			System.out.println(p.getNome_prod()+"\t\t"+p.getVlr()+"+");
		}
		System.out.println("-------------------");
		System.out.println("Total:\t\t"+total);		
	}
	
	
	//getter-setter
	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
}
