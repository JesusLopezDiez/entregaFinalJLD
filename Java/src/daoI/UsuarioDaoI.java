package daoI;

import java.sql.SQLException;

import beans.Usuario;

public interface UsuarioDaoI {

	boolean insertarUsuario(Usuario u);

	Usuario buscar(String usuario) throws SQLException;



	int a�adir(Usuario usuario) throws SQLException;

	Usuario buscar(String usuario, String pass) throws SQLException;

}
