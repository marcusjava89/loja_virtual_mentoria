package jdev.mentoria.lojavirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jdev.mentoria.lojavirtual.model.Acesso;
import jdev.mentoria.lojavirtual.repository.AcessoRepository;
import jdev.mentoria.lojavirtual.service.AcessoService;

@Controller/*Anotação para a classe controlador do Spring MVC.*/
@RestController	
public class AcessoController {
	
	@Autowired
	private AcessoService acessoService; 
	
	@Autowired
	private AcessoRepository acessoRepository;
	
	@ResponseBody /*Poder dar um retorno da API.*/
	@PostMapping(value = "/salvarAcesso")/*Mapeamento da URL para receber JSON.*/
	/*Sem @RequestBody os dados iriam nulos.*/
	public ResponseEntity<Acesso> salvarAcesso(@RequestBody Acesso acesso) {

		Acesso acessoSalvo = acessoService.save(acesso);
		
		return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
	}
	
	/*Receber dados enviados por um formulário ou via JSON. POr isso não é @DeleteMApping.*/
	@ResponseBody 
	@PostMapping(value = "/deleteAcesso")/*Mapeamento da URL para receber JSON.*/
	public ResponseEntity<?> deleteAcesso(@RequestBody Acesso acesso) {

		acessoRepository.deleteById(acesso.getId());
		
		return new ResponseEntity("Acesso removido.",HttpStatus.OK);
	}
	
	@ResponseBody 
	@DeleteMapping(value = "/deleteAcessoPorId/{id}") 
	public ResponseEntity<?> deleteAcessoPorId(@PathVariable("id") Long id) {
		/*Método que deleta pelo id*/
		acessoRepository.deleteById(id);
		
		return new ResponseEntity("Acesso removido por id.", HttpStatus.OK);
	}
	
	@ResponseBody 
	@GetMapping(value = "/obterAcesso/{id}") 
	public ResponseEntity<?> obterAcesso(@PathVariable("id") Long id) {
		/*Método que deleta pelo id*/
		Acesso acesso = acessoRepository.findById(id).get();
		
		return new ResponseEntity<Acesso>(acesso, HttpStatus.OK);
	}
	
}




