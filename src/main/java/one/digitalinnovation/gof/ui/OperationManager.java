package one.digitalinnovation.gof.ui;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import one.digitalinnovation.gof.model.Account;
import one.digitalinnovation.gof.model.CheckingAccount;
import one.digitalinnovation.gof.model.Client;
import one.digitalinnovation.gof.model.SavingsAccount;
import one.digitalinnovation.gof.service.ClientService;

public class OperationManager {

	@Autowired
	private ClientService clientService;
    private String[] ACCOUNT_KINDS = {"Savings Account", "Checking Account"};
    Scanner input;
    private Client client;
    private Account account;

    public OperationManager(Scanner input) {
        this.input = input;
    }

    public void createAccount(){
        createClient(input);
        System.out.println("What kind of account do you want to create?");
        for(int i = 0; i < ACCOUNT_KINDS.length; i++)
            System.out.println("[" + (i + 1) + "] - " + ACCOUNT_KINDS[i]);
        int accountType = input.nextInt();

        if(accountType == 1)
            account = new SavingsAccount(client);
        else
            account = new CheckingAccount(client);
    }

    private void createClient(Scanner input){
        System.out.print("Please enter your full name: ");
        String name = input.next();
        System.out.print("Please enter your CPF: ");
        String CPF = input.next();
        System.out.print("Please enter your phone number: ");
        String phoneNumber = input.next();
        Client newClient = new Client(null, name, CPF, phoneNumber);
        List<Client> clients = (List<Client>) clientService.findAll();
        for(Client client : clients)
	        if(client.getCpf().equals(newClient.getCpf()));
	        	this.client = clientService.findById(client.getId());
	    if(this.client.equals(null))
	    	this.client = newClient;
    }

    public void printSuccessfullMessage(){
        System.out.printf("%s%s%s",
    		"Account successfully created, ",
    		client.getName(),
    		"!");
    }
    public void executeBankServices(){
        int serviceID = input.nextInt();
        System.out.println("How much?");
        double amount = input.nextDouble();
        try {
            switch (serviceID) {
                case 1:
                    account.withdraw(amount);
                    account.printExtract();
                    break;
                case 2:
                    account.deposit(amount);
                    account.printExtract();
                    break;
                default:
                    account.printExtract();
            }
        }
        catch(NullPointerException e){
            System.out.println("Account needed to be created first!");
        }
    }

    public void printBankInfo(){
        System.out.println("Marauder's Bank, founded in 1999 by Fred and Jorge Weasley");
    }
}

