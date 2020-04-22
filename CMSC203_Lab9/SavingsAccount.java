
public class SavingsAccount extends BankAccount {
	private double rate = 2.5;
	private int savingsNumber = 0;
	private String accountNumber = "";
	
	public SavingsAccount(String name, double amount) {
		super(name, amount);
		//System.out.println(name+": "+super.getAccountNumber());
		accountNumber = super.getAccountNumber()+"-"+savingsNumber;
	}
	
	public SavingsAccount(SavingsAccount oldAccount, double amount) {
		super((BankAccount)oldAccount, amount);
		savingsNumber = oldAccount.getSavingsNumber()+1;
		accountNumber = super.getAccountNumber()+"-"+savingsNumber;
	}
	
	public void postInterest() {
		System.out.println(rate/100);
		this.deposit(this.getBalance()*((rate/100)/12));
	}
	
	@Override
	public String getAccountNumber() {
		return this.accountNumber;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getSavingsNumber() {
		return savingsNumber;
	}
}
