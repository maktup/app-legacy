package pe.com.ibm.legacy.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.sql.Connection; 
import javax.ws.rs.core.Response;
import pe.com.ibm.legacy.bean.Auditoria;
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
  	    * @param  idCli
  	    * @param  dniCli
  	    * @return Response
  	    **/
		public javax.ws.rs.core.Response procesarValidarRiesgo( String idCli, String dniCli ){
			   System.out.println( "------- [INICIO] - procesarValidarRiesgo -------" );   
			   
			   Auditoria objAudit    = new Auditoria();			   
			   Response  objResponse = null;
			   
			   try{				   
				   int vEstadoDni   = Integer.parseInt( this.objUtilLegacy.existeDniEnCadena( dniCli ) );
				   int vEstadoIdCli = Integer.parseInt( this.objUtilLegacy.existeClienteEnCadena( idCli ) ); 
				   
				   if( (vEstadoDni == 0) && (vEstadoIdCli == 0) ){
					   
					   objAudit.setCodigo( "0" );
					   objAudit.setDescripcion( "Proceso de validación de RIESGO: [SI ACEPTADO]." ); 
				   }
				   else{
					   objAudit.setCodigo( "-1" );
					   objAudit.setDescripcion( "Proceso de validación de RIESGO: [NO ACEPTADO]." );  
				   }		
			   }
			   catch( Exception e ) {
				      e.printStackTrace();
				      
					  objAudit.setCodigo( "-1" );
					  objAudit.setDescripcion( "ERROR ENCONTRADO: [" + e.getMessage() + "]" );  
			   }
			   finally{
				       objResponse = Response.ok( objAudit ).build(); 
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
			   
			   Auditoria objAudit    = new Auditoria();			   
			   Response  objResponse = null;
			   
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
			   }
			   catch( Exception e ) {
				      e.printStackTrace();
				      
					  objAudit.setCodigo( "-1" );
					  objAudit.setDescripcion( "ERROR ENCONTRADO: [" + e.getMessage() + "]" );  
			   }
			   finally{
				       objResponse = Response.ok( objAudit ).build(); 
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
			   
			   Auditoria objAudit    = new Auditoria();			   
			   Response  objResponse = null;
			   
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
			   }
			   catch( Exception e ) {
				      e.printStackTrace();
				      
					  objAudit.setCodigo( "-1" );
					  objAudit.setDescripcion( "ERROR ENCONTRADO: [" + e.getMessage() + "]" );  
			   }
			   finally{
				       objResponse = Response.ok( objAudit ).build(); 
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
			   
			   Auditoria objAudit    = new Auditoria();			   
			   Response  objResponse = null;
			   
			   try{		
				   this.objUtilConexion = new UtilConexion(); 
				   this.objConexion     = this.objUtilConexion.obtenerConexionMYSQL( this.objConexion );
 
	     		   if( this.objConexion != null ){ 
					   System.out.println( "Successfully connected to MYSQL in IBMCLOUD" );
					   System.out.println( "DB version: [" + this.objConexion.getMetaData().getDatabaseProductVersion() + "]" ); 
	     	          
					   //---------------------//
					   //LOGICA
					   
					   //---------------------//
					   
					   objAudit.setCodigo( "0" );
					   objAudit.setDescripcion( "Proceso de validación de SOLICITUD: [SI ACEPTADO]." ); 
				   }
				   else{
					   objAudit.setCodigo( "-1" );
					   objAudit.setDescripcion( "Proceso de validación de SOLICITUD: [NO ACEPTADO]." );  
				   }		
			   }
			   catch( Exception e ) {
				      e.printStackTrace();
				      
					  objAudit.setCodigo( "-1" );
					  objAudit.setDescripcion( "ERROR ENCONTRADO: [" + e.getMessage() + "]" );  
			   }
			   finally{
				       objResponse = Response.ok( objAudit ).build(); 
				       System.out.println( "------- [FIN] - procesarObtenerResultados -------" ); 
			   }
			     
			   return objResponse; 	
		} 
 
 }

