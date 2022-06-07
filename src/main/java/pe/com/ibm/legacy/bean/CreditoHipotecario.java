package pe.com.ibm.legacy.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import java.io.Serializable; 

/**
 * CreditoHipotecario
 * @author cguerra
 **/
 @XmlRootElement( name = "CreditoHipotecario" ) 
 @Schema( name = "CreditoHipotecario", description = "POJO que representa la entidad CreditoHipotecario." )
 public class CreditoHipotecario implements Serializable{
	 
		private static final long serialVersionUID = 2548104558661770400L;
 
		@Schema( required = true )
		@XmlElement
		private String idCre;
		
		@Schema( required = true )
		@XmlElement
		private String tipoCre;
		
		@Schema( required = true )
		@XmlElement
		private String montoInmuebleCre;
		
		@Schema( required = true )
		@XmlElement
		private String plazoCre;

		
		public String getIdCre() {
			return idCre;
		}

		public void setIdCre(String idCre) {
			this.idCre = idCre;
		}

		public String getTipoCre() {
			return tipoCre;
		}

		public void setTipoCre(String tipoCre) {
			this.tipoCre = tipoCre;
		}

		public String getMontoInmuebleCre() {
			return montoInmuebleCre;
		}

		public void setMontoInmuebleCre(String montoInmuebleCre) {
			this.montoInmuebleCre = montoInmuebleCre;
		}

		public String getPlazoCre() {
			return plazoCre;
		}

		public void setPlazoCre(String plazoCre) {
			this.plazoCre = plazoCre;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
 
 }
 
