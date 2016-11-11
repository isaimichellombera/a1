package a1.models;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tc_acceso")
public class Access {

	// database fields

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Id
	private long id_cliente;

	@Temporal(TemporalType.TIMESTAMP)
	//@DateTimeFormat(pattern = "dd/MM/YYY");
	private Timestamp login;

	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp logout;

	// public methods
	
	public Access() {}

	public Access(long id) {
		this.id = id;
	}

	public Access(long id, long idc) {
		this.id = id;
		this.id_cliente = idc;
	}

	// getter setter methods
	
	public long getId() {
		return id;
	}

	public void setId(long value) {
		this.id = value;
	}

	public long getIdCliente() {
		return id_cliente;
	}

	public void setIdCliente(long value) {
		this.id_cliente = value;
	}

	public Timestamp getLogin() {
		return login;
	}

	public void setLogin(Date d) {
		this.login = d;
	}

	public TimeStamp getLogout() {
		return logout;
	}

	public void setLogout(Date d) {
		this.logout = d;
	}
}
