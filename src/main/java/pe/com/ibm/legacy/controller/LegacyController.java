package pe.com.ibm.legacy.controller;
 
import javax.inject.Inject;
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
import pe.com.ibm.legacy.bean.RespAuditoria;
import pe.com.ibm.legacy.bean.RespConsultaSolicitud; 
import pe.com.ibm.legacy.service.LegacyService;

/**
 * LegacyController
 * @author cguerra
 **/
@Path( "legacys" )
public class LegacyController{
 
     @Inject
     private LegacyService clienteService; 
 
   /** 
    * validarRiesgo	
    * @param  sueldoBrutoCre
    * @param  plazoMesesCre
    * @param  costoInmuebleCre
    * @param  montoInicialCre
    * @param  montoFinanciarCre
    * @param  tasaCre
    * @return Response 
    **/
    @GET
	@Path( "/get/validarRiesgo/{sueldoBrutoCre}/{plazoMesesCre}/{costoInmuebleCre}/{montoInicialCre}/{montoFinanciarCre}/{tasaCre}")
	@Produces( { MediaType.APPLICATION_JSON } ) 
    @APIResponse(
            responseCode = "404",
            description  = "Error en el envio de datos",
            content      = @Content( mediaType = "application/json" ) ) 
    @APIResponseSchema( 
    		value               = RespAuditoria.class,
            responseDescription = "Proceso Exitoso.",
            responseCode        = "200")
    @Operation(
            summary     = "Operacion para la validarRiesgo.",
            description = "Operacion para la validarRiesgo." )	     
	public Response validarRiesgo( @PathParam( "sueldoBrutoCre" ) String sueldoBrutoCre, @PathParam( "plazoMesesCre" ) String plazoMesesCre, @PathParam( "costoInmuebleCre" ) String costoInmuebleCre, @PathParam( "montoInicialCre" ) String montoInicialCre, @PathParam( "montoFinanciarCre" ) String montoFinanciarCre, @PathParam( "tasaCre" ) String tasaCre ){  
		   System.out.println( "------- [INICIO] - validarRiesgo: [" + "sueldoBrutoCre=" + sueldoBrutoCre + ", plazoMesesCre=" + plazoMesesCre + ", costoInmuebleCre=" + costoInmuebleCre + ", montoInicialCre=" + montoInicialCre + ", montoFinanciarCre=" + montoFinanciarCre + ", tasaCre=" + tasaCre + "] -------" );
	        
		   String objResponseMsg = "";
		   
		   try{ 
			   double vSueldoBrutoCre    = Double.parseDouble( sueldoBrutoCre );
			   int    vPlazoMesesCre     = Integer.parseInt(   plazoMesesCre  );
			   double vCostoInmuebleCre  = Double.parseDouble( costoInmuebleCre  );
			   double vMontoInicialCre   = Double.parseDouble( montoInicialCre   );
			   double vMontoFinanciarCre = Double.parseDouble( montoFinanciarCre );
			   double vTasaCre           = Double.parseDouble( tasaCre );
			   
			   Response objRespuesta = this.clienteService.procesarValidarRiesgo( vSueldoBrutoCre, vPlazoMesesCre, vCostoInmuebleCre, vMontoInicialCre, vMontoFinanciarCre,vTasaCre );			   
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
     		value               = RespAuditoria.class,
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
    * obtenerResultados	
  	* @return Response 
  	**/
  	@GET
  	@Path( "/get/obtenerResultados" )
  	@Produces( { MediaType.APPLICATION_JSON } )
      @APIResponse(
              responseCode = "404",
              description  = "Error en el envio de datos",
              content      = @Content( mediaType = "application/json" ) ) 
      @APIResponseSchema( 
      		value               = RespConsultaSolicitud.class,
              responseDescription = "Proceso Exitoso.",
              responseCode        = "200")
      @Operation(
              summary     = "Operacion para la obtenerResultados.",
              description = "Operacion para la obtenerResultados." )  
  	public Response obtenerResultados(){
  		   System.out.println( "------- [INICIO] - obtenerResultados: -------" );   

    		   String objResponseMsg = "";
    		   
    		   try{ 
    			   Response objRespuesta = this.clienteService.procesarObtenerResultados( null );			   
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
     
   /** 
    * obtenerResultados	
	* @param  idSoli
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
    		value               = RespConsultaSolicitud.class,
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

