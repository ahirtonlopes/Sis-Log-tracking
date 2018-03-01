
public class Principal {
	
	private static Acessar objeto_de_acesso;
	
	public static void main(String[] args) 
	{
		    //Cado de Teste: Rede CCET UFMA
		    //Coletora: 00:21:91:74:72:dc (PETCOMP)

			String coletora="00:21:91:74:72:dc"; //Endereco MAC para a estacao coletora
			try {
				objeto_de_acesso = new Acessar(coletora);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			new Thread(new Runnable(){
				public void run()
				{
					try{
					  while(true)
					  {
						 //Chama a rotina para verificar os APs proximos de 30 em 30 segundos 
						 objeto_de_acesso.Ler();
						 Thread.sleep(30000); //30 milisegundos = 30 Segundos
					  }
					}
					catch (Exception e)
					{
					e.printStackTrace();	
					}
				}
			}).start();		
	}		
	
}
