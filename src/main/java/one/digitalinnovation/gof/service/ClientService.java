package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Client;

public interface ClientService {

	Iterable<Client> findAll();

	Client findById(Long id);

	void save(Client client);

	void update(Long id, Client client);

	void delete(Long id);

}