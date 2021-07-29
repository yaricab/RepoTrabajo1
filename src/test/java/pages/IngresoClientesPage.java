package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class IngresoClientesPage extends ClaseBase {


        public IngresoClientesPage(WebDriver driver) { super(driver);
        }

        //Identificar localizadores
        By locatorTxtRut = By.name("UsuarioRut");
        By locatorTxtContraseña = By.id("PasswordClient");
        By locatorBtnIniciarSesion = By.xpath("//body/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/button[1]");

        //locator mensajeError
        By locatorMensajeError = By.cssSelector("body.modal-open:nth-child(2) div.modal.fade.show:nth-child(5) div.modal-dialog.modal-dialog-centered div.modal-content div.modal-body div.no-form div.col-xs-12.text-center:nth-child(1) > p:nth-child(1)");

        //acciones del page
        public void llenarIngresoClientes(String rut,String contraseña){
            agregarTexto(esperarPorPresenciaElemento(locatorTxtRut),rut);
            agregarTexto(esperarPorPresenciaElemento(locatorTxtContraseña),contraseña);
            click(esperarPorElementoAClickear(locatorBtnIniciarSesion));

        }

        public String obtenerMensajeError(){
            return obtenerTexto(esperarPorPresenciaElemento(locatorMensajeError));
        }


    }

