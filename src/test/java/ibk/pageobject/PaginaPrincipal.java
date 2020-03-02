package ibk.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class PaginaPrincipal extends PageObject {
    Robot r=new Robot();

    @FindBy(xpath= "//*[@id=\"userIdInput\"]")
    WebElementFacade inputUser;

    @FindBy(xpath = "//*[@id=\"mainLogin\"]/form/div[2]/input")
    WebElementFacade btnContinue;

    @FindBy(xpath = "//*[@id=\"userPasswordInput\"]")
    WebElementFacade inputClave;

    @FindBy(xpath = "//*[@id=\"dijit_form_DropDownButton_0\"]/span[3]")
    WebElementFacade btnDesplegar;

    @FindBy(xpath = "//*[@id=\"dijit_MenuItem_9_text\"]")
    WebElementFacade btnBuscar;

    @FindBy(xpath="//*[@id=\"idx_form_ComboLink_0_link\"]")
    WebElementFacade btnNewSearch;

    @FindBy(xpath = "//*[@id=\"ecm_widget_search_BasicSearchDefinition_0_searchButton_label\"]")
    WebElementFacade btnSearch;

    @FindBy(xpath = "//*[@id=\"ecm_widget_MessageBar_0_messageSelector\"]/tbody[2]/tr/td[1]/div[1]/span")
    WebElementFacade resultsNumber;

    public void aceptarTerminos() throws InterruptedException {

        //Actions action = new Actions(driver);
        Thread.sleep(15000);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(900);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(900);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(900);
        //Serenity.takeScreenshot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(900);
        //Serenity.takeScreenshot();
        //action.contextClick(archivo).build().perform();
    }

    public void loguearse(String correo, String pssw) throws InterruptedException {
        //btnuser.withTimeoutOf(2, TimeUnit.SECONDS).waitUntilClickable().sendKeys("joel.armando.leiva.collazos@everis.com");
        inputUser.sendKeys(correo);
        //Serenity.takeScreenshot();
        btnContinue.click();
        Thread.sleep(900);
        inputClave.sendKeys(pssw);
        //Serenity.takeScreenshot();
        btnContinue.click();
        Thread.sleep(9000);
    }

    public void busqueda(String text) throws InterruptedException {
        btnDesplegar.click();
        //Serenity.takeScreenshot();
        btnBuscar.click();
        btnNewSearch.click();
        Thread.sleep(900);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        btnSearch.click();
        //Thread.sleep(9000);
        //Serenity.takeScreenshot();
    }

    public String busquedaResultado() throws InterruptedException {
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(9000);
        Serenity.takeScreenshot();
        return resultsNumber.withTimeoutOf(10, TimeUnit.SECONDS).getText();
    }

    public PaginaPrincipal() throws AWTException {
    }


}
