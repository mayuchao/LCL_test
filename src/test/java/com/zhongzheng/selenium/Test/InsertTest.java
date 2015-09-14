package com.zhongzheng.selenium.Test;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import com.baidu.selenium.page.PageUrlMapping;
import com.baidu.selenium.page.factory.PageFactory;
import com.baidu.selenium.page.support.DefaultUrlNavigator;
import com.baidu.selenium.test.CasePriority;
import com.baidu.selenium.test.TestBase;
import com.zhongzheng.selenium.Page.IndexPage;
import com.zhongzheng.selenium.Page.InsertPage;


public class InsertTest extends TestBase {
	private static final Logger LOG = LoggerFactory.getLogger(InsertPage.class);

	@Override
	protected void initBeforeClass() {
		// TODO Auto-generated method stub
		
	}
	@Test(groups = { CasePriority.BVT, CasePriority.BF, CasePriority.CheckIn, CasePriority.ES })
	public void insertTest()
	{
		String url = PageUrlMapping.getAbsoluteUrl(IndexPage.class);
		new DefaultUrlNavigator().doNavigation(driver, url);		
		InsertPage insertPage = PageFactory.createPage(InsertPage.class, driver);
				
		String jigou="当前位置：机构管理/管理内部机构";
		String str2=insertPage.increaseTest();    //跳转到内部管理机构界面
		boolean bool2=str2.equals(jigou);
		System.out.println("内部管理机构界面是否跳转成功："+bool2);
	    LOG.debug("当前位置:[{}]", str2);
	    Assert.assertTrue(str2.startsWith(jigou));	
	    
		String inert="当前位置：机构管理/管理内部机构";
		String str3=insertPage.insert();    //进行新增操作
		boolean bool3=str3.equals(inert);
		System.out.println("新增操作是否成功：："+bool3);
	    LOG.debug("当前位置:[{}]", str3);
	    Assert.assertTrue(str3.startsWith(inert));	

		
	}
}
