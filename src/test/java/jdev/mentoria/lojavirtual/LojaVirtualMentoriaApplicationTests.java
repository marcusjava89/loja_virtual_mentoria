package jdev.mentoria.lojavirtual;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	/*Objeto do Spring que pega as informações da aplicação que está rodando. Necessário para contrução do objeto
	 *MockMvc, objeto que trabalha com serialização.*/
	@Autowired
	private WebApplicationContext wac;
	
	@Test
	public void testRestApiCadastroAcesso() throws JsonProcessingException, Exception {
		/*DefaultMockMvcBuilder é usada para configurar e construir uma instância de MockMvc.*/
		/*MockMvcRequestBuilders é uma classe utilitária que fornece métodos para criar requisições HTTP simuladas
		 *(como post(), get(), put(), etc.).*/
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		/*MockMvc é uma ferramenta poderosa para testar controladores (controllers) em aplicações Spring MVC de forma
		 *isolada, sem a necessidade de implantar a aplicação em um servidor real. */
		MockMvc mockMvc = builder.build();
		
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("ROLE_COMPRADOR9");
		
		/*ObjectMapper da biblioteca Jackson. Faz a serialização e a desserialização de uma string json para objetos,
		 *coleções, listas java e vice-versa.*/
		ObjectMapper objectMapper = new ObjectMapper();
		
		/*é usada para realizar ações e verificações (assertions) após simular uma requisição HTTP com o MockMvc*/
		 /*objectMapper.writeValueAsString(acesso) serializa acesso em uma string json.*/
		/*perform() é usado para simular uma requisição HTTP (GET, POST, PUT, DELETE, etc.). Não precisamos salvar o
		 *acesso com acessoRespository.save(acesso), porque o perform salva.*/
		/*O método .content() é usado para definir o corpo (body) da requisição HTTP.*/
		/*objectMapper.writeValueAsString(acesso) converte um objeto Java (acesso) em uma string JSON.*/
		/*.accept() define o tipo de mídia (media type) que o cliente (aqui, o teste) espera receber como resposta.*/
		/*MediaType.APPLICATION_JSON indica que o cliente espera uma resposta no formato JSON.*/
		/*perform() retorna um objeto do tipo ResultActions, que permite realizar verificações (assertions) na 
		 *resposta da requisição.*/
		/*retornoApi armazena o resultado da requisição.*/
		ResultActions retornoApi = mockMvc.perform(MockMvcRequestBuilders.post("/salvarAcesso")
									.content(objectMapper.writeValueAsString(acesso))
									.accept(MediaType.APPLICATION_JSON)
									.contentType(MediaType.APPLICATION_JSON)); 
		/*Ele é retornado pelo método perform() do MockMvc*/
		
		/*andReturn Retorna o MvcResult, que contém detalhes completos sobre o resultado da requisição simulada.*/
		System.out.println("Retorno da API" + retornoApi.andReturn().getResponse().getContentAsString());
		
		/*Desserializa a string json em objeto java, nesse caso objeto Acesso. O objeto de retorno não foi completo
		 *antes de @JsonIgnore, porque ele procura setAuthoroty.*/
		Acesso objetoRetorno = objectMapper.readValue(retornoApi.andReturn().getResponse().getContentAsString(),
								Acesso.class);
		 
		assertEquals(acesso.getDescricao(), objetoRetorno.getDescricao());	
		
	}
	
	@Test
	public void testRestApiDeleteAcesso() throws JsonProcessingException, Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("ROLE_TESTE_DELETE");

		acessoRepository.save(acesso);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi = mockMvc.perform(MockMvcRequestBuilders.post("/deleteAcesso")
									.content(objectMapper.writeValueAsString(acesso))
									.accept(MediaType.APPLICATION_JSON)
									.contentType(MediaType.APPLICATION_JSON)); 
		System.out.println("Retorno da API: " + retornoApi.andReturn().getResponse().getContentAsString());	
		System.out.println("Retorno do status: "+retornoApi.andReturn().getResponse().getStatus());
		
		assertEquals("Acesso removido.", retornoApi.andReturn().getResponse().getContentAsString());
		assertEquals(200, retornoApi.andReturn().getResponse().getStatus());
	}
	
	@Test
	public void testRestApiDeletePorIDAcesso() throws JsonProcessingException, Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("ROLE_TESTE_DELETE_ID");

		acessoRepository.save(acesso);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi = mockMvc
									.perform(MockMvcRequestBuilders.delete("/deleteAcessoPorId/"+acesso.getId())
									.content(objectMapper.writeValueAsString(acesso))
									.accept(MediaType.APPLICATION_JSON)
									.contentType(MediaType.APPLICATION_JSON)); 
		System.out.println("Retorno da API: " + retornoApi.andReturn().getResponse().getContentAsString());	
		System.out.println("Retorno do status: "+retornoApi.andReturn().getResponse().getStatus());
		
		assertEquals("Acesso removido por id.", retornoApi.andReturn().getResponse().getContentAsString());
		assertEquals(200, retornoApi.andReturn().getResponse().getStatus());
	}
	
	@Test
	public void testRestApiObterAcessoID() throws JsonProcessingException, Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("ROLE_OBTER_ID");
		
		acessoRepository.save(acesso);
				
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi = mockMvc
									.perform(MockMvcRequestBuilders.get("/obterAcesso/"+acesso.getId())
									.content(objectMapper.writeValueAsString(acesso))
									.accept(MediaType.APPLICATION_JSON)
									.contentType(MediaType.APPLICATION_JSON)); 
		
		assertEquals(200, retornoApi.andReturn().getResponse().getStatus());
		
		Acesso acessoRetorno = objectMapper.readValue(retornoApi.andReturn().getResponse().getContentAsString(), 
				Acesso.class);
		
		assertEquals(acesso.getId(), acessoRetorno.getId());
		
	}
	
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
		
		/*Teste de carregamento. */
		
		Acesso acesso2 = acessoRepository.findById(acesso.getId()).get();
		assertEquals(acesso.getId(), acesso2.getId());
		
		/*Teste de delete*/
		
		acessoRepository.deleteById(acesso2.getId());
		
		/*O flush força o envio dessas operações pendentes para o banco de dados, garantindo que o estado do banco de
		 * dados e o estado da sessão estejam sincronizados.*/
		acessoRepository.flush(); /*Roda esse SQL de delete no banco de dados.*/
		
		/*findById tenta encontrar objeto que foi apagado do banco, para não daa excessão temos o orElse, se tiver o 
		 *objeto acesso2, retorna ele,  se não retorna null*/
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










