

IMPORTANTE:
----------
* MICROSERVICIO Dummy para pruebas, que SIMULAN plataforma LEGACY para la presentación E2E.
* VERSION: 1.0 

Los LINKs del 'MICROSERVICIO' son:
---------------------------------

  1. Las 'URI' de tipo [GET] son:
     ---------------------------
  
     - validarRiesgo: 
	   $ curl http://localhost:9080/app-legacy/ibm/legacys/get/validarRiesgo/{sueldoBrutoCre}/{plazoMesesCre}/{costoInmuebleCre}/{montoInicialCre}/{montoFinanciarCre}/{tasaCre}
	   
       $ curl http://app-legacy-dummy-liberty.cluster-cla-cp4i-obs-ccc03eca20d26e6ac64511f874a64b9b-0000.us-south.containers.appdomain.cloud/app-legacy/ibm/legacys/get/validarRiesgo/{sueldoBrutoCre}/{plazoMesesCre}/{costoInmuebleCre}/{montoInicialCre}/{montoFinanciarCre}/{tasaCre}
       
     - validarPersona:  
	   $ curl http://localhost:9080/app-legacy/ibm/legacys/get/validarPersona/{idCli}/{dniCli}
	   
       $ curl http://app-legacy-dummy-liberty.cluster-cla-cp4i-obs-ccc03eca20d26e6ac64511f874a64b9b-0000.us-south.containers.appdomain.cloud/app-legacy/ibm/legacys/get/validarPersona/{idCli}/{dniCli}
       
     - validarAlerta:  
	   $ curl http://localhost:9080/app-legacy/ibm/legacys/get/validarAlerta/{idSoli}
	   
       $ curl http://app-legacy-dummy-liberty.cluster-cla-cp4i-obs-ccc03eca20d26e6ac64511f874a64b9b-0000.us-south.containers.appdomain.cloud/app-legacy/ibm/legacys/get/validarAlerta/{idSoli}
       
     - procesarObtenerResultados:  
	   $ curl http://localhost:9080/app-legacy/ibm/legacys/get/obtenerResultados/{idSoli}
	   
       $ curl http://app-legacy-dummy-liberty.cluster-cla-cp4i-obs-ccc03eca20d26e6ac64511f874a64b9b-0000.us-south.containers.appdomain.cloud/app-legacy/ibm/legacys/get/obtenerResultados/{idSoli} 
      	    
       	    
DETALLE:
------- 
* Para INFORMACION interna del MICROSERVICIO, apoyarse en ACTUATOR ingresando a: 
  http://localhost:8080/actuator
  http://app-legacy-dummy-liberty.cluster-cla-cp4i-obs-ccc03eca20d26e6ac64511f874a64b9b-0000.us-south.containers.appdomain.cloud/actuator

BANNERs:
-------
* http://www.patorjk.com/software/taag



DESPLIEGUE OPENSHIFT CON DOCKER:
--------------------------------
$ docker build -t app-legacy .
$ docker run -i --rm -p 9080:9080 app-legacy

http://localhost:9080/openapi
http://localhost:9080/openapi/ui/



DESPLIEGUE OPENSHIFT CON LIBERTY:
--------------------------------

1. 'GENERACIÓN DE IMAGE-STREAM':

$ oc delete imagestream.image.openshift.io app-legacy -n dummy-liberty
$ oc import-image app-legacy --from=docker.io/maktup/app-legacy:latest --confirm -n dummy-liberty
$ oc get imagestream.image.openshift.io app-legacy -n dummy-liberty


2. 'DESPLEIGUE EN LIBERTY-SERVER':

apiVersion: apps.openliberty.io/v1beta2
kind: OpenLibertyApplication
metadata:
  name: app-legacy
  namespace: dummy-liberty
spec:
  applicationImage: image-registry.openshift-image-registry.svc:5000/dummy-liberty/app-legacy
  expose: true
  replicas: 1

