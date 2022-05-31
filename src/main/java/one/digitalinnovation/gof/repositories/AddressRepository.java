package one.digitalinnovation.gof.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import one.digitalinnovation.gof.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

}