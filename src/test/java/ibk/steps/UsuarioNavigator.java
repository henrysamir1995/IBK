package ibk.steps;

import ibk.pageobject.PaginaPrincipal;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Steps;

public class UsuarioNavigator extends ScenarioActor {
    String actor;

    @Steps(shared=true)
    PaginaPrincipal paginaPrincipal;

    public void ingresar_a_pagina(){
        paginaPrincipal.setDefaultBaseUrl("https://interbank.bpm.ibmcloud.com/ecm/test/navigator/");
        paginaPrincipal.open();
    }

    public void aceptar_terminos() throws InterruptedException {
        paginaPrincipal.aceptarTerminos();
    }

    public void loguearse(String correo, String pssw) throws InterruptedException {
        paginaPrincipal.loguearse(correo,pssw);
    }

    public void busqueda(String texto) throws InterruptedException {
        paginaPrincipal.busqueda(texto);
    }

    public void resultados() throws InterruptedException {
        String texto=paginaPrincipal.busquedaResultado();
        System.out.println(texto);
    }
}
