package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.selectPage;

public class selectTest extends BaseTest {
	private selectPage selectablePage;

	private final String baseUrl = "https://demoqa.com/selectable";


	@Test(priority = 1)
	public void testSelectFromList() {
		selectablePage = new selectPage(driver);
		driver.get(baseUrl);
		
		Assert.assertTrue(selectablePage.isListTabActive(), "List tab must be active by default!");

		selectablePage.selectItemInList();

		Assert.assertTrue(selectablePage.isSelectedItemInListActive(),
				"Expected select in list value not selected correctly!");
	}

	@Test(priority = 2)
	public void testSelectFromGrid() {
		selectablePage.clickGridTab();

		Assert.assertTrue(selectablePage.isGridTabActive(), "Grid tab must be active after click on it!");

		selectablePage.selectItemInGrid();

		Assert.assertTrue(selectablePage.isSelectedItemInGridActive(),
				"Expected select in grid value not selected correctly!");
	}

}
