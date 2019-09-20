package at.htl.football;

import java.util.ArrayList;
import java.util.List;

public class League {

    private List<Team> teams = new ArrayList<>();

    public void addMatchResult(Match match) {

        Team team = new Team(match.getHomeName());
        team.addMatch(match);

    }

    private Team findOrCreateTeam(String name) {

        if (teams.size() == 0) {

            teams.add(new Team(name));

        } else {

            for (int i = 0; i < teams.size(); i++) {

                if (teams.get(i).getName().equals(name)) {

                    return teams.get(i);

                }
            }

            teams.add(new Team(name));

            return new Team(name);

        }

        return null;

    }

    public List<Team> getTable() {

    }
}
