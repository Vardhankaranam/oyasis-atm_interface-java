package atm;

public class Back {
    long balance ;
    public void status(long bal) {
		 balance = bal;
	 }
    public long cur() {
    	return balance;
    }
}
