package pe.com.ibm.legacy.bean;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Auditoria
 * @author cguerra
 **/
 @XmlRootElement( name = "Auditoria" ) 
 @Schema( name = "Auditoria", description = "POJO que representa la entidad Auditoria." )
 public class Auditoria implements Serializable{
 
	    private static final long serialVersionUID = -2282410118223693954L;
	
		@Schema( required = true )
		@XmlElement
		private int    id;
		
		@Schema( required = true )
		@XmlElement
		private String codigo;
		
		@Schema( required = true )
		@XmlElement
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
