package Account;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


/**
 * @author framgiavn
 */
public class RMIServer {
    public static void main(String args[]) {

        try {
            IAccount rAccount = new AccountServiceImpl();

            LocateRegistry.createRegistry(6789);

            // Ðang ky ðoi tuong nay voi rmiregistry
            Naming.bind("rmi://localhost:6789/SeptemberRMI", rAccount);

            System.out.println(">>>>>INFO: RMI Server started!!!!!!!!");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

