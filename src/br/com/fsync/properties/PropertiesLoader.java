package br.com.fsync.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author MarcusLuiz
 */
public class PropertiesLoader {  
  
    /*private Properties props;  
    private String nomeDoProperties = "ipConfig.properties";  
  
    protected PropertiesLoader(){  
            props = new Properties();  
            InputStream in = this.getClass().getResourceAsStream(nomeDoProperties);  
            try{  
                    props.load(in);  
                    in.close();  
            }  
            catch(IOException e){e.printStackTrace();}  
    }  
  
    protected String getValor(String chave){  
            return (String)props.getProperty(chave);  
    }*/
    
    public Properties props;
    //public String nomeDoProperties = "/LandA.properties";

    public PropertiesLoader() {
        //InputStream in = this.getClass().getResourceAsStream("/br/com/landa/properties/LandA.properties");
        try {
            FileInputStream in = new FileInputStream("Z:\\LandA\\LandA.properties");
            //FileInputStream in = new FileInputStream("//Users//marcusluiz//IpConfig.properties");
            props = new Properties();
            props.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValor(String chave) {
        return (String) props.getProperty(chave);
    }
}