#ifndef _OUTFIELDER_
#define _OUTFIELDER_
#include "Player.hpp"
#include "Match.hpp"
class Outfielder : public Player {
private:
    int noTackles;
    int noPasses;
    int noShots;
    int noAssists;
    int noGoals;

public:

    Outfielder(bool gender, const std::string& nombre, int edad, const Country& nacionalidad)
        : Player(gender, nombre, edad, nacionalidad), noTackles(0),noAssists(0),noShots(0),noGoals(0),noPasses(0) {}


    void updateStats(Match *m) override {

        //UPDATE DE STATS
        if (m->getTeamOne()->inTeam(this)) {
            noMatches++;
            noAssists += rand() % (4);
            noPasses += rand() % (21);
            noShots += rand() % (5);
            noTackles += rand() % (8);
        } else {
            noMatches++;
            noAssists += rand() % (4);
            noPasses += rand() % (21);
            noShots += rand() % (5);
            noTackles += rand() % (8);
        }
        noGoals+=m->countGoals(this);
    }

    void printStats() override {
        std::cout << "Nombre: " << getName() << std::endl;
        std::cout << "Edad: " << getAge() << std::endl;
        std::cout << "Partidos jugados: " << getNoMatches() << std::endl;
        std::cout << "Goles: " << noGoals << std::endl;
        std::cout << "Asistencias: " << noAssists << std::endl;
        std::cout << "Pases: " << noPasses << std::endl;
        std::cout << "Tiros: " << noShots << std::endl;
        std::cout << "Entradas: " << noTackles << std::endl;
    }
};
#endif