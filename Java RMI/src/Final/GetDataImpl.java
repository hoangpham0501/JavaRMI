package Final;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


public class GetDataImpl extends UnicastRemoteObject implements GetData{
	private static final long serialVersionUID = 1L;
	 
	public GetDataImpl() throws RemoteException {
	    }
	 
	 public Vector<UserProfile> getData(String name) throws RemoteException {
		 Connection conn;
		 Vector<UserProfile> vector = new Vector<>();
		 try{
 			//Nap driver
 			Class.forName("com.mysql.jdbc.Driver");
 			//Ket noi csdl
 			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MiniChat", "root","123456");
 			//Tao doi tuong DatabaseMetaData de lay thong tin cua csdl
 			Statement stm = conn.createStatement();
 			ResultSet rst = stm.executeQuery("Select * from danhba WHERE name LIKE \'%"+name+"%\'");
 			while(rst.next()){
 				UserProfile user = new UserProfile();
 				user.setname(rst.getString("name"));
 				user.setphonenumber(rst.getString("phonenumber"));
 				vector.add(user);
 			}
		 }
 		catch(Exception e){
 			System.out.println(e);
 		}
		 return vector;
  }
	 
}
