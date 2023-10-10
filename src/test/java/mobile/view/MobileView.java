package mobile.view;

import mobile.lib.MobileBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.environment.ManageEnvironment.getProperty;
import static com.environment.ManageEnvironment.setProperty;

public class MobileView extends MobileBase {
    private String btnRegistrarId = "com.exito.appcompania:id/AppCompatButton_registrarse";
    private String inputNombresReg = "//android.widget.LinearLayout[@resource-id=\"com.exito.appcompania:id/CustomEditText_nombres\"]//android.widget.EditText";
    private String inputApellidosReg = "//android.widget.LinearLayout[@resource-id=\"com.exito.appcompania:id/CustomEditText_apellidos\"]//android.widget.EditText";
    private String inputNumDocReg = "//android.widget.LinearLayout[@resource-id=\"com.exito.appcompania:id/CustomEditText_numero_doc\"]//android.widget.EditText";
    private String inputAnioNacReg = "(//android.widget.ImageButton[@content-desc=\"Show dropdown menu\"])[2]";
    private String inputMesNacReg = "(//android.widget.ImageButton[@content-desc=\"Show dropdown menu\"])[3]";
    private String inputDiaNacReg = "(//android.widget.ImageButton[@content-desc=\"Show dropdown menu\"])[4]";
    private String inputCelularReg = "//android.widget.EditText[@resource-id=\"com.exito.appcompania:id/TextInputEditText_tel\"]";
    private String inputEmailReg = "//android.widget.LinearLayout[@resource-id=\"com.exito.appcompania:id/CustomEditText_email_register\"]//android.widget.EditText";
    private String checkBoxReg1 = "//android.widget.CheckBox[@resource-id=\"com.exito.appcompania:id/AppCompatTextView_terminos_y_condiciones\"]";
    private String checkBoxReg2 = "//android.widget.CheckBox[@resource-id=\"com.exito.appcompania:id/AppCompatTextView_politicas_tratamiento\"]";
    private String btnConfirmRegId = "com.exito.appcompania:id/AppCompatButton_registrar";
    private String textTitleConfirmId = "com.exito.appcompania:id/AppCompatTextView_bienvenido";
    private String pinCodeId = "com.exito.appcompania:id/PinView_code_otp";
    private String inputPassword = "//android.widget.LinearLayout[@resource-id=\"com.exito.appcompania:id/CustomEditText_create_password\"]//android.widget.EditText";
    private String inputPassConfirm = "//android.widget.LinearLayout[@resource-id=\"com.exito.appcompania:id/CustomEditText_confirm_create_password\"]//android.widget.EditText";
    private String btnRegCrearId = "com.exito.appcompania:id/AppCompatButton_continuar";
    private String btnIngresarId = "com.exito.appcompania:id/AppCompatButton_ingresar";
    private String inputEmailLoginId = "com.exito.appcompania:id/TextInputEditText_email";
    private String inputPassLogin = "//android.widget.LinearLayout[@resource-id=\"com.exito.appcompania:id/CustomEditText_password\"]//android.widget.EditText";
    private String btnIniciarSesionId = "com.exito.appcompania:id/AppCompatButton_ingresar";
    private String btnMapThisTimeId = "com.android.permissioncontroller:id/permission_allow_one_time_button";
    private String inputSearchBarId = "com.exito.appcompania:id/appCompatEditText_search_bar";
    private String btnMercado = "//android.view.ViewGroup[@resource-id=\"com.exito.appcompania:id/constraintLayout_container_itemlist_hall\"]";
    private String btnBuyAndCollectId = "com.exito.appcompania:id/constraitLayout_buy_and_collect";
    private String cbCiudad = "(//android.widget.ImageButton[@content-desc=\"Show dropdown menu\"])[1]";
    private String cbAlmacen = "(//android.widget.ImageButton[@content-desc=\"Show dropdown menu\"])[2]";
    private String btnCotinueBuyAndCollectId = "com.exito.appcompania:id/appCompatButton_continue";
    private String btnCategory = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.exito.appcompania:id/recyclerViewHalls\"]/android.view.ViewGroup";
    private String btnAddProductId = "com.exito.appcompania:id/constraitLayout_add_item";
    private String productTitleId = "com.exito.appcompania:id/appCompatTextView_product_title";
    private String btnAddProductToCartId = "com.exito.appcompania:id/add_to_cart_food_button";
    private String btnCartId = "com.exito.appcompania:id/appCompatImageView_shopping_cart";
    private String shoppingCartTitleId = "com.exito.appcompania:id/appCompatTextView_shopping_cart_title";
    private String textItemShopCart = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.widget.TextView[2]";

    public void ingresarARegistrar() {
        getDriver().findElement(By.id(btnRegistrarId)).click();
    }
    public void ingresarValoresARegistrar(){
        Actions actions = new Actions(getDriver());
        getDriver().findElement(By.xpath(inputNombresReg)).sendKeys("Alan");
        getDriver().findElement(By.xpath(inputApellidosReg)).sendKeys("Vald");
        getDriver().findElement(By.xpath(inputNumDocReg)).sendKeys("1234567890");

        getDriver().findElement(By.xpath(inputAnioNacReg)).click();
        actions.moveToLocation(165, 2033).click().build().perform();
        getDriver().findElement(By.xpath(inputMesNacReg)).click();
        actions.moveToLocation(516, 1191).click().build().perform();
        getDriver().findElement(By.xpath(inputDiaNacReg)).click();
        actions.moveToLocation(839, 1200).click().build().perform();

        getDriver().findElement(By.xpath(inputCelularReg)).sendKeys("3987654321");
        getDriver().findElement(By.xpath(inputEmailReg)).sendKeys("demo@sample.com");
        WebElement cb1 = getDriver().findElement(By.xpath(checkBoxReg1));
        WebElement cb2 = getDriver().findElement(By.xpath(checkBoxReg2));
        Point cb1L = cb1.getLocation();
        Point cb2L = cb2.getLocation();
        actions.moveToLocation(cb1L.x, cb1L.y).click().build().perform();
        actions.moveToLocation(cb2L.x, cb2L.y).click().build().perform();
    }

    public void confirmarRegistro() {
        getDriver().findElement(By.id(btnConfirmRegId)).click();
    }

    public boolean validarComfirmacion() {
        return getDriver().findElement(By.id(textTitleConfirmId)).isDisplayed();
    }


    public void ingresarAlLogin() {
        getDriver().findElement(By.id(btnIngresarId)).click();
    }

    public void ingresarValoresLogin() {
        getDriver().findElement(By.id(inputEmailLoginId)).sendKeys("pat.valder@gmail.com");
        getDriver().findElement(By.xpath(inputPassLogin)).sendKeys("Clave123456");
    }

    public void iniciarSesion() {
        getDriver().findElement(By.id(btnIniciarSesionId)).click();
    }

    public boolean validarLogin() {
        //getDriver().findElement(By.id(btnMapThisTimeId)).click();
        return getDriver().findElement(By.id(inputSearchBarId)).isDisplayed();
    }
    public void seleccionarProducto(){
        Actions actions = new Actions(getDriver());
        getDriver().findElement(By.xpath(btnMercado)).click();

        getDriver().findElement(By.id(btnBuyAndCollectId)).click();

        getDriver().findElement(By.xpath(cbCiudad)).click();
        actions.moveToLocation(279, 1488).click().build().perform();
        getDriver().findElement(By.xpath(cbAlmacen)).click();
        actions.moveToLocation(419, 1925).click().build().perform();

        getDriver().findElement(By.id(btnCotinueBuyAndCollectId)).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getDriver().findElement(By.id(btnCotinueBuyAndCollectId)).click();
        getDriver().findElement(By.xpath(btnCategory)).click();

        getDriver().findElement(By.id(btnAddProductId)).click();

        getDriver().findElement(By.id(btnAddProductToCartId)).click();

    }
    public void ingresarAlCarrito(){
        getDriver().findElement(By.id(btnCartId)).click();
        getDriver().findElement(By.id(shoppingCartTitleId)).isDisplayed();
    }
    public boolean validarCarrito(){
        return getDriver().findElement(By.xpath(textItemShopCart)).isDisplayed();
    }
}
