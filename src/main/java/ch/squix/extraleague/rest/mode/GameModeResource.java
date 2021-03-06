package ch.squix.extraleague.rest.mode;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import ch.squix.extraleague.model.league.League;
import ch.squix.extraleague.model.league.LeagueDao;
import ch.squix.extraleague.rest.games.GamesResource;
import ch.squix.extraleague.rest.games.mode.GameMode;
import ch.squix.extraleague.rest.games.mode.GameModeEnum;



public class GameModeResource extends ServerResource {
	
	private static final Logger log = Logger.getLogger(GamesResource.class.getName());
	
	@Get(value = "json")
	public List<GameModeDto> execute() throws UnsupportedEncodingException {
		League currentLeague = LeagueDao.getCurrentLeague();
		List<GameModeEnum> filteredGameModes = currentLeague.getFilteredGameModes();
		List<GameModeDto> dtos = new ArrayList<>();
		for(GameModeEnum mode : GameModeEnum.values()) {
			GameModeDto dto = new GameModeDto();
			dto.setName(mode.name());
			dto.setLabel(mode.getLabel());
			dto.setDescription(mode.getDescription());
			if (filteredGameModes != null && !filteredGameModes.contains(mode)) {
				dtos.add(dto);
			}
		}
		return dtos;
	}
}