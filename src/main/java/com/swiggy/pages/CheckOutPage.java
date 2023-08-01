package com.swiggy.pages;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {
	private WebDriverWait wait;
	
	@FindBy(xpath="//div[contains(@class,'_2axtv')]")
	private WebElement verifyText;

	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	}
	
	public String VerifyText() {
		wait.until(ExpectedConditions.visibilityOfAllElements(verifyText));
		String msg=verifyText.getText();
		return msg;
	}
}
 