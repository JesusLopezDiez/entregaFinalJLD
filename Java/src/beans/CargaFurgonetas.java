package beans;

public class CargaFurgonetas {
	
	private Integer id;
	private String nenvio;
	private Integer idFurgoneta;
	private String fechaAlta;
	private String fechaBaja;
	
	
	public CargaFurgonetas(Integer id,String nenvio,Integer idFurgoneta, String fechaAlta, String fechaBaja) {
		super();
		this.id=id;
		this.nenvio = nenvio;
		this.idFurgoneta=idFurgoneta;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}
	
	public CargaFurgonetas() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNenvio() {
		return nenvio;
	}
	public void setNenvio(String nenvio) {
		this.nenvio = nenvio;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Integer getIdFurgoneta() {
		return idFurgoneta;
	}

	public void setIdFurgoneta(Integer idFurgoneta) {
		this.idFurgoneta = idFurgoneta;
	}

	@Override
	public String toString() {
		return "Numero envio=" + nenvio + ", Fecha de Alta=" + fechaAlta ;
	}
	
	
	

}
