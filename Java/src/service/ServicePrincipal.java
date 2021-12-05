package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.CargaFurgonetas;
import beans.DatosEnvio;
import beans.Estados;
import beans.Furgonetas;
import dao.DatosEnvioDao;
import dao.EstadosDao;
import dao.FurgonetasDao;

public class ServicePrincipal {

	EstadosDao eDao = new EstadosDao();
	DatosEnvioDao deDao = new DatosEnvioDao();
	FurgonetasDao fuDao = new FurgonetasDao();

	public List<Estados> historico(String nenvio) {

		List<Estados> estados = new ArrayList<Estados>();

		try {
			estados = eDao.buscar(nenvio);
		} catch (SQLException e) {
			return estados;
		}
		return estados;
	}

	public String altaEstado(String estado, String nenvio,String origen) {

		List<Estados> estados = new ArrayList<Estados>();
		estados = historico(nenvio);
		int respuesta = 0;

		for (Estados e : estados) {
			if (e.getEstado().equals("Entregado")) {
				return "El paquete ya ha sido entregado no se puede modificar su estado";
			}
		}
		
		List<String> envios = enviosEnFurgonetas();
		
		for (String de: envios) {
			if(de.equals(nenvio) && !origen.equals("Clasificador") && estado.equals("Entregado") ) {
				return "No puedes entregar un paquete sin bajarlo de la furgoneta";
			}
		}

		try {
			respuesta = eDao.añadirEstado(estado, nenvio);
		} catch (SQLException e) {
			
			e.printStackTrace();
			return "Error en la base de datos";
		}
		if (respuesta != 0) {
			return "Añadido un nuevo estado al envio:" + estado;
		}
		return "";

	}

	public DatosEnvio BuscarEnvio(String nenvio) {
		DatosEnvio salida = new DatosEnvio();

		try {
			salida = deDao.buscar(nenvio);
		} catch (SQLException e) {
			e.printStackTrace();
			return salida;
		}
		return salida;

	}

	public String altaEnvio(DatosEnvio envio) {

		int respuesta = 0;

		try {
			respuesta = deDao.añadirEnvio(envio);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error en la base de datos";
		}
		if (respuesta != 0) {
			altaEstado("Alta en el sistema", envio.getNenvio(),"Pantalla");
			return "Envio dado de alta: su numero de envio es : " + envio.getNenvio();
		}
		return "";

	}

	public Furgonetas buscarFurgoneta(String matricula) {

		Furgonetas salida = null;

		try {
			salida = fuDao.buscar(matricula);
		} catch (SQLException e) {
			e.printStackTrace();
			return salida;
		}
		return salida;

	}

	public String EliminarFurgoneta(String matricula) {

		
		int funciono = 0;

		try {
			funciono = fuDao.quitarFurgoneta(matricula);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error en la base de datos";
		}
		if (funciono != 0) {
			return "OK Furgoneta dada de baja";
		}

		else {
			return "Ha ocurrido un error";
		}

	}

	public String AltaFurgoneta(String matricula, String desde, String hasta) {

		Furgonetas f = new Furgonetas(null, matricula, desde, hasta, null, null);

		
		int funciono = 0;

		Furgonetas f2 = buscarFurgoneta(matricula);
		if (f2 == null) {

			try {
				funciono = fuDao.añadirFurgoneta(f);
			} catch (SQLException e) {
				e.printStackTrace();
				return "Error en la base de datos";
			}
			if (funciono != 0) {
				return "OK Furgoneta dada de alta";
			}

			else {
				return "Ha ocurrido un error";
			}
		} else {
			return "Ya hay una furgoneta con esa matricula";
		}

	}

	public String EliminarCarga(int id, String nenvio) {

		
		int funciono = 0;

		try {
			funciono = fuDao.quitarCarga(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error en la base de datos";
		}
		if (funciono != 0) {
			altaEstado("Envio bajado de furgoneta",nenvio,"PDA");
			return "Mercancia dada de baja";
		}

		else {
			return "Ha ocurrido un error";
		}

	}

	public String ModificarFurgoneta(String matricula, String desde, String hasta) {

		
		int funciono = 0;

		try {
			funciono = fuDao.modificarFurgoneta(matricula, desde, hasta);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error en la base de datos";
		}
		if (funciono != 0) {
			return "OK Furgoneta modificada Correctamente";
		}

		else {
			return "Ha ocurrido un error";
		}

	}

	public List<DatosEnvio> buscarTodosEnvios() {

		List<DatosEnvio> salida = new ArrayList<DatosEnvio>();

		try {
			salida = deDao.sacarTodos();
		} catch (SQLException e) {
			e.printStackTrace();
			return salida;
		}
		return salida;

	}
	
	public List<String> enviosEnFurgonetas() {

		List<String> salida = new ArrayList<String>();

		try {
			salida = fuDao.enviosEnFurgonetas();
		} catch (SQLException e) {
			e.printStackTrace();
			return salida;
		}
		return salida;

	}

	public List<Furgonetas> clasificar(String cp) {

		List<Furgonetas> salida = new ArrayList<Furgonetas>();

		try {
			salida = fuDao.clasificar(cp);
		} catch (SQLException e) {
			e.printStackTrace();
			return salida;
		}
		return salida;

	}

	public String añadirCarga(String nenvio, int id) {

		CargaFurgonetas subir = new CargaFurgonetas(null, nenvio, id, null, null);
		int resultado = 0;

		try {
			resultado = fuDao.añadirCarga(subir);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error en la base de datos";
		}
		if (resultado != 0) {
			altaEstado("Envio añadido a furgoneta: "+id,nenvio,"Clasificador");
			return "OK Carga añadida correctamente";
		}
		else{
			return "ha ocurrido un error";
		}

	}

}
