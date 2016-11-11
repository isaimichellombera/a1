package a1.models;

import java.util.Date;
//import java.util.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tc_acceso")
public class Access {

	// database fields

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private long cliente;

	//@Temporal(TemporalType.TIMESTAMP)
	//private Date login;
	// casting problems ???
	@NotNull
	private String login;

	//@Temporal(TemporalType.TIMESTAMP)
	//private Date logout;
	@NotNull
	private String logout;

	// public methods
	
	public Access() {}

	public Access(long id) {
		this.id = id;
	}

	public Access(long id, long idc) {
		this.id = id;
		this.cliente = idc;
	}

	public Access(String login, String logout) {
		this.login = login;
		this.logout = logout;
	}

	// getter setter methods
	
	public long getId() {
		return id;
	}

	public void setId(long value) {
		this.id = value;
	}

	public long getIdCliente() {
		return cliente;
	}

	public void setIdCliente(long value) {
		this.cliente = value;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String d) {
		this.login = d;
	}

	public String getLogout() {
		return logout;
	}

	public void setLogout(String d) {
		this.logout = d;
	}
}
