package jdev.mentoria.lojavirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jdev.mentoria.lojavirtual.model.Acesso;
@Repository
@Transactional /*Garante que todos os métodos (herdados e personalizados) sejam executados dentro de uma transação.*/
public interface AcessoRepository extends JpaRepository<Acesso, Long>{
	
	@Query("select a from Acesso a where upper(trim(a.descricao)) like %?1%")
	List<Acesso> buscarAcessoDesc(String desc);
	
}

/*A anotação @Transactional é usada para definir que um método ou classe deve ser executado dentro de uma transação no
 *banco de dados. Transações são importantes para garantir que operações no banco de dados sejam executadas de forma
 *atômica (ou seja, todas as operações são concluídas com sucesso, ou nenhuma é aplicada).*/

/*@Transactional diretamente na interface do repositório significa que todos os métodos dessa interface serão execu-
 *tados dentro de uma transação.*/