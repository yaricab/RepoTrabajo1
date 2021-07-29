package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class FormularioContratacionPage extends ClaseBase {

    public FormularioContratacionPage(WebDriver driver) {
        super(driver);
    }

    //Identificar localizadores
    By locatorTxtRut = By.name("txtRut");
    By locatorTxtNroSerie = By.id("txtSerie");
    By locatorChkAutorizacion = By.xpath("//body/app-root[1]/app-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-steppers[1]/mat-horizontal-stepper[1]/div[2]/div[1]/app-paso-uno[1]/div[2]/form[1]/div[2]/app-persona-natural[1]/form[1]/div[1]/div[2]/div[1]/mat-checkbox[1]/label[1]/span[1]");
    //
    By locatorBtnContinuar = By.xpath("//div[contains(text(),'Continuar')]");

    //locator mensajeError
    By locatorLblError = By.xpath("//mat-dialog-content");

    //acciones del page
    public void llenarFormularioRetomaContratacion(String rut,String nroSerie){
        agregarTexto(esperarPorPresenciaElemento(locatorTxtRut),rut);
        agregarTexto(esperarPorPresenciaElemento(locatorTxtNroSerie),nroSerie);
        click(esperarPorElementoAClickear(locatorChkAutorizacion));
        click(esperarPorElementoAClickear(locatorBtnContinuar));
    }

    public String obtenerMensajeError(){
        return obtenerTexto(esperarPorPresenciaElemento(locatorLblError));
    }


}
