package br.edu.fatec.projetoec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatec.projetoec.model.Pet;
import br.edu.fatec.projetoec.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {
	
	@Autowired
	private PetService petService;
	
@GetMapping	
public ResponseEntity<List<Pet>> findALL(){
	
	List<Pet> list = petService.findALL();
	return ResponseEntity.ok(list);
}
	
@GetMapping("/{id}")
public ResponseEntity<Pet> find(@PathVariable(name = "id") Integer id){
	Optional<Pet> ong = this.petService.findById(id);
	if (ong.isPresent()) {
		return ResponseEntity.ok(ong.get());
	} else {
		return ResponseEntity.notFound().build();		}
}

}
