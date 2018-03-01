package conexao;

import java.sql.*;

public class Conexao {
	
	// Variaveis
	String nomedobanco="bdsislog";
	private String ip="localhost";
	private String host;
	private String driver;
	
	private Connection conn=null;
	private Statement st=null;	
	
	public Connection getConn(){
		return conn;
	}
	
	public void setConn(Connection con){
		this.conn = con;
	}
	
	public Statement getSt(){
		return st;
	}
	
	public void setSt(Statement s){
		this.st = s;
	}
	
	/** Criar uma nova instância de conexão*/
	
	public Conexao() throws Exception{
		
		 host = "jdbc:mysql://"+ip+"/"+nomedobanco;
		 driver = "com.mysql.jdbc.Driver";
		
		 Class.forName(driver).newInstance();
                  		                          //Usuario: sislog
		                                        // Senha: 123sislog123
		 this.conn = DriverManager.getConnection(host, "sislog", "123sislog123"); 
	     this.st = conn.createStatement();
	     
	}
	
}
