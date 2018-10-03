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
    
    //TODO: comento porque algo esta mal en el get
    /*
    public String getDatosAsignaciones(String body, String token){
        ClientResponse responseDatosAsignaciones = this.client.resource(API_NOTITAS).path(RESOURCE_ASSIGMENTS)
        		.header("Authorization", token)
                .accept("application/json")
                .get(ClientResponse.class, body);
        
        String datosAsigEnString = responseDatosAsignaciones.getEntity(String.class);
        return datosAsigEnString;
    }*/
    
    
    public void putDatosAlumnos(String body, String token) {
    	WebResource webResource = client.resource(API_NOTITAS).path(RESOURCE_STUDENT);
    
    	//Input de ejemplo => donde dice input va el body
    	String input = "{ \" code\" : \"" + "1566076" + "\"," +
            " \"first_name\":\"" + "Lautaro" + "\"," + 
            " \"last_name\":\"" +  "Odriozola" + "\"," +
            " \"github_user\":\"" + "lautiOdriozola" + "\"}";
    
    	ClientResponse response = webResource.type("application/json").put(ClientResponse.class,input);
    
    	if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
		     	+ response.getStatus());
		}	
    }

   
}