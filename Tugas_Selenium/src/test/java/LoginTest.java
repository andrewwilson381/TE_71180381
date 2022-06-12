import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;

public class LoginTest {

    ChromeDriver chromeDriver;

    @Given("browser dibuka")
    public void browser_dibuka(){
        System.out.println("step browser_dibuka ");
        System.setProperty("webdriver.chrome.driver",
                Objects.requireNonNull(getClass().getClassLoader()
                        .getResource("webdriver/chromedriver.exe")).getFile());
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40)); // menunggu maksimal waktu terbuka browser
        chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }
    @Given("user berada di halaman login")
    public void browser_dibuka(){
        throw new io.cucumber.java.PendingException();
    }
    @When("user memasukkan username dan password")
    public void browser_dibuka(){
        throw new io.cucumber.java.PendingException();
    }
    @When("tombol login ditekan")
    public void browser_dibuka(){
        throw new io.cucumber.java.PendingException();
    }
    @Then("user redirect ke halaman utama")
    public void browser_dibuka(){
        throw new io.cucumber.java.PendingException();
    }
}
