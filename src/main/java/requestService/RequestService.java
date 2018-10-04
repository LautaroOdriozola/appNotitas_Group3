package requestService;
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
    private static final String API_NOTITAS = "http://notitas.herokuapp.com/";
    private static final String RESOURCE_STUDENT = "student";
    private static final String RESOURCE_ASSIGMENTS = "student/assignments";

    //Inicializacion del cliente.
    public RequestService() {
        this.client = Client.create();
    }

    public String getDatosAlumno(String body, String token){
        ClientResponse responseDatosAlumno = this.client.resource(API_NOTITAS).path(RESOURCE_STUDENT)
        		.header("Authorization","Bearer " + token)
                .accept("application/json")
                .get(ClientResponse.class);
        
        String datosAlumnoEnString = responseDatosAlumno.getEntity(String.class);
        return datosAlumnoEnString;
        
    }
    
    //TODO: comento porque algo esta mal en el get
    
    public String getDatosAsignaciones(String body, String token){
        ClientResponse responseDatosAsignaciones = this.client.resource(API_NOTITAS).path(RESOURCE_ASSIGMENTS)
        		.header("Authorization","Bearer " + token)
                .accept("application/json")
                .get(ClientResponse.class);
        
        String datosAsigEnString = responseDatosAsignaciones.getEntity(String.class);
        return datosAsigEnString;
    }
    
    
    public void putDatosAlumnos(String body, String token) {
    	WebResource webResource = client.resource(API_NOTITAS).path(RESOURCE_STUDENT);
    
    	ClientResponse response = webResource
    			.header("Authorization","Bearer " + token)
    			.type("application/json")
    			.put(ClientResponse.class,body);
    
    	if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
		     	+ response.getStatus());
		}	
    }

   
}