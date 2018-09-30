package serviceRequest;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

/* Pecursos a utilizar
*  http://notitas.herokuapp.com/student (PUT)
*  http://notitas.herokuapp.com/student
*  http://notitas.herokuapp.com/student/assignments
* */

public class RequestService {
    private Client client;
    private static final String API_NOTITAS = "hhttp://notitas.herokuapp.com/";
    private static final String RESOURCE_STUDENT = "student";
    private static final String RESOURCE_ASSIGMENTS = "student/assignments";

    //Inicializacion del cliente.
    public RequestService() {
        this.client = Client.create();
    }

    public String getDatosAlumno(){
        ClientResponse responseDatosAlumno = this.client.resource(API_NOTITAS).path(RESOURCE_STUDENT)
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        
        String datosAlumnoEnString = responseDatosAlumno.getEntity(String.class);
        return datosAlumnoEnString;
    }
    
    public String getDatosAsignaciones(){
        ClientResponse responseDatosAsignaciones = this.client.resource(API_NOTITAS).path(RESOURCE_ASSIGMENTS)
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        
        String datosAsigEnString = responseDatosAsignaciones.getEntity(String.class);
        return datosAsigEnString;
    }

   
}