package jdev.mentoria.lojavirtual.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario implements UserDetails{
	/*Na manunteção não apagar a tabela Usuário porque dela depende outra tabela e pode dar problema.*/
	/*UserDetails implementa Serializable, por isso serialVersionUID.*/
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	private Long id;
	
	@Column(nullable = false)
	private String login;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAtualSenha; 
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable = false,
	foreignKey =  @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
	private Pessoa pessoa;
	
	@OneToMany(fetch = FetchType.LAZY)
	/*Aqui criamos no banco de dados usuario_acesso. Aqui temos um @JoinTable e não @JoinColumn*/
	/*Aqui é classe dona e Acesso classe inversa.\dxs*/
	@JoinTable(name = "usuario_acesso", uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id","acesso_id"},
	name = "unique_acesso_user"), 
	joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario", unique = false,
	foreignKey = @ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT)),
	inverseJoinColumns = @JoinColumn(name = "acesso_id", unique = false, referencedColumnName = "id", table = "acesso",
	foreignKey =  @ForeignKey( name = "acesso_fk", value = ConstraintMode.CONSTRAINT)))
	private List<Acesso> acessos;
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	/*É necessário ter o unique false para termos mais de um tipo de acesso, referência.*/
	
	/*Tudo dentro de @JoinTable está relacionada à tabela usuario_acesso, que gera uma CONSTRAINT que não deveria,
	 *por isso será removida na manuntenção do banco de dados.*/
	
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
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/*Existem mais três métodos que deveriam vir de UserDetails e não vieram, mas nessa versão eles já estão retor-
	 *nando true. O professor teve que mudar manualmente para true. Caso dê problema buscar métodos na interface.*/
}