package ch.squix.extraleague.server;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.UnsupportedEncodingException;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import ch.squix.extraleague.model.league.League;

import com.google.appengine.api.NamespaceManager;



public class AddLeagueResource extends ServerResource {
	
	@Get(value = "json")
	public String execute() throws UnsupportedEncodingException {
		String leagueName = (String) this.getRequestAttributes().get("leagueName");
		String domain = (String) this.getRequestAttributes().get("domain");
		League league = new League();
		league.setDomain(domain);
		league.setName(leagueName);

		String oldNamespace = NamespaceManager.get();
		try {
			NamespaceManager.set("");
			ofy().save().entity(league).now();
			return "OK";
		} finally {
		  NamespaceManager.set(oldNamespace);
		}

	}

}