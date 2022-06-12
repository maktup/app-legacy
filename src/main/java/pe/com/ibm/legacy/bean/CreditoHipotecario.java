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
		private String montoInicialCre;
		
		@Schema( required = true )
		@XmlElement
		private String montoFinanciarCre;
		
		@Schema( required = true )
		@XmlElement
		private String plazoMesesCre;
		
		@Schema( required = true )
		@XmlElement
		private String sueldoBrutoCre;
		
		@Schema( required = true )
		@XmlElement
		private String costoInmuebleCre;		
		
		@Schema( required = true )
		@XmlElement
		private String tasaCre;

		
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

		public String getMontoInicialCre() {
			return montoInicialCre;
		}

		public void setMontoInicialCre(String montoInicialCre) {
			this.montoInicialCre = montoInicialCre;
		}

		public String getMontoFinanciarCre() {
			return montoFinanciarCre;
		}

		public void setMontoFinanciarCre(String montoFinanciarCre) {
			this.montoFinanciarCre = montoFinanciarCre;
		}

		public String getPlazoMesesCre() {
			return plazoMesesCre;
		}

		public void setPlazoMesesCre(String plazoMesesCre) {
			this.plazoMesesCre = plazoMesesCre;
		}

		public String getSueldoBrutoCre() {
			return sueldoBrutoCre;
		}

		public void setSueldoBrutoCre(String sueldoBrutoCre) {
			this.sueldoBrutoCre = sueldoBrutoCre;
		}

		public String getCostoInmuebleCre() {
			return costoInmuebleCre;
		}

		public void setCostoInmuebleCre(String costoInmuebleCre) {
			this.costoInmuebleCre = costoInmuebleCre;
		}

		public String getTasaCre() {
			return tasaCre;
		}

		public void setTasaCre(String tasaCre) {
			this.tasaCre = tasaCre;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}		
 
 }
 
