package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Client;
import one.digitalinnovation.gof.model.ClientRepository;
import one.digitalinnovation.gof.model.Address;
import one.digitalinnovation.gof.model.AddressRepository;
import one.digitalinnovation.gof.service.ClientService;
import one.digitalinnovation.gof.service.ViaCepService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ViaCepService viaCepService;

	@Override
	public Iterable<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client findById(Long id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.get();
	}

	@Override
	public void save(Client client) {
		saveClientWithCep(client);
	}

	@Override
	public void update(Long id, Client client) {
		Optional<Client> clientBd = clientRepository.findById(id);
		if (clientBd.isPresent()) {
			saveClientWithCep(client);
		}
	}

	@Override
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
	
	private void saveClientWithCep(Client client) {
		String cep = client.getAddress().getCep();
		Address endereco = addressRepository.findById(cep).orElseGet(() -> {
			Address newAddress = viaCepService.consultarCep(cep);
			addressRepository.save(newAddress);
			return newAddress;
		});
		client.setAddress(endereco);
		clientRepository.save(client);
	}

}