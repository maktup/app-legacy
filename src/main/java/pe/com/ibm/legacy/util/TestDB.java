package pe.com.ibm.legacy.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
/**
 * TestDB 
 * @author TestDB
 **/
 public class TestDB{
	  
	   /**
	    * main 	
	    * @param argumentos
	    **/
		public static void main( String[] argumentos ){
		   	   TestDB x = new TestDB();
			   Connection objConexion = null;
			   objConexion = x.obtenerConexionMYSQL( objConexion );
			   System.out.println( "======> objConexion: [" + objConexion + "]" );	
		}
	
	   /**
	    * obtenerConexionMYSQL
	    * @param  objConexion
	    * @return Connection	
	    **/
		public Connection obtenerConexionMYSQL( Connection objConexion ){
	            System.out.println( "------------- [INICIO] - [obtenerConexionMYSQL] -------------" );
	 		 
	            File      objJKS    = null;			 
				Statement objStmt   = null;
				ResultSet objRs     = null;
				String    vSQL      = Constantes.MYSQL_QUERY;
				int       vTimeOut  = 5;
				String    vRutaTemp = "";
				
				try{
					objJKS    = new File( "C:\\WORKSPACE_JAVA\\QUARKUS\\app-legacy\\src\\main\\resources\\certificado-myql.crt" );
 					vRutaTemp = objJKS.getAbsolutePath(); 					
					System.out.println( "vRutaTemp: [" + vRutaTemp + "]" );
					
					System.setProperty( "javax.net.ssl.keyStore",           vRutaTemp );
					System.setProperty( "javax.net.ssl.keyStorePassword",   Constantes.MYSQL_CLAVE_CERTI ); 
					System.setProperty( "javax.net.ssl.trustStore",         vRutaTemp  );
					System.setProperty( "javax.net.ssl.trustStorePassword", Constantes.MYSQL_CLAVE_CERTI );  				 
					System.out.println( "======> vURL: [" + Constantes.MYSQL_URL + "]" );
					
					Class.forName( Constantes.MYSQL_DRIVERCLASS ).newInstance();			
			        objConexion = DriverManager.getConnection( Constantes.MYSQL_URL, Constantes.MYSQL_USUARIO, Constantes.MYSQL_PASSWORD ); 
					System.out.println( "======> objConexion: [" + objConexion + "]" );	 
					
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
				 } 
				 catch( Exception e ){ 
				 	    e.printStackTrace();
				 } 
				 catch( Throwable e ){ 
					    e.printStackTrace();
				 } 
				 finally{
				         if( objConexion != null ){			    	
				    	     try{
				    		     objConexion.close();
				    		     System.out.println( "------------- [FIN] - [obtenerConexionMYSQL] -------------" );
				    	     } 
				    	     catch ( Exception e ){
				    	     }
				         }
		         } 
			    
			     return objConexion;
	     }	
 }
