package jdev.mentoria.lojavirtual;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jdev.mentoria.lojavirtual.controller.AcessoController;
import jdev.mentoria.lojavirtual.model.Acesso;
import jdev.mentoria.lojavirtual.repository.AcessoRepository;
import junit.framework.TestCase;

/*Baixamos o JUnit 3 para poder estender a classe TestCase.*/
@SpringBootTest(classes = LojaVirtualMentoriaApplication.class) /*Dizer a classe que estamos testando*/
public class LojaVirtualMentoriaApplicationTests extends TestCase{


	@Autowired
	private AcessoController acessoController;
	
	@Autowired
	private AcessoRepository acessoRepository;
	
	@Test
	public void testarCadastro() {
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("Role_Admin");
		
		assertEquals(true, acesso.getId() == null);
		/*Gravou no banco de Dados*/
		acesso = acessoController.salvarAcesso(acesso).getBody();
		assertEquals(true, acesso.getId() > 0);
		/*Validar dados da forma correta.*/
		assertEquals("Role_Admin", acesso.getDescricao());
		
		/*Teste de carregamento*/
		
		Acesso acesso2 = acessoRepository.findById(acesso.getId()).get();
		assertEquals(acesso.getId(), acesso2.getId());
		
		/*Teste de delete*/
		
		acessoRepository.deleteById(acesso2.getId());
		
		/*O flush força o envio dessas operações pendentes para o banco de dados, garantindo que o estado do banco de
		 * dados e o estado da sessão estejam sincronizados.*/
		acessoRepository.flush(); /*Roda esse Sql de delet no banco de dados.*/
		
		
	}
	
}










