package com.zhongzheng.selenium.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baidu.selenium.control.html.Button;
import com.baidu.selenium.page.Page;

public class IndexPage extends Page {
	
	  private static final Logger LOG = LoggerFactory.getLogger(IndexPage.class);
	//  WebElement close;
	public IndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	WebElement index=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/ul/li[2]/div/span")));	
		
	public String management()
	{
		//点击“机构管理”，展示下拉内容		
		index.click();
		
		WebElement name=new Button(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/ul/li/span/span")));
		name.click();
		
		WebElement button=new Button(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/ul/li/div/ul/li/div/button")));
		button.click();
		
		WebElement grid=new Button(driver.findElement(By.linkText("外部机构管理")));
		grid.click();
		
	//	close=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div/ul/li[2]/span[3]")));  //定位关闭按钮
		
		//获取“外部机构管理”展示内容的iframe，并且跳转到该iframe
		WebElement fram=driver.findElement(By.className("c-iframe"));
		driver.switchTo().frame(fram);
		
/*		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/	
		//抓取外部机构管理界面的信息
		String str=driver.findElement(By.xpath("/html/body/div[2]/div/div")).getText().replace(" ", "");
		return str;
		//this.Flip();
	}
/*	
	//实现翻页功能
	public String Flip() {
		
		WebElement selected=new Button(driver.findElement(By.linkText("5")));  //定位页码
		selected.click();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement nextPage=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[3]/div/div[4]/a[3]/span")));  //下一页
		nextPage.click();		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		WebElement previousPage=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[3]/div/div[4]/a[2]/span")));  //上一页
		previousPage.click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		WebElement lastPage=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[3]/div/div[4]/a[4]/span")));  //最后一页
		lastPage.click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		WebElement firstPage=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[3]/div/div[4]/a/span")));  //最前一页
		firstPage.click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		WebElement select=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[3]/div/div[4]/span/span/span/span[2]")));  //点击下来列表
		select.click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		WebElement select1=new Button(driver.findElement(By.xpath("/html/body/div[5]/div/ul/li[3]")));  //选择每页展示的页数
		select1.click();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String str1=null;		
		str1=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[3]/div/div[4]/span[2]")).getText().replace(" ", "");  //抓取网页中的文本值
			
		driver.switchTo().defaultContent(); //返回默认的页面
		close.click();
		
		
		//boolean bool=str.equals(str1);
	//	System.out.println("抓取的内容："+str1);
		//System.out.println("翻页是否成功："+bool);
		return str1;
	//	this.testIncrease();  //新增内部管理机构
	}

	//把页面跳转到内部管理机构新增界面
	public String testIncrease() {
		
	//	driver.switchTo().defaultContent();
		//点击“常用链接”，展示下拉内容
		WebElement top=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/ul/li/div/span")));
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
		Button xueli=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/div/div/div[4]/span[2]/span/span/span")));
		Button zhiye=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/ul/li[2]/span[2]")));
		Button juzhu=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/ul/li[3]/span[2]")));
		
		//由于“证件号码”输入框的特殊性（默认把光标放到最后），导致无法正常输入，所以只有先点击后获取光标后才能正常输入
		number.click();
		number.sendKeys("111111111111111111");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		name.sendKeys("张三");
		sex.click();
		date.sendKeys("7/1/2015");
		jiguan.sendKeys("政府");
		xueli.click();
		Button xueli1=new Button(driver.findElement(By.xpath("/html/body/div[5]/div/ul/li[2]")));
		xueli1.click();
		
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
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//进入居住信息界面，抓取地址元素，并且输入地址信息
		juzhu.click();
		WebElement dizhi=new TextBox(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/div[3]/div/div/span[2]/input")));
		dizhi.sendKeys("洞庭北路融汇商务园区xxx号");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//抓取确定按钮，并且点击确定按钮
		Button zengj=new Button(driver.findElement(By.id("button")));
		zengj.click();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//抓取新增页面的信息
		String str3=driver.findElement(By.xpath("/html/body/div[2]/div/div")).getText().replace(" ", "");
		return str3;

	}
*/
	@Override
	public boolean isLoaded() {
		// TODO Auto-generated method stub
		return false;
	}
	public String getURL(){
		String url= driver.getCurrentUrl();
		LOG.debug("url:[{}]", url);
		return url;
	}

}
