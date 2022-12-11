package by.bsu.zorg.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ZorgPage implements PageApi {

    private final WebDriver driver;

    public ZorgPage(final WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public String openMain() {
        return driver.findElement(By.xpath("//a[@class='dropdown-toggle dropdown-img']")).getText();
    }

    @Override
    public String openSearchResults() {
        fillSearchInputAndSend("кухонная вытяжка");
        return driver.findElement(By.xpath("//div[@class='name']//a")).getText();
    }

    @Override
    public String openProduct() {
        fillSearchInputAndSend("кухонная вытяжка");
        clickProduct();
        return findProductCode();
    }

    @Override
    public void login(final String email, final String password) {
        clickProfileBtn();
        printLogin(email);
        printPsw(password);
        clickEnterBtn();
    }

    @Override
    public void emptyLogin() {
        clickProfileBtn();
        clickEnterBtn();
    }

    private void clickProduct() {
        final String xpathProduct = "//div[@class='name']//a";
        By byProductResult = By.xpath(xpathProduct);
        WebElement elementProductClick = driver.findElement(byProductResult);
        elementProductClick.click();
    }

    private String findProductCode() {
        final String xpathProductCode = "//span[@itemprop='model']";
        By byProductCodeResult = By.xpath(xpathProductCode);
        WebElement elementProductCode = driver.findElement(byProductCodeResult);
        return elementProductCode.getText();
    }

    private void clickProfileBtn() {
        final String xpathpRrofileBtn = "//a[@id='modaltrigger']";
        By byProfileBtn = By.xpath(xpathpRrofileBtn);
        WebElement elementProfileBtn = driver.findElement(byProfileBtn);
        elementProfileBtn.click();
    }

    private void clickEnterBtn() {
        final String xpathEnterBtn = "//input[@id='loginbtn']";
        By byEnterBtn = By.xpath(xpathEnterBtn);
        WebElement elementEnterBtn = driver.findElement(byEnterBtn);
        elementEnterBtn.click();
    }

    private void printLogin(String login) {
        final String xpathLogin = "//input[@id='email']";
        By byLoginInput = By.xpath(xpathLogin);
        WebElement elementLoginInput = driver.findElement(byLoginInput);
        elementLoginInput.sendKeys(login);
    }

    private void printPsw(String password) {
        final String xpathPsw = "//input[@id='password']";
        By byPswInput = By.xpath(xpathPsw);
        WebElement elementPswInput = driver.findElement(byPswInput);
        elementPswInput.sendKeys(password);
    }

    private void fillSearchInputAndSend(final String name) {
        openSearchInput();
        printSearch(name);
        selectButtonSearch();
    }

    private void openSearchInput() {
        final String xpathButtonSearch = "//span[@class='sb-icon-search']";
        By byButtonSearch = By.xpath(xpathButtonSearch);
        WebElement elementButtonSearch = driver.findElement(byButtonSearch);
        elementButtonSearch.click();
    }

    private void printSearch(String name) {
        final String xpathSearchName = "//input[@class='sb-search-input']";
        By bySearchName = By.xpath(xpathSearchName);
        WebElement elementInputName = driver.findElement(bySearchName);
        elementInputName.sendKeys(name);
    }

    private void selectButtonSearch() {
        final String xpathButtonSearch = "//input[@class='sb-search-submit']";
        By byButtonSearch = By.xpath(xpathButtonSearch);
        WebElement elementButtonSearch = driver.findElement(byButtonSearch);
        elementButtonSearch.click();
    }
}
