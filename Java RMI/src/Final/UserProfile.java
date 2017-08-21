package Final;

import java.io.Serializable;

public class UserProfile implements Serializable
{
	String name;
	String phonenumber;
	
	public String getname() {
		return name;
	}

	public void setname(String username) {
		this.name = username;
	}

	public String getphonenumer() {
		return phonenumber;
	}

	public void setphonenumber(String num) {
		this.phonenumber = num;
	}
	
	public UserProfile(){
		
	}
	
	public UserProfile(String n, String num){
		name = n;
		phonenumber = num;
	}
	
	 public String toString() {
			return name +" "+phonenumber;
	}

}
