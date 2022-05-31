package one.digitalinnovation.gof.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import one.digitalinnovation.gof.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}