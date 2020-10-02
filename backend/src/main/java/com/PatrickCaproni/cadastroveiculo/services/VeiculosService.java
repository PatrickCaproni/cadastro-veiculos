package com.PatrickCaproni.cadastroveiculo.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PatrickCaproni.cadastroveiculo.dto.VeiculosDTO;
import com.PatrickCaproni.cadastroveiculo.entities.Veiculos;
import com.PatrickCaproni.cadastroveiculo.repositories.VeiculosRepository;
import com.PatrickCaproni.cadastroveiculo.services.exceptions.DatabaseException;
import com.PatrickCaproni.cadastroveiculo.services.exceptions.ResourceNotFoundException;

@Service
public class VeiculosService {
	
	@Autowired
	public VeiculosRepository repository;

	@Transactional(readOnly = true)
	public Page<VeiculosDTO> findAllPaged(PageRequest pageRequest) {
		Page<Veiculos> list = repository.findAll(pageRequest);
		return list.map(x -> new VeiculosDTO(x));
	}

	@Transactional(readOnly = true)
	public VeiculosDTO findById(Long id) {
		Optional<Veiculos> obj = repository.findById(id);
		Veiculos entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new VeiculosDTO(entity);
	}

	@Transactional
	public VeiculosDTO insert(VeiculosDTO dto) {
		Veiculos entity = new Veiculos();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new VeiculosDTO(entity);
	}

	@Transactional
	public VeiculosDTO update(Long id, VeiculosDTO dto) {
		try {
			Veiculos entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new VeiculosDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	private void copyDtoToEntity(VeiculosDTO dto, Veiculos entity) {

		entity.setVeiculo(dto.getVeiculo());
		entity.setMarca(dto.getMarca());
		entity.setAno(dto.getAno());
		entity.setDescricao(dto.getDescricao());
		entity.setVendido(dto.getVendido());
	}

}
