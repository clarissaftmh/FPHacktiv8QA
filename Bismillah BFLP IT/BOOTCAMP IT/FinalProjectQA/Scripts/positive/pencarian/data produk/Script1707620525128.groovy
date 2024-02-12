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

import com.kms.katalon.core.testdata.TestDataFactory

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Ambil data dari file CSV
def testData = TestDataFactory.findTestData("Data Files/pencarian_data/data produk")

// Looping untuk setiap baris data
for (def row = 1; row <= testData.getRowNumbers(); row++) {
	// Ambil nilai dari kolom-kolom yang diperlukan
	def namaProduk = testData.getValue("namaProduk", row)
	def hargaProduk = testData.getValue("rentangHarga", row)

	// Lakukan pengujian pencarian produk
	WebUI.openBrowser('')
	WebUI.maximizeWindow()
	WebUI.navigateToUrl('https://advantageonlineshopping.com/#/')

	// Masukkan nama produk ke dalam kotak pencarian
	
	WebUI.click(findTestObject('Object Repository/positive/pencarian/input valid/svg_Sign out_menuSearch'))
	WebUI.setText(findTestObject('Object Repository/positive/pencarian/input valid/input_Sign out_autoComplete'), namaProduk)
	
	WebUI.click(findTestObject('Object Repository/data driven/product card'))

//	WebUI.click(findTestObject('Object Repository/data driven/result'))

	// Verifikasi apakah produk ditemukan
	
//	WebUI.verifyElementPresent(findTestObject('Object Repository/data driven/product name').replace('{namaProduk}', namaProduk))
//	WebUI.verifyElementText(findTestObject('Object Repository/data driven/product price').replace('{namaProduk}', namaProduk), hargaProduk)

//	// Verifikasi nama produk
//	WebUI.verifyElementPresent(findTestObject('xpath://div[@class="product"]/span[contains(text(), "' + namaProduk + '")]'))
//	
//	// Verifikasi harga produk
//	WebUI.verifyElementPresent(findTestObject('xpath://div[@class="product"]/span[contains(text(), "' + hargaProduk + '")]'))
//	

	WebUI.closeBrowser()
}
