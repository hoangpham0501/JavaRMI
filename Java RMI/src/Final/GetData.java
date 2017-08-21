package Final;

import java.rmi.*;
import java.util.Vector;
public interface GetData extends Remote{
	public Vector<UserProfile> getData(String name) throws RemoteException ;
}
