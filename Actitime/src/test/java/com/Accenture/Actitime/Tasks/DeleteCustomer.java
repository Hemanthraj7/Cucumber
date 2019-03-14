package com.Accenture.Actitime.Tasks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Accenture.Actitime.BaseClass.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class DeleteCustomer {
	
	public WebDriver driver;
	@Given("^an user opens browsers and url$")
	public void Openbrowser()
	{
	
		System.setProperty("webdriver.chrome.driver", "E:\\Actitime\\Browsers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	@Then("^a login page should be displayed$")
	public void Check1()
	{
		String Act=driver.getTitle();
		String Exp="actiTIME - Login";
		Assert.assertEquals(Exp, Act);
		System.out.println("Passed1");
	}
	@When("^user enters valid username & password$")
	public void loginDetails()
	{
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
	}
	@And("^click on login button$")
	public void loginbutton()
	{
		driver.findElement(By.id("loginButton")).click();
	}
	@Then("^the application should be logged in$")
	public void Check2()
	{
		String Exp1="Switch to actiPLANS";
		String Act1=driver.findElement(By.xpath("//span[text()='Switch to actiPLANS']")).getText();
		Assert.assertEquals(Act1, Exp1);
		System.out.println("Passed2");
	}
	@When("^user clicks on TASKS tab$")
	public void Taskstab()
	{
		  driver.findElement(By.xpath("//div[text()='TASKS']")).click();
	}

		@And("^search customer name in search text box$")
		public void Seacrchtext()
		{
			  driver.findElement(By.xpath("(//input[@placeholder='Start typing name ...'])[1]")).sendKeys("HemanthRaj");			
		}
		@And("^click on customersettings button$")
		public void Settins()
		{
			driver.findElement(By.xpath("//span[contains(text(),'HemanthRaj')]/../../../..//div[@class='editButton']")).click();
		}
		@Then("^popup page should display$")
		public void Check5()
		{
			String Act3=driver.findElement(By.xpath("(//div[@class='actions'])[1]")).getAttribute("class");
			String Exp3="actions";
			Assert.assertEquals(Exp3, Act3);
			System.out.println("passed4");
		}
		@When("^user click on Actions button$")
		public void Action()
		{
			driver.findElement(By.xpath("//div[@class='actionButton']")).click();
		}
		@And("^click on delete button$")
		public void Delete()
		{
			driver.findElement(By.xpath("(//div[text()='Delete'])[2]")).click();
		}
		@And("^click on delete permanently button$")
		public void deletePermanently()
		{
			driver.findElement(By.xpath("//span[contains(text(),'Delete permanently')]")).click(); 			
		}
}
