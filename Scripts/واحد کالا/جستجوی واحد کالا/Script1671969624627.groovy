import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.SelectorMethod

import com.thoughtworks.selenium.Selenium
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join
import org.testng.asserts.SoftAssert
import com.kms.katalon.core.testdata.CSVData
import org.openqa.selenium.Keys as Keys
import myPack.SelectBy as by

def driver = DriverFactory.getWebDriver()
selenium = new WebDriverBackedSelenium(driver, GlobalVariable.baseUrl)
selenium.open(GlobalVariable.baseUrl)


selenium.click("xpath=//li[@id='menu_base']/a")
selenium.click("xpath=//li[@id='menu_unit']/a/span")
selenium.waitForPageToLoad(GlobalVariable.pageLoadWT)
selenium.selectFrame("index=0")

GlobalVariable.randomNum = selenium.getEval("Math.floor(1000000+Math.random()*10000000)").toInteger()+1000000
selenium.click("id=Name")
selenium.type("id=Name", (GlobalVariable.randomNum).toString())
selenium.click("id=btnregister")

driver.switchTo().defaultContent()
try {
	selenium.getText("xpath=//div[@id='toast-container']/div/div")
}
catch (Exception e) {
	this.println(e)
}
selenium.selectFrame("index=0")
selenium.click("xpath=//input[@type='search']")
WebUI.setText(by.xpath("//input[@type='search']"), "xxx no match found xxx")
WebUI.waitForElementPresent(by.xpath("//*[contains(text(),'موردی یافت نشد')]"), GlobalVariable.elementPresentWT)
selenium.type("xpath=//input[@type='search']", (GlobalVariable.randomNum).toString())
WebUI.waitForElementPresent(by.xpath("//*[@id='_dataTable']/tbody/tr[1]/td[2]"), GlobalVariable.elementPresentWT)
GlobalVariable.response = selenium.getText("xpath=//*[@id=\"_dataTable\"]/tbody/tr[1]/td[2]")
if((GlobalVariable.response).contains(GlobalVariable.randomNum.toString()))
	CustomKeywords.'myPack.ReadWriteExcel.report'("جستجوی واحد کالا","passed")
else
	CustomKeywords.'myPack.ReadWriteExcel.report'("جستجوی واحد کالا","passed")
	
