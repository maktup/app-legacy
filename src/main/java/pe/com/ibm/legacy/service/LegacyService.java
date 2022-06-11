package pe.com.ibm.legacy.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import pe.com.ibm.legacy.bean.Alerta;
import pe.com.ibm.legacy.bean.Auditoria;
import pe.com.ibm.legacy.bean.Cliente;
import pe.com.ibm.legacy.bean.CreditoHipotecario;
import pe.com.ibm.legacy.bean.RespAlerta;
import pe.com.ibm.legacy.bean.RespAuditoria;
import pe.com.ibm.legacy.bean.Solicitud;
import pe.com.ibm.legacy.util.Constantes;
import pe.com.ibm.legacy.util.UtilConexion;
import pe.com.ibm.legacy.util.UtilLegacy;

/**
 * ClienteService 
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
				   double vSueldoNetro           = (sueldoBrutoCre * 0.7);
				   double vDivisionDeuda         = (vSueldoNetro * 0.6); 
				
				   double vValorDeuda            = (montoFinanciarCre + tasaCre);
				   double vMontoMaximoEndeudable = (vValorDeuda / plazoMesesCre);
				   
				   System.out.println( "=> vSueldoNetro: ["   + vSueldoNetro   + "]" );
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
			   System.out.println( "------- [INICIO] - procesarObtenerResultados -------" );   
 		 
			   Statement          objStmt      = null;
			   ResultSet          objRs        = null;
			   int                vTimeOut     = 5;
			   String             vSQL         = Constantes.MYSQL_QUERY;
			   RespAlerta         objRespAler  = new RespAlerta();
			   Auditoria          objAudit     = new Auditoria();	
			   Response           objResponse  = null;
			   Alerta             objAler      = new Alerta(); 
			   Solicitud          objSoli      = new Solicitud();	
			   Cliente            objCli       = new Cliente();  
			   CreditoHipotecario objCred      = new CreditoHipotecario();
			   
			   try{ 
				   this.objUtilConexion = new UtilConexion(); 
				   this.objConexion     = this.objUtilConexion.obtenerConexionMYSQL( this.objConexion );
 
	     		   if( this.objConexion != null ){ 
					   System.out.println( "Successfully connected to MYSQL in IBMCLOUD" );
					   System.out.println( "DB version: [" + this.objConexion.getMetaData().getDatabaseProductVersion() + "]" ); 
	     	          
					   //---------------------//
					   //LOGICA
					   
					   if( objConexion != null ){
						   System.out.println( "Successfully connected to MARIABD in IBMCLOUD" );
						   System.out.println( "DB version: [" + objConexion.getMetaData().getDatabaseProductVersion() + "]" ); 
	 
						   objStmt = objConexion.createStatement();
					       objRs   = objStmt.executeQuery( vSQL );
					       objStmt.setQueryTimeout( vTimeOut ); 
					     
					       for( ;objRs.next(); ){
							    System.out.println( "==>: " + objRs.getString( 1 ) );
							    System.out.println( "==>: " + objRs.getString( 2 ) );
							    System.out.println( "==>: " + objRs.getString( 3 ) ); 
						   }					 
					   }					   
					   //---------------------//
					   
					   objAudit.setCodigo( "0" );
					   objAudit.setDescripcion( "Proceso de validación de SOLICITUD: [SI ACEPTADO]." ); 
				   }
				   else{
					   objAudit.setCodigo( "-1" );
					   objAudit.setDescripcion( "Proceso de validación de SOLICITUD: [NO ACEPTADO]." );  
				   }	
	     		   
	     		   objSoli.setCliente( objCli );
	     		   objSoli.setCreditoHipotecario( objCred );
	     		   
	     		   objRespAler.setAlerta( objAler );
	     		   objRespAler.setAuditoria( objAudit );	
	     		   objRespAler.setSolicitud( objSoli );
	     		  
				   objResponse = Response.ok( objRespAler ).build(); 
			   }
			   catch( Exception e ) {
				      e.printStackTrace();
				      
					  objAudit.setCodigo( "-1" );
					  objAudit.setDescripcion( "ERROR ENCONTRADO: [" + e.getMessage() + "]" );  
				 
		     		  objSoli.setCliente( objCli );
		     		  objSoli.setCreditoHipotecario( objCred );
		     		  
		     		  objRespAler.setAlerta( objAler );
		     		  objRespAler.setAuditoria( objAudit );	
		     		  objRespAler.setSolicitud( objSoli );	
					  objResponse = Response.status( 500 ).entity( objRespAler ).build();
			   }
			   finally{ 
				       System.out.println( "------- [FIN] - procesarObtenerResultados -------" ); 
			   }
			     
			   return objResponse; 
		}  
 }

