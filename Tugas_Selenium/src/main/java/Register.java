import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Register{
    //untuk mengecheck pengaturan jenis isian dan jumlah karakter pada first name dan Surname
    public static String usernameCheckLength(String fName,String sName){
        String fullUsername="";
        //apakah user mengisi surname?
        if(sName.length()>0){
            fullUsername+=fName+sName;
        }
        else{
            fullUsername+=fName;
        }

        //apakah user mengisi username?
        if(fullUsername.length()==0){
            return "kosong";
        }
        else if(fullUsername.length()<=20){
            //apakah termasuk alphanumeric
            if(fullUsername.matches("^[a-zA-Z0-9]*$")){
                return "kurang dari 20 karakter dan termasuk alphanumeric";
            }
            else {
                return "kurang dari 20 karakter dan bukan termasuk alphanumeric";
            }
        }
        else if(fullUsername.length()>20){
            //apakah termasuk alphanumeric
            if(fullUsername.matches("^[a-zA-Z0-9]*$")){
                return "lebih dari 20 karakter dan termasuk alphanumeric";
            }
            else{
                return "lebih dari 20 karakter dan termasuk alphanumeric";
            }
        }
        else{
            return "Error";
        }
    }

    //untuk mengecheck pengaturan jenis password harus alphabet dan numberik
    public static String passwordCheckAlphanumeric(String password){
        if(password.matches("^[a-zA-Z0-9]*$")){
            return "termasuk alphanumeric";
        }
        else{
            return "bukan termasuk alphanumeric";
        }
    }

    //untuk mengecheck pengaturan jumlah kata password
    public static String passwordCheckCharactersMinMax(String password){
        if(password.length()<8){
            return "kurang dari 8 karakter";
        }
        else if(password.length()>13){
            return "lebih dari 13 karakter";
        }
        else{
            return "valid";
        }
    }
}
