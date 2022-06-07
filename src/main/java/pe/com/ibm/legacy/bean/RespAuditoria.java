package pe.com.ibm.legacy.bean;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RespAuditoria
 * @author cguerra
 **/
 @XmlRootElement( name = "RespAuditoria" ) 
 @Schema( name = "RespAuditoria", description = "POJO para la respuesta de RespAuditoria." )
 public class RespAuditoria implements Serializable{
 
	    private static final long serialVersionUID = -2288550118743644954L;
 
		@Schema( required = true )
		@XmlElement
		private Auditoria auditoria;

		public Auditoria getAuditoria() {
			return auditoria;
		}

		public void setAuditoria(Auditoria auditoria) {
			this.auditoria = auditoria;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		  
 }
