package Final;

import java.rmi.*;
import java.util.Vector;
public interface SaveData extends Remote{
	public void SaveDT(String data) throws RemoteException ;
}
