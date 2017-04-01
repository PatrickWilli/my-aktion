package myaktion.test;

import model.Campaign;
import myaktion.test.pages.EditCampaignPage;
import myaktion.test.pages.ListCampaignsPage;
import org.jboss.arquillian.graphene.Graphene;

public class SetupDatabase
{
	public static void addCampaign(final Campaign campaign)
	{
		final EditCampaignPage editCampaignPage = Graphene.goTo(EditCampaignPage.class);
		final ListCampaignsPage listCampaignsPage = Graphene.goTo(ListCampaignsPage.class);
		listCampaignsPage.doAddCampaign();
		editCampaignPage.assertOnPage();
		editCampaignPage.setCampaign(campaign);
		editCampaignPage.doSave();
	}
}
