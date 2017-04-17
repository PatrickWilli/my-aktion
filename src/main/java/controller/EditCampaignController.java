package controller;

import data.CampaignListProducer;
import data.CampaignProducer;
import model.Campaign;
import util.Events.Added;
import util.Events.Deleted;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class EditCampaignController implements Serializable
{
	private static final long serialVersionUID = 2815796004558360299L;

	@Inject
	private CampaignProducer campaignProducer;
	
	@Inject 
	@Added
	private Event<Campaign> campaignAddEvent;

	/*@Inject
	public EditCampaignController(CampaignListProducer campaignListProducer)
	{
		this.campaignListProducer = campaignListProducer;
	}*/
	
	/*public void setCampaignListProducer(CampaignListProducer campaignListProducer)
	{
		this.campaignListProducer = campaignListProducer;
	}*/
	
	public String doSave()
	{
		if (campaignProducer.isAddMode())
		{
			//campaignListProducer.getCampaigns().add(campaignProducer.getSelectedCampaign());
			campaignAddEvent.fire(campaignProducer.getSelectedCampaign());
		}
		return Pages.LIST_CAMPAIGNS;
	}

	public String doCancel()
	{
		return Pages.LIST_CAMPAIGNS;
	}
}