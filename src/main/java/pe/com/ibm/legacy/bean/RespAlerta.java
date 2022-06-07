package pe.com.ibm.legacy.bean;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RespAlerta
 * @author cguerra
 **/
 @XmlRootElement( name = "RespAlerta" ) 
 @Schema( name = "RespAlerta", description = "POJO para la respuesta de RespAlerta." )
 public class RespAlerta implements Serializable{
 
	    private static final long serialVersionUID = -2288550118743364954L;
 
		@Schema( required = true )
		@XmlElement
		private Auditoria auditoria;

		@Schema( required = true )
		@XmlElement
		private Alerta alerta;
		
		@Schema( required = true )
		@XmlElement
		private Solicitud solicitud;

		
		public Auditoria getAuditoria() {
			return auditoria;
		}

		public void setAuditoria(Auditoria auditoria) {
			this.auditoria = auditoria;
		}

		public Solicitud getSolicitud() {
			return solicitud;
		}

		public void setSolicitud(Solicitud solicitud) {
			this.solicitud = solicitud;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public Alerta getAlerta() {
			return alerta;
		}

		public void setAlerta(Alerta alerta) {
			this.alerta = alerta;
		}
 
 }
