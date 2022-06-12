package pe.com.ibm.legacy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.enterprise.context.ApplicationScoped;

/**
 * UtilSerializacion
 * @author cguerra
 **/
 @ApplicationScoped
 public class UtilSerializacion{
	   
	   /**
	    * transformaArchivoToBase64 
	    * @param  filePath
	    * @return String
	    * @throws IOException
	    **/
		// Soportado desde java 1.8
		public static String transformaArchivoToBase64( String filePath ) throws IOException{
			String base64 = "";
			File   file   = new File( filePath );
			
			try( FileInputStream fis = new FileInputStream( file ) ){
				 byte fileData[] = new byte[(int) file.length() ];
				 fis.read( fileData );
				 base64 = java.util.Base64.getEncoder().encodeToString( fileData );
			}
			catch( FileNotFoundException e ){
				   throw e;
			}
			catch( IOException ioe ){
				   throw ioe;
			}
			
			return base64;
		}
	   
	   /**
	    * transformaBase64ToArchivo	
	    * @param  base64
	    * @param  pathFile
	    * @throws IOException
	    **/
		//Soportado desde java 1.8
		public static void transformaBase64ToArchivo( String base64, String pathFile ) throws IOException{
			try( FileOutputStream fos = new FileOutputStream( pathFile ) ){
				 byte[] fileData = java.util.Base64.getDecoder().decode(base64);
				 fos.write( fileData );
			}
			catch( FileNotFoundException e ){
				   throw e;
			}
			catch( IOException ioe ){
				   throw ioe;
			}
		}	
	
	   /**
	    * main	
	    * @param argumentos
	    **/
		public static void main( String[] argumentos ){
			   try{
				   String vCertiMySql = transformaArchivoToBase64( "C:\\WORKSPACE_ACE\\MQ\\proy_employee_service_crgaJava\\resources\\certificado-myql.crt" ); 
				   System.out.println( "=> vCertiMySql: [" + vCertiMySql + "]" );
				   
				   //DESENCRIPTA el CERTIFICADO en una RUTA comun fisicamente [/tmp/certificado.crt]: 
				   UtilSerializacion.transformaBase64ToArchivo( Constantes.CADENA_CERTIFICADO_MYSQL_BASE64, Constantes.MYSQL_RUTA_TEMP_CERTI );
			   } 
			   catch( Exception e ){
				      e.printStackTrace(); 
			   }
		}		
		
 }
 
