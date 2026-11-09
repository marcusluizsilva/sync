package br.com.fsync.properties;

/**
 *
 * @author marcusluiz
 */
public class PropertiesReader {
    
    private static PropertiesLoader loader = new PropertiesLoader();  
      
    public static String getValor(String chave) {  
            return (String)loader.getValor(chave);  
    }
}
