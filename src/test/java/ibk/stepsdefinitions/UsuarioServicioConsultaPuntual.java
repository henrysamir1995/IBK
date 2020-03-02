package ibk.stepsdefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import ibk.steps.ServicioConsultaPuntual;
import net.thucydides.core.annotations.Steps;

public class UsuarioServicioConsultaPuntual {
    @Steps(shared = true)
    ServicioConsultaPuntual usuario;


    @Given("^Que el (.*) completa las cabeceras y parametros$")
    public void completa_headers(String nombreDeUsuario){
       usuario.isCalled(nombreDeUsuario);
       usuario.definir_headers();
    }

    @When("^(.*) realiza la consulta por documento: (.*)$")
    public void realiza_consulta_existente(String nombreDeUsuario,String doc){
        usuario.isCalled(nombreDeUsuario);
        usuario.enviar_peticion(doc);
    }
    @Then("^Valida que la respuesta sea exitosa con status code: \"(.*)\" y el response contenga el id de documento: (.*)$")
    public void valida_datos(Integer code,String iddoc){
        usuario.validar_response(code,iddoc);
    }

    @When("^(.*) realiza la consulta con un documento que no existe: (.*)$")
    public void realiza_consulta_no_existente(String nombreDeUsuario,String doc){
        usuario.isCalled(nombreDeUsuario);
        usuario.enviar_peticion(doc);
    }

    @Then("^Valida que la respuesta devuelva un mensaje de error: \"(.*)\", con status code: \"(.*)\"$")
    public void valida_response(String mensaje,Integer code){
        usuario.validar_error(mensaje,code);}

}
