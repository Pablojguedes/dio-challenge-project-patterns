package one.digitalinnovation.gof.model;

import java.util.List;

import javax.persistence.OneToMany;

public class Bank {
    private String name;
    @OneToMany
    private List<Account> accounts;

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account accountToAdd){
        accounts.add(accountToAdd);
    }

    public void removeAccountById(int id){
        for(Account account : accounts)
        	if(id == account.getNumber())
        		accounts.remove(account);
    }
}