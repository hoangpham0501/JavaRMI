package Final;

import java.awt.*;
import java.awt.event.*;
import java.rmi.*;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;

public class Client extends JFrame implements ActionListener 
{
	private static final String SERVERDB = "rmi://localhost:2345/DB";
	private static final String SERVERFILE = "rmi://localhost:3456/FILE";
	
	Vector<UserProfile> vector;
	 
	 private JTable jtable = new JTable();
	 private DefaultTableModel tableModel = new DefaultTableModel();
	
	JButton btSearch = new JButton("Search");
	JButton btSave = new JButton("Save");
	JButton btSaveAll = new JButton("Save All");
	JPanel p0 = new JPanel();
	JScrollPane p1 = new JScrollPane();
	JTextField jtfSearch = new JTextField(25);
	
	String username;
	String phonenumber;
	
	private void loadGui(){		
		setLayout(new BorderLayout());
		p0 = new JPanel(new GridLayout(1,5));
		p0.add(new JLabel("Search: "));
		p0.add(jtfSearch);
		p0.add(btSearch);
		p0.add(btSave);
		p0.add(btSaveAll);
		this.add(p0, BorderLayout.CENTER);
				
		String []colsName = {"Result"};
        tableModel.setColumnIdentifiers(colsName);  //dat tieu de cho table
        jtable.setModel(tableModel);    // ket noi jtable voi tableModel
        p1 = new JScrollPane(jtable);
        this.add(p1, BorderLayout.SOUTH);
		
		this.setVisible(true);
		this.pack();
		this.setLocation(200,150);
	}
	
	private void addEvent(){
		btSearch.addActionListener(this);
		btSave.addActionListener(this);
		btSaveAll.addActionListener(this);
	}
	
	 private Client() {
		super("Client");
		loadGui();
		addEvent();
	 }
	 
	 public static void main(String[] args) throws UnsupportedLookAndFeelException, ParseException {
		UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
		new Client();
	 }
	 
	 public void actionPerformed(ActionEvent e) {
		 if(e.getActionCommand().equals("Search")){
			 tableModel.setRowCount(0);
			 try {
					GetData gdt = (GetData) Naming.lookup(SERVERDB);
					vector = gdt.getData(jtfSearch.getText());
					String []colsName = {"Username", "Phone Number"};
			        tableModel.setColumnIdentifiers(colsName);
					for (int i = 0; i < vector.size(); i++){
					    String rows[] = new String[2];
					    rows[0] = vector.get(i).getname();
		                rows[1] = vector.get(i).getphonenumer();
		                tableModel.addRow(rows);
					}
			} 
			 catch (MalformedURLException | RemoteException | NotBoundException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(Client.this, "Khong ket noi duoc voi server", "ERROR", JOptionPane.ERROR_MESSAGE, null);
			}
		 }
		 
		 if(e.getActionCommand().equals("Save")){
			 try {
					SaveData save = (SaveData) Naming.lookup(SERVERFILE);				
			 		int row = jtable.getSelectedRow();		 		
			 		if(row != -1){
			 			String name1 = jtable.getModel().getValueAt(row,0).toString();
				 		String num1 = jtable.getModel().getValueAt(row,1).toString();
			 			UserProfile user = new UserProfile(name1, num1);
			 			save.SaveDT(user.toString());
			 			JOptionPane.showMessageDialog(Client.this, "LUU THANH CONG!", "Success!", JOptionPane.CLOSED_OPTION, null);
			 		}
			 		else{
			 			JOptionPane.showMessageDialog(Client.this, "Ban phai chon nguoi muon luu vao danh ba", "ERROR", JOptionPane.ERROR_MESSAGE, null);
			 		}
			} 
			 catch (MalformedURLException | RemoteException | NotBoundException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(Client.this, "Khong ket noi duoc voi server", "ERROR", JOptionPane.ERROR_MESSAGE, null);
			}
		 }
		 
		 if(e.getActionCommand().equals("Save All")){
			 try {
					SaveData save = (SaveData) Naming.lookup(SERVERFILE);
			 		for (int i = 0; i < vector.size(); i++){
						String name = vector.get(i).getname();
						String number = vector.get(i).getphonenumer();
						UserProfile up = new UserProfile(name,number);
						save.SaveDT(up.toString());
					}
			 		JOptionPane.showMessageDialog(Client.this, "LUU THANH CONG!", "Success!", JOptionPane.CLOSED_OPTION, null);
			} 
			 catch (MalformedURLException | RemoteException | NotBoundException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(Client.this, "Khong ket noi duoc voi server", "ERROR", JOptionPane.ERROR_MESSAGE, null);
			}
		 }
	 }
}
