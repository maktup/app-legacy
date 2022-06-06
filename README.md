
IMPORTANTE:
----------
* MICROSERVICIO Dummy para pruebas, que SIMULAN plataforma LEGACY para la presentación E2E.
* VERSION: 1.0 

Los LINKs del 'MICROSERVICIO' son:
---------------------------------

  1. Las 'URI' de tipo [GET] son:
     ---------------------------
  
     - validarRiesgo: 
	   $ curl http://localhost:8080/legacys/get/validarRiesgo/{idCli}/{dniCli}
  
     - validarPersona:  
	   $ curl http://localhost:8080/legacys/get/validarPersona/{idCli}/{dniCli}
 
     - validarAlerta:  
	   $ curl http://localhost:8080/legacys/get/validarAlerta/{idSoli}
 
     - procesarObtenerResultados:  
	   $ curl http://localhost:8080/legacys/get/procesarObtenerResultados/{idSoli}
	   
 
DETALLE:
------- 
* Para INFORMACION interna del MICROSERVICIO, apoyarse en ACTUATOR ingresando a: 'http://localhost:8080/actuator'


BANNERs:
-------
* http://www.patorjk.com/software/taag

