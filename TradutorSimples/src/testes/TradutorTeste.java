package testes;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TradutorTeste {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "../recursos/geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testPalavraWall() throws Exception {
    driver.get(baseUrl + "/TradutorSimples/");
    driver.findElement(By.name("palavra")).clear();
    driver.findElement(By.name("palavra")).sendKeys("wall");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("parede", driver.findElement(By.cssSelector("b")).getText());
  }
  
  @Test
  public void testPalavraPlay() throws Exception {
    driver.get(baseUrl + "/TradutorSimples/");
    driver.findElement(By.name("palavra")).clear();
    driver.findElement(By.name("palavra")).sendKeys("play");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("jogar", driver.findElement(By.cssSelector("b")).getText());
  }
  
  @Test
  public void testPalavraNaoExiste() throws Exception {
    driver.get(baseUrl + "/TradutorSimples/");
    driver.findElement(By.name("palavra")).clear();
    driver.findElement(By.name("palavra")).sendKeys("softbox");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("softbox", driver.findElement(By.cssSelector("b")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}