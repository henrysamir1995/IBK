package ibk.stepsdefinitions;

import cucumber.api.java.en.And;
import ibk.Utils.Util;
import ibk.steps.UsuarioNavigator;
import net.thucydides.core.annotations.Steps;

public class UsuarioDeficionesPasosNavigator {
    @Steps(shared=true)
    UsuarioNavigator usuario;

    @And("^El documento (.*) se encuentre almacenado en el ECM$")
    public void validar(String cp) throws InterruptedException {
        usuario.ingresar_a_pagina();
        usuario.aceptar_terminos();
        usuario.loguearse(Util.USER, Util.PSSW);
        usuario.busqueda(cp);
        usuario.resultados();
    }
}
