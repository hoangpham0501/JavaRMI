package Calculator;

import java.rmi.*;
public interface Calculator extends Remote{
   public int addNum(int x,int y) throws RemoteException ;
}