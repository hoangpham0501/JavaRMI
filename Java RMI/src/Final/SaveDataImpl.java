package Final;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.*;
import java.rmi.server.*;

public class SaveDataImpl extends UnicastRemoteObject implements SaveData{
	private static final long serialVersionUID = 1L;
	 
	public SaveDataImpl() throws RemoteException {
	    }
	 
	 public void SaveDT(String data) throws RemoteException {
		 File file = new File("./contacts.txt");
			FileWriter fileWriter;
			try {
			    fileWriter = new FileWriter(file,true);
			    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			    PrintWriter printWriter = new PrintWriter(bufferedWriter);
			    printWriter.println(data);
			    printWriter.flush();
			    printWriter.close();
			    bufferedWriter.close();
			    fileWriter.close();
			} 
			catch (IOException e) {
			    e.printStackTrace();
			}
  }
	 
}

