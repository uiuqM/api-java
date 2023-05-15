package com.projectcourse.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projectcourse.project.entities.OrderItem;
import com.projectcourse.project.repositories.OrderItemRepository;
import com.projectcourse.project.services.exceptions.DatabaseException;
import com.projectcourse.project.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderItemService {
    @Autowired
	private OrderItemRepository repository;
	
	public List<OrderItem> findAll(){
		return repository.findAll();
	}

	public OrderItem findById(Long id) {
		Optional<OrderItem> obj = repository.findById(id);
		return obj.get();
	}

	public OrderItem insert(OrderItem obj){
		return repository.save(obj);
	}

	public void delete(Long id){
		try{
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e){
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e){
			throw new DatabaseException(e.getMessage());
		}
	}

	public OrderItem update(Long id, OrderItem obj){
		try{
			OrderItem entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e){
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(OrderItem entity, OrderItem obj){
		entity.setProduct(obj.getProduct());
        entity.setQuantity(obj.getQuantity());
	}
}
