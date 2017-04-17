package data;

import model.Account;
import model.Campaign;
import model.Donation;
import model.Donation.Status;
import services.CampaignService;
import util.Events.Added;
import util.Events.Deleted;
import util.TestQualifier.MyService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@SessionScoped
public class CampaignListProducer implements Serializable
{
	private static final long serialVersionUID = -182866064791747156L;
	
	private List<Campaign> campaigns;
	
	@Inject 
	private CampaignService campaignService;

	@PostConstruct
	public void init()
	{
		campaigns = campaignService.getAllCampaigns();
	}
	
	public void onCampaignAdded(@Observes @Added Campaign campaign)
	{
		getCampaigns().add(campaign);
	}
	
	public void onCampaignDeleted(@Observes @Deleted Campaign campaign)
	{
		getCampaigns().remove(campaign);
	}
	
	@Produces
	@Named
	public List<Campaign> getCampaigns()
	{
		return campaigns;
	}

}