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
		public static String  MYSQL_RUTA_TEMP_CERTI      = "/tmp/certificado.crt";
		public static String  MYSQL_CLAVE_CERTI          = "mariadb";	                         	
		public static String  MYSQL_DRIVERCLASS          = "org.mariadb.jdbc.Driver";
		public static String  MYSQL_QUERY                = "SELECT ID, NUM_TARJETA, NUM_CUENTA FROM ibmclouddb.TB_DUMMY_02;";
		public static int     MYSQL_TIMEOUT_QUERY        = 10;
       		
		//----------------- [BASE64] -----------------//
		
		//IMPORTANTE: el contenido del: [certificado-myql.crt] se debe TRANSFORMAR a CADENA: 
	    public static String CADENA_CERTIFICADO_BASE64   = "/u3+7QAAAAIAAAABAAAAAgAHbWFyaWFkYgAAAYESya7sAAVYLjUwOQAAA60wggOpMIICkaADAgECAgkAjdDOe/R2Q2AwDQYJKoZIhvcNAQELBQAwHjEcMBoGA1UEAxMTSUJNIENsb3VkIERhdGFiYXNlczAeFw0yMTA3MDgxMDA0MjhaFw0zMTA3MDYxMDA0MjhaMB4xHDAaBgNVBAMTE0lCTSBDbG91ZCBEYXRhYmFzZXMwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCtjVFZhwgwo6IgllAiJb+daBSajPNsyjUiAd9YON2iSvu5RXwvkQs7IpKwfjEqOd5/RB0SC3+HvYCtqm3a6Ma01RR3qRb7NInfbhPUvQBoP2v/JTXK1fQbIXvafPILoxkQrfOZ9S4yKNqfa0vDRSqNZUxfoazmCgRBA64XKnsEEXn8N6bPK6u+CutUxRVs/Ed5WtBEBPniWPpAspUaD3QE8HII03tyCcyy5c3Kh4LA527/oUJUAbiwdaRP/RES4zg8jvRoxVodYXKsDLkgyqRfoWjW7cWolmruUO/YJTRXnFtVCszUK52+xUi9Y0cGo8G19rbsbWvgS5o7zfbONI2RAgMBAAGjgekwgeYwHQYDVR0OBBYEFIXh7AayqtmdHgLzvPLWk1HRAqrZME4GA1UdIwRHMEWAFIXh7AayqtmdHgLzvPLWk1HRAqrZoSKkIDAeMRwwGgYDVQQDExNJQk0gQ2xvdWQgRGF0YWJhc2VzggkAjdDOe/R2Q2AwDwYDVR0TAQH/BAUwAwEB/zARBglghkgBhvhCAQEEBAMCAQYwCQYDVR0SBAIwADArBglghkgBhvhCAQ0EHhYcVGlueUNBIEdlbmVyYXRlZCBDZXJ0aWZpY2F0ZTAJBgNVHREEAjAAMA4GA1UdDwEB/wQEAwICBDANBgkqhkiG9w0BAQsFAAOCAQEASEpYL8cucDgFJxDIvUMQA6byIi3cl4OxqymnG5yEW/n/KMT4CDZWpGf5Qh1AuuIqGyulnsBRzL8snWoyhM4IpYCIBgIxeIsspTlj5Qn7m4Q/ZMn4gYiHK0+28rR39lfZ4zncTOYEhNE8pJQh1SdLebpnL9TvhfTfwKAcXFscu0uSJQYLXXbvEqpjR5A6IEo02drC8i308mPavDiQ8xL8XXi3bv5cStj8WZMd4ls5ifZrmKzKOyva2Q1BNNzf0Erts0oVrwJkLQuuAtaRagwoJzLUPhtg5sD5RVVWVWILoIGalXtqEa400FQO6IgxVgEyEl+XWRcZgLU5wbwrITlUr4QwAH2MpXbf4Fq/a9WQO8Zlc8cG"; 
 	
 }
