import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client2 {
    private static Receive receiveOfClient1;
    private static final String ADDRESS_CLIENT1 = "rmi://localhost:1234/Client1";

    private Client2() {
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
	// bind client2 to register
	Registry re = LocateRegistry.createRegistry(5678);
	ReceiveImpl impl = new ReceiveImpl();
	re.rebind("Client2", impl);

	System.out.println("Client2 is started!!");

	boolean check = false;

	System.out.println("looking up client1...");

	while (!check) {
	    try {
		receiveOfClient1 = (Receive) Naming.lookup(ADDRESS_CLIENT1);

	    } catch (RemoteException e) {
		// do nothing
	    }
	    if (receiveOfClient1 != null) {
		check = true;
	    }
	}

	System.out.println("detected Client1 !!");
	System.out.println("let's chat!");

	new Thread(() -> {
	    while (true) {
		try {
		    String message = new Scanner(System.in).nextLine();
		    receiveOfClient1.receive("Client2", message);

		} catch (RemoteException e) {
		    e.printStackTrace();
		}
	    }
	}).start();

    }
}
