package br.edu.fatec.projetoec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatec.projetoec.model.Adotante;
import br.edu.fatec.projetoec.service.AdotanteService;

@RestController
@RequestMapping("/adotantes")
public class AdotanteController {
	
		@Autowired
		private AdotanteService adotanteService;
		
	@GetMapping	
	public ResponseEntity<List<Adotante>> findALL(){
		
		List<Adotante> list = adotanteService.findALL();
		return ResponseEntity.ok(list);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Adotante> find(@PathVariable(name = "id") Integer id){
		Optional<Adotante> ong = this.adotanteService.findById(id);
		if (ong.isPresent()) {
			return ResponseEntity.ok(ong.get());
		} else {
			return ResponseEntity.notFound().build();		}
	}

}
