package com.example.desafiobc.desafiobc.sevives;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.desafiobc.desafiobc.dto.ClientDTO;
import com.example.desafiobc.desafiobc.entities.Client;
import com.example.desafiobc.desafiobc.repositories.ClientRepository;
import com.example.desafiobc.desafiobc.sevives.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	
	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(Pageable pageable) {
		Page<Client> list = repository.findAll(pageable);
		return list.map(x-> new ClientDTO(x));		
	}
	
	
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id){		
		Client entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resourse not found"));			
		return new ClientDTO(entity);	
			
						
		}
		


	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}


	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {	
		try {
			Client entity = repository.getReferenceById(id);		
			copyDtoToEntity(dto, entity);		
			entity = repository.save(entity);
			return new ClientDTO(entity);		
						
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Resource not found");
			
		}
		
	}
	
	
	@Transactional
	public void delete(Long id) {
		try {
			
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Resource not found");
			
		}		
		 
	}



	private void copyDtoToEntity(ClientDTO dto, Client entity) {		
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		
	}

}
