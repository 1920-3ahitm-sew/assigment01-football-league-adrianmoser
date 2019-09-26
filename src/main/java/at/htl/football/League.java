package at.htl.football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League {

    private List<Team> teams = new ArrayList<>();

    public void addMatchResult(Match match) {

        Team team = findOrCreateTeam(match.getHomeName());
        Team guestTeam = findOrCreateTeam(match.getGuestName());

        team.addMatch(match);
        guestTeam.addMatch(match);

    }

    private Team findOrCreateTeam(String name) {

        for (Team team : teams) {

            if (team.getName().equals(name)) {

                return team;

            }

        }

        Team oTeam = new Team(name);

        teams.add(oTeam);

        return oTeam;

    }

    public List<Team> getTable() {

        Collections.sort(teams);

        return teams;

    }
}
