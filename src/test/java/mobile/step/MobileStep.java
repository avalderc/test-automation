package mobile.step;

import mobile.lib.MobileDriverManager;
import mobile.view.MobileView;
import org.junit.After;
import org.junit.Assert;

public class MobileStep {
    private final MobileView mobileView = new MobileView();
    @After
    public void tearDown() {
        MobileDriverManager.quitDriver();
    }
    public void ingresarALaAppMobile() {
        MobileDriverManager.setUpDriver();
    }
    public void ingresarARegistrarme() {
        mobileView.ingresarARegistrar();
    }
    public void ingresarValoresARegistrar() {
        mobileView.ingresarValoresARegistrar();
    }

    public void confirmarRegistro() {
        mobileView.confirmarRegistro();
    }

    public void validarComfirmacion() {
        Assert.assertTrue("Error", mobileView.validarComfirmacion());
    }

    public void ingresarAlLogin() {
        mobileView.ingresarAlLogin();
    }

    public void ingresarValoresLogin() {
        mobileView.ingresarValoresLogin();
    }

    public void iniciarSesion() {
        mobileView.iniciarSesion();
    }

    public void validarLogin() {
        Assert.assertTrue("Error", mobileView.validarLogin());
    }
    public void inicioSesion() {
        mobileView.ingresarAlLogin();
        mobileView.ingresarValoresLogin();
        mobileView.iniciarSesion();
        Assert.assertTrue("Error", mobileView.validarLogin());
    }
    public void seleccionarProducto(){
        mobileView.seleccionarProducto();
    }
    public void ingresarAlCarrito(){
        mobileView.ingresarAlCarrito();
    }
    public void validarCarrito(){
        Assert.assertTrue("Error", mobileView.validarCarrito());
    }


}
