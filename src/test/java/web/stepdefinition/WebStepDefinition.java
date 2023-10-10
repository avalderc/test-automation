package web.stepdefinition;

import com.utils.UtilSession;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;
import web.step.WebStep;

public class WebStepDefinition {
    @Steps
    WebStep webStep;
    @Before
    public void beforeScenario (Scenario scenario)
    {
        UtilSession.saveVariableOnSession("scenario", scenario);
    }
    @Dado("^que ingreso a la web$")
    public void ingresoALaWeb(){
        webStep.ingresarALaWeb();
    }

    @Dado("^que elijo una categoria y subcategoria$")
    public void queElijoUnaCategoriaYSubcategoria() {
        webStep.elegirCategoriaYSubcategoria();
    }

    @Y("^elijo los productos con sus cantidades$")
    public void elijoLosProductosConSusCantidades() {
        webStep.elegirProductos();
    }

    @Cuando("^ingreso al carrito$")
    public void ingresoAlCarrito() {
        webStep.ingresarAlCarrito();
    }

    @Entonces("^valido los nombres de los productos$")
    public void validoLosNombresDeLosProductos() {
        webStep.validarNombresProductos();
    }

    @Y("^valido el total de los precios de los productos agregados$")
    public void validoElTotalDeLosPreciosDeLosProductosAgregados() {
        webStep.validarTotalPreciosProductosAgregados();
    }

    @Y("^valido las cantidades de los productos agregados$")
    public void validoLasCantidadesDeLosProductosAgregados() {
        webStep.validarCantidadesProductosAgregados();
    }

    @Y("^valido el numero de productos agregados$")
    public void validoElNumeroDeProductosAgregados() {
        webStep.validarNumerProductosAgregados();
    }
}
