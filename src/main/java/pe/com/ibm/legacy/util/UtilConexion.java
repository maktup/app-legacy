package pe.com.ibm.legacy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.enterprise.context.ApplicationScoped;

/**
 * UtilConexion
 * @author cguerra
 **/
 @ApplicationScoped
 public class UtilConexion{
 
	   /**
	    * obtenerConexionMYSQL
	    * @param  objConexion
	    * @return Connection	
	    **/
	    public Connection obtenerConexionMYSQL( Connection objConexion ){
	           System.out.println( "------------- [INICIO] - [obtenerConexionMYSQL] -------------" );
 	  
	           String vRutaArchivoTemporal = null;
	            
			   try{ 
				   vRutaArchivoTemporal = Constantes.MYSQL_RUTA_TEMP_CERTI;  
				   System.out.println( "vRutaArchivoTemporal: [" + vRutaArchivoTemporal + "]" );
				   
				   //DESENCRIPTA el CERTIFICADO en una RUTA comun fisicamente [/tmp/certificado.crt]: 
				   UtilSerializacion.transformaBase64ToArchivo( Constantes.CADENA_CERTIFICADO_BASE64, vRutaArchivoTemporal );
 
				   System.setProperty( "javax.net.ssl.keyStore",           vRutaArchivoTemporal );
				   System.setProperty( "javax.net.ssl.keyStorePassword",   Constantes.MYSQL_CLAVE_CERTI ); 
				   System.setProperty( "javax.net.ssl.trustStore",         vRutaArchivoTemporal );
				   System.setProperty( "javax.net.ssl.trustStorePassword", Constantes.MYSQL_CLAVE_CERTI );  				 
				   System.out.println( "======> vURL: [" + Constantes.MYSQL_URL + "]" );
					
				   Class.forName( Constantes.MYSQL_DRIVERCLASS ).newInstance();			
			       objConexion = DriverManager.getConnection( Constantes.MYSQL_URL, Constantes.MYSQL_USUARIO, Constantes.MYSQL_PASSWORD ); 
				   System.out.println( "======> objConexion: [" + objConexion + "]" ); 
				} 
				catch( Exception e ){ 
				       e.printStackTrace();
				} 
				catch( Throwable e ){ 
					   e.printStackTrace();
				} 
				finally{  	    	        
		    		    System.out.println( "------------- [FIN] - [obtenerConexionMYSQL] -------------" );				    	  		        
		         } 
			    
			     return objConexion;
	    }		
  
 }
 
