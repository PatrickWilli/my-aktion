package controller;

import model.Donation.Status;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class ListDonationsController implements Serializable
{
	private static final long serialVersionUID = 437878972432L;

	public String doOk()
	{
		return Pages.LIST_CAMPAIGNS;
	}
}