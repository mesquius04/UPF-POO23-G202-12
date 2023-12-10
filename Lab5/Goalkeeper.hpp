#ifndef _GOALKEEPER_
#define _GOALKEEPER_
#include "Player.hpp"
#include "Match.hpp"
class Goalkeeper : public Player {
private:
    int noSaves;
    int noGoalsLet;

public:

    Goalkeeper(bool gender, const std::string& nombre, int edad, const Country& nacionalidad)
        : Player(gender, nombre, edad, nacionalidad), noSaves(0),noGoalsLet(0) {}


    void updateStats(Match *m) override {
        
        //UPDATE DE GOLES
        if (m->getTeamOne()->inTeam(this)) {
            noMatches++;
            noGoalsLet += m->getGoalTwo();
        } else {
            noMatches++;
            noGoalsLet += m->getGoalOne();
        }

        //UPDATE DE PARADAS
        noSaves += rand() % (7);
        
    }
    void printStats() override {
        std::cout << "Nombre: " << getName() << std::endl;
        std::cout << "Edad: " << getAge() << std::endl;
        std::cout << "Partidos jugados: " << getNoMatches() << std::endl;
        std::cout << "Paradas: " << noSaves << std::endl;
        std::cout << "Goles en contra: " << noGoalsLet << std::endl;
    }
};
#endif