package ibk.steps;

import ibk.Utils.Util;
import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.ScenarioActor;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.containsString;

public class ServicioIngestaAsync extends ScenarioActor {

    String actor;
    String endpoint="https://api.uat.interbank.per/api/v1/ecm-services/document";

    public void definir_request_1(String cp){
        String TEMPLATE_CUSTOMER_CREATION = "templates/R_"+cp+".json";
        String body= Util.getTemplate(TEMPLATE_CUSTOMER_CREATION);
        given().contentType(ContentType.JSON)
                .headers(Util.getHeadersWithIngestaPDF())
                .body(body);
    }

    public void enviar_peticion(){
        when().post(endpoint);
    }

    public void validar_metadata(String cp) {
        then().statusCode(200).body(containsString("SE ENVIO EXITOSAMENTE EL ARCHIVO "+cp));
        }

    public void definir_request_2(String cp){
        String TEMPLATE_CUSTOMER_CREATION = "templates/R_"+cp+".json";
        String body= Util.getTemplate(TEMPLATE_CUSTOMER_CREATION);
        given().contentType(ContentType.JSON)
                .headers(Util.getHeadersWithIngestaEXCEL())
                .body(body);
    }

    public void definir_request_3(String cp){
        String TEMPLATE_CUSTOMER_CREATION = "templates/R_"+cp+".json";
        String body= Util.getTemplate(TEMPLATE_CUSTOMER_CREATION);
        given().contentType(ContentType.JSON)
                .headers(Util.getHeadersWithIngestaWORD())
                .body(body);
    }

    public void validar_error(String error) {
        then().statusCode(400).body(containsString(error));
    }

    public void definir_request_4(String cp){
        String TEMPLATE_CUSTOMER_CREATION = "templates/R_"+cp+".json";
        String body= Util.getTemplate(TEMPLATE_CUSTOMER_CREATION);
        given().contentType(ContentType.JSON)
                .headers(Util.getHeadersWithIngestaWORD())
                .body(body);
    }

    public void definir_request_5(String cp){
        String TEMPLATE_CUSTOMER_CREATION = "templates/R_"+cp+".json";
        String body= Util.getTemplate(TEMPLATE_CUSTOMER_CREATION);
        given().contentType(ContentType.JSON)
                .headers(Util.getHeadersWithIngestaFirmaIncorrecta())
                .body(body);
    }

    public void definir_request_6(String cp){
        String TEMPLATE_CUSTOMER_CREATION = "templates/R_"+cp+".json";
        String body= Util.getTemplate(TEMPLATE_CUSTOMER_CREATION);
        given().contentType(ContentType.JSON)
                .headers(Util.getHeadersWithIngesta5MB())
                .body(body);
    }
}
