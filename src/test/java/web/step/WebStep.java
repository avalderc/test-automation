package web.step;

import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import web.page.ExitoPage;

import java.time.Duration;

public class WebStep extends ScenarioSteps {
    ExitoPage webPage;

    @Step
    public void ingresarALaWeb() {
        webPage.open();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webPage.setExitoLocation();
    }

    public void elegirCategoriaYSubcategoria() {
        webPage.elegirCategoria();
        webPage.elegirSubCategoria();
    }
    public void elegirProductos(){
        webPage.elegirProductos();
    }

    public void ingresarAlCarrito() {
        webPage.ingresarAlCarrito();
    }

    public void validarNombresProductos() {
        boolean valido = webPage.validarNombresProductos();
        Assert.assertTrue("Algún Producto no Coincide",valido);
    }

    public void validarTotalPreciosProductosAgregados() {
        boolean valido = webPage.validarTotalPreciosProductosAgregados();
        Assert.assertTrue("Total de Precios de Producto no es correcto",valido);
    }

    public void validarCantidadesProductosAgregados() {
        boolean valido = webPage.validarCantidadesProductosAgregados();
        Assert.assertTrue("Cantidades de Productos Agregados no es correcto",valido);
    }

    public void validarNumerProductosAgregados() {
        boolean valido = webPage.validarNumerProductosAgregados();
        Assert.assertTrue("Numero de productos no es correcto",valido);
    }
}
