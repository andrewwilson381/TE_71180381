Feature: feature to test login fungtionality

    Scenario: periksa login dengan akun yang benar
      Given browser dibuka
      And user berada di halaman login
      When user memasukkan username dan password
      And tombol login ditekan
      Then user redirect ke halaman utama