package one.digitalinnovation.gof.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import one.digitalinnovation.gof.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

}