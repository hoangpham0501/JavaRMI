import java.rmi.Remote;
import java.rmi.RemoteException;

@FunctionalInterface
public interface Receive extends Remote {
    public void receive(String name,String message) throws RemoteException;
}
