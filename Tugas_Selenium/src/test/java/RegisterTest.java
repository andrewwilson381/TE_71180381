import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class RegisterTest{
    //Masuk ke halaman register
    ChromeDriver chromeDriver;
    @Given("Buka browser web")
    public void buka_browser_web(){
        System.out.println("step browser_dibuka ");
        System.setProperty("webdriver.chrome.driver",
                Objects.requireNonNull(getClass().getClassLoader()
                        .getResource("webdriver/chromedriver.exe")).getFile());
        chromeDriver=new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }
    @Given("User ada di halaman register")
    public void user_ada_di_halaman_register(){
        chromeDriver.navigate().to("https://demo.guru99.com/insurance/v1/register.php");
    }

    //mencari tombol create
    String jenisTombol, nilaiTombol;
    @Given("Bentuk tombol create")
    public void bentuk_tombol_create(String string, String string2){
        this.jenisTombol=string;
        this.nilaiTombol=string2;
    }
    @When("Mencari tombol create")
    public void mencari_tombol_create(){
        List<WebElement> list=chromeDriver.findElements(
                By.xpath("//input[@type='"+this.jenisTombol+"' and @value='"+this.nilaiTombol+"']"));
        if(list.size()>0){
            this.checkTombol="ada";
        }
        else{
            this.checkTombol="tidak ada";
        }
    }
    @Then("Tombol create")
    public void tombol_create(String string) {
        Assertions.assertEquals(string,this.checkTombol);
        chromeDriver.close();
        chromeDriver.quit();
    }


    //mencari tombol reset
    String tombolReset,checkTombol;
    @Given("Bentuk tombol reset")
    public void bentuk_tombol_reset(String string){
        this.tombolReset = string;
    }
    @When("IMencari tombol reset")
    public void mencari_tombol_reset(){
        List<WebElement> list=chromeDriver.findElements(
                By.id(this.tombolReset));
        if(list.size()>0){
            this.checkTombol="ada";
        }
        else{
            this.checkTombol="tidak ada";
        }
    }
    @Then("Tombol reset")
    public void tombol_reset(String string){
        Assertions.assertEquals(string,this.checkTombol);
        chromeDriver.close();
        chromeDriver.quit();
    }
}