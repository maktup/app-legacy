package pe.com.ibm.legacy.util;

import javax.enterprise.context.ApplicationScoped;

/**
 * Constantes
 * @author cguerra
 **/
 @ApplicationScoped
 public class Constantes{
        
	    //------------------ [BD-HARDCODE] ------------------//
		public static String  BD_CODIGOS_VALIDAR_ID_PERSONA   = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20";
		public static String  BD_CODIGOS_VALIDAR_DNI          = "41816133,41816155,42316133,41676133,41816129,41816156,42316133,41556133,4181783,43716133,41867133,42181678";
		public static String  BD_CODIGOS_VALIDAR_ID_SOLICITUD = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20";
				
        
	    //------------------ [MYSQL] ------------------//
		public static String  MYSQL_USUARIO              = "5d24b0ab84274745ab8a2601689ef88d";
		public static String  MYSQL_PASSWORD             = "4df8cd6a38a32169ac854de699dcb1b2eacac987ce398a177f4092b0ea1f6366";
		public static String  MYSQL_HOST                 = "7af86fbb-cb51-47d5-87d2-ad70fb3c222c.c38qvnlz04atmdpus310.databases.appdomain.cloud";
		public static Integer MYSQL_PUERTO               = 32492;
		public static String  MYSQL_BD                   = "ibmclouddb";		
		public static String  MYSQL_URL                  = "jdbc:mysql://" + MYSQL_HOST + ":" + MYSQL_PUERTO + "/" + MYSQL_BD + "?verifyServerCertificate=false&useSSL=true&requireSSL=true";		
		public static String  MYSQL_RUTA_CERTI           = "/resources/certificado-myql.crt";  
		public static String  MYSQL_RUTA_TEMP_CERTI      = "C:\\home\\aceuser\\certificadoNew.crt";  //IMPORTANTE ==> DESPLIEGUE EN [LOCAL].
		//public static String  MYSQL_RUTA_TEMP_CERTI      = "/home/aceuser/certificadoNew.crt";       //IMPORTANTE ==> DESPLIEGUE EN [OPENSHIFT].
		public static String  MYSQL_CLAVE_CERTI          = "mariadb";	                         	
		public static String  MYSQL_DRIVERCLASS          = "org.mariadb.jdbc.Driver";
		public static String  MYSQL_QUERY                = "SELECT ID, NUM_TARJETA, NUM_CUENTA FROM ibmclouddb.TB_DUMMY_02;";
		public static int     MYSQL_TIMEOUT_QUERY        = 10;
		
 }
