package Account;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * @author framgiavn
 */
public interface IAccount extends Remote {

    /**
     * @return
     * @throws RemoteException
     */
    public User getUser() throws RemoteException;
}
