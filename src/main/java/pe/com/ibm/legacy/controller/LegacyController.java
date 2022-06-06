package pe.com.ibm.legacy.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import pe.com.ibm.legacy.bean.Auditoria;
import pe.com.ibm.legacy.service.LegacyService;
import javax.inject.Inject;

/**
 * LegacyController
 * @author cguerra
 **/
@Path( "legacys" )
public class LegacyController{
 
    @Inject
    private LegacyService clienteService;
        
   /** 
    * validarPersona	
    * @param  idCli
    * @param  dniCli
    * @return Response 
    **/
    @GET
	@Path( "/get/validarRiesgo/{idCli}/{dniCli}")
	@Produces( { MediaType.APPLICATION_JSON } ) 
    @APIResponse(
            responseCode = "404",
            description  = "Error en el envio de datos",
            content      = @Content( mediaType = "application/json" ) ) 
    @APIResponseSchema( 
    		value               = Auditoria.class,
            responseDescription = "Proceso Exitoso.",
            responseCode        = "200")
    @Operation(
            summary     = "Operacion para la validarRiesgo.",
            description = "Operacion para la validarRiesgo." )	     
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
     @APIResponse(
             responseCode = "404",
             description  = "Error en el envio de datos",
             content      = @Content( mediaType = "application/json" ) ) 
     @APIResponseSchema( 
     		value               = Auditoria.class,
             responseDescription = "Proceso Exitoso.",
             responseCode        = "200")
     @Operation(
             summary     = "Operacion para la validarPersona.",
             description = "Operacion para la validarPersona." ) 
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
     @APIResponse(
             responseCode = "404",
             description  = "Error en el envio de datos",
             content      = @Content( mediaType = "application/json" ) ) 
     @APIResponseSchema( 
     		value               = Auditoria.class,
             responseDescription = "Proceso Exitoso.",
             responseCode        = "200")
     @Operation(
             summary     = "Operacion para la validarAlerta.",
             description = "Operacion para la validarAlerta." )     
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
    @APIResponse(
            responseCode = "404",
            description  = "Error en el envio de datos",
            content      = @Content( mediaType = "application/json" ) ) 
    @APIResponseSchema( 
    		value               = Auditoria.class,
            responseDescription = "Proceso Exitoso.",
            responseCode        = "200")
    @Operation(
            summary     = "Operacion para la obtenerResultados.",
            description = "Operacion para la obtenerResultados." )  
	
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

