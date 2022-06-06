package pe.com.ibm.legacy.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response; 
import pe.com.ibm.legacy.service.LegacyService;
import javax.inject.Inject;

/**
 * LegacyController
 * @author cguerra
 **/
@Path( "/legacys" )
public class LegacyController{
 
    @Inject
    private LegacyService clienteService;
    
   /** 
    * validarRiesgo	
    * @param  idCli
    * @param  dniCli
    * @return Response 
    **/
    @GET
    @Path( "/get/validarRiesgo/{idCli}/{dniCli}" )
    @Produces( { MediaType.APPLICATION_JSON } )
	public Response validarRiesgo( @PathParam( "idCli" ) String idCli, @PathParam( "dniCli" ) String dniCli ){
		   System.out.println( "------- [INICIO] - validarRiesgo: [" + "idCli=" + idCli + ", dniCli=" + dniCli + "] -------" );   

		   String objResponseMsg = "";
		   
		   try{ 
			   Response objRespuesta = this.clienteService.procesarValidarRiesgo( idCli, dniCli );			   
			   return objRespuesta;
		   }
		   catch( Exception e ) { 
			      e.printStackTrace();
			      return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).entity( objResponseMsg ).build();
		   }	
		   catch( Throwable e ) { 
			      e.printStackTrace();
			      return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).entity( objResponseMsg ).build();
		   }	
		   finally{
			       System.out.println( "------- [FIN] - validarRiesgo] -------" );   
		   }
	} 
     
    /** 
     * validarPersona	
     * @param  idCli
     * @param  dniCli
     * @return Response 
     **/
     @GET
     @Path( "/get/validarPersona/{idCli}/{dniCli}" )
     @Produces( { MediaType.APPLICATION_JSON } )
	 public Response validarPersona( @PathParam( "idCli" ) String idCli, @PathParam( "dniCli" ) String dniCli ){
		   System.out.println( "------- [INICIO] - validarPersona: [" + "idCli=" + idCli + ", dniCli=" + dniCli + "] -------" );   

		   String objResponseMsg = "";
		   
		   try{ 
			   Response objRespuesta = this.clienteService.procesarValidarPersona( idCli, dniCli );			   
			   return objRespuesta;
		   }
		   catch( Exception e ) { 
			      e.printStackTrace();
			      return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).entity( objResponseMsg ).build();
		   }	
		   catch( Throwable e ) { 
			      e.printStackTrace();
			      return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).entity( objResponseMsg ).build();
		   }	
		   finally{
			       System.out.println( "------- [FIN] - validarPersona] -------" );   
		   }
	}     
    
    /** 
     * validarAlerta	
     * @param  idCli
     * @param  dniCli
     * @return Response 
     **/
     @GET
     @Path( "/get/validarAlerta/{idSoli}" )
     @Produces( { MediaType.APPLICATION_JSON } )
 	 public Response validarAlerta( @PathParam( "idSoli" ) String idSoli ){
 		   System.out.println( "------- [INICIO] - validarAlerta: [" + "idSoli=" + idSoli + "] -------" );   

 		   String objResponseMsg = "";
 		   
 		   try{ 
 			   Response objRespuesta = this.clienteService.procesarValidarAlerta( idSoli );			   
 			   return objRespuesta;
 		   }
 		   catch( Exception e ) { 
 			      e.printStackTrace();
 			      return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).entity( objResponseMsg ).build();
 		   }	
 		   catch( Throwable e ) { 
 			      e.printStackTrace();
 			      return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).entity( objResponseMsg ).build();
 		   }	
 		   finally{
 			       System.out.println( "------- [FIN] - validarAlerta] -------" );   
 		   }
 	} 
     	 	     
   /** 
    * validarAlerta	
	* @param  idCli
	* @param  dniCli
	* @return Response 
	**/
	@GET
	@Path( "/get/obtenerResultados/{idSoli}" )
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response obtenerResultados( @PathParam( "idSoli" ) String idSoli ){
		   System.out.println( "------- [INICIO] - obtenerResultados: [" + "idSoli=" + idSoli + "] -------" );   

  		   String objResponseMsg = "";
  		   
  		   try{ 
  			   Response objRespuesta = this.clienteService.procesarObtenerResultados( idSoli );			   
  			   return objRespuesta;
  		   }
  		   catch( Exception e ) { 
  			      e.printStackTrace();
  			      return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).entity( objResponseMsg ).build();
  		   }	
  		   catch( Throwable e ) { 
  			      e.printStackTrace();
  			      return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).entity( objResponseMsg ).build();
  		   }	
  		   finally{
  			       System.out.println( "------- [FIN] - obtenerResultados] -------" );   
  		   }
  	}      
     
  }

