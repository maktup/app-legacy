package pe.com.ibm.legacy.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import java.io.Serializable; 

/**
 * Cliente
 * @author cguerra
 **/
 @XmlRootElement( name = "Cliente" ) 
 @Schema( name = "Cliente", description = "POJO que representa la entidad Cliente." )
 public class Cliente implements Serializable{
	 
		private static final long serialVersionUID = 2548122558661770400L;
 		
		@Schema( required = true )
		@XmlElement
		private String idCli;
		
		@Schema( required = true )
		@XmlElement
		private String dniCli;
		
		@Schema( required = true )
		@XmlElement
		private String nombresCli;
		
		@Schema( required = true )
		@XmlElement
		private String apellidosCli;
		
		@Schema( required = true )
		@XmlElement
		private String montoIngresoCli;
	
		@Schema( required = true )
		@XmlElement
		private String tipoCli;

		@Schema( required = true )
		@XmlElement
		private String correoCli;

		
		public String getIdCli() {
			return idCli;
		}

		public void setIdCli(String idCli) {
			this.idCli = idCli;
		}

		public String getDniCli() {
			return dniCli;
		}

		public void setDniCli(String dniCli) {
			this.dniCli = dniCli;
		}

		public String getNombresCli() {
			return nombresCli;
		}

		public void setNombresCli(String nombresCli) {
			this.nombresCli = nombresCli;
		}

		public String getApellidosCli() {
			return apellidosCli;
		}

		public void setApellidosCli(String apellidosCli) {
			this.apellidosCli = apellidosCli;
		}

		public String getMontoIngresoCli() {
			return montoIngresoCli;
		}

		public void setMontoIngresoCli(String montoIngresoCli) {
			this.montoIngresoCli = montoIngresoCli;
		}

		public String getTipoCli() {
			return tipoCli;
		}

		public void setTipoCli(String tipoCli) {
			this.tipoCli = tipoCli;
		}

		public String getCorreoCli() {
			return correoCli;
		}

		public void setCorreoCli(String correoCli) {
			this.correoCli = correoCli;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
 
 }
 
