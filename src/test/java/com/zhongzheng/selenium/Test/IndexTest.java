package com.zhongzheng.selenium.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.baidu.selenium.page.PageUrlMapping;
import com.baidu.selenium.page.factory.PageFactory;
import com.baidu.selenium.page.support.DefaultUrlNavigator;
import com.baidu.selenium.test.CasePriority;
import com.baidu.selenium.test.TestBase;
import com.zhongzheng.selenium.Page.IndexPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IndexTest extends TestBase {
	private static final Logger LOG = LoggerFactory.getLogger(IndexPage.class);

	@Override
	protected void initBeforeClass() {
		// TODO Auto-generated method stub
		
	}
	
	 @Test(groups = { CasePriority.BVT, CasePriority.BF, CasePriority.CheckIn, CasePriority.ES })
	public void searchTest()
	{
		String url = PageUrlMapping.getAbsoluteUrl(IndexPage.class);
		new DefaultUrlNavigator().doNavigation(driver, url);		
		IndexPage indexPage = PageFactory.createPage(IndexPage.class, driver);
		
		String tarUrl="file:///C:/kendo/index.html";		
		String toUrl= indexPage.getURL();		
		boolean bool4=toUrl.equals(tarUrl);
		System.out.println("是否成功打开首页："+bool4);
	//	System.out.println("地址："+toUrl);		
	    LOG.debug("toUrl:[{}]", toUrl);
	    Assert.assertTrue(toUrl.startsWith(tarUrl));
	    
		String weizhi="当前位置：机构管理/管理内部机构";
		String str=indexPage.management();    //跳转到外部管理结构界面
	//	System.out.println("抓取的跳转页面内容："+str);
		boolean bool=str.equals(weizhi);
		System.out.println("外部管理结构界面是否跳转成功："+bool);
	    LOG.debug("当前位置:[{}]", str);
	    Assert.assertTrue(str.startsWith(weizhi));
/*		
		String page="1-20of100items";
		String str1=indexPage.Flip();    //进行翻页操作
		boolean bool1=str1.equals(page);
		System.out.println("翻页是否成功："+bool1);
	    LOG.debug("翻页信息:[{}]", str1);
	    Assert.assertTrue(str1.startsWith(page));	
		
		String jigou="当前位置：机构管理/管理内部机构";
		String str2=indexPage.testIncrease();    //跳转到内部管理机构界面
		boolean bool2=str2.equals(jigou);
		System.out.println("内部管理机构界面是否跳转成功："+bool2);
	    LOG.debug("当前位置:[{}]", str2);
	    Assert.assertTrue(str2.startsWith(jigou));	
	    
		String inert="当前位置：机构管理/管理内部机构";
		String str3=indexPage.insert();    //进行新增操作
		boolean bool3=str3.equals(inert);
		System.out.println("新增操作是否成功：："+bool3);
	    LOG.debug("当前位置:[{}]", str3);
	    Assert.assertTrue(str3.startsWith(inert));	
*/		
	}
}
