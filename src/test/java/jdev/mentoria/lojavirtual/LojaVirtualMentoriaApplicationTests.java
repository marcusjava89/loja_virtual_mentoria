package jdev.mentoria.lojavirtual;

import java.util.List;

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
		/*Gravou no banco de Dados. O getBody() é usado para extrair o conteúdo (corpo) da resposta (ResponseEntity)*/
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
		acessoRepository.flush(); /*Roda esse SQL de delete no banco de dados.*/
		
		/*findById tenta encontrar objeto que foi apagado do banco, para não daa excessão temos o orElse, se tiver o 
		 *obejto acesso2, retorna ele,  se não retorna null*/
		Acesso acesso3 = acessoRepository.findById(acesso2.getId()).orElse(null);
		
		assertEquals(true, acesso3 == null);
		
		/*Teste de query.*/
		
		acesso = new Acesso();
		acesso.setDescricao("ROLE_ALUNO");
		acesso = acessoController.salvarAcesso(acesso).getBody();
		
		List<Acesso> acessos = acessoRepository.buscarAcessoDesc("ALUNO".trim().toUpperCase());
		
		assertEquals(1, acessos.size());
		
		acessoRepository.deleteById(acesso.getId());
		
	}
	
}










