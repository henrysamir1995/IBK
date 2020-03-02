package ibk.steps;

import ibk.Utils.Util;
import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.ScenarioActor;


import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.containsString;

public class ServicioConsultaPorFiltro extends ScenarioActor {

    String actor;
    String endpoint="https://api.uat.interbank.per/api/v1/ecm-services/document/search";

    public void completar_request(String campo1,String valor1,String campo2,String valor2){
        given().contentType(ContentType.JSON)
        .headers(Util.getCommonHeadersConsultaFiltro())
        .queryParam("documentClass","CLASE_RECLAMOS")
        .body(Util.getMap2Fields(campo1,valor1,campo2,valor2));
    }

    public void enviar_peticion(){
        when().post(endpoint);
    }

    public void validar_metadata(Integer code)
    {
        then().statusCode(code).body(containsString("fileName")); }

    public void validar_error(String mensaje,Integer code){
        then().statusCode(code).body(containsString(mensaje));
    }

    public void completar_request_2(String campo1,String valor1,String campo2,String valor2,String campo3,String valor3){
        given().contentType(ContentType.JSON)
        .headers(Util.getCommonHeadersConsultaFiltro())
        .queryParam("documentClass","CLASE_RECLAMOS")
        .body(Util.getMap3Fields(campo1,valor1,campo2,valor2,campo3,valor3));
    }

}
