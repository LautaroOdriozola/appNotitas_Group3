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
    private static final String API_NOTITAS = "http://localhost:8080/";
    private static final String RESOURCE_TOKEN = "token";
    private static final String RESOURCE_STUDENT = "alumno";
    private static final String RESOURCE_ASSIGMENTS = "alumno/notas";

    //Inicializacion del cliente.
    public RequestService() {
        this.client = Client.create();
    }

    public String getDatosAlumno(String body, String token){
        ClientResponse responseDatosAlumno = this.client.resource(API_NOTITAS).path(RESOURCE_STUDENT)
        		.header("Authorization",token)
                .accept("application/json")
                .get(ClientResponse.class);
        
    	if (responseDatosAlumno.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
		     	+ responseDatosAlumno.getStatus());
		}
        
        String datosAlumnoEnString = responseDatosAlumno.getEntity(String.class);
        return datosAlumnoEnString;
        
    } 
    
    public String getToken(String user, String password) {
    	//String body = "{ \" usuario\" : \"" + user + "\"," + " \"password\":\"" + password + "\"}" ;    	
   	
    	ClientResponse response = this.client.resource(API_NOTITAS).path(RESOURCE_TOKEN)
    			.header("Authorization", user)
    			.get(ClientResponse.class);
    	
    	if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
		     	+ response.getStatus());
		}
    	
    	String token = response.getEntity(String.class);
    	return token;
    }
    
    //TODO: comento porque algo esta mal en el get
    
    public String getDatosAsignaciones(String body, String token){
        ClientResponse responseDatosAsignaciones = this.client.resource(API_NOTITAS).path(RESOURCE_ASSIGMENTS)
        		.header("Authorization",token)
                .accept("application/json")
                .get(ClientResponse.class);
        
    	if (responseDatosAsignaciones.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
		     	+ responseDatosAsignaciones.getStatus());
		}
        
        String datosAsigEnString = responseDatosAsignaciones.getEntity(String.class);
        return datosAsigEnString;
    }
    
    
    public void putDatosAlumnos(String body, String token) {
    	WebResource webResource = client.resource(API_NOTITAS).path(RESOURCE_STUDENT);
    
    	ClientResponse response = webResource
    			.header("Authorization",token)
    			.type("application/json")
    			.put(ClientResponse.class,body);
    
    	if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
		     	+ response.getStatus());
		}	
    }

   
}