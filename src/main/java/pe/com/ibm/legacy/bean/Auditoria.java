package pe.com.ibm.legacy.bean;

import java.io.Serializable;

/**
 * cguerra
 * @author Solicitud
 **/
 public class Auditoria implements Serializable{
 
	    private static final long serialVersionUID = -2282410118743693954L;
	
		private int    id;
		private String codigo;
		private String descripcion;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		} 
 }
