package one.digitalinnovation.gof.security;

import one.digitalinnovation.gof.exceptions.InvalidOperationException;
import one.digitalinnovation.gof.model.Account;

public class OperationValidator {

	OperationValidator operationValidator;
	
	private OperationValidator() {
		operationValidator = new OperationValidator();
	}
	
    public void validateOperation(double value, Account sourceAccount)
        throws InvalidOperationException{
            if(value > sourceAccount.getAmount())
                throw new InvalidOperationException("Insufficient funds! Operation can't be done.");
    }
}
