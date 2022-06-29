package atm;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

class Oyasis  {
	Scanner sc = new Scanner(System.in);
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now();  
	long x ;
	int y,s;
	long bal = 1000000;
	
    List<String> his = new ArrayList<>();
	Oyasis() {
		System.out.println("Enter your id");
		x = sc.nextLong();
		System.out.println("Enter your pin");
		y = sc.nextInt();
		System.out.println("Successfully loged-in with id "+ x );
		System.out.println();
		choice();
		}
	
	  public void choice() {
		  System.out.println("1.Transactions History\n"
					+ "\n"
					+ "2.Withdraw\n"
					+ "\n"
					+ "3.Deposit\n"
					+ "\n"
					+ "4.Transfer\n"
					+ "\n"
					+ "5.Quit");
			System.out.println("enter your choice");
			s = sc.nextInt();
			 
			if(s == 1) {
				history();
			} else if(s == 2) {
				withdraw();
			} else if(s == 3) {
				deposit();
			} else if(s == 4) {
				transfer();
			} else if(s == 5) {
				exit();
			} else {
				System.out.println("enter appropriate choice");
			}
				
			
		  		
	  }
		public void history() {
			int i;
			for(i = 0; i < his.size(); i++) {
				System.out.println(his.get(i));
			System.out.println("");
			}
			choice();
		}
		public void withdraw() {
			long w;
			System.out.println("Enter the amount to withdraw");
			w = sc.nextLong();
			if(w > bal) {
				System.out.println("no sufficient balance");
				his.add("no sufficient balance on" + dtf.format(now));
			} else {
				bal = bal - w;
				System.out.println("amount withdrawn successfully remaining balance " + bal +" on " + dtf.format(now));
				his.add("withdrawn " + w + " on " + dtf.format(now));
			}
			choice();
		}
		public void deposit() {
			long d;
			System.out.println("Enter amount to deposit");
			d = sc.nextLong();
			bal = bal + d;
			System.out.println("successfully deposited " + d + " on " + dtf.format(now) + " updated balance " + bal);
			his.add("credited " + bal + " on " + dtf.format(now));
			choice();
		}
		public void transfer() {
			long id , a ;
			System.out.println("Enter the id of account to transfer");
			id = sc.nextLong();
			System.out.println("Enter amount to transfer");
			a = sc.nextLong();
			bal = bal - a;
			System.out.println("deposited " + a + " from account " + x + " on " + dtf.format(now) + " current balance " + bal);
			his.add("transfered " + a + " to " + id + " on " + dtf.format(now));
			choice();
		}
	 public void exit() {
		 int e ;
		 System.out.println("successfully logged out with id " + x);
		 System.out.println("enter 1 for accessing again");
		 e = sc.nextInt();
		 if(e == 1) {
			 choice();
		 } 
	 }
}
public class ATM {
	public static void main(String...args) {
    Oyasis o = new Oyasis();
	}
}
