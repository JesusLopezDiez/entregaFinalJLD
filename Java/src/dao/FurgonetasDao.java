package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.CargaFurgonetas;
import beans.Estados;
import beans.Furgonetas;
import conexion.Conexion;
import daoI.FurgonetasDaoI;

public class FurgonetasDao implements FurgonetasDaoI {

	@Override
	public Furgonetas buscar(String matricula) throws SQLException {

		Connection c = Conexion.obtenerConexion();
		Furgonetas salida = null ;
		List<CargaFurgonetas> salidalista = null;
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery("select * from furgonetas where matricula = '" + matricula + "' ;");

		if (result.next()) {
			do {
				salida = new Furgonetas(result.getInt("idfurgoneta"), result.getString("matricula"),
						result.getString("rutadesde"), result.getString("rutahasta"), result.getString("fechaAlta"),
						result.getString("fechaBaja"));
			} while (result.next());
			
		}
		else {
			c.close();
			return salida;
		}
		
		salida.setCarga(sacarCarga(salida.getId()));
		
		c.close();
		return salida;
	}
	
	public List<CargaFurgonetas> sacarCarga(int id) throws SQLException {

		Connection c = Conexion.obtenerConexion();
		List<CargaFurgonetas> salidalista = new ArrayList();
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery(
				"select * from cargafurgonetas where idfurgoneta = " + id + " and fechaBaja is null ;");
		if (result.next()) {
			do {
				CargaFurgonetas carga = new CargaFurgonetas(result.getInt("idcarga"), result.getString("nenvio"),
						id, result.getString("fechaAlta"), result.getString("fechaBaja"));
				salidalista.add(carga);
			} while (result.next());
			st.close();
		}
		else {
			c.close();
			return salidalista;
		}

		
		c.close();
		return salidalista;
	}
	

	@Override
	public int añadirFurgoneta(Furgonetas furgoneta) throws SQLException {
		Connection c = Conexion.obtenerConexion();
		Statement st = c.createStatement();
		int id = 1;

		ResultSet result = st.executeQuery("select max(idfurgoneta) + 1 as id from furgonetas");
		if (result.next()) {
			do {
				id = result.getInt("id");
			} while (result.next());
		}

		String sql = "INSERT INTO furgonetas VALUES (" + id + ",'" + furgoneta.getMatricula() + "','"
				+ furgoneta.getRutaDesde() + "','" + furgoneta.getRutaHasta() + "',now(),null)";

		int act = st.executeUpdate(sql);
		c.close();
		return act;

	}

	@Override
	public int añadirCarga(CargaFurgonetas carga) throws SQLException {
		Connection c = Conexion.obtenerConexion();
		Statement st = c.createStatement();

		int id = 1;

		ResultSet result = st.executeQuery("select max(idcarga) + 1 as id from cargafurgonetas");
		if (result.next()) {
			do {
				id = result.getInt("id");
			} while (result.next());
		}

		String sql = "INSERT INTO cargafurgonetas VALUES (" + id + ",'" + carga.getNenvio() + "',"
				+ carga.getIdFurgoneta() + ",now(),null)";

		int act = st.executeUpdate(sql);
		c.close();
		return act;

	}

	@Override
	public int quitarCarga(int id) throws SQLException {
		Connection c = Conexion.obtenerConexion();
		Statement st = c.createStatement();

		String sql = "update cargafurgonetas set fechaBaja = now() where idCarga = " + id ;

		int act = st.executeUpdate(sql);
		c.close();
		return act;

	}

	@Override
	public int quitarFurgoneta(String matricula) throws SQLException {
		Connection c = Conexion.obtenerConexion();
		Statement st = c.createStatement();

		String sql = "update furgonetas set fechaBaja = now() where matricula = '" + matricula+"'" ;

		int act = st.executeUpdate(sql);
		c.close();
		return act;

	}

	@Override
	public int modificarFurgoneta(String matricula, String desde, String hasta) throws SQLException {
		Connection c = Conexion.obtenerConexion();
		Statement st = c.createStatement();

		String sql = "update furgonetas set rutadesde = '" + desde + "', rutahasta= '" + hasta + "' where matricula = '"	+ matricula+"'" ;
		System.out.println(sql);

		int act = st.executeUpdate(sql);
		c.close();
		return act;

	}

	@Override
	public List<Furgonetas> clasificar(String cpDestino) throws SQLException {

		Connection c = Conexion.obtenerConexion();
		Furgonetas salida = null;
		List<Furgonetas> salidalista = new ArrayList();
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery("select * from furgonetas where rutadesde<= '" + cpDestino + "'and rutahasta>='"
				+ cpDestino + "' and fechaBaja is null ");

		if (result.next()) {
			do {
				salida = new Furgonetas(result.getInt("idfurgoneta"), result.getString("matricula"),
						result.getString("rutadesde"), result.getString("rutahasta"), result.getString("fechaAlta"),
						result.getString("fechaBaja"));
				salidalista.add(salida);

			} while (result.next());
		} else {
			c.close();
			return salidalista;
		}
		c.close();
		return salidalista;
	}

	public List<String> enviosEnFurgonetas() throws SQLException{
		Connection c = Conexion.obtenerConexion();
		
		List<String> salidalista = new ArrayList();
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery("select nenvio from cargafurgonetas where fechaBaja is null");

		if (result.next()) {
			do {
				String salida =result.getString("nenvio");
				salidalista.add(salida);

			} while (result.next());
		} else {
			c.close();
			return salidalista;
		}
		c.close();
		return salidalista;
	}


}
