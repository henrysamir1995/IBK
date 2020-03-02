package ibk.stepsdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ibk.steps.ServicioIngestaAsync;
import net.thucydides.core.annotations.Steps;

public class UsuarioServicioIngestaAsync {
    @Steps(shared = true)
    ServicioIngestaAsync usuario;

    @Given("^Que el (.*) completa el request para ingestar un PDF con las condiciones del (.*)$")
    public void completaRequest1(String nombreDeUsuario,String cp){
        usuario.isCalled(nombreDeUsuario);
        usuario.definir_request_1(cp);
    }

    @When("^(.*) realiza la ingesta$")
    public void ingestaDocumento(String nombreDeUsuario){
        usuario.isCalled(nombreDeUsuario);
        usuario.enviar_peticion();
    }

    @Then("^Valida que el response devuelva un mensaje de envio exitoso del archivo (.*)$")
    public void validaRespose(String cp){
        usuario.validar_metadata(cp);
    }

    @Given("^Que el (.*) completa el request para ingestar un EXCEL con las condiciones del (.*)$")
    public void completaRequest2(String nombreDeUsuario, String cp){
        usuario.isCalled(nombreDeUsuario);
        usuario.definir_request_2(cp);
    }

    @Given("^Que el (.*) completa el request para ingestar un WORD con las condiciones del (.*)$")
    public void completaRequest3(String nombreDeUsuario, String cp){
        usuario.isCalled(nombreDeUsuario);
        usuario.definir_request_3(cp);
    }

    @Then("^Valida que el response muestre un mensaje de error: \"(.*)\"$")
    public void validaResposeError(String error){
        usuario.validar_error(error);
    }

    @Given("^Que el (.*) completa el request para ingestar una C.R. con las condiciones del (.*)$")
    public void completaRequest4(String nombreDeUsuario,String cp){
        usuario.isCalled(nombreDeUsuario);
        usuario.definir_request_4(cp);
    }

    @Given("^Que el (.*) completa el request para ingestar una Evidencia con las condiciones del (.*)$")
    public void completaRequest5(String nombreDeUsuario, String cp){
        usuario.isCalled(nombreDeUsuario);
        usuario.definir_request_5(cp);
    }

    @Given("^Que el (.*) completa el request para ingestar una H.R. con las condiciones del (.*)$")
    public void completaRequest6(String nombreDeUsuario, String cp){
        usuario.isCalled(nombreDeUsuario);
        usuario.definir_request_6(cp);
    }

    @Given("^Que el (.*) completa el request para ingestar un archivo no permitido con las condiciones del (.*)$")
    public void completaRequest7(String nombreDeUsuario, String cp){
        usuario.isCalled(nombreDeUsuario);
        usuario.definir_request_3(cp);
    }
}