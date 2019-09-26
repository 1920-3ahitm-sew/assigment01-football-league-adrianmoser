package at.htl.football;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        League league = new League();

        Path file = Paths.get("bundesliga-1819.csv");

        String date;
        String homeTeam;
        String guestTeam;
        int homeGoals;
        int guestGoals;

        try {

            List<String> list = Files.readAllLines(file);

            for (int i = 1; i < list.size(); i++) {

                String line = list.get(i);
                String[] parts = line.split(";");
                homeTeam = parts[1];
                guestTeam = parts[2];
                homeGoals = Integer.parseInt(parts[3]);
                guestGoals = Integer.parseInt(parts[4]);

                league.addMatchResult(new Match(homeTeam, guestTeam, homeGoals, guestGoals));

            }


        } catch (IOException e) {

            e.printStackTrace();

        }

        printTable(league.getTable());

    }

    private static void printTable(List<Team> teamList) {

        System.out.printf("Team                Pts  W   D   L  GF  GA  GD");
        System.out.println();

        for (Team team : teamList) {

            System.out.print(team.getName());

            for (int i = 0; i < 20 - team.getName().length(); i++) {

                System.out.print(" ");

            }

            System.out.printf("%2d  %2d  %2d  %2d  %2d  %2d  %2d", team.getPoints(), team.getWins(), team.getDraws(), team.getDefeats(), team.getGoalsShot(), team.getGoalsReceived(), team.getGoalDifference());
            System.out.println();

        }

        System.out.println();
        System.out.print("Pts...Points, W...Won, D...Drawn, L...Lost");
        System.out.println();
        System.out.print("GF...Goals for, GA...Goals against, GD...Goal difference");

    }

}
