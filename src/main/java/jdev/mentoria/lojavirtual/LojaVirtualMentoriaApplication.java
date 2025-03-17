package jdev.mentoria.lojavirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/*Colocar novas anotações para evitar problemas.*/
@SpringBootApplication
@EntityScan(basePackages = "jdev.mentoria.lojavirtual.model")/*Escaneia as entidades que são as tabelas*/
@ComponentScan(basePackages = "jdev.*")/*Asterisco para fazer a varredura em tudo que tem algum componente.*/
@EnableJpaRepositories(basePackages = "jdev.mentoria.lojavirtual.repository")
@EnableTransactionManagement /*Habilita o suporte a transações no Spring.*/
public class LojaVirtualMentoriaApplication {
	public static void main(String[] args) {
		SpringApplication.run(LojaVirtualMentoriaApplication.class, args);
		System.out.println("Conexão loja virtual mentoria.");
	}
}
/*Tivemos que baixar a versão o jdk 11 e depois mudar a versão para o Java 11 e a versão do spring para 2.5.8 para
 *a classe depreciada WebSecurityConfigurerAdapter pudesse rodar.*/

/*Baixamos o framework JUnit 3 para estender na classe de Testes*/

/*Colocamos a dependência jackson para json no pom.xml que nos ajudará para o Mockito.*/
 