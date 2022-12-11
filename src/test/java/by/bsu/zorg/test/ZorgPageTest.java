package by.bsu.zorg.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: 12/1/2022 Util class

/**
 * Tests for {@link ZorgPage}
 */
class ZorgPageTest {

    private WebDriver driver;
    private ZorgPage page;

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        page = new ZorgPage(driver);
        driver.get("https://zorginox.by/");
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    /**
     * {@link ZorgPage#openMain()}
     */
    @Test
    void openMain_ShouldOpen() {
        // verify
        assertEquals("КУХОННЫЕ ВЫТЯЖКИ", page.openMain());
    }

    /**
     * {@link ZorgPage#openSearchResults()}
     */
    @Test
    void findProduct_ShouldFindAtLeastOne() {
        assertEquals("Кухонная вытяжка ZorG Technology ARSTAA 50S WH", page.openSearchResults());
    }

    /**
     * {@link ZorgPage#openProduct()}
     */
    @Test
    void openProduct_ShouldOpenAndCodeExists() {
        assertEquals("ARSTAA 50S WH", page.openProduct());
    }

    /**
     * {@link ZorgPage#emptyLogin()}
     */
    @Test
    void login_ShouldNotLogin_WhenEmptyEmailAndPassword() {
        // when
        page.emptyLogin();

        // verify
        assertEquals("Неправильно заполнены поля E-Mail и/или пароль!", findErrorMessage());
    }

    /**
     * {@link ZorgPage#login(String, String)}
     */
    @Test
    void login_ShouldNotLogin_WhenIncorrectEmailAndPassword() {
        // when
        page.login(Util.generateEmail(), Util.generatePassword());

        // verify
        assertEquals("Неправильно заполнены поля E-Mail и/или пароль!", findErrorMessage());
    }

    /**
     * {@link ZorgPage#login(String, String)}
     */
    @Test
    void login_ShouldLogin_WhenCorrectEmailAndPassword() {
        // when
        page.login("egatg@mailto.plus", "5tr0n@");

        // verify
        final String actual = driver.findElement(By.xpath("//article[@class='account-content']//h1"))
                .getText();
        assertEquals("ЛИЧНЫЙ КАБИНЕТ", actual);
    }

    private String findErrorMessage() {
        final String xpathErrorMailRequire = "//div[@class='alert alert-danger']";
        By byErrorMailRequire = By.xpath(xpathErrorMailRequire);
        WebElement elementErrorMailRequire = driver.findElement(byErrorMailRequire);
        return elementErrorMailRequire.getText();
    }

}