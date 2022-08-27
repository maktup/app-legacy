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
		private String apellidoMatCli;
		
		@Schema( required = true )
		@XmlElement
		private String apellidoPatCli;
		
		@Schema( required = true )
		@XmlElement
		private String tipoCli;
	
		@Schema( required = true )
		@XmlElement
		private String correoCli;
		
		@Schema( required = true )
		@XmlElement
		private String telefonoCli;
		
		@Schema( required = true )
		@XmlElement
		private String generoCli;
		
		
		public String getTelefonoCli() {
			return telefonoCli;
		}

		public void setTelefonoCli(String telefonoCli) {
			this.telefonoCli = telefonoCli;
		}
 
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

		public String getApellidoMatCli() {
			return apellidoMatCli;
		}

		public void setApellidoMatCli(String apellidoMatCli) {
			this.apellidoMatCli = apellidoMatCli;
		}

		public String getApellidoPatCli() {
			return apellidoPatCli;
		}

		public void setApellidoPatCli(String apellidoPatCli) {
			this.apellidoPatCli = apellidoPatCli;
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

		public String getGeneroCli() {
			return generoCli;
		}

		public void setGeneroCli(String generoCli) {
			this.generoCli = generoCli;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
 
 }
 
