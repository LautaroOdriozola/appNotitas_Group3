package src.main.java.requestService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

/* Recursos a utilizar
*  http://notitas.herokuapp.com/student (put)
*  http://notitas.herokuapp.com/student (get)
*  http://notitas.herokuapp.com/student/assignments (get)
* */

public class RequestService {
    private Client client;
    private static final String API_NOTITAS = "hhttp://notitas.herokuapp.com/GET";
    private static final String RESOURCE_STUDENT = "student";
    private static final String RESOURCE_ASSIGMENTS = "student/assignments";

    //Inicializacion del cliente.
    public RequestService() {
        this.client = Client.create();
    }

    public String getDatosAlumno(String body, String token){
        ClientResponse responseDatosAlumno = this.client.resource(API_NOTITAS).path(RESOURCE_STUDENT)
        		.header("Authorization", token)
                .accept("application/json")
                .get(ClientResponse.class);
        
        String datosAlumnoEnString = responseDatosAlumno.getEntity(String.class);
        return datosAlumnoEnString;
        
    }
    
    public String getDatosAsignaciones(String body, String token){
        ClientResponse responseDatosAsignaciones = this.client.resource(API_NOTITAS).path(RESOURCE_ASSIGMENTS)
        		.header("Authorization", token)
                .accept("application/json")
                .get(ClientResponse.class, body);
        
        String datosAsigEnString = responseDatosAsignaciones.getEntity(String.class);
        return datosAsigEnString;
    }
    
    
    public void putDatosAlumnos(String body, String token) {
    WebResource webResource = client.resource();
    ClientResponse response = webResource.resource(API_NOTITAS).path(RESOURCE_STUDENT)
                    .header("Authorization", token)
                    .accept("application/json")
                    .put(ClientResponse.class, body);
    }

   
}