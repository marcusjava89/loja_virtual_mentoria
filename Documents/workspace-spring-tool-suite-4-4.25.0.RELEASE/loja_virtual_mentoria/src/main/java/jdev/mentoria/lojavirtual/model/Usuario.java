package jdev.mentoria.lojavirtual.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario implements UserDetails{
	
	/*UserDetails implementa Serializable, por isso serialVersionUID.*/
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	private Long id;
	private String login;
	private String senha;
	@Temporal(TemporalType.DATE)
	private Date dataAtualSenha; 
	
	/*Sem essa anotação temos erro de execução. O mesmo acontece em Pessoa com lista de endereços. Listas de objetos 
	 *de outras classes são chaves estrangeiras.*/
	@OneToMany(fetch = FetchType.LAZY)
	/*Aqui criamos no banco de dados usuario_acesso*/
	@JoinTable(name = "usuario_acesso", uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id","acesso_id"},
	name = "unique_acesso_user"), 
	joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario", unique = false,
	foreignKey = @ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT)),
	inverseJoinColumns = @JoinColumn(name = "acesso_id", unique = false, referencedColumnName = "id", table = "acesso",
	foreignKey =  @ForeignKey( name = "acesso_fk", value = ConstraintMode.CONSTRAINT)))
	private List<Acesso> acessos;
	
	/*É necessário ter o unique false para termos mais de um tipo de acesso, referência.*/
	
	/*Tudo dentro de @JoinTable está relacionada à tabela usuario_acesso, que gera uma CONSTRAINT que não deveria, por
	 *isso será removida na manuntenção do banco de dados.*/
	
	/*Em inverseJoinColumns dizemos que unique tinha que ser false e mesmo assim foi criado um constraint no banco de
	 *dados em usuario_acessos, que vai ser eliminado na manuntenção do banco./
	
	/*Autoridades = São os acessos, ou seja ROLE_ADMIN, ROLE_SECRETARIO, ROLE_FINANCEIRO.*/
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.acessos;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	/*Existem mais três métodos que deveriam vir de UserDetails e não vieram, mas nessa versão eles já estão retor-
	 *nando true. O professor teve que mudar manualmente para true. Caso dê problema buscar métodos na interface.*/
}
