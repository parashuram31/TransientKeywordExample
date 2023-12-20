package TransientKeyword;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransientKeywordExample {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos= new FileOutputStream("file.txt");
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		AccountHolder a1= new AccountHolder("Parashuram",100000,"xyz");
		oos.writeObject(a1);
		AccountHolder a2= new AccountHolder("Prajwal",200000,"abc");
		oos.writeObject(a2);
		oos.close();
		fos.close();
	
	FileInputStream fis= new  FileInputStream("file.txt");
	ObjectInputStream ois= new ObjectInputStream(fis);
	AccountHolder x= (AccountHolder)ois.readObject();
	x.show();
	ois.close();
	fis.close();
	}
}

 class AccountHolder implements Serializable{
	 private String name;
	 private double balance;
	 transient private String password;
	 
	 public AccountHolder(String n, double b, String pass) {
		 name = n;
		 balance =b;
		 password =pass;
	 }
	 public void show() {
		 System.out.println("Name="+name+"\nBal="+balance+"\nPassword="+password);
	 }
 }
