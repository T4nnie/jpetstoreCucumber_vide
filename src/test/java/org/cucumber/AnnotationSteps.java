package org.cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AnnotationSteps {

    WebDriver driver;

    @Given("I am a registered user of the pet store")
    public void i_am_a_registered_user_of_the_pet_store(){
        
    }
    @Given("I visit the Jpetstore web site")
    public void je_suis_sur_le_site_site_jpetstore(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
    }

    @When("Sign in with the correct login and password")
    public void je_clique_sur_le_lien_de_connexion(){
        driver.findElement(By.xpath("//a[.='Sign In']")).click();
        driver.findElement(By.xpath("//input[@name='username']")).click();
    	driver.findElement(By.xpath("//input[@name='username']")).clear();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("j2ee");
        driver.findElement(By.xpath("//input[@name='password']")).click();
    	driver.findElement(By.xpath("//input[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("j2ee");
        driver.findElement(By.xpath("//input[@name='signon']")).click();
    }

    @Then("I access the home page")
    public void je_suis_connecte_en_tant_que_ABC(){
        assert(driver.findElement(By.xpath("//div[@id='WelcomeContent']")).getText().contains("ABC"));
    }
	
}
