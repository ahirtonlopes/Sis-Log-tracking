
import java.net.*;
import java.io.*;
import java.util.Vector;

//Classe para Acessar e Ler os enderecos MAC proximos ao Access Point Zinwell G220

public class Acessar {

	private URL objeto_url;
	private URLConnection objeto_conexao;
	private BufferedReader buffer_leitura;
	private ProgramControl objcontrolebanco;
	private String url, saida_texto, string_comparacao;
    private Vector enderecos_mac;
    private int String;
    private String coletora, movel;
    
    public Acessar(String estacao_coletora)  throws Exception
    {
    
     coletora = estacao_coletora;
     enderecos_mac = new Vector();
        
     url = "http://192.168.2.254/wlsurvey.asp"; // Endereco para tabela

     //Esta string serve para comparar aonde comecam os enderecos MAC
     string_comparacao="<td align=center width=\"20%\" bgcolor="+"\"#C0C0C0\"><font size=\"2\">";
     
     objeto_url = new URL(url);
     objeto_conexao = objeto_url.openConnection();
     buffer_leitura = new BufferedReader( new InputStreamReader(objeto_conexao.getInputStream()));
     objcontrolebanco= new ProgramControl();
    }
    
    public void Ler () throws Exception
    {
    	while ((saida_texto = buffer_leitura.readLine()) != null)
    	{
          if(saida_texto.startsWith(string_comparacao))
          {
            saida_texto=saida_texto.substring(62,79); // Eliminando a formatacao HTML - Pegando apenas o MAC
            enderecos_mac.add(String, saida_texto); 
          }
        }
          
        for(int i=0; i<enderecos_mac.size(); i++) //Checara todos os MAC salvos, tentar salvar na tabela LOG
         {
          movel = ""+enderecos_mac.get(i);
          objcontrolebanco.SalvaBanco(coletora , movel); //Chama rotina para salvar na tabela LOG, passando a estacao coletora e a movel     
         }
    }

}