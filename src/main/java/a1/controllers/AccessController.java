package a1.controllers;

import a1.models.Access;
import a1.models.AccessDao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
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
			acceso = new Access("","");
			accessDao.save(acceso);
			acceso.setIdCliente(acceso.getId()); // keep IDs consistent for this hackathon
			accessDao.save(acceso);
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

		try {
			acceso = accessDao.findById(id);
			acceso.setLogin(String.valueOf(System.currentTimeMillis()));
			accessDao.save(acceso);
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

		try {
			acceso = accessDao.findById(id);
			//acceso.setLogout(new Timestamp(System.currentTimeMillis()));
			acceso.setLogout(String.valueOf(System.currentTimeMillis()));
			accessDao.save(acceso);
		}
		catch (Exception e) {
			return acceso;
		}
		return acceso;
	}

	@RequestMapping("/baja")
	//public Access baja(long id) {
	public Access baja(long id) {
		try {
			Access acceso = new Access(id);
			accessDao.delete(acceso);
		}
		catch (Exception e) {
			return new Access(id);
		}
		return new Access(id);
	}
}
