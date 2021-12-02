package dao;




import java.sql.Connection;
import java.sql.ResultSet;

import beans.Estados;
import beans.Usuario;
import conexion.Conexion;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daoI.EstadosDaoI;
import daoI.UsuarioDaoI;

public class EstadosDao implements EstadosDaoI{
	
	



	@Override
	public List<Estados> buscar(String nenvio) throws SQLException {
		
		Connection c = Conexion.obtenerConexion();
		Estados salida;
		List<Estados> salidalista = new ArrayList();
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery("select * from estados where nenvio = '"+nenvio+"' order by fecha desc;");
		if (result.next()) {
		    do {
		      salida = new Estados(result.getInt("idestados"),result.getString("nenvio"),result.getString("Estado"),result.getString("fecha"));
		      salidalista.add(salida);
		    } while(result.next());
		} else {
			c.close();
			return salidalista;
		}
		c.close();
		return salidalista;
	}
	
	
	
	@Override
	public int a�adirEstado(String estado,String nenvio) throws SQLException {
		
		Connection c = Conexion.obtenerConexion();
		Statement st = c.createStatement();
		int id=1;
		
		ResultSet result = st.executeQuery("select max(idestados) + 1 as id from estados");
		if (result.next()) {
		    do {
		      id =result.getInt("id");
		    } while(result.next());
		}
		
		String sql = "INSERT INTO estados VALUES ("+id+",'"+nenvio+"','"+estado+"',now())";
		
		int act = st.executeUpdate(sql);
		c.close();
		return act;
	}
	
	
	

}
