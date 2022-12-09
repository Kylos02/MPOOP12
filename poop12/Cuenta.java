package poop12;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Leny
 */
class Cuenta extends Thread{
    private static double saldo;
    
    public Cuenta(String name){
        super(name);
        saldo=0;
    }
    
    public static double consultaSaldo(){
        return saldo;
    }
    
    public synchronized void depositarDinero(double monto){
        saldo += monto;
        System.out.println(getName()+ " depositando saldo ... saldo: "+saldo);
        notifyAll();
    }
    
    public synchronized void retirarDinero(double monto){
        if(saldo<=0 || monto>saldo){
            System.out.println(getName()+" debe esperar un deposito saldo: "+saldo);
            try{
                sleep(5000);
            }catch (InterruptedException ex){
                System.out.println(ex.getMessage());
            }
        }
        else{
            saldo -= monto;
            System.out.println(getName()+" extrajo la cantidad: $"+monto+"Saldo actual: $"+saldo);
        }
        notifyAll();
    }
    
    public void run(){
        if(getName().equals("Deposito 1")|| getName().equals("Deposito 2")){
            for(int i=0;i<25;i++){
                this.depositarDinero(100);
            }
        }
        else{
            for(int i=0;i<25;i++){
                this.retirarDinero(50);
            }
        }
    }
    
}

