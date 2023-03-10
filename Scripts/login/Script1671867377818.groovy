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
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.testobject.SelectorMethod as SelectorMethod
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join
import org.testng.asserts.SoftAssert as SoftAssert
import com.kms.katalon.core.testdata.CSVData as CSVData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import myPack.SelectBy as by

WebUI.openBrowser('')

def driver = DriverFactory.getWebDriver()

selenium = new WebDriverBackedSelenium(driver, GlobalVariable.baseUrl)

selenium.open(GlobalVariable.baseUrl)

selenium.waitForPageToLoad(GlobalVariable.pageLoadWT) 

WebUI.click(by.xpath('//*[@id=\'UserName\']'))

selenium.type('id=UserName', 'ali.pnhyn'.toString())

selenium.type('id=Password', 'a`123456'.toString())

selenium.click('xpath=//button[@type=\'submit\']')

WebUI.waitForElementPresent(by.xpath('//*[@id=\'select2-TenantsID-container\']'), GlobalVariable.elementPresentWT)

selenium.click('id=select2-TenantsID-container')

selenium.click('xpath=/html/body/span/span/span[2]/ul/li[5]')

selenium.click('id=enter')

selenium.waitForPageToLoad(GlobalVariable.pageLoadWT)

GlobalVariable.response = ''

try {
    GlobalVariable.response = selenium.getText('xpath=/html/body/div[2]/div[1]/a/strong')
}
catch (Exception e) {
    println(e)
} 

assert(GlobalVariable.response != '')

