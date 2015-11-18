package com.model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LandingPage {
	
	
	@Test(dataProvider="loginData")
	public void loginWordpress(String usrName,String passwd){
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://wordpress.com/");
		driver.findElement(By.className("click-wpcom-login")).click();
		driver.findElement(By.id("user_login" )).clear();
		driver.findElement(By.id("user_login" )).sendKeys(usrName);
		driver.findElement(By.id("user_pass" )).clear();
		driver.findElement(By.id("user_pass" )).sendKeys(passwd);
		driver.findElement(By.id("wp-submit" )).click();
		
	}
	@Test
	public void logout(){
		
	}
	
	
	
	//DATAPROVIDER
	@DataProvider(name="loginData")
	public Object [][] passData(){
		
		ExcelConfig config=new ExcelConfig("/Users/capiwega/gitHubRepo/PoiSelenium/SeleniumPoiforGetHub/testData/inputData.xlsx");
		int row=config.getRowCount(0);
		Object [][] data=new Object[row][3];
		for(int i=0;i<row;i++){
			data[i][0]=config.getData(0, i, 1);//userName
			data[i][1]=config.getData(0, i, 2);//password
			
		}
		System.out.println(data[0][1]);
		return data;
	}
}