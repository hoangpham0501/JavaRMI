package Calculator;

import java.rmi.*;
import java.rmi.server.*;
public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
	 private static final long serialVersionUID = 1L;
	 public CalculatorImpl() throws RemoteException {
	    }
	 public int addNum(int x,int y) throws RemoteException {
      System.out.println("Client request to Calculator!!");
      return (x+y);
   }
}