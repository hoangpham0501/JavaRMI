package RMI_DB;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.rowset.WebRowSet;

public class AccessDBServer {
	public static void main(String []args){
		try {
			java.rmi.registry.LocateRegistry.createRegistry(7000);
			AccessDBInterface acc=null;
			acc=new AccessDBImpl();
			Context ctx =new InitialContext();
			ctx.bind("rmi:acc", acc);
			System.out.println("Server is running..");
			/*try {
			 * AccessDBImpl db=new AccessDBImpl();
			 * WebRowSet rs=db.GetTable(“DimCurrency”);
			 * while(rs.next())
			 * {
			 * System.out.println(rs.getString(1));
			 * }
			 * }
			 * catch (Exception ex) {
			 * ex.printStackTrace();
			 * }*/
			} catch (Exception e) {
				e.printStackTrace();
				}
		}
}
