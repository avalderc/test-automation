package com.mid;

import com.frame.PageFrame;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class ExitoMiddleware extends PageFrame {
    @FindBy(xpath = "//*[@id=\"wps-overlay-close-button\"]")
    protected WebElement adModalCloseBtn;
    @FindBy(xpath = "//div[contains(@class,\"exito-geolocation-3-x-addressContainer\")]")
    protected WebElement geoLocationBtn;
    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div[2]/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[1]/div/div/div/button")
    protected WebElement menuBtn;
    @FindBy(xpath = "//div[contains(@class,\"containerDrawer\")]/div[contains(@class,\"categoryList\")]/ul/li[contains(@class,\"exito-category\")]")
    protected WebElement sideBarCategoria;
    @FindBy(xpath = "//div[contains(@class,\"containerDrawer\")]/div[contains(@class,\"categoryList\")]/ul/li[contains(@class,\"exito-category\")]")
    protected List<WebElement> sideBarCategorias;
    @FindBy(xpath = "//div[contains(@class,\"containerDrawer\")]/ul/li[contains(@class,\"exito-category\")]")
    protected WebElement sideBarCategoriaMobile;
    @FindBy(xpath = "//div[contains(@class,\"containerDrawer\")]/ul/li[contains(@class,\"exito-category\")]")
    protected List<WebElement> sideBarCategoriasMobile;
    @FindBy(xpath = "//button[contains(@id,\"categorias-nivel1\") and contains(text(),\"Ver más\")]")
    protected WebElementFacade subCategoriaMobileVerMas;
    @FindBy(xpath = "//li[contains(@id,\"categorias-nivel2\")]")
    protected WebElement subCategoria1Mobile;
    @FindBy(xpath = "//a[contains(@id,\"categorias-nivel3\")]")
    protected WebElement subCategoria2Mobile;
    @FindBy(xpath = "//*[@id=\"exito-geolocation-3-x-modalContainer\"]/div/div/div[1]/span")
    protected WebElement closeModalGeoLocation;
    @FindBy(xpath = "//*[@id=\"exito-geolocation-3-x-modalContainer\"]//div[contains(@class,\"containerFormDeliveryType\")]//div[contains(@class,\"ciudad\")]//div[contains(@class,\"control\")]")
    protected WebElement ciudadSelect;
    @FindBy(xpath = "//*[@id=\"exito-geolocation-3-x-modalContainer\"]//div[contains(@class,\"containerFormDeliveryType\")]//div[contains(@class,\"ciudad\")]//div[contains(@id,\"react-select-2-option\")]")
    protected WebElement menuCiudades;
    @FindBy(xpath = "//*[@id=\"exito-geolocation-3-x-modalContainer\"]//div[contains(@class,\"containerFormDeliveryType\")]//div[contains(@class,\"almacen\")]//div[contains(@class,\"control\")]")
    protected WebElement almacenSelect;
    @FindBy(xpath = "//*[@id=\"exito-geolocation-3-x-modalContainer\"]//div[contains(@class,\"containerFormDeliveryType\")]//div[contains(@class,\"almacen\")]//div[contains(@id,\"react-select-4-option\")]")
    protected WebElement menuAlmacenes;
    @FindBy(xpath = "//div[@id=\"exito-geolocation-3-x-modalContainer\"]//button[contains(@class,\"primaryButton\")]")
    protected WebElement geoLocationPrimaryButton;
    @FindBy(xpath = "//div[@id=\"exito-geolocation-3-x-modalContainer\"]")
    protected WebElement geoLocationContainer;
    @FindBy(xpath = "//div[contains(@class,\"geolocation-3-x-sectionTitle\") and contains(text(),\"Hemos guardado tus preferencias de entrega\")]")
    protected WebElement geoLocationTitleDone;
    @FindBy(xpath = "//*[@id=\"gallery-layout-container\"]/div")
    protected WebElement productoItem;
    @FindBy(xpath = "//*[@id=\"gallery-layout-container\"]/div")
    protected List<WebElement> productosItems;
    @FindBy(xpath = "//div[contains(@class,\"productSummaryBuyButtonProductDetail\")]//button")
    protected WebElement quickBuyAddBtn;
    @FindBy(xpath = "//div[contains(@class,\"quickPurchaseModalContainermodal\")]//span[contains(@class,\"defaultModalClose\")]")
    protected WebElement quickBuyCloseBtn;
    @FindBy(xpath = "//div[contains(@class,\"stepperBoard\")]")
    protected WebElement quickBuyStepperBoard;
    @FindBy(xpath = "//div[contains(@class,\"stepperBoard\")]/div")
    protected WebElement quickBuyStepperQty;
    @FindBy(xpath = "//div[contains(@class,\"stepperBoard\")]//button[contains(@class,\"add-to-car\")]")
    protected WebElement quickBuyStepperAdd;
    @FindBy(xpath = "//a[contains(@class,\"minicartLink\")]")
    protected WebElement cartLink;
    @FindBy(xpath = "//div[contains(@class,\"minicartQuantity\")]")
    protected WebElement miniCartQty;
    @FindBy(xpath = "//div[contains(@class,\"itemCartContent\")]")
    protected WebElement itemCart;
    @FindBy(xpath = "//div[contains(@class,\"itemCartContent\")]")
    protected List<WebElement> itemsCart;
    protected String ITEMCART_NAME_XPATH = "*//span[contains(@data-molecule-product-detail-name-span,\"true\")]";
    protected String ITEMCART_PRICE_XPATH = "*//div[contains(@data-molecule-product-detail-prices,\"true\")]/div/span";
    //protected String ITEMCART_QTY_XPATH = "*//span[contains(@data-molecule-quantity-und-value,\"true\")]";
    protected String ITEMCART_QTY_XPATH = "*//*[contains(@data-atom-container,\"true\")]//span[1]";
    @FindBy(xpath = "//div[contains(@class,\"preLoginInputText\")]/input")
    protected WebElement emailPreInput;
    protected String EMAIL_PREINPUT = "//div[contains(@class,\"preLoginInputText\")]/input";
    @FindBy(xpath = "//button[contains(@class,\"preLoginActiveButton\")]")
    protected WebElement preLoginBtn;
    protected String TOAST_CLOSE_XPATH="//div[contains(@class,\"vtex-toast\")]//div[contains(@class,\"close\")]";
    protected String SUB_CATEGORIA="a[id^='Categor\u00EDas-nivel3']";
    protected String SUB_CATEGORIA_MOB_VERMAS="button[id^='categorias-nivel1']";
    protected String SUB_CATEGORIA_MOB1="li[id^='categorias-nivel2']";
    protected String SUB_CATEGORIA_MOB2="a[id^='categorias-nivel3']";
    protected String PRODUCTO_NAME_XPATH="*//span[contains(@class,\"vtex-store-components-3-x-productBrand\")]";
    protected String PRODUCTO_PRICE_XPATH="*//div[contains(@class,\"exito-vtex-components-4-x-PricePDP\")]/span";
    protected String PRODUCTO_ADDBTN_XPATH="*//div[contains(@class,\"BuyButton\")]/button";
    protected String PRODUCTO_FASTBUYBTN_XPATH="*//div[contains(@class,\"BuyButton\")]//span";
    protected String QUICK_ADD_XPATH="//div[contains(@class,\"productSummaryBuyButtonProductDetail\")]//button";
    protected String QUICK_CLOSE_XPATH = "//div[contains(@class,\"quickPurchaseModalContainermodal\")]//span[contains(@class,\"defaultModalClose\")]";
    protected String PRODUCTO_QTYDIV_XPATH="*//div[contains(@class,\"SummaryQuantityProductRich\")]";
    protected String PRODUCTO_QTYDIV_ADD_XPATH = "*//button[contains(@class,\"add-to-car\")]";
    protected String PRODUCTO_QTYDIV_STEPPER_XPATH = "*//div[contains(@class,\"stepperContainerQty\")]";
}
