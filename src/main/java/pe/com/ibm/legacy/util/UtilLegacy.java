package pe.com.ibm.legacy.util;
 
/**
 * UtilLegacy
 * @author cguerra
 **/
 public class UtilLegacy{
 
	   /**
	    * existeEnCadena
	    * @param  vDni
	    * @return String
	    */
		public String existeDniEnCadena( String vDni ){	            
			   System.out.println( "------- [INICIO] - existeDniEnCadena -------" );
 
			    String   vCadenaBDDni = Constantes.BD_CODIGOS_VALIDAR_DNI;
			    String[] vArrayBD     = vCadenaBDDni.split( "\\," );			
			    String   vExiste      = "-1";
				
			    System.out.println( "- DB de DNIs =>: [" + Constantes.BD_CODIGOS_VALIDAR_DNI + "]" );
			    
			    try{					
					for( String vValor : vArrayBD ){ 
						if( vDni.contentEquals( vValor ) ) {
							System.out.println( "- DNI: [" + vDni + "] encontrado en DB." );
							vExiste = "0"; 
						}
					}					
				}
				catch( Exception e ) {
					   System.out.println( "ERROR => " + e.getMessage() ); 
					   e.printStackTrace();
				}
				finally{
				        System.out.println( "------- [FIN] - existeDniEnCadena -------" );
				}
				
				return vExiste;
		}
	 
	   /**
	    * existeClienteEnCadena
	    * @param  vDni
	    * @return String
	    */
		public String existeClienteEnCadena( String vDni ){	            
			   System.out.println( "------- [INICIO] - existeClienteEnCadena -------" );
 
			    String   vCadenaBDDni = Constantes.BD_CODIGOS_VALIDAR_ID_PERSONA; 
			    String[] vArrayBD     = vCadenaBDDni.split( "\\," );			
			    String   vExiste      = "-1";
				
			    System.out.println( "- DB de IdClientes =>: [" + Constantes.BD_CODIGOS_VALIDAR_ID_PERSONA + "]" );
			    
			    try{					
					for( String vValor : vArrayBD ){
						if( vDni.contentEquals( vValor ) ) {
							System.out.println( "- IdCliente: [" + vDni + "] encontrado en DB." );
							vExiste = "0"; 
						}
					}					
				}
				catch( Exception e ) {
					   System.out.println( "ERROR => " + e.getMessage() ); 
					   e.printStackTrace();
				}
				finally{
				        System.out.println( "------- [FIN] - existeClienteEnCadena -------" );
				}
				
				return vExiste;
		}

	   /**
	    * existeSolicitudEnCadena
	    * @param  vIdSoli
	    * @return String
	    */
		public String existeSolicitudEnCadena( String vIdSoli ){	            
			   System.out.println( "------- [INICIO] - existeSolicitudEnCadena -------" );
 
			    String   vCadenaBDDni = Constantes.BD_CODIGOS_VALIDAR_ID_SOLICITUD; 
			    String[] vArrayBD     = vCadenaBDDni.split( "\\," );			
			    String   vExiste      = "-1";
				
			    System.out.println( "- DB de IdSolicitudes =>: [" + Constantes.BD_CODIGOS_VALIDAR_ID_SOLICITUD + "]" );
			    
			    try{					
					for( String vValor : vArrayBD ){
						if( vIdSoli.contentEquals( vValor ) ) {
							System.out.println( "- IdSolicitud: [" + vIdSoli + "] encontrado en DB." );
							vExiste = "0"; 
						}
					}					
				}
				catch( Exception e ) {
					   System.out.println( "ERROR => " + e.getMessage() ); 
					   e.printStackTrace();
				}
				finally{
				        System.out.println( "------- [FIN] - existeSolicitudEnCadena -------" );
				}
				
				return vExiste;
		}
		
 }

