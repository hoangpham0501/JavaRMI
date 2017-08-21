package Calculator;

import java.util.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
	
	private static Registry registry;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Finding ...");
			Calculator c= (Calculator)Naming.lookup("rmi://localhost:2345/MyCalculator");
			Scanner nhapvao = new Scanner(System.in);
			System.out.print("a= ");
			int a = nhapvao.nextInt();
			System.out.print("b= ");
			int b = nhapvao.nextInt();
			System.out.println("Ket qua: " + c.addNum(a, b));
		}
		catch (Exception e) {
			System.out.println("Loi "+ e);
		}
	}
}
