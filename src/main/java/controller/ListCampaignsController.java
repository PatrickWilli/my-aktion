package controller;

import model.Campaign;
import util.Events.Deleted;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import data.CampaignProducer;

import java.io.Serializable;

@ViewScoped
@Named
public class ListCampaignsController implements Serializable
{
	private static final long serialVersionUID = 8693277383648025822L;
	@Inject
	private CampaignProducer campaignProducer;
	private Campaign campaignToDelete;
	@Inject @Deleted
	private Event<Campaign> campaignDeleteEvent;

	public String doAddCampaign()
	{
		campaignProducer.prepareAddCampaign();
		return Pages.EDIT_CAMPAIGN;
	}

	public String doEditCampaign(Campaign campaign)
	{
		campaignProducer.prepareEditCampaign(campaign);
		return Pages.EDIT_CAMPAIGN;
	}

	public String doEditDonationForm(Campaign campaign)
	{
		campaignProducer.setSelectedCampaign(campaign);
		return Pages.EDIT_DONATION_FORM;
	}

	public String doListDonations(Campaign campaign)
	{
		campaignProducer.setSelectedCampaign(campaign);
		return Pages.LIST_DONATIONS;
	}

	public void doDeleteCampaign(Campaign campaign) 
	{
		this.campaignToDelete = campaign;
		System.out.println("Aktion zum löschen vorgemerkt");
	}
	
	public void commitDeleteCampaign() 
	{
		campaignDeleteEvent.fire(campaignToDelete);
	}
}