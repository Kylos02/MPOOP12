package poop12;

/**
 *
 * @author Leny
 */
public class POOP12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Cuenta hilo1=new Cuenta("Deposito 1");
       Cuenta hilo2=new Cuenta("Deposito 2");
       Cuenta hilo3=new Cuenta("Retiro 1");
       Cuenta hilo4=new Cuenta("Retiro 2");
       
       hilo1.start();
       hilo2.start();
       hilo3.start();
       hilo4.start();
    }
    
}
