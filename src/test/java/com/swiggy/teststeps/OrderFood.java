package com.swiggy.teststeps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.swiggy.pages.CheckOutPage;
import com.swiggy.pages.LandingPage;
import com.swiggy.pages.PlaceOrder;
import com.swiggy.pages.TopRestaurantPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderFood {
	
	WebDriver driver;
	PlaceOrder placeOrder;
	
@Given("a user is on the landing page on Amazon")
public void a_user_is_on_the_landing_page_on_amazon() {
	 driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://swiggy.com");
}

@When("he type Hyderabad and select the first option")
public void he_type_hyderabad_and_select_the_first_option() throws InterruptedException {
	LandingPage landingPage=new LandingPage(driver);
	landingPage.searchItem("Hyderabad");
  
}

@When("he click on first restaurant under Top Restaurant chains in Hyderabad")
public void he_click_on_first_restaurant_under_top_restaurant_chains_in_hyderabad() {
	TopRestaurantPage topRestaurantPage=new TopRestaurantPage(driver);
	topRestaurantPage.ClickFirstRestaurant();
   
}

@When("he click Add button on the first listed dish")
public void he_click_add_button_on_the_first_listed_dish() {
	placeOrder=new PlaceOrder(driver);
	placeOrder.ClickFirstDish();
}

@When("he hover over Cart icon")
public void he_hover_over_cart_icon() throws InterruptedException {
	
	placeOrder.HoverOverCartIcon();
}

@When("he click on Check Out button")
public void he_click_on_check_out_button() {
	placeOrder.ClickCheckout();
}

@Then("verify the text {string}")
public void verify_the_text(String string) {
	CheckOutPage checkOutPage=new CheckOutPage(driver);
	String expectedTextMsg=string;
	String actualTextMsg=checkOutPage.VerifyText();
	Assert.assertEquals(actualTextMsg, expectedTextMsg);
    
}

}
