#ifndef _PLAYER_
#define _PLAYER_
#include "Country.hpp"
class Match;
class Player {
protected:
    int age;
    std::string name;
    int noMatches;
    bool female;
    Country* nationality;

public:
    // Constructor
    Player( bool gender,const std::string& nombre,int edad,const Country& nacionalidad)
        : female(gender),age(edad), name(nombre), noMatches(0){
            nationality = new Country(nacionalidad);
        }

    // Getters
    int getAge() const {
        return age;
    }

    std::string getName() const {
        return name;
    }
    bool isFemale(){
        return female;
    }
    int getNoMatches() const {
        return noMatches;
    }

    Country* getNationality() const {
        return nationality;
    }
    virtual void updateStats(Match * m)=0;
    virtual void printStats()=0;
};
#endif