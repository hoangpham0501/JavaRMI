package Final;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class FileServer {
   public static void main(String[] args) {
	   
      try {
    	  SaveData save = new SaveDataImpl();
    	  LocateRegistry.createRegistry(3456);
          Naming.bind("rmi://localhost:3456/FILE", save);    
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