package br.edu.fatec.projetoec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fatec.projetoec.model.OngTest;
import br.edu.fatec.projetoec.repository.OngTestRepository;

@Service
public class OngTestService {
	
	private final OngTestRepository ongRepository;
	
	public OngTestService(OngTestRepository ongRepository) {
		this.ongRepository = ongRepository;
	}
	
	public OngTest save(OngTest ong) {
		return this.ongRepository.save(ong);
	}
	
	public List<OngTest> findALL(){
		return this.ongRepository.findAll();
	}

	public Optional<OngTest> findById(Integer id) {
		return this.ongRepository.findById(id);
	}

	public void delete(Integer id) {
		ongRepository.deleteById(id);
	}

}
