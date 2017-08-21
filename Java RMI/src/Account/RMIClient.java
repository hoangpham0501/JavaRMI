package Account;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


/**
 * 
 * @author framgiavn
 *
 */
public class RMIClient {
    public static void main(String args[]) {
        try {
            //Xac ðinh RMI may chu.
            IAccount iAccount = (IAccount) Naming.lookup("rmi://localhost:6789/SeptemberRMI");
            System.out.println("Name: " + iAccount.getUser().getUname());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

