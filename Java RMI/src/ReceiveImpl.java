import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class ReceiveImpl extends UnicastRemoteObject implements Receive {
    protected ReceiveImpl() throws RemoteException {
    	super();
    }

    @Override
    public void receive(String name, String message) throws RemoteException {
    	System.out.println(name + " : " + message);
    }

}
