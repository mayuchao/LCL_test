package com.zhongzheng.selenium.Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.baidu.selenium.control.html.Button;
import com.baidu.selenium.control.html.TextBox;
import com.baidu.selenium.page.Page;
import com.zhongzheng.selenium.Data.ExcelWorkBook;

public class InsertPage extends Page {
	
	public InsertPage(WebDriver driver) {
		super(driver);
		// TODO 自动生成的构造函数存根
	}
	WebElement top=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/ul/li/div/span")));
	
	//把页面跳转到内部管理机构新增界面
		public String increaseTest() {
			//点击“常用链接”，展示下拉内容			
			top.click();			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			//获取“内部机构管理”元素，并且点击进入该界面
			WebElement grid3=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/ul/li/ul/li/div/a")));
			grid3.click();			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//获取“内部机构管理”展示内容的iframe，并且跳转到该iframe
			WebElement fram1=driver.findElement(By.xpath("//iframe[contains(@src,'grid.3.html')]")); //寻找页面中src属性值包含有grid.3.html这个单词的所有iframe元素
			driver.switchTo().frame(fram1);
			
			//获取“新增”按钮的元素，并且点击“新增”，把页面跳转到“新增”界面
			WebElement insert=new Button(driver.findElement(By.id("button")));
			insert.click();

			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//抓取跳转到新增页面后的信息
			String str2=driver.findElement(By.xpath("/html/body/div[2]/div/div")).getText().replace(" ", "");
			return str2;
		}	

	//进行新增界面进行新增操作
		public String insert() {
			
			driver.switchTo().defaultContent();  //先返回默认的界面
			
			//获取“新增界面”的iframe，并且跳转到该iframe
			WebElement fram2=driver.findElement(By.xpath("//iframe[contains(@src,'form.1.html')]")); 
			driver.switchTo().frame(fram2);
			
			//获取新增的界面元素，并且输入相关信息
			WebElement Certificates=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/span[2]/span/span")));
			Certificates.click();
			WebElement Cer=new Button(driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[2]")));
			Cer.click();
			WebElement number=new TextBox(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/span[2]/input"))); 
			WebElement name=new TextBox(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[3]/span[2]/input")));
			WebElement sex=new Button(driver.findElement(By.id("radio2")));
			WebElement date=new TextBox(driver.findElement(By.id("datepicker")));
			WebElement jiguan=new TextBox(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/div/div/div[3]/span[2]/input")));
			Button education=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/div/div/div[4]/span[2]/span/span/span")));
			Button zhiye=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/ul/li[2]/span[2]")));
			Button juzhu=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/ul/li[3]/span[2]")));
			
			ExcelWorkBook book=new ExcelWorkBook();
			try {
				book.excelutils("C:\\test\\seleniumDate.xlsx", "Sheet1");
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			
			//由于“证件号码”输入框的特殊性（默认把光标放到最后），导致无法正常输入，所以只有先点击后获取光标后才能正常输入
			number.click();
			number.sendKeys(book.number[1]);  //证件号码
			name.sendKeys(book.name[1]);      //姓名
			sex.click();                      //性别
			date.sendKeys(book.date[1]);      //出生日期
			jiguan.sendKeys(book.issuingAuthority[1]);    //发证机构
			education.click();
			Button education1=new Button(driver.findElement(By.xpath("/html/body/div[5]/div/ul/li[2]")));
			education1.click();
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//进入职业信息界面，抓取所属行业元素，并且选择行业
			zhiye.click();
			Button hangye=new Button(driver.findElement(By.id("checkbox1")));
			Button hangye1=new Button(driver.findElement(By.id("checkbox2")));
			hangye.click();
			hangye1.click();

			//进入居住信息界面，抓取地址元素，并且输入地址信息
			juzhu.click();
			WebElement dizhi=new TextBox(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/div[3]/div/div/span[2]/input")));
			dizhi.sendKeys(book.address[1]);   //地址
			
			//抓取确定按钮，并且点击确定按钮
			Button zengj=new Button(driver.findElement(By.id("button")));
			zengj.click();			
			
			//抓取新增页面的信息
			String str3=driver.findElement(By.xpath("/html/body/div[2]/div/div")).getText().replace(" ", "");
			return str3;

		}
		@Override
		public boolean isLoaded() {
			// TODO 自动生成的方法存根
			return false;
		}
}
