package one.digitalinnovation.gof.ui;

import java.util.Scanner;

public class UserInterface {

    public String[] MAIN_MENU_OPERATIONS = {"Create Account", "Bank Services", "Info", "Leave"};
    public String[] BANK_SERVICES_MENU_OPERATIONS = {"Withdraw", "Deposit", "Extract"};

    public void execute(Scanner input){
        System.out.println("Hello! You are talking with me, BankBot! How can i help you?");
        Menu mainMenu = new Menu(MAIN_MENU_OPERATIONS);
        mainMenu.printMenu();
        Menu servicesMenu = new Menu(BANK_SERVICES_MENU_OPERATIONS);
        OperationManager operationManager = new OperationManager(input);

        int response = input.nextInt();
        input.nextLine();
        while(response != 4) {
            switch (response) {
                case 1:
                    operationManager.createAccount();
                    operationManager.printSuccessfullMessage();
                    break;
                case 2:
                    servicesMenu.printMenu();
                    operationManager.executeBankServices();
                    break;
                default:
                    operationManager.printBankInfo();
                    break;
            }
            System.out.println();
            mainMenu.printMenu();
            response = input.nextInt();
        }
        System.out.println("Thanks for using our services!");
    }
}
