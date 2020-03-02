package ibk.steps;

import ibk.Utils.Util;
import net.serenitybdd.core.steps.ScenarioActor;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.containsString;

public class ServicioConsultaPuntual extends ScenarioActor {
    String actor;

public void definir_headers(){
    given().headers(Util.getCommonHeadersConsultaPuntual())
            .queryParam("documentClass","CLASE_RECLAMOS");
}

public void enviar_peticion(String doc){
    String endpoint="https://api.uat.interbank.per/api/v1/ecm-services/document/" + doc;
    when().get(endpoint);
}

public void validar_response(Integer code,String iddoc)
{
    then().statusCode(code).body("id",is(iddoc));
}

public void validar_error(String mensaje,Integer code)
{
        then().statusCode(code).body(containsString(mensaje));
    }
}
