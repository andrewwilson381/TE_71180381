Feature: Feature to test register functionality

  Scenario Outline: apakah pengisian username sudah benar
    Given Diketahui form username wajib diisi adalah first_name dan surname
    When Mengecheck pengaturan jumlah dan jenis karakter form  first_name "<fName>" dan surename "<sName>"
    Then Diketahui jumlah dan jenis karakter form  username "<checkUsername>"
    Examples:
      | fName           | sName         | checkUsername                         |
      | NULL            | NULL          | Tidak Valid                           |
      | Firstname       | NULL          | Tidak valid                           |
      | NULL            | Surname       | Tidak valid                           |
      | Firstname       | Surname       | Valid                                 |
      | Abcdefghijklmn  | Opqrstuvwxyz  | Valid, lebih dari 20 karakter         |
      | Firstname99     | Surname99     | Valid, terdapat angka                 |
      | Firstname#      | Surname#      | Valid, terdapat simbol                |

  Scenario Outline: apakah pengisian password sudah benar
    Given Diketahui batas password harus delapan sampai tigabelas karakter dan alpanumeric "<password>"
    When Mengecheck apakah password alpanumeric "<checkJenisPassword>"
    And Mengecheck apakah jumlah karakter password delapan sampai tigabelas "<checkJumlahPassword>"
    Then Diketahui batasan password  "<hasil>"
    Examples:
      | password          | checkJenisPassword  | checkJumlahPassword | hasil       |
      | NULL              | NULL                | NULL                | Tidak Valid |
      | Password          | alphabet            | 8                   | Tidak Valid |
      | Password123       | alphanumeric        | 11                  | Valid       |
      | Password123#      | bukan alphanumeric  | 12                  | Tidak Valid |
      | Password123456789 | alphanumeric        | 17                  | Tidak Valid |