package jdev.mentoria.lojavirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*A anotação abaixo é o que faz o Springboot funcionar*/
@SpringBootApplication
public class LojaVirtualMentoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaVirtualMentoriaApplication.class, args);
		System.out.println("Conexão loja virtual mentoria.");
	}

}
