/**
 *
 * @author marcu
 */
public class Teste {
    
    public static void main(String[] args) {
        String text = "MARCUS LUIZ ALVES DA SILVA";
        String[] s = text.trim().split(" ");
        System.out.println("Primeira: "+s[0]);
        System.out.println("Ultima: "+s[s.length-1]);
    }
    
}
