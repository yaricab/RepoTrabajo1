package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class RetomarContratacionPage extends ClaseBase {

    public RetomarContratacionPage(WebDriver driver) {
        super(driver);
    }

    //Identificar localizadores
    By locatorBtnRetomarContratacion =By.xpath("//button[contains(text(),'contrat')]");

    //acciones del page
    public void irARetomarContratacion(){
        click(esperarPorElementoAClickear(locatorBtnRetomarContratacion));
    }
}
