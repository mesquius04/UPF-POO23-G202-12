#include <iostream>
#include "Player.hpp"
#include "Match.hpp"
#include "Team.hpp"
#include "Goalkeeper.hpp"
#include "Outfielder.hpp"
#include "Country.hpp"

int main() {

    Country country1("Spain");
    Country country2("France");
    

    Goalkeeper gplayer1(false, "Alex", 21, country1);
    Goalkeeper gplayer2(true, "Maria", 22, country2);

    Outfielder player1(false, "Marti", 19, country1);
    Outfielder player2(true, "Marc", 19, country2);


    Team team1("Team 1", &country1, Team::MALE);
    Team team2("Team 2", &country2, Team::FEMALE);

    team1.addPlayer(&player1);
    team1.addPlayer(&gplayer1);

    team2.addPlayer(&player2);
    team2.addPlayer(&gplayer2);
    
    Match match(&team1, &team2);

    match.simulateMatch();
    match.printMatch();


    for (Player *player : team1.getPlayers()) {
        player->updateStats(&match);
    }

    for (Player *player : team2.getPlayers()) {
        player->updateStats(&match);
    }

    
    for (Player *player : team1.getPlayers()) {
        player->printStats();
    }

    for (Player *player : team2.getPlayers()) {
        player->printStats();
    }

    return 0;
}
