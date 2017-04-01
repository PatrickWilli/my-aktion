package myaktion.test;

import model.Donation;
import myaktion.test.pages.DonateMoneyPage;
import myaktion.test.pages.EditDonationFormPage;
import myaktion.test.pages.ListCampaignsPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class DonateMoneyITCase extends AbstractITCase
{
	@Drone
	private WebDriver browser;
	@Page
	private EditDonationFormPage editDonationFormPage;
	@Page
	private DonateMoneyPage donateMoneyPage;

	@Before
	public void setupDatabase()
	{
		SetupDatabase.addCampaign(DataFactory.createTestCampaign());
	}

	@Test
	public void testDonateMoney(@InitialPage ListCampaignsPage listCampaignsPage)
	{
		listCampaignsPage.clickCampaignUrl();
		editDonationFormPage.assertOnPage();
		browser.get(editDonationFormPage.getFormURL());
		donateMoneyPage.assertOnPage();
		donateMoneyPage.setDonation(DataFactory.createDonation());
		donateMoneyPage.doDonation();
		donateMoneyPage.assertThankYou();
	}
}