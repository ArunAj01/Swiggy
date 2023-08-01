package com.swiggy.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrder {
	private WebDriverWait wait;
	private Actions actions;
	
	@FindBy(xpath="(//div[contains(@class,'_1RPOp')])[1]")
	private WebElement firstDish;
	
	@FindBy(xpath="(//a[contains(@class,'_1T-E4')])[1]")
	private WebElement cartIcon;
	
	@FindBy(xpath="//div[contains(@class,'_55uP6')]")
	private WebElement checkout;
	
	public PlaceOrder(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		actions=new Actions(driver);
	}
	
	public void ClickFirstDish() {
		wait.until(ExpectedConditions.visibilityOfAllElements(firstDish));
		firstDish.click();
		}
	
	
	public void HoverOverCartIcon() throws InterruptedException {
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfAllElements(cartIcon));
		actions.moveToElement(cartIcon).build().perform();
	}
	
	public void ClickCheckout() {
		wait.until(ExpectedConditions.visibilityOfAllElements(checkout));
		checkout.click();
	}
	
}
