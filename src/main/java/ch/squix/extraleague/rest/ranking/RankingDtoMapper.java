package ch.squix.extraleague.rest.ranking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ch.squix.extraleague.model.ranking.EternalRanking;
import ch.squix.extraleague.model.ranking.PlayerRanking;
import ch.squix.extraleague.model.ranking.Ranking;

public class RankingDtoMapper {

	private static RankingsDto getRankingDtos(List<PlayerRanking> playerRankings, Date createdDate) {
		List<RankingDto> playerRankingList = new ArrayList<>();
		if (playerRankings != null) {
			for (PlayerRanking playerRanking : playerRankings) {
				RankingDto rankingDto = new RankingDto();
				rankingDto.setPlayer(playerRanking.getPlayer());
				rankingDto.setGamesWon(playerRanking.getGamesWon());
				rankingDto.setGamesLost(playerRanking.getGamesLost());
				rankingDto.setRanking(playerRanking.getRanking());
				rankingDto.getBadges().clear();
				rankingDto.getBadges().addAll(playerRanking.getBadges());
				rankingDto.setGoalsMade(playerRanking.getGoalsMade());
				rankingDto.setGoalsGot(playerRanking.getGoalsGot());
				rankingDto.setOffensivePositionRate(playerRanking.getOffensivePositionRate());
				rankingDto.setDefensivePositionRate(playerRanking.getDefensivePositionRate());
				rankingDto.setOffensiveGoalsRate(playerRanking.getOffensiveGoalsRate());
				rankingDto.setBestPartner(playerRanking.getBestPartner());
				rankingDto.setBestPartnerRate(playerRanking.getBestPartnerRate());
				rankingDto.setWorstPartner(playerRanking.getWorstPartner());
				rankingDto.setWorstPartnerRate(playerRanking.getWorstPartnerRate());
				rankingDto.setBestOpponent(playerRanking.getBestOpponent());
				rankingDto.setBestOpponentRate(playerRanking.getBestOpponentRate());
				rankingDto.setWorstOpponent(playerRanking.getWorstOpponent());
				rankingDto.setWorstOpponentRate(playerRanking.getWorstOpponentRate());
				rankingDto.setAverageSecondsPerMatch(playerRanking.getAverageSecondsPerMatch());
				rankingDto.setCurrentShapeRate(playerRanking.getCurrentShapeRate());
				rankingDto.setPlayedWith(playerRanking.getPlayedWith());
				rankingDto.setNeverPlayedWith(playerRanking.getNeverPlayedWith());
				rankingDto.setTightlyLostRate(playerRanking.getTightlyLostRate());
				rankingDto.setTightlyWonRate(playerRanking.getTightlyWonRate());
				rankingDto.setPartners(PlayerComboDtoMapper.mapToDtos(playerRanking.getPartners()));
				rankingDto.setOpponents(PlayerComboDtoMapper.mapToDtos(playerRanking.getOpponents()));
				rankingDto.setEloValue(playerRanking.getEloValue());
				rankingDto.setAverageGoalsPerMatch(playerRanking.getAverageGoalsPerMatch());
				rankingDto.setEloRanking(playerRanking.getEloRanking());
				rankingDto.setScoreHistogram(playerRanking.getScoreHistogram());
				rankingDto.setTrueSkillRating(playerRanking.getTrueSkillRating());
				rankingDto.setTrueSkillRanking(playerRanking.getTrueSkillRanking());
				rankingDto.setTrueSkillMean(playerRanking.getTrueSkillMean());
				rankingDto.setTrueSkillSigma(playerRanking.getTrueSkillSigma());
				rankingDto.setMaxGoalsPerGame(playerRanking.getMaxGoalsPerGame());
				rankingDto.setAchievementPoints(playerRanking.getAchievementPoints());
				rankingDto.setBestSlam(playerRanking.getBestSlam());
				rankingDto.setRankingDelta(playerRanking.getRankingDelta());
				rankingDto.setEloDelta(playerRanking.getEloDelta());
				playerRankingList.add(rankingDto);
			}
		}
		return new RankingsDto(playerRankingList, createdDate);
	}

	public static RankingsDto convertToDto(EternalRanking ranking) {
		if (ranking != null) {
			return getRankingDtos(ranking.getPlayerRankings(), ranking.getCreatedDate());
		}
		return new RankingsDto();
	}

	public static RankingsDto convertToDto(Ranking ranking) {
		if (ranking == null || ranking.getPlayerRankings() == null) {
			return new RankingsDto();
		}
		return getRankingDtos(ranking.getPlayerRankings(), ranking.getCreatedDate());
	}

	public static RankingDto getPlayerRanking(String player, Ranking ranking) {
		RankingsDto rankings = convertToDto(ranking);
		for (RankingDto dto : rankings.getRankings()) {
			if (dto.getPlayer().equals(player)) {
				return dto;
			}
		}
		return null;
	}
	
	public static RankingDto getPlayerRanking(String player, EternalRanking ranking) {
		RankingsDto rankings = convertToDto(ranking);
		for (RankingDto dto : rankings.getRankings()) {
			if (dto.getPlayer().equals(player)) {
				return dto;
			}
		}
		return null;
	}

}
