package jdev.mentoria.lojavirtual;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jdev.mentoria.lojavirtual.controller.AcessoController;
import jdev.mentoria.lojavirtual.model.Acesso;
import jdev.mentoria.lojavirtual.service.AcessoService;

@SpringBootTest(classes = LojaVirtualMentoriaApplication.class) /*Dizer a classe que estamos testando*/
public class LojaVirtualMentoriaApplicationTests {

	@Autowired
	private AcessoService acessoService;

	//@Autowired
	//private AcessoRepository acessoRepository;
	
	@Autowired
	private AcessoController acessoController;
	
	@Test
	public void testCadastraAcesso() { 
		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_ADMIN5");
		acessoController.salvarAcesso(acesso);
	}
}
