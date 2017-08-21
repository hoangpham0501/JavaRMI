package Calculator;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
   public static void main(String[] args) {
	   
      try {
    	  Calculator c = new CalculatorImpl();
    	  LocateRegistry.createRegistry(2345);
          Naming.bind("rmi://localhost:2345/MyCalculator", c);    
          System.out.println("Register...!!!");  
      }
      catch (RemoteException e) {
          e.printStackTrace();
      } catch (AlreadyBoundException e) {
          e.printStackTrace();
      } catch (MalformedURLException e) {
          e.printStackTrace();
      }
   }
}