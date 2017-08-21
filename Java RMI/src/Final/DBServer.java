package Final;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class DBServer {
   public static void main(String[] args) {
	   
      try {
    	  GetData db = new GetDataImpl();
    	  LocateRegistry.createRegistry(2345);
          Naming.bind("rmi://localhost:2345/DB", db);    
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