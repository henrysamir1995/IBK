package ibk.stepsdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ibk.steps.ServicioConsultaPorFiltro;
import net.thucydides.core.annotations.Steps;

public class UsuarioServicioConsultaPorFiltro {

    @Steps(shared = true)
    ServicioConsultaPorFiltro usuario;

    @Given("^Que el (.*) completa las cabeceras, parametros y request: (.*)=(.*), (.*)=(.*)$")
    public void completaPeticion1(String nombreDeUsuario,String campo1,String valor1,String campo2,String valor2){
        usuario.isCalled(nombreDeUsuario);
        usuario.completar_request(campo1,valor1,campo2,valor2);
    }

    @When("^(.*) realiza la consulta$")
    public void realizaConsulta(String nombreDeUsuario){
        usuario.isCalled(nombreDeUsuario);
        usuario.enviar_peticion();
    }

    @Then("^Valida que el response devuelva la metadata con status code: \"(.*)\"$")
    public void validaResponse(Integer code){
        usuario.validar_metadata(code);
    }

    @Then("^Valida que el response devuelva un mensaje de error: \"(.*)\", con status code: \"(.*)\"$")
    public void validaMensajeError(String mensaje, Integer code){
        usuario.validar_error(mensaje,code); }


    @Given("^Que el (.*) completa los headers, parametros y request: (.*)=(.*), (.*)=(.*), (.*)=(.*)$")
    public void completaPeticion2(String nombreDeUsuario,String campo1,String valor1,String campo2,String valor2, String campo3, String valor3){
        usuario.isCalled(nombreDeUsuario);
        usuario.completar_request_2(campo1,valor1,campo2,valor2,campo3,valor3);
    }
}
