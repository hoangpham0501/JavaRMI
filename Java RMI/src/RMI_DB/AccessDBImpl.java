package RMI_DB;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.rowset.*;
import com.sun.rowset.*;

public class AccessDBImpl extends UnicastRemoteObject implements AccessDBInterface {

	private Connection con;
	private Statement stmt;

public AccessDBImpl() throws RemoteException
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MiniChat", "root","123456");
		stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			}
	}

public WebRowSet GetTable(String tableName) throws RemoteException {
	WebRowSet rs = null;
	try {
		String sql = "select * from user";
		ResultSet r = stmt.executeQuery(sql);
		//rs = new WebRowSetImpl();
		rs.populate(r);
		} catch (Exception e) {
			e.printStackTrace();
			}
	return rs;
	}

public int ExecUpdateSQL(String sql) throws RemoteException {
	return 0;
	}
}