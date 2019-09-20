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

            List<String> list = new ArrayList<>();
            list = Files.readAllLines(file);

            for (int i = 0; i < list.size(); i++) {

                String line = list.get(i);
                String[] parts = line.split(";");
                date = parts[0];
                homeTeam = parts[1];
                guestTeam = parts[2];
                homeGoals = Integer.parseInt(parts[3]);
                guestGoals = Integer.parseInt(parts[4]);

                league.addMatchResult(new Match(homeTeam, guestTeam, homeGoals, guestGoals));

            }


        } catch (IOException e) {

            e.printStackTrace();

        }



    }

    private void printTable(List<Team> teamList) {


    }

}
