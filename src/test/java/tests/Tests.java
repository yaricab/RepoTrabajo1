package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.FormularioContratacionPage;
import pages.HomePage;
import pages.RetomarContratacionPage;
import utilidades.DataDriven;
import utilidades.PropertiesDriven;

import java.io.IOException;
import java.util.List;


public class Tests {
    //atributos
    private WebDriver driver;
    private DataDriven data;
    private List<String> datosCP;
    private PropertiesDriven properties;

    //atributos (pages)
    private HomePage homePage;
    private RetomarContratacionPage retomaContratacionPage;
    private FormularioContratacionPage  formularioContratacionPage;

    @BeforeSuite
    public void inicioSuiteDePruebas(){
        properties = new PropertiesDriven();
        System.out.println("Inicio de suite de pruebas automatizadas");
    }

    @BeforeClass
    public void preparacionClase(){

        data = new DataDriven();

        homePage = new HomePage(driver);

        homePage.conexionDriver(properties.obtenerProperty("rutaDriver"),properties.obtenerProperty("browserProperty"),properties.obtenerProperty("browser"));

        retomaContratacionPage = new RetomarContratacionPage(homePage.getDriver());

        formularioContratacionPage = new FormularioContratacionPage(retomaContratacionPage.getDriver());
    }

    @BeforeMethod
    public void preparacionTests(){
        String url = properties.obtenerProperty("url");
        System.out.println(url);
        homePage.cargarPagina(url);
        homePage.maximizarVentana();
    }

    @Test
    public void CP001_retomaFormularioContratacion() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP001_retomaFormularioContratacion");
        homePage.irAHazteCliente();
        retomaContratacionPage.irARetomarContratacion();
        formularioContratacionPage.llenarFormularioRetomaContratacion(datosCP.get(1),datosCP.get(2));
        Assert.assertEquals(formularioContratacionPage.obtenerMensajeError(),datosCP.get(3));
    }

    @AfterMethod
    public void after(){

    }

    @Test
    public void CP002(){

    }
    @Test
    public void CP003(){

    }
    @Test
    public void CP004(){

    }
    @Test
    public void CP005(){

    }
}
