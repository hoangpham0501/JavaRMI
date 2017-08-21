import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client1 {
    private static Receive receiveOfClient2;

    private static final String ADDRESS_CLIENT2 = "rmi://localhost:5678/Client2";

    private Client1() {
	/*
	 * Utility classes, which are a collection of static members, are not
	 * meant to be instantiated.
	 * 
	 * Even abstract utility classes, which can be extended, should not have
	 * public constructors.
	 * 
	 * Java adds an implicit public constructor to every class which does
	 * not define at least one explicitly.
	 * 
	 * Hence, at least one non-public constructor should be defined.
	 * 
	 */
    }

    public static void main(String[] args)
	    throws RemoteException, MalformedURLException, NotBoundException, InterruptedException {

	// bind client1 to register
	Registry re = LocateRegistry.createRegistry(1234);
	ReceiveImpl impl = new ReceiveImpl();
	re.rebind("Client1", impl);
	System.out.println("Client1 is started!!");

	boolean check = false;
	System.out.println("looking up Client2...");
	while (!check) {
	    try {
		receiveOfClient2 = (Receive) Naming.lookup(ADDRESS_CLIENT2);

	    } catch (RemoteException e) {
		// Do nothing
	    }
	    if (receiveOfClient2 != null)
		check = true;
	}

	System.out.println("detected Client1!!");
	System.out.println("let's chat!");
	// chat
	new Thread(() -> {
	    while (true) {
		try {
		    String message = new Scanner(System.in).nextLine();
		    receiveOfClient2.receive("Client1", message);
		    
		} catch (RemoteException e) {
		    e.printStackTrace();
		}
	    }
	}).start();

    }

}
