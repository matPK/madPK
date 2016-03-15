package backend.br.com.supermarket;

import java.sql.*;

public class DataAccess {
	
	private static DataAccess instance;
	
	//private constructor
	private DataAccess(){
		//
	}
	
	//private instantiator
	private static DataAccess getInstance(){
		instance = new DataAccess();
		return instance;
	}
	
	//db connection method
	private Connection connect(){
		try{
			return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306"+//db address
				"/javadb"+//name of the db
				"?autoReconnect=true"+//autoReconnect?
				"&useSSL=false",//use SSL?
				"root",//insert your db login here
				"!MatPK1991"//insert your password here
			);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//returns a statement created within the connection variable
	private static Statement getStatement(){
		try{
			Connection c = getInstance().connect();
			return c.createStatement();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//query executer, returns result set. Use for SELECT. Pass the String of the query as the parameter.
	public static ResultSet dataAccessQuery(String query){
		try{
			return getStatement().executeQuery(query);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//update executer, returns nothing. Use for DELETE, UPDATE, etc. Pass the String of the query as the parameter.
	public static void nullDataAccessQuery(String query){
		try{
			getStatement().executeUpdate(query);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}