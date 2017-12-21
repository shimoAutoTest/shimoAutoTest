package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import elementFile.SearchWith;

public class TestInit {
	public WebDriver driver = null;
	public WebDriverWait wait = null;
	String test_url;
	baseFunc init = new baseFunc();

	public TestInit() {

	}

	@BeforeClass
	public void firstMethod() {
		test_url = init.getUrl();
		driver = init.initData(this);
		driver.navigate().to(test_url);
		wait = new WebDriverWait(driver, 20);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("--------------------------------------------");
		String url = driver.getCurrentUrl();
		if (url != test_url) {
			logout();
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		pageInit();
	}

	@AfterClass
	public void lastMethod() {
		System.out.println("--------------------------------------------");
		// 关闭浏览器
		driver.quit();
	}

	/**
	 * 登录
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void login(String user, String pwd) {
		String className = new Exception().getStackTrace()[1].getMethodName();
		printLog(className, user);

		driver.navigate().to(test_url + "login");
		wait.until(ExpectedConditions.elementToBeClickable(login_submit));
		userEmail.sendKeys(user);
		userPwd.sendKeys(pwd);
		login_submit.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_new));
	}

	/**
	 * 登出
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void logout() {
		driver.navigate().to(test_url + "logout");
	}

	/**
	 * 页签切换
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void switchToPage(int i) {
		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		driver.switchTo().window(it.get(i));
	}

	/**
	 * 删除浏览器多余标签页
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void pageInit() {
		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		int n = it.size();
		for (int i = 0; i < n - 1; i++) {
			driver.switchTo().window(it.get(i));
			driver.close();
		}

		winHandels = driver.getWindowHandles();
		it = new ArrayList<String>(winHandels);
		driver.switchTo().window(it.get(0));
	}
	
	/**
	 * Log
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	public void printLog(String classname, String userID) {
		System.out.println(classname + "[" + userID + "]");

	}

	/**
	 * 判断元素是否存在
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public boolean doesWebElementExist(WebDriver driver, By selector) {

		try {
			driver.findElement(selector);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// homePage
	@SearchWith(pageName = "homePage", elementName = "userEmail")
	public WebElement userEmail;
	@SearchWith(pageName = "homePage", elementName = "userPwd")
	public WebElement userPwd;
	@SearchWith(pageName = "homePage", elementName = "login_submit")
	public WebElement login_submit;

	// desktop
	@SearchWith(pageName = "desktop", elementName = "desktop_new")
	public WebElement desktop_new;
	@SearchWith(pageName = "desktop", elementName = "desktop_show_type")
	public WebElement desktop_show_type;
	@SearchWith(pageName = "desktop", elementName = "desktop")
	public WebElement desktop;
	@SearchWith(pageName = "desktop", elementName = "desktop1_1")
	public WebElement desktop1_1;
	@SearchWith(pageName = "desktop", elementName = "desktop_newDoc")
	public WebElement desktop_newDoc;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_11")
	public WebElement desktop_setting_doc_11;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_name_ok")
	public WebElement desktop_newFolder_name_ok;
	@SearchWith(pageName = "desktop", elementName = "desktop1_1_folder")
	public WebElement desktop1_1_folder;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_5")
	public WebElement desktop_setting_doc_5;
	@SearchWith(pageName = "desktop", elementName = "desktop1_2_folder")
	public WebElement desktop1_2_folder;
	@SearchWith(pageName = "desktop", elementName = "desktop_list_1_file")
	public WebElement desktop_list_1_file;
	@SearchWith(pageName = "desktop", elementName = "desktop_list_2_file")
	public WebElement desktop_list_2_file;
	@SearchWith(pageName = "desktop", elementName = "desktop_list_3_file")
	public WebElement desktop_list_3_file;
	@SearchWith(pageName = "desktop", elementName = "desktop_order")
	public WebElement desktop_order;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByUpdate")
	public WebElement desktop_orderByUpdate;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByCreate")
	public WebElement desktop_orderByCreate;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByFile")
	public WebElement desktop_orderByFile;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByOwner")
	public WebElement desktop_orderByOwner;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByFolderUP")
	public WebElement desktop_orderByFolderUP;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByDefault")
	public WebElement desktop_orderByDefault;
	@SearchWith(pageName = "desktop", elementName = "desktop_newSheet")
	public WebElement desktop_newSheet;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder")
	public WebElement desktop_newFolder;
	@SearchWith(pageName = "desktop", elementName = "desktop_import")
	public WebElement desktop_import;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_name")
	public WebElement desktop_newFolder_name;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_name_cancel")
	public WebElement desktop_newFolder_name_cancel;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_1")
	public WebElement desktop_setting_doc_1;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_2")
	public WebElement desktop_setting_doc_2;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_3")
	public WebElement desktop_setting_doc_3;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_6")
	public WebElement desktop_setting_doc_6;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_8")
	public WebElement desktop_setting_doc_8;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_9")
	public WebElement desktop_setting_doc_9;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_folder_9")
	public WebElement desktop_setting_folder_9;
	@SearchWith(pageName = "desktop", elementName = "desktop_set")
	public WebElement desktop_setting;
	@SearchWith(pageName = "desktop", elementName = "desktop_shortcut_1")
	public WebElement desktop_shortcut_1;
	@SearchWith(pageName = "desktop", elementName = "desktop_moveFolder_button")
	public WebElement desktop_moveFolder_button;
	@SearchWith(pageName = "desktop", elementName = "desktop_moveFolder_back_button")
	public WebElement desktop_moveFolder_back_button;
	@SearchWith(pageName = "desktop", elementName = "desktop_moveFolder_list_1")
	public WebElement desktop_moveFolder_list_1;
	@SearchWith(pageName = "desktop", elementName = "desktop_moveFolder_list_2")
	public WebElement desktop_moveFolder_list_2;

	// doc
	@SearchWith(pageName = "doc", elementName = "b_back")
	public WebElement b_back;
	@SearchWith(pageName = "doc", elementName = "doc_edit")
	public WebElement doc_edit;

	// dashboard
	@SearchWith(pageName = "dashboard", elementName = "dashboard_update_time")
	public WebElement dashboard_update_time;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_update_file")
	public WebElement dashboard_update_file;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_update_name")
	public WebElement dashboard_update_name;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_setting_doc_8")
	public WebElement dashboard_setting_doc_8;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_setting_doc_10")
	public WebElement dashboard_setting_doc_10;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_setting_doc_12")
	public WebElement dashboard_setting_doc_12;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_share_setting_doc_10")
	public WebElement dashboard_share_setting_doc_10;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_shareTime_1")
	public WebElement dashboard_shareTime_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_shareTime_unread")
	public WebElement dashboard_shareTime_unread;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_share_file")
	public WebElement dashboard_share_file;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_1")
	public WebElement dashboard_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_2")
	public WebElement dashboard_2;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_3")
	public WebElement dashboard_3;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_4")
	public WebElement dashboard_4;
	@SearchWith(pageName = "dashboard", elementName = "dashboard")
	public WebElement dashboard;
	@SearchWith(pageName = "dashboard", elementName = "favorites")
	public WebElement favorites;
	@SearchWith(pageName = "dashboard", elementName = "trash")
	public WebElement trash;

	// addCollaborator
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_close")
	public WebElement button_addCollaborator_close;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_1_list")
	public WebElement b_addCollaborator_1_list;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_2_list")
	public WebElement b_addCollaborator_2_list;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_3_list")
	public WebElement b_addCollaborator_3_list;
	@SearchWith(pageName = "addCollaborator", elementName = "list_addCollaborator_1")
	public WebElement list_addCollaborator_1;
	@SearchWith(pageName = "addCollaborator", elementName = "list_addCollaborator_4")
	public WebElement list_addCollaborator_4;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_total")
	public WebElement addCollaborator_total;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_1_add")
	public WebElement addCollaborator_1_add;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_companyList_2_add")
	public WebElement addCollaborator_companyList_2_add;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_company_list")
	public WebElement addCollaborator_company_list;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_back")
	public WebElement b_addCollaborator_back;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_confirm")
	public WebElement b_addCollaborator_confirm;
	@SearchWith(pageName = "addCollaborator", elementName = "list_addCollaborator_changeOwner_1")
	public WebElement list_addCollaborator_changeOwner_1;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_1_list_userName")
	public WebElement addCollaborator_1_list_userName;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_2_list_userName")
	public WebElement addCollaborator_2_list_userName;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_folder_add")
	public WebElement addCollaborator_folder_add;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator")
	public WebElement button_addCollaborator;
	@SearchWith(pageName = "addCollaborator", elementName = "input_addCollaborator")
	public WebElement input_addCollaborator;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_1_add")
	public WebElement b_addCollaborator_1_add;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_ok")
	public WebElement b_addCollaborator_ok;

}
