package jdev.mentoria.lojavirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
	
	@ResponseBody 
	@PostMapping(value = "/deleteAcesso")/*Mapeamento da URL para receber JSON.*/
	public ResponseEntity<?> deleteAcesso(@RequestBody Acesso acesso) {

		acessoRepository.deleteById(acesso.getId());
		
		return new ResponseEntity("Acesso removido.",HttpStatus.OK);
	}
	
}