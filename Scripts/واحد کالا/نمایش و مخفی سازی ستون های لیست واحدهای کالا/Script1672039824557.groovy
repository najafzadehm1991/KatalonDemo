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

def driver = DriverFactory.getWebDriver()
selenium = new WebDriverBackedSelenium(driver, GlobalVariable.baseUrl)
selenium.open(GlobalVariable.baseUrl)

selenium.click("xpath=//li[@id='menu_base']/a")
selenium.click("xpath=//li[@id='menu_unit']/a/span")
selenium.waitForPageToLoad(GlobalVariable.pageLoadWT)
selenium.selectFrame("index=0")

GlobalVariable.successStep = "undefined"
selenium.click("xpath=//div[@id='_dataTable_wrapper']/div/div[2]/button[4]/span/i")
selenium.click("xpath=//div[@id='_dataTable_wrapper']/div/div[2]/div[2]/button")
GlobalVariable.response = selenium.getText("xpath=//*[@id=\"_dataTable\"]/thead/tr/th[1]")
if (GlobalVariable.response!="ردیف") {
selenium.click("xpath=//div[@id='_dataTable_wrapper']/div/div[2]/div[2]/button")
GlobalVariable.response = selenium.getText("xpath=//*[@id=\"_dataTable\"]/thead/tr/th[1]")
if (GlobalVariable.response=="ردیف") {
selenium.click("xpath=//div[@id='_dataTable_wrapper']/div/div[2]/div[2]/button[2]")
GlobalVariable.response = selenium.getText("xpath=//*[@id=\"_dataTable\"]/thead/tr/th[2]")
if (GlobalVariable.response!="عنوان") {
selenium.click("xpath=//div[@id='_dataTable_wrapper']/div/div[2]/div[2]/button[2]")
GlobalVariable.response = selenium.getText("xpath=//*[@id=\"_dataTable\"]/thead/tr/th[2]")
if (GlobalVariable.response=="عنوان") {
selenium.click("xpath=//div[@id='_dataTable_wrapper']/div/div[2]/div[2]/button[3]/span")
int i = 0
i = selenium.getXpathCount("xpath=//*[@id=\"_dataTable\"]/thead/tr/th[3]").toInteger()
if (i==0) {
selenium.click("xpath=//div[@id='_dataTable_wrapper']/div/div[2]/div[2]/button[3]/span")
GlobalVariable.response = selenium.getText("xpath=//*[@id=\"_dataTable\"]/thead/tr/th[3]")
if (GlobalVariable.response=="عملیات") {
	GlobalVariable.successStep = "passed"
					}
				}
			}
		}
	}
}
if(GlobalVariable.successStep == "passed")
	CustomKeywords.'myPack.ReadWriteExcel.report'("نمایش و مخفی سازی ستون های لیست واحدهای کالا","failed")
else
	CustomKeywords.'myPack.ReadWriteExcel.report'("نمایش و مخفی سازی ستون های لیست واحدهای کالا","failed")
