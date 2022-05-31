package one.digitalinnovation.gof.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import one.digitalinnovation.gof.exceptions.InvalidOperationException;
import one.digitalinnovation.gof.security.OperationValidator;

public abstract class Account implements AccountInterface {
	
	
	private static final int DEFAULT_AGENCY = 1;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	protected int agency;
	protected int number;
	protected double amount;
	protected Client client;
	@Autowired
	private OperationValidator operationValidator;
	
	
	public Account(Client client) {
		this.agency = Account.DEFAULT_AGENCY;
		this.client = client;
	}

	public int getAgency() {
		return agency;
	}

	public int getNumber() {
		return number;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public void withdraw(double value) {
		try {
			operationValidator.validateOperation(value, this);
			amount -= value;
		}
		catch(InvalidOperationException e){
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void deposit(double value) {
		amount += value;
	}

	@Override
	public void transfer(double value, AccountInterface destinationAccount) {
		this.withdraw(value);
		destinationAccount.deposit(value);
	}

	protected void printInfo() {
		System.out.printf("%s%s%n%s%d%n%s%d%n%s%.2f%n%n",
			"Client: ", this.client.getName(),
			"Agency: ", this.getAgency(),
			"Number: ", this.number,
			"Amount: ", this.amount);
	}
}
