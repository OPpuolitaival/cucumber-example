# Cucumber example

This is an example project of testing web page with Cucumber and Selenium

## Related links:

* Get started with cucumber: https://cucumber.io/docs/guides/10-minute-tutorial/
* Selenium documentation: https://www.selenium.dev/documentation/en/
* AssertJ documentation: https://joel-costigliola.github.io/assertj/

## Run in Mac OS

Prerequirements:
1. Install homebrew: https://brew.sh/index_fi
1. Install java development kit (JDK): https://www.oracle.com/java/technologies/javase-downloads.html
1. Install maven 
    ```
    brew install maven
    ```
1. Install Chrome browser: https://google.com/chrome/
1. Install chromedriver using homebrew: 
    ```
    brew cask install chromedriver
    ```
    

Run the test in this project root. 
```
mvn clean test -Dwebdriver.chrome.driver=/usr/local/bin/chromedriver
```
*Note: "/usr/local/bin/chromedriver" might be different. Please check it by command `which chromedriver`*

