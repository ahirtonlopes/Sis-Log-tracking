/*package conexao;

import java.sql.*;
//import ExemploCliente.Conexao;

public class db {
		
		private Conexao conec = null;
		private String sql = "";
		
		*//**Criar uma nova instâcia de Cliente*//*
		
		public db() throws Exception{
			this.conec = new Conexao();
		}
		
		public ResultSet buscaIp (String ip){
			try {
				sql = "select * from ips where ip = '" + ip + "'";
				return conec.getSt().executeQuery(sql);
			} catch (Exception ex){
				return null;
			}
		}
		
		public boolean insereIp (int id, String ip){
			try {
				System.out.println("-----------------------");
				sql = "insert into ips (Id,ip) " + "values ('" + id + "','" + ip + "')";
				int rs = conec.getSt().executeUpdate(sql);
				if (rs!=0)
					return true;
				else
					return false;
			} catch (Exception ex){
				return false;
			}
		}
		
		public boolean excluiIp (String ip){
			try {			
				sql = "delete from ips where ip = " + ip + "";
				int rs = conec.getSt().executeUpdate(sql);
				if (rs!=0)
					return true;
				else
					return false;
			} catch (Exception ex){
				return false;
			}
		}
		
		public ResultSet listaIp(){
			try{
				sql = "select * from ips";
				return conec.getSt().executeQuery(sql);
			} catch (Exception ex){
				return null;
			}
		}
		
	}

*/

package conexao;

import java.sql.ResultSet;

public class db {
		
		private Conexao conec = null;
		private String sql = "";
		
		/**Criar uma nova instâcia de Cliente*/
		
		public db() throws Exception{
			this.conec = new Conexao();
		}
		
		public ResultSet buscaIp (String ip){
			try {
				sql = "select * from ips where ip = '" + ip + "'";
				return conec.getSt().executeQuery(sql);
			} catch (Exception ex){
				return null;
			}
		}
		
		public boolean insereIp (int id, String ip){
			try {
				sql = "insert into ips (Id,ip) " + "values ('" + id + "','" + ip + "')";
				int rs = conec.getSt().executeUpdate(sql);
				if (rs!=0)
					return true;
				else
					return false;
			} catch (Exception ex){
				return false;
			}
		}
		
		public boolean excluiIp (String ip){
			try {			
				sql = "delete from ips where ip = '" + ip + "'";
				int rs = conec.getSt().executeUpdate(sql);
				if (rs!=0)
					return true;
				else
					return false;
			} catch (Exception ex){
				return false;
			}
		}
		
		public ResultSet listaIp(){
			try{
				sql = "select * from ips";
				return conec.getSt().executeQuery(sql);
			} catch (Exception ex){
				return null;
			}
		}

		//Atualizado
		public ResultSet consultaOnibus (String mac){
			try {
				sql = "select id_onibus from onibus where mac_onibus = '" + mac +"';";
				
				System.out.println(sql);
				ResultSet rs = conec.getSt().executeQuery(sql);
				rs.next();
				int id = rs.getInt("id_onibus");
				return rs;
			} catch (Exception ex){
				return null;
			}
		}
		
		//Atualizado
		public ResultSet consultaParada (String mac){
			try {
				sql = "select id_parada from parada where mac_parada = '" + mac + "';";
				ResultSet rs = conec.getSt().executeQuery(sql);
				rs.next();
				int id = rs.getInt("id_parada");
				return rs;
			} catch (Exception ex){
				return null;
			}
		}
	
		public ResultSet consultaLog (int id_onibus, int id_parada){
			try {
				sql = "select * from log where (onibus='" + id_onibus + "' and parada_anterior='" + id_parada + "')";
				ResultSet rs = conec.getSt().executeQuery(sql);
				rs.next();
				int id = rs.getInt("id");
				return rs;
			} catch (Exception ex){
				return null;
			}
		}
		
		public boolean gravaLog (int id_onibus, int id_parada){
			int id_log = 0;
			try {
				System.out.println("-----------------------");
				//Insere o id do onibus e da parada, mais a data atual. Sendo que ao valor da data atual soma-se mais 30 segundos (NOW()+INTERVAL 30 SECOND)
				sql = "insert into log (onibus_log,parada_log,data_log,id_log) " + "values ('" + id_onibus + "','" + id_parada+ "',NOW()+INTERVAL 30 SECOND,'" +id_log+ "');";
				System.out.print(sql);
				int rs = conec.getSt().executeUpdate(sql);
				if (rs!=0){
					System.out.println("Inclusão feita com sucesso!");
					return true;
				}else{
					System.out.println("Falha na Inclusão");
					return false;
				}
			} catch (Exception ex){
				System.out.println("Exception Error");
				return false;
			}
		}
		
	}

