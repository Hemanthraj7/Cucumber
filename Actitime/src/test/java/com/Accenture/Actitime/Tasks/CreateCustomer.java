package com.Accenture.Actitime.Tasks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
//import com.Accenture.Actitime.BaseClass.*;
public class CreateCustomer  {
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
	
	@And("^user click on add new and create customer$")
	public void click2()
	{
		  driver.findElement(By.xpath("//div[@class='plusIcon']")).click();
		  driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
	}
	@When("^the user enters name and descripion$")
	public void enterdetails()
	{
		  driver.findElement(By.xpath("(//input[@placeholder='Enter Customer Name'])[2]")).sendKeys("Hemanth Raj121");
		  driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys("Yeah nigga This is Raj");
	}
	@And("^click on create customer$")
	public void Click3()
	{
		  driver.findElement(By.xpath("//div[@class='commitButtonPlaceHolder']")).click();
	}
	@Then("^customer should be creatred$")
	public void check4()
	{	
		String Exp3=driver.findElement(By.xpath("(//div[text()='Hemanth Raj777'])[2]")).getAttribute("title");
		String Act3="Hemanth Raj121";
		System.out.println(Exp3);
		Assert.assertEquals(Exp3, Act3);
		System.out.println("Passed");
	}
	@And("^click on logout button and close the browser$")
	public void logout()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[@href='/logout.do']")).click();
		driver.close();
		}
	
}
