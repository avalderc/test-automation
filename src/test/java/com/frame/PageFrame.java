package com.frame;

import com.utils.UtilSession;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.Normalizer;
import java.time.Duration;
import java.util.List;

public abstract class PageFrame extends PageObject {
    private long IMP_WAIT_TIMEOUT = 10;
    protected Actions actions = new Actions(getDriver());
    protected WebDriverWait driverWait(long timeout) {return new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));}
    protected WebDriverWait driverWait() {return new WebDriverWait(getDriver(), Duration.ofSeconds(IMP_WAIT_TIMEOUT));}
    protected void scrollToElement(WebElement webElement){
        actions.scrollToElement(webElement).build().perform();
    }
    protected void takeScreenShot(){
        Scenario scenario =  UtilSession.getVariableOnSession("scenario");
        final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }
    protected boolean waitVisibilityOfByXPath(long timeOutInSeconds, String XPath){
        return driverWait(timeOutInSeconds).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                try {
                    List<WebElement> webElements = getDriver().findElements(By.xpath(XPath));
                    System.out.println(webElements.size());
                    return webElements.size() > 0;
                } catch (Exception e) {
                    System.out.println("waitVisibilityOfByXPath: "+this.getClass().getName()+"\n"+e);
                    return false;
                }
            }
        });
    }
    protected boolean waitVisibilityOfByXPath(String XPath){
        return waitVisibilityOfByXPath(IMP_WAIT_TIMEOUT, XPath);
    }

    protected WebElement waitVisibilityFromElementByXPath(WebElement webElement,String xPath, long timeOutInSeconds){
        return driverWait(timeOutInSeconds).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                try {
                    WebElement we = webElement.findElement(By.xpath(xPath));
                    if(we!=null) return we;
                } catch (Exception e) {
                    System.out.println("waitVisibilityFromElementByXPath: "+this.getClass().getName()+"\n"+e);
                    return null;
                }
                return null;
            }
        });
    }
    protected WebElement waitVisibilityFromElementByXPath(WebElement webElement,String xPath){
        return waitVisibilityFromElementByXPath(webElement, xPath, IMP_WAIT_TIMEOUT);
    }
    protected JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
    private Object executeScript(String script){
        return jsExecutor.executeScript(script, new Object[0]);
    }
    protected WebElement getElementJS(String cssSelector) {
        String finalQuerySelector = "return document.querySelector(\"%s\")";
        finalQuerySelector = String.format(finalQuerySelector, cssSelector);
        WebElement element = (WebElement) executeScript(finalQuerySelector);
        if (element == null) {
            System.out.println("El elemento no fue encontrado: " + this.getClass());
        }
        return element;
    }
    protected List<WebElement> getElementsJS(String cssSelector) {
        String finalQuerySelector = "return document.querySelectorAll(\"%s\")";
        finalQuerySelector = String.format(finalQuerySelector, cssSelector);
        List<WebElement> elementList = (List<WebElement>) executeScript(finalQuerySelector);
        if (elementList.isEmpty()) {
            System.out.println("Elementos no encontrados: " + this.getClass());
        }
        return elementList;
    }
    protected WebElement waitAndGetElement(String cssSelector, long timeOutInSeconds){
        return driverWait(timeOutInSeconds).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                try {
                    WebElement webElement = getElementJS(cssSelector);
                    if(webElement!=null) return webElement;
                } catch (Exception e) {
                    System.out.println("waintAndGetElement: "+this.getClass().getName()+"\n"+e);
                    return null;
                }
                return null;
            }
        });
    }
    protected WebElement waitAndGetElement(String cssSelector) {return this.waitAndGetElement(cssSelector,IMP_WAIT_TIMEOUT);}
    protected List<WebElement> waitAndGetElements(String cssSelector, long timeOutInSeconds){
        return driverWait(timeOutInSeconds).until(new ExpectedCondition<List<WebElement>>() {
            @Override
            public List<WebElement> apply(WebDriver webDriver) {
                try {
                    List<WebElement> webElements = getElementsJS(cssSelector);
                    return webElements;
                } catch (Exception e) {
                    System.out.println("waintAndGetElements: "+this.getClass().getName()+"\n"+e);
                    return null;
                }
            }
        });
    }
    protected List<WebElement> waitAndGetElements(String cssSelector) {return this.waitAndGetElements(cssSelector,IMP_WAIT_TIMEOUT);}
}
