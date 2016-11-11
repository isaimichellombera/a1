package a1;

import a1.models.Access;
import a1.models.AccessDao;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessController {

	@Autowired
	private AccessDao accessDao;

	// NUEVO ACCESO
	@RequestMapping("/nuevo_acceso")
	public Access nuevo_acceso(long id_cliente) {
		String access_id = "";
		Access acceso = null;

		try {
			acceso = new Access();
			accessDao.save(acceso);
			access_id = String.valueOf(acceso.getId);
		}
		catch (Exception e) {
			return acceso;
		}
		
		return acceso;
	}

	// CONSULTA ID DE CLIENTE
	@RequestMapping("/consulta_id_cliente")
	public Access consulta_cliente(long id) {
		Access acceso = null;

		try {
			acceso = accessDao.findById(id);
		}
		catch (Exception e) {
			return acceso;
		}

		return acceso;
	}

	// RECORDAR LOGIN FECHAHORA
	@RequestMapping("/login")
	public Access login(long id) {
		Access acceso = null;
		Date now = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

		try {
			acceso = accessDao.findById(id);
			acceso.setLogin(now);
		}
		catch (Exception e) {
			return acceso;
		}
		return acceso;
	}

	// RECORDAR LOGOUT FECHAHORA
	@RequestMapping("/logout")
	public Access logout(long id) {
		Access acceso = null;
		Date now = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

		try {
			acceso = accessDao.findById(id);
			acceso.setLogout(now);
		}
		catch (Exception e) {
			return acceso;
		}
		return acceso;
	}

}
