package cases;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class testSearch extends TestInit {
	/**
	 * 桌面搜索文件，点击搜索结果列表中内容跳转
	 * 
	 * @author 刘晨
	 * @Time 2017-12-22
	 *
	 */
	@Test(enabled = true)
	public void searchResult() throws InterruptedException {
		login("liuchen@shimo.im", "123123");
		action.moveToElement(dashboard_search_button).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_search_input));
		dashboard_search_input.sendKeys("搜索测试");
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_search_result_1));
		dashboard_search_result_1.click();
		Thread.sleep(2000);
		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(b_back));

		String title = driver.getTitle();
		assertEquals(title, "搜索测试");

	}

	/**
	 * hover 搜索图标输入搜索内容，移开鼠标，搜索结果保持，输入框不收起
	 * 
	 * @author 刘晨
	 * @Time 2018-01-09
	 *
	 */
	@Test(enabled = true)
	public void search_move() throws InterruptedException {
		login("liuchen@shimo.im", "123123");
		action.moveToElement(dashboard_search_button).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_search_input));
		dashboard_search_input.sendKeys("搜索测试");

		action.moveToElement(desktop).perform();
		Boolean result = dashboard_search_input.isDisplayed();
		assertTrue(result);
	}

	/**
	 * hover 搜索图标输入搜索内容，移开鼠标，任意点击搜索外的位置，搜索收起
	 * 
	 * @author 刘晨
	 * @Time 2018-01-09
	 *
	 */
	@Test(enabled = true)
	public void search_moveAndClick() throws InterruptedException {
		login("liuchen@shimo.im", "123123");
		action.moveToElement(dashboard_search_button).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_search_input));
		dashboard_search_input.sendKeys("搜索测试");

		action.moveToElement(dashboard_search_input, -100, 0).click().perform();

		Thread.sleep(1000);
		Boolean result = dashboard_search_button.isDisplayed();
		assertTrue(result);
	}
}
