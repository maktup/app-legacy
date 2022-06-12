package pe.com.ibm.legacy.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import pe.com.ibm.legacy.bean.Auditoria;
import pe.com.ibm.legacy.bean.Cliente;
import pe.com.ibm.legacy.bean.CreditoHipotecario; 
import pe.com.ibm.legacy.bean.RespAuditoria;
import pe.com.ibm.legacy.bean.RespConsultaSolicitud;
import pe.com.ibm.legacy.bean.Resultado;
import pe.com.ibm.legacy.bean.Solicitud;
import pe.com.ibm.legacy.util.Constantes;
import pe.com.ibm.legacy.util.UtilConexion;
import pe.com.ibm.legacy.util.UtilLegacy;

/**
 * LegacyService 
 * @author cguerra
 **/
 @ApplicationScoped
 public class LegacyService{
        
	    private UtilLegacy   objUtilLegacy   = new UtilLegacy();
	    private UtilConexion objUtilConexion = null;    
	    private Connection   objConexion     = null;
 
  	   /**
  	    * procesarValidarRiesgo
  	    * @param  sueldoBrutoCre
  	    * @param  plazoMesesCre
  	    * @param  costoInmuebleCre
  	    * @param  montoInicialCre
  	    * @param  montoFinanciarCre
  	    * @param  tasaCre
  	    * @return Response
  	    **/
		public javax.ws.rs.core.Response procesarValidarRiesgo( double sueldoBrutoCre, int plazoMesesCre, double costoInmuebleCre, double montoInicialCre, double montoFinanciarCre, double tasaCre ){
			   System.out.println( "------- [INICIO] - procesarValidarRiesgo -------" );   
			   
			   RespAuditoria objRespAudit = new RespAuditoria();
			   Auditoria     objAudit     = new Auditoria();			   
			   Response      objResponse  = null;
 
			   try{	 			   
				   double vSueldoNeto            = (sueldoBrutoCre * 0.7);
				   double vMontoMaximoEndeudable = (vSueldoNeto * 0.6); 
				
				   double vValorDeuda    = (montoFinanciarCre + tasaCre);
				   double vDivisionDeuda = (vValorDeuda / plazoMesesCre);
				   
				   System.out.println( "=> vSueldoNeto: ["    + vSueldoNeto    + "]" );
				   System.out.println( "=> vDivisionDeuda: [" + vDivisionDeuda + "]" );
				   System.out.println( "=> vValorDeuda: ["    + vValorDeuda    + "]" );
				   System.out.println( "=> vMontoMaximoEndeudable: [" + vMontoMaximoEndeudable + "]" );
				   
				   //Escenario ERROR: 
				   if( vMontoMaximoEndeudable < vDivisionDeuda){
					   objAudit.setCodigo( "-1" );
					   objAudit.setDescripcion( "Proceso de validación de RIESGO: [NO ACEPTADO], NO califica por CAPACIDAD de endeudamiento." ); 
				   }	
				   //Escenario OK: 
				   else{
					    objAudit.setCodigo( "0" );
					    objAudit.setDescripcion( "Proceso de validación de RIESGO: [SI ACEPTADO], SI califica." );  
				   }
 				   
				   objRespAudit.setAuditoria( objAudit );				   
				   objResponse = Response.ok( objRespAudit ).build(); 
			   }
			   catch( Exception e ) {
				      e.printStackTrace();
				      
					  objAudit.setCodigo( "-1" );
					  objAudit.setDescripcion( "ERROR ENCONTRADO: [" + e.getMessage() + "]" );  
					  
					  objRespAudit.setAuditoria( objAudit );	
					  objResponse = Response.status( 500 ).entity( objAudit ).build();
			   }
			   finally{ 
				       System.out.println( "------- [FIN] - procesarValidarRiesgo -------" ); 
			   }
			     
			   return objResponse; 	
		}	
		
  	   /**
  	    * procesarValidarPersona
  	    * @param  idCli
  	    * @param  dniCli
  	    * @return Response
  	    **/
		public javax.ws.rs.core.Response procesarValidarPersona( String idCli, String dniCli ){
			   System.out.println( "------- [INICIO] - procesarValidarPersona -------" );   
			   
			   RespAuditoria objRespAudit = new RespAuditoria();
			   Auditoria     objAudit     = new Auditoria();			   
			   Response      objResponse  = null;
			   
			   try{				   
				   int vEstadoDni   = Integer.parseInt( this.objUtilLegacy.existeDniEnCadena( dniCli ) );
				   int vEstadoIdCli = Integer.parseInt( this.objUtilLegacy.existeClienteEnCadena( idCli ) ); 
				   
				   if( (vEstadoDni == 0) && (vEstadoIdCli == 0) ){
					   
					   objAudit.setCodigo( "0" );
					   objAudit.setDescripcion( "Proceso de validación de PERSONA: [SI ACEPTADO]." ); 
				   }
				   else{
					   objAudit.setCodigo( "-1" );
					   objAudit.setDescripcion( "Proceso de validación de PERSONA: [NO ACEPTADO]." );  
				   }
				   
				   objRespAudit.setAuditoria( objAudit );				   
				   objResponse = Response.ok( objRespAudit ).build(); 
			   }
			   catch( Exception e ) {
				      e.printStackTrace();
				      
					  objAudit.setCodigo( "-1" );
					  objAudit.setDescripcion( "ERROR ENCONTRADO: [" + e.getMessage() + "]" );  
					  
					  objRespAudit.setAuditoria( objAudit );	
					  objResponse = Response.status( 500 ).entity( objAudit ).build();
			   }
			   finally{ 
				       System.out.println( "------- [FIN] - procesarValidarPersona -------" ); 
			   }
			     
			   return objResponse;
		}
				
  	   /**
  	    * procesarValidarAlerta
  	    * @param  idSol
  	    * @return Response
  	    **/
		public javax.ws.rs.core.Response procesarValidarAlerta( String idSol ){
			   System.out.println( "------- [INICIO] - procesarValidarAlerta -------" );   
			   
			   RespAuditoria objRespAudit = new RespAuditoria();
			   Auditoria     objAudit     = new Auditoria();
			   Response      objResponse  = null;
			   
			   try{
				   //PASOS:
				   //1. Obtener valores de: TB_RESULTADOS cada 20 minutos, que tengan: codeVP & codeVR => 0..
				   //2. Setear estructura en TOPIC.
				   //3. Actualizar campo: eventoEnvio => ENVIADO. 
				   
				   int vEstadoIdSol = Integer.parseInt( this.objUtilLegacy.existeSolicitudEnCadena( idSol ) ); 
				   
				   if( (vEstadoIdSol == 0) ){
					   
					   objAudit.setCodigo( "0" );
					   objAudit.setDescripcion( "Proceso de validación de SOLICITUD: [SI ACEPTADO]." ); 
				   }
				   else{
					   objAudit.setCodigo( "-1" );
					   objAudit.setDescripcion( "Proceso de validación de SOLICITUD: [NO ACEPTADO]." );  
				   }	
				   
				   objRespAudit.setAuditoria( objAudit );	
				   objResponse = Response.ok( objRespAudit ).build(); 
			   }
			   catch( Exception e ) {
				      e.printStackTrace();
				      
					  objAudit.setCodigo( "-1" );
					  objAudit.setDescripcion( "ERROR ENCONTRADO: [" + e.getMessage() + "]" );  
					  
					  objRespAudit.setAuditoria( objAudit );	
					  objResponse = Response.status( 500 ).entity( objAudit ).build();
			   }
			   finally{ 
				       System.out.println( "------- [FIN] - procesarValidarAlerta -------" ); 
			   }
			     
			   return objResponse; 	
		}
		
  	   /**
  	    * procesarObtenerResultados
  	    * @param  idSol
  	    * @return Response
  	    **/
		public javax.ws.rs.core.Response procesarObtenerResultados( String idSol ){
			   System.out.println( "------- [INICIO] - procesarObtenerResultados ??? -------" );   
 		 
			   Statement             objStmt        = null;
			   ResultSet             objRs          = null; 
			   String                vSQL           = null; 
			   Auditoria             objAudit       = new Auditoria();	
			   Response              objResponse    = null;
			   Solicitud             objSoli        = new Solicitud();	
			   Cliente               objCli         = new Cliente();  
			   CreditoHipotecario    objCred        = new CreditoHipotecario();
			   Resultado             objResult      = new Resultado();
			   RespConsultaSolicitud objRespConsSol = null;
			   			   
			   try{ 
				   this.objUtilConexion = new UtilConexion(); 
				   this.objConexion     = this.objUtilConexion.obtenerConexionMYSQL( this.objConexion );
 
	     		   if( this.objConexion != null ){ 
					   System.out.println( "Successfully connected to MYSQL in IBMCLOUD" );
					   System.out.println( "DB version: [" + this.objConexion.getMetaData().getDatabaseProductVersion() + "]" ); 
	     	  					   
					   //---- [BUSCAR REGISTRO EN: 'TB_CLIENTE' & 'TB_CREDITO_HIPOTECARIO' & 'TB_SOLICITUD' & 'TB_RESULTADOS'] ----//
				       vSQL = "SELECT c.dniCli, c.nombresCli, c.apellidoMatCli, c.apellidoPatCli, c.tipoCli, c.correoCli, c.generoCli, "
				       		+ "       ch.tipoCre, ch.montoInicialCre, ch.montoFinanciarCre, ch.plazoMesesCre, ch.sueldoBrutoCre, ch.costoInmuebleCre, ch.tasaCre, "
				       		+ "       s.idCli, s.idCre, "
				       		+ "       r.idSol, r.codeVP, r.detalleVP, r.codeVR, r.detalleVR, r.eventoEnvio "
				       		+ "FROM   ibmclouddb.TB_CLIENTE c, ibmclouddb.TB_CREDITO_HIPOTECARIO ch, ibmclouddb.TB_SOLICITUD s, ibmclouddb.TB_RESULTADOS r "
				       		+ "WHERE  s.idCli  = c.idCli  AND "
				       		+ "       s.idCre  = ch.idCre AND "
				       		+ "       s.idSol  = r.idSol  AND "
				       		+ "       s.idSol  LIKE '" + idSol + "'";  
                       
				       System.out.println( "SQL: [" + vSQL + "]" );
				       
				       objStmt = this.objConexion.createStatement();
				       objRs   = objStmt.executeQuery( vSQL );
				       objStmt.setQueryTimeout( Constantes.MYSQL_TIMEOUT_QUERY ); 
				       
				       System.out.println( "objStmt: [" + objStmt + "]" );
				       System.out.println( "objRs: ["   + objRs   + "]" );
				       System.out.println( "objStmt: [" + objStmt + "]" );
				       
					   //CLIENTE: 
					   String vDniCli         = null;
					   String vNombresCli     = null;
					   String vApellidoMatCli = null;
					   String vApellidoPatCli = null;
					   String vTipoCli        = null;
					   String vCorreoCli      = null;
					   String vGeneroCli      = null;
					   
					   //CREDITO_HIPOTECARIO: 
					   String vTipoCre           = null;
					   double vMontoInicialCre   = 0;
					   double vMontoFinanciarCre = 0;
					   int    vPlazoMesesCre     = 0;
					   double vSueldoBrutoCre    = 0;
					   double vCostoInmuebleCre  = 0;
					   double vTasaCre           = 0;
					   			
					   //TB_SOLICITUD: 
					   int    vIdCli         = 0;
					   int    vIdCre         = 0;
					   
					   //TB_RESULTADOS: 
						   String  vIdSol        = null;
						   String  vCodeVP       = null;
						   String  vDetalleVP    = null;
						   String  vCodeVR       = null;
						   String  vDetalleVR    = null;
						   String  vEventoEnvio  = null;						   		
 
						   for( ;objRs.next(); ){
							    objRespConsSol = new RespConsultaSolicitud(); 
							    objSoli        = new Solicitud();
							    objResult      = new Resultado(); 
							    objCli         = new Cliente();
							    objCred        = new CreditoHipotecario();
							    							    
							    vDniCli            = objRs.getString( 1 );
							    vNombresCli        = objRs.getString( 2 );
							    vApellidoMatCli    = objRs.getString( 3 );
							    vApellidoPatCli    = objRs.getString( 4 );
							    vTipoCli           = objRs.getString( 5 );
							    vCorreoCli         = objRs.getString( 6 );
							    vGeneroCli         = objRs.getString( 7 );
							    
							    vTipoCre           = objRs.getString( 8 );
							    vMontoInicialCre   = objRs.getDouble( 9 );
							    vMontoFinanciarCre = objRs.getDouble( 10 );
							    vPlazoMesesCre     = objRs.getInt( 11 );
							    vSueldoBrutoCre    = objRs.getDouble( 12 );
							    vCostoInmuebleCre  = objRs.getDouble( 13 );
							    vTasaCre           = objRs.getDouble( 14 );
							    
							    vIdCli             = objRs.getInt( 15 );
							    vIdCre             = objRs.getInt( 16 );
							    
							    vIdSol             = objRs.getString( 17 );
							    vCodeVP            = objRs.getString( 18 );
							    vDetalleVP         = objRs.getString( 19 );
							    vCodeVR            = objRs.getString( 20 );
							    vDetalleVR         = objRs.getString( 21 );
							    vEventoEnvio       = objRs.getString( 22 ); 							    							    
 
						    //Objeto: CLIENTE: 
						    objCli.setIdCli( vIdCli + "" );
						    objCli.setDniCli( vDniCli );
						    objCli.setNombresCli( vNombresCli );
						    objCli.setApellidoMatCli( vApellidoMatCli );
						    objCli.setApellidoPatCli( vApellidoPatCli );
						    objCli.setTipoCli(vTipoCli );
						    objCli.setCorreoCli( vCorreoCli ); 
						    objCli.setGeneroCli( vGeneroCli );
						    
						    //Objeto: CREDITO-HIPOTECARIO: 
						    objCred.setIdCre( vIdCre + "" );
						    objCred.setTipoCre( vTipoCre );
						    objCred.setMontoInicialCre( vMontoInicialCre + "" );
						    objCred.setMontoFinanciarCre(vMontoFinanciarCre + "" );
						    objCred.setPlazoMesesCre( vPlazoMesesCre + "" );
						    objCred.setSueldoBrutoCre( vSueldoBrutoCre + "" );
						    objCred.setCostoInmuebleCre( vCostoInmuebleCre + "" );
						    objCred.setTasaCre( vTasaCre + "" );
						    
						    //Objeto: RESULTADO: 
						    objResult.setIdSol( vIdSol );
						    objResult.setCodeVP( vCodeVP );
						    objResult.setDetalleVP( vDetalleVP );
						    objResult.setCodeVR( vCodeVR );
						    objResult.setDetalleVR( vDetalleVR );
						    objResult.setEventoEnvio( vEventoEnvio );
						    
						    //Objeto: SOLICITUD: 
						    objSoli.setCliente( objCli ); 
						    objSoli.setCreditoHipotecario( objCred );  	
						    
						    //Objeto: RESPUESTA-SOLICITUD: 
						    objRespConsSol.setAuditoria( null );
						    objRespConsSol.getListaSolicitud().add( objSoli );
						    objRespConsSol.setResultado( objResult ); 
						    
							System.out.println( "==> vIdCli: [" + vIdCli + "]" );
							System.out.println( "==> vDniCli: [" + vDniCli + "]" ); 
							System.out.println( "==> vNombresCli: [" + vNombresCli + "]" );
							System.out.println( "==> vApellidoMatCli: [" + vApellidoMatCli + "]" );
							System.out.println( "==> vApellidoPatCli: [" + vApellidoPatCli + "]" );
							System.out.println( "==> vTipoCli: [" + vTipoCli + "]" );
							System.out.println( "==> vIdCvCorreoClireGET: [" + vCorreoCli + "]" );
							System.out.println( "==> vGeneroCli: [" + vGeneroCli + "]" );
							System.out.println( "==> vIdCre: [" + vIdCre + "]" );
							System.out.println( "==> vTipoCre: [" + vTipoCre + "]" );
							System.out.println( "==> vMontoInicialCre: [" + vMontoInicialCre + "]" );
							System.out.println( "==> vMontoFinanciarCre: [" + vMontoFinanciarCre + "]" );
							System.out.println( "==> vPlazoMesesCre: [" + vPlazoMesesCre + "]" );
							System.out.println( "==> vSueldoBrutoCre: [" + vSueldoBrutoCre + "]" );
							System.out.println( "==> vCostoInmuebleCre: [" + vCostoInmuebleCre + "]" );
							System.out.println( "==> vTasaCre: [" + vTasaCre + "]" );
							System.out.println( "==> vIdCli: [" + vIdCli + "]" );
							System.out.println( "==> vIdCre: [" + vIdCre + "]" );
							System.out.println( "==> vIdSol: [" + vIdSol + "]" );
							System.out.println( "==> vCodeVP: [" + vCodeVP + "]" );
							System.out.println( "==> vDetalleVP: [" + vDetalleVP + "]" );
							System.out.println( "==> vCodeVR: [" + vCodeVR + "]" );
							System.out.println( "==> vDetalleVR: [" + vDetalleVR + "]" );
							System.out.println( "==> vEventoEnvio: [" + vEventoEnvio + "]" ); 							 
					   } 	 	 
					   
					   objAudit.setCodigo( "0" );
					   objAudit.setDescripcion( "Proceso obtención de datos exitoso." ); 
				   }
				   else{
					    objAudit.setCodigo( "-1" );
					    objAudit.setDescripcion( "Error en el proceso de obtener datos." );  
				   }	
	     		   
	     		   objRespConsSol.setAuditoria( objAudit );	     		  
				   objResponse = Response.ok( objRespConsSol ).build(); 
			   }
			   catch( Exception e ) {
				      e.printStackTrace();
				      
					  objAudit.setCodigo( "-1" );
					  objAudit.setDescripcion( "ERROR ENCONTRADO: [" + e.getMessage() + "]" );  
				  
					  objRespConsSol.setAuditoria( objAudit );	 
					  objResponse = Response.status( 500 ).entity( objRespConsSol ).build();
			   }
			   catch( Throwable e ) {
				      e.printStackTrace();
				      
					  objAudit.setCodigo( "-1" );
					  objAudit.setDescripcion( "ERROR ENCONTRADO: [" + e.getMessage() + "]" );  
				  
					  objRespConsSol.setAuditoria( objAudit );	 
					  objResponse = Response.status( 500 ).entity( objRespConsSol ).build();
			   }
			   finally{ 
				       System.out.println( "------- [FIN] - procesarObtenerResultados ?? -------" ); 
			   }
			     
			   return objResponse; 
		}  
 }

