package pe.com.ibm.legacy.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import java.io.Serializable; 

/**
 * Alerta
 * @author cguerra
 **/
 @XmlRootElement( name = "Cliente" ) 
 @Schema( name = "Alerta", description = "POJO que representa la entidad Alerta." )
 public class Alerta implements Serializable{
	 
		private static final long serialVersionUID = 2548122557761770400L;
  		
		@Schema( required = true )
		@XmlElement
		private String idSol;
		
		@Schema( required = true )
		@XmlElement
		private String codeVP;
		
		@Schema( required = true )
		@XmlElement
		private String detalleVP;
		
		@Schema( required = true )
		@XmlElement
		private String codeVR;
		
		@Schema( required = true )
		@XmlElement
		private String detalleVR;
	
		@Schema( required = true )
		@XmlElement
		private String estadoAprobacion;

		@Schema( required = true )
		@XmlElement
		private String detalleAprobacion;

		@Schema( required = true )
		@XmlElement
		private String eventoEnvio;

		
		public String getIdSol() {
			return idSol;
		}

		public void setIdSol(String idSol) {
			this.idSol = idSol;
		}

		public String getCodeVP() {
			return codeVP;
		}

		public void setCodeVP(String codeVP) {
			this.codeVP = codeVP;
		}

		public String getDetalleVP() {
			return detalleVP;
		}

		public void setDetalleVP(String detalleVP) {
			this.detalleVP = detalleVP;
		}

		public String getCodeVR() {
			return codeVR;
		}

		public void setCodeVR(String codeVR) {
			this.codeVR = codeVR;
		}

		public String getDetalleVR() {
			return detalleVR;
		}

		public void setDetalleVR(String detalleVR) {
			this.detalleVR = detalleVR;
		}

		public String getEstadoAprobacion() {
			return estadoAprobacion;
		}

		public void setEstadoAprobacion(String estadoAprobacion) {
			this.estadoAprobacion = estadoAprobacion;
		}

		public String getDetalleAprobacion() {
			return detalleAprobacion;
		}

		public void setDetalleAprobacion(String detalleAprobacion) {
			this.detalleAprobacion = detalleAprobacion;
		}

		public String getEventoEnvio() {
			return eventoEnvio;
		}

		public void setEventoEnvio(String eventoEnvio) {
			this.eventoEnvio = eventoEnvio;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
 
 }
 
