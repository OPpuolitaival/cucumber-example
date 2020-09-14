  Feature: Amazon sell Nikon camera
    As a user I want to buy Nikon D3X camera from Amazon

    Scenario: User check that Nikon D3X is available
      Given "https://amazon.com" web site
      When search "Nikon"
      When sort results from highest to slowest price
      When select second product
      Then product topic contains "Nikon D3X"