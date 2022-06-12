Feature: feature to test register fungtionality

  Scenario: Ada tombol create di bagian bawah form
    Given Buka browser web
    And User ada di halaman register
    And Bentuk tombol create
    When Mencari tombol create
    Then Tombol create

  Scenario: Ada tombol reset di bagian bawah form
    Given Buka browser web
    And Pengguna ada di halaman register
    And Bentuk tombol reset
    When Mencari tombol reset
    Then Tombol reset