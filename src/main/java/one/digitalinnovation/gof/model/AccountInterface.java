package one.digitalinnovation.gof.model;

public interface AccountInterface {
	
	void withdraw(double value);
	
	void deposit(double value);
	
	void transfer(double value, AccountInterface destinationAccount);
	
	void printExtract();
}
