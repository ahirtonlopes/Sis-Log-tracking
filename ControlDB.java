import java.sql.ResultSet;
import java.sql.Timestamp;

import conexao.db;


public class ControlDB {
	
	public static void main(String[] args) throws Exception {
		
//		ResultSet rsLog, rsOnibus, rsParada;
//		int id_log, id_onibus, id_parada;
//
//		db db1 = new db();
//
//    	//Encontra ID do onibus no DB        	
//    	rsOnibus = db1.consultaOnibus("192.168.2.101");
//    	if(rsOnibus != null)
//    		id_onibus = rsOnibus.getInt("id");
//    	else{
//    		rsOnibus = db1.consultaOnibus("192.168.2.103");
//    		if(rsOnibus != null)
//    			id_onibus = rsOnibus.getInt("id");
//    		else
//    			id_onibus = 0;
//    	}
//    	
//    	//Encontra ID da parada no DB
//    	rsParada = db1.consultaParada("192.168.2.255");    	
//    	
//    	if(rsParada != null)
//    		id_parada = rsParada.getInt("id");
//    	else{
//    		rsParada = db1.consultaParada("192.168.2.254");
//    		if(rsParada != null)
//    			id_parada = rsParada.getInt("id");
//    		else
//    			id_parada = 0;
//    	}
//
//    	System.out.println(id_onibus + " - " + id_parada);
//    	
//		rsLog = db1.consultaLog(id_onibus, 4);		
//		
//		if(rsLog != null){
//			System.out.println("Id encontrado: " + rsLog.getInt("id"));
//		}else{
//			System.out.println("Id não encontrado!");
//		}
//		
		
		
		
		int i = 0, j= 0;
		
		Timestamp data1 = new Timestamp(System.currentTimeMillis());
		
		System.out.println(data1);
		
		
		while(j<1000000000){
			while(i<10000000){
				i++;
			}
			j++;
		}
		
		
		
		
		data1.setTime(System.currentTimeMillis());
		
		
		System.out.println(data1);
		
		
		
	}
}

