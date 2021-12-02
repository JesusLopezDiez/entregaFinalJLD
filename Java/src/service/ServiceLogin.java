package service;

import java.sql.Connection;
import java.sql.SQLException;

import beans.Usuario;
import conexion.Conexion;
import dao.UsuarioDao;
import daoI.UsuarioDaoI;

public class ServiceLogin {

	private UsuarioDao usrdao =  new UsuarioDao() ;

	public String nuevaAlta(String user, String pass) {

		Usuario nuevo = new Usuario(user, pass);
	
		int ok = 0;

		Usuario existente = null;
		try {
			existente = usrdao.buscar(nuevo.getUser());
		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (existente == null) {
			try {
				ok = usrdao.a�adir(nuevo);
				if (ok != 0) {
					return "Usuario dado de alta correctamente";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return "Error en la base de datos";
			
			}
		}
			return "Ya existe este usuario";
		

	}
	
	public boolean comprobar(String user, String pass) {

		Usuario existente = null;
		try {
			existente = usrdao.buscar(user,pass);
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		if (existente != null) {
			
					return true;
				}
			 
		
			return false;
		

	}

}