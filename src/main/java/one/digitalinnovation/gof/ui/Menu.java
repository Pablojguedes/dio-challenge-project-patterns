package one.digitalinnovation.gof.ui;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<String> operations = new ArrayList<>();

    public Menu(String[] operations) {
        for(String operation : operations)
            this.operations.add(operation);
    }

    public void addOperation(String operation){
        operations.add(operation);
    }

    public void removeOperation(String operation){
        operations.remove(operation);
    }

    public void printMenu(){
        for(String operation: operations)
            System.out.printf("%s%d%s%s%n",
                "[",
                operations.indexOf(operation) + 1,
                "] - ",
                operation);
    }
}

