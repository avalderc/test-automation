package mobile.stepdefinition;

import com.utils.UtilSession;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.*;
import mobile.step.MobileStep;
import net.serenitybdd.annotations.Steps;

public class MobileStepDefinition {
    @Steps
    MobileStep mobileStep;
    @Before
    public void beforeScenario (Scenario scenario)
    {
        UtilSession.saveVariableOnSession("scenario", scenario);
    }
    @Dado("^que ingreso a la aplicacion mobile$")
    public void ingresoALaAppMobile(){
        mobileStep.ingresarALaAppMobile();
    }
    @Dado("^que ingreso a registrarme$")
    public void ingresoARegistrarme(){
        mobileStep.ingresarARegistrarme();
    }
    @E("^ingreso los valores a registrar$")
    public void ingresoLosValoresARegistrar() {
        mobileStep.ingresarValoresARegistrar();
    }
    @Cuando("^confirmo el registro$")
    public void confirmoElRegistro() {
        mobileStep.confirmarRegistro();
    }
    @Entonces("^valido que se confirme$")
    public void validoQueSeConfirme() {
        mobileStep.validarComfirmacion();
    }
    @Dado("^que ingreso al login$")
    public void queIngresoAlLogin() {
        mobileStep.ingresarAlLogin();
    }
    @E("^ingreso los valores de inicio de sesion$")
    public void ingresoLosValoresDeInicioDeSesion() {
        mobileStep.ingresarValoresLogin();
    }
    @Cuando("^al iniciar sesion$")
    public void alIniciarSesion() {
        mobileStep.iniciarSesion();
    }

    @Entonces("^valido que pueda hacer login$")
    public void validoQuePuedaHacerLogin() {
        mobileStep.validarLogin();
    }
    @Dado("^inicio sesion$")
    public void inicioSesion() {
        mobileStep.inicioSesion();
    }
    @Y("^selecciono un producto$")
    public void seleccionoUnProducto() {
        mobileStep.seleccionarProducto();
    }

    @Cuando("^al ingreso al carrito$")
    public void alIngresoAlCarrito() {
        mobileStep.ingresarAlCarrito();
    }

    @Entonces("^valido el carrito$")
    public void validoElCarrito() {
        mobileStep.validarCarrito();
    }
}
