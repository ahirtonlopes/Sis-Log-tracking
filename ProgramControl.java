import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import conexao.db;

public class ProgramControl{

	boolean verifica = true;
    ResultSet rsOnibus = null, rsParada = null, rsLog = null;
    int id_onibus = 0;
    int id_parada = 0;
    long tempo;
    db db1;
	
	public ProgramControl(){
	    
        //Cria objeto para fazer a comunicacao com DB
        try {
			db1 = new db();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       }

      public void SalvaBanco(String maccoletora, String macmovel) throws SQLException
      {

        
        Timestamp time1 = new Timestamp(0);
        Timestamp time2 = new Timestamp(0);
        
        time1.setTime(System.currentTimeMillis());
        
        	//Encontra ID do onibus no DB        	
        	rsOnibus = db1.consultaOnibus(macmovel);//string com o MAC da estacao movel
        	
        	if(rsOnibus != null){
        		id_onibus = rsOnibus.getInt("id_onibus");
        		System.out.println("id onibus:"+id_onibus);
        	}else{
                        id_onibus = 0;
        	}
        	
        	//Encontra ID da parada no DB
        	rsParada = db1.consultaParada(maccoletora);//tring com o MAC da estacaocoletora
        	if(rsParada != null){
        		id_parada = rsParada.getInt("id_parada");
        		System.out.println("id parada:"+id_parada);
        	}else{
        		id_parada = 0;
        	}
        	
        	//Inclus�o no DB na tabela LOG
        	if((id_onibus != 0) && (id_parada != 0)){
        		
        		rsLog = db1.consultaLog(id_onibus, id_parada);
        		if(rsLog != null){
        			
        			rsLog.first();
        			
        			time2 = rsLog.getTimestamp("data");
        			tempo = time1.getTime() - time2.getTime();
        		
        			System.out.println(tempo);
        		
        			if(tempo > 60000){
        				//Incluir controle de tempo de inclus�o usando biblioteca TimeStamp
        				db1.gravaLog(id_onibus, id_parada);
        			}
        		}else{
        			//Incluir controle de tempo de inclus�o usando biblioteca TimeStamp
    				db1.gravaLog(id_onibus, id_parada);
        		}
        	} 
        }
	
}
