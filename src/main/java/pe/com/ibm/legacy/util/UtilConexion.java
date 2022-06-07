package pe.com.ibm.legacy.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
			     
	           File   objArchivoTemp       = null;	  
	           String vRutaArchivoTemporal = null;
	            
			   try{   
			       this.leerDatosDeArchivoJAR( Constantes.MYSQL_RUTA_CERTI, Constantes.MYSQL_RUTA_TEMP_CERTI ); 			    	
			       objArchivoTemp = new File(  Constantes.MYSQL_RUTA_TEMP_CERTI );
			        
			       vRutaArchivoTemporal = objArchivoTemp.getAbsolutePath(); 
		           System.out.println( "vRutaArchivoTemporal: [" + vRutaArchivoTemporal + "]" );
		         		            
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
		    	        objArchivoTemp.delete();		    	        
		    		    System.out.println( "------------- [FIN] - [obtenerConexionMYSQL] -------------" );				    	  		        
		         } 
			    
			     return objConexion;
	    }		
    
	   /**
	    * leerDatosDeArchivoJAR	
	    * @param  nombreCertificado
	    * @param  vRutaCertificadoOutput
	    * @return String 
	    **/
	    private void leerDatosDeArchivoJAR( String nombreCertificado, String vRutaCertificadoOutput ){
	    	   System.out.println( "------------- [INICIO] - [leerDatosDeArchivoJAR] -------------" );
	    	
	    	   InputStream  objIS = null;  
	    	   OutputStream objOS = null;  
	    	   
	    	   try{
		           objIS = this.getClass().getResourceAsStream( nombreCertificado ); //new FileInputStream(  "/Users/source.txt" );
		           objOS = new FileOutputStream( vRutaCertificadoOutput );

		           byte[] objBuffer = new byte[ 1024 ]; 
		           int    vBytesLeer; 
 
		           for( ;(vBytesLeer = objIS.read( objBuffer ) ) != -1; ){
		                objOS.write( objBuffer, 0, vBytesLeer );
		           }
		         
		           objIS.close(); 
		           objOS.flush();
		           objOS.close(); 
		      } 
		      catch( Exception e ){
		             e.printStackTrace();
		      } 
	    	  finally{
	    		      System.out.println( "------------- [FIN] - [leerDatosDeArchivoJAR] -------------" ); 
	    	  }
	    }	   
	    
 }
 
