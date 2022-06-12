import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class PengaturanFormRegisterTest {
    //Testcase untuk mengisi first name dan surname
    String fName,sName,checkUsername;
    private static Stream<Arguments> provideFirstnameAndSurname() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("Firstname", ""),
                Arguments.of("Firstname99", ""),
                Arguments.of("Firstname#", ""),
                Arguments.of("Firstname99#", ""),
                Arguments.of("", "Surname"),
                Arguments.of("", "Surname99"),
                Arguments.of("", "Surname#"),
                Arguments.of("", "Surname99#"),
                Arguments.of("Firstname", "Surname"),
                Arguments.of("Firstname99", "Surname"),
                Arguments.of("Firstname", "Surname99"),
                Arguments.of("Firstname#", "Surname"),
                Arguments.of("Firstname", "Surname#"),
                Arguments.of("Firstname99#", "Surname"),
                Arguments.of("Firstname", "Surname99#"),
                Arguments.of("Firstname99", "Surname99"),
                Arguments.of("Firstname#", "Surname#"),
                Arguments.of("Firstname99#", "Surname99#")
        );
    }

    //apakah pengisian username sudah benar
    @Given("Diketahui form username adalah first_name dan surname")
    public void diketahui_form_username_adalah_first_name_dan_surname(String string,String string2){
        this.fName=string;
        this.sName=string2;
    }
    @When("Mengecheck pengaturan jumlah dan jenis karakter form  first_name dan surename")
    public void mengecheck_pengaturan_jumlah_dan_jenis_karakter_form_first_name_dan_surename(){
        checkUsername=Register.usernameCheckLength(this.fName,this.sName);
    }
    @Then("Diketahui jumlah dan jenis karakter form  username")
    public void diketahui_jumlah_dan_jenis_karakter_form_username(String string){
        System.out.println("Compare: "+string+" | "+checkUsername);
        Assertions.assertEquals(string,checkUsername);
    }

    //apakah pengisian password sudah benar
    String password,checkPassword;
    @Given("Diketahui batas password harus delapan sampai tigabelas karakter dan alpanumeric")
    public void diketahui_batas_password_harus_delapan_sampai_tigabelas_karakter_dan_alpanumeric(String string){
        this.password=string;
    }
    @When("Mengecheck apakah password alpanumeric")
    public void mengecheck_apakah_password_alpanumeric(){
        checkPassword=Register.passwordCheckAlphanumeric(this.password);
    }
    @When("Mengecheck apakah jumlah karakter password delapan sampai tigabelas")
    public void mengecheck_apakah_jumlah_karakter_password_delapan_sampai_tigabelas() {
        checkPassword=Register.passwordCheckCharactersMinMax(this.password);
    }
    @Then("Diketahui batasan password")
    public void diketahui_batasan_password(String string){
        Assertions.assertEquals(string,checkPassword);
    }
}
