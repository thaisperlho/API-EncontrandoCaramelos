package br.edu.fatec.projetoec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatec.projetoec.model.Ong;
import br.edu.fatec.projetoec.service.OngService;

@RestController
@RequestMapping("/ongs")
public class OngController {
	
	@Autowired
	private OngService ongService;
	
	
@GetMapping	
public ResponseEntity<List<Ong>> findALL(){
	
	List<Ong> list = ongService.findALL();
	return ResponseEntity.ok(list);
}

@GetMapping("/{id}")
public ResponseEntity<Ong> find(@PathVariable(name = "id") Integer id){
	Optional<Ong> ong = this.ongService.findById(id);
	if (ong.isPresent()) {
		return ResponseEntity.ok(ong.get());
	} else {
		return ResponseEntity.notFound().build();		}
}

}
