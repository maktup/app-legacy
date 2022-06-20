package pe.com.ibm.legacy.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import java.io.Serializable; 

/**
 * Solicitud
 * @author cguerra
 **/
 @XmlRootElement( name = "Solicitud" ) 
 @Schema( name = "Solicitud", description = "POJO que representa la entidad Solicitud." )
 public class Solicitud implements Serializable{
	 
		private static final long serialVersionUID = 2544122558661770400L;
  
		@Schema( required = true )
		@XmlElement
		private String idSol;
		
		@Schema( required = true )
		@XmlElement
		private Cliente cliente;
		
		@Schema( required = true )
		@XmlElement
		private CreditoHipotecario creditoHipotecario;

		@Schema( required = true )
		@XmlElement
		private Resultado resultado;
		
		
		public Resultado getResultado() {
			return resultado;
		}

		public void setResultado(Resultado resultado) {
			this.resultado = resultado;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public CreditoHipotecario getCreditoHipotecario() {
			return creditoHipotecario;
		}

		public void setCreditoHipotecario(CreditoHipotecario creditoHipotecario) {
			this.creditoHipotecario = creditoHipotecario;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public String getIdSol() {
			return idSol;
		}

		public void setIdSol(String idSol) {
			this.idSol = idSol;
		}
 
 }
 
