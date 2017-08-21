package RMI_DB;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.sql.rowset.WebRowSet;

public interface AccessDBInterface extends Remote{
	public WebRowSet GetTable(String tableName) throws RemoteException;
	public int ExecUpdateSQL(String sql)throws RemoteException;
}