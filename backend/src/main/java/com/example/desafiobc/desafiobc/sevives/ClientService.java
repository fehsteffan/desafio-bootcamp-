package com.example.desafiobc.desafiobc.sevives;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.desafiobc.desafiobc.dto.ClientDTO;
import com.example.desafiobc.desafiobc.entities.Client;
import com.example.desafiobc.desafiobc.repositories.ClientRepository;

@Service
public class ClientService {
	
	
	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable) {
		Page<Client> list = repository.findAll(pageable);
		return list.map(x-> new ClientDTO(x));		
	}
	
	
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id){
		Client client = repository.findById(id).get();		
		return new ClientDTO(client);		
	}


	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}
	

}
