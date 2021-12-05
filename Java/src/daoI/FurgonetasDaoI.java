package daoI;

import java.sql.SQLException;
import java.util.List;

import beans.CargaFurgonetas;
import beans.Furgonetas;

public interface FurgonetasDaoI {

	Furgonetas buscar(String matricula) throws SQLException;

	int añadirFurgoneta(Furgonetas furgoneta) throws SQLException;

	int añadirCarga(CargaFurgonetas carga) throws SQLException;


	int modificarFurgoneta(String matricula, String desde, String hasta) throws SQLException;

	int quitarFurgoneta(String matricula) throws SQLException;

	List<Furgonetas> clasificar(String cpDestino) throws SQLException;

	int quitarCarga(int id) throws SQLException;

	

}
