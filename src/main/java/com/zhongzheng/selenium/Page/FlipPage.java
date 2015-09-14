package com.zhongzheng.selenium.Page;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baidu.selenium.control.html.Button;
import com.baidu.selenium.page.Page;

public class FlipPage extends Page {
	
	public FlipPage(WebDriver driver) {
		super(driver);
		// TODO 自动生成的构造函数存根
	}
	private static final Logger LOG = LoggerFactory.getLogger(FlipPage.class);	
		
	//实现翻页功能
		public String flip() {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			WebElement selected=new Button(driver.findElement(By.linkText("5")));  //定位页码
			WebElement nextPage=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[3]/div/div[4]/a[3]/span")));  //下一页
			WebElement previousPage=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[3]/div/div[4]/a[2]/span")));  //上一页
			WebElement lastPage=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[3]/div/div[4]/a[4]/span")));  //最后一页
			WebElement firstPage=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[3]/div/div[4]/a/span")));  //最前一页
			WebElement select=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[3]/div/div[4]/span/span/span/span[2]")));  //点击下来列表

			selected.click();
			nextPage.click();
			previousPage.click();
			lastPage.click();
			firstPage.click();
			select.click();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			WebElement select1=new Button(driver.findElement(By.xpath("/html/body/div[5]/div/ul/li[3]")));  //选择每页展示的页数
			select1.click();
			
						
			String str1=null;		
			str1=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[3]/div/div[4]/span[2]")).getText().replace(" ", "");  //抓取网页中的文本值
				
			driver.switchTo().defaultContent(); //返回默认的页面

			WebElement close=new Button(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div/ul/li[2]/span[3]")));  //定位关闭按钮
			close.click();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return str1;

		}
		@Override
		public boolean isLoaded() {
			// TODO 自动生成的方法存根
			return false;
		}
}
