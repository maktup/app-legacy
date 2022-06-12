package pe.com.ibm.legacy.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/** 
 * RespConsultaSolicitud
 * @author cguerra
 **/
 @XmlRootElement( name = "RespConsultaSolicitud" ) 
 @Schema( name = "RespConsultaSolicitud", description = "POJO para la respuesta de RespConsultaSolicitud." )
 public class RespConsultaSolicitud implements Serializable{
 
	    private static final long serialVersionUID = -2287750118743364954L;
 
		@Schema( required = true )
		@XmlElement
		private Auditoria auditoria;

		@Schema( required = true )
		@XmlElement
		private List<Solicitud> listaSolicitud;

		@Schema( required = true )
		@XmlElement
		private Resultado resultado;
		
		//Constructor: 
		public RespConsultaSolicitud(){
			   this.listaSolicitud = new ArrayList<Solicitud>();
		}
 
		public Auditoria getAuditoria() {
			   return auditoria;
		}
 
		public void setAuditoria(Auditoria auditoria) {
			   this.auditoria = auditoria;
		}
 
		public List<Solicitud> getListaSolicitud() {
			   return listaSolicitud;
		}
 
		public void setListaSolicitud(List<Solicitud> listaSolicitud) {
			   this.listaSolicitud = listaSolicitud;
		}
 
		public static long getSerialversionuid() {
			   return serialVersionUID;
		}

		public Resultado getResultado() {
			   return resultado;
		}

		public void setResultado(Resultado resultado) {
			   this.resultado = resultado;
		}
 
 }
 