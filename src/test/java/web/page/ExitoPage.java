package web.page;

import com.mid.ExitoMiddleware;
import com.utils.ManageProducts;
import com.utils.Product;
import com.utils.Util;
import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

import static com.environment.ManageEnvironment.getProperty;
import static com.environment.ManageEnvironment.setProperty;

@DefaultUrl("https://www.exito.com")
public class ExitoPage extends ExitoMiddleware {

    public void closeAd() {
        WebElement webElement = driverWait(20).until(ExpectedConditions.visibilityOf(adModalCloseBtn));
        if(webElement.isDisplayed()) webElement.click();
    }
    public void setExitoLocation() {
        driverWait().until(ExpectedConditions.visibilityOf(geoLocationBtn)).click();
        driverWait().until(ExpectedConditions.visibilityOf(closeModalGeoLocation));
        driverWait().until(ExpectedConditions.visibilityOf(ciudadSelect)).click();
        driverWait().until(ExpectedConditions.visibilityOf(menuCiudades)).click();
        driverWait().until(ExpectedConditions.visibilityOf(almacenSelect)).click();
        driverWait().until(ExpectedConditions.visibilityOf(menuAlmacenes)).click();
        driverWait().until(ExpectedConditions.elementToBeClickable(geoLocationPrimaryButton)).click();
        driverWait().until(ExpectedConditions.visibilityOf(geoLocationTitleDone));
        closeModalGeoLocation.click();
    }

    public void elegirCategoria() {
        menuBtn.click();
        int width = getDriver().manage().window().getSize().width;
        if(width>1026){
            driverWait().until(ExpectedConditions.elementToBeClickable(sideBarCategoria));
            int randNum = Util.random(sideBarCategorias.size()-1);
            sideBarCategorias.get(randNum).click();
        }else{
            driverWait().until(ExpectedConditions.elementToBeClickable(sideBarCategoriaMobile));
            int randNum = Util.random(sideBarCategoriasMobile.size()-1);
            sideBarCategoriasMobile.get(randNum).click();
        }
        takeScreenShot();
    }
    public void elegirSubCategoria(){
        int width = getDriver().manage().window().getSize().width;
        if(width>1026){
            waitAndGetElement(SUB_CATEGORIA);
            List<WebElement> subCategorias = waitAndGetElements(SUB_CATEGORIA);
            int randNum = Util.random(subCategorias.size()-1);
            subCategorias.get(randNum).click();
        }else{
            waitAndGetElement(SUB_CATEGORIA_MOB_VERMAS);
            waitAndGetElement(SUB_CATEGORIA_MOB1).click();
            waitAndGetElement(SUB_CATEGORIA_MOB2).click();
        }
        driverWait(20).until(ExpectedConditions.visibilityOf(productoItem));
        scrollToElement(productoItem);
        takeScreenShot();
    }
    public void elegirProductos(){
        driverWait().until(ExpectedConditions.visibilityOf(productoItem));
        int productsSize = productosItems.size();
        List<Integer> randomNums = new ArrayList<Integer>();
        while (randomNums.size() < 5)
        {
            Integer next = Util.random(productsSize-1);
            if(!randomNums.contains(next)) randomNums.add(next);
        }
        System.out.println(randomNums);
        for (int i = 0; i < 5; i++) {
            //int index = randomNums.get(i);
            WebElement productoItem = productosItems.get( randomNums.get(i) );
            scrollToElement(productoItem);
            driverWait(15).until(ExpectedConditions.visibilityOf(productoItem));
            String name = productoItem.findElement(By.xpath(PRODUCTO_NAME_XPATH)).getText();
            String priceText = productoItem.findElement(By.xpath(PRODUCTO_PRICE_XPATH)).getText();
            String priceSt = Util.matchAmount(priceText);
            float priceNum = Float.parseFloat(priceSt);

            //Agregamos el producto
            List<WebElement> addbtn = productoItem.findElements(By.xpath(PRODUCTO_ADDBTN_XPATH));
            int qty = Util.random(1, 10);
            if(addbtn.size() == 0) {
                productoItem.findElement(By.xpath(PRODUCTO_FASTBUYBTN_XPATH)).click();
                driverWait().until(ExpectedConditions.visibilityOf(quickBuyAddBtn)).click();
                driverWait().until(ExpectedConditions.visibilityOf(quickBuyStepperQty));

                for (int j = 1; j < qty; j++) {
                    quickBuyStepperAdd.click();
                    String qtyText = String.format("%d.00", j + 1);
                    driverWait().until(ExpectedConditions.textToBePresentInElement(quickBuyStepperQty, qtyText));
                }
                quickBuyCloseBtn.click();
            }else {
                scrollToElement(addbtn.get(0));
                actions.moveToElement(addbtn.get(0)).click().build().perform();
                WebElement qtyDiv = waitVisibilityFromElementByXPath(productoItem, PRODUCTO_QTYDIV_XPATH);

                // Añadimos productos 1 a 1
                for (int j = 1; j < qty; j++) {
                    waitVisibilityFromElementByXPath(qtyDiv, PRODUCTO_QTYDIV_ADD_XPATH).click();
                    WebElement qtyStepper = qtyDiv.findElement(By.xpath(PRODUCTO_QTYDIV_STEPPER_XPATH));
                    String qtyText = String.format("%d.00", j + 1);
                    driverWait().until(ExpectedConditions.textToBePresentInElement(qtyStepper, qtyText));
                }
            }
            ManageProducts.addProduct(name, priceNum, qty);
            takeScreenShot();
        }
    }

    public void ingresarAlCarrito() {
        scrollToElement(cartLink);
        setProperty("miniCartQty", miniCartQty.getText());
        driverWait(20).until(ExpectedConditions.elementToBeClickable(cartLink)).click();
        driverWait(20).until(ExpectedConditions.visibilityOf(itemCart));
        List<WebElement> preLogin = getDriver().findElements(By.xpath(EMAIL_PREINPUT));
        if (preLogin.size() > 0) {
            preLogin.get(0).sendKeys("ejemplo@email.com");
            preLoginBtn.click();
        }
        scrollToElement(itemCart);
        takeScreenShot();
    }

    public boolean validarNombresProductos() {
        final boolean[] result = {true};
        List<Product> products = ManageProducts.getProducts();
        itemsCart.forEach(webElement -> {
            String name = webElement.findElement(By.xpath(ITEMCART_NAME_XPATH)).getText();
            System.out.println(name);
            Optional<Product> productsFiltered = products.stream()
                    .filter(product -> product.getName().equals(name)).findFirst();
            result[0] = productsFiltered.isPresent() && result[0];
        });
        return result[0];
    }

    public boolean validarTotalPreciosProductosAgregados() {
        final boolean[] result = {true};
        List<Product> products = ManageProducts.getProducts();
        itemsCart.forEach(webElement -> {
            String name = webElement.findElement(By.xpath(ITEMCART_NAME_XPATH)).getText();
            String price = webElement.findElement(By.xpath(ITEMCART_PRICE_XPATH)).getText();
            float priceNum = Float.parseFloat( Util.matchAmount(price) );
            System.out.println(priceNum);
            Optional<Product> productsFiltered = products.stream()
                    .filter(product -> product.getName().equals(name)).findFirst();
            result[0] = productsFiltered.isPresent() && result[0];
            if(productsFiltered.isEmpty()) return;
            Product product = productsFiltered.get();
            float amount = product.getPrice() * product.getQty();
            double abs = Math.abs(Math.round(amount - priceNum));
            System.out.println(product.getQty()+" * "+product.getPrice()+" = "+amount);
            result[0] = result[0] && (abs == 0);
        });
        return result[0];
    }

    public boolean validarCantidadesProductosAgregados() {
        final boolean[] result = {true};
        List<Product> products = ManageProducts.getProducts();
        itemsCart.forEach(webElement -> {
            String name = webElement.findElement(By.xpath(ITEMCART_NAME_XPATH)).getText();
            String qty = webElement.findElement(By.xpath(ITEMCART_QTY_XPATH)).getText();
            int qtyNum = Integer.parseInt( Util.matchAmount(qty) );
            Optional<Product> productsFiltered = products.stream()
                    .filter(product -> product.getName().equals(name)).findFirst();
            result[0] = productsFiltered.isPresent() && result[0];
            if(productsFiltered.isEmpty()) return;
            Product product = productsFiltered.get();
            result[0] = result[0] && (product.getQty() == qtyNum);
        });
        return result[0];
    }

    public boolean validarNumerProductosAgregados() {
        final boolean[] result = {true};
        List<Product> products = ManageProducts.getProducts();
        itemsCart.forEach(webElement -> {
            String name = webElement.findElement(By.xpath(ITEMCART_NAME_XPATH)).getText();
            String qty = webElement.findElement(By.xpath(ITEMCART_QTY_XPATH)).getText();
            int qtyNum = Integer.parseInt( Util.matchAmount(qty) );
            Optional<Product> productsFiltered = products.stream()
                    .filter(product -> product.getName().equals(name)).findFirst();
            result[0] = productsFiltered.isPresent() && result[0];
            if(productsFiltered.isEmpty()) return;
            Product product = productsFiltered.get();
            result[0] = result[0] && (product.getQty() == qtyNum);
        });
        return result[0];
    }
}
