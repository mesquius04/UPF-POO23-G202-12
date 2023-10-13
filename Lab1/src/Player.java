public class Player {
    private boolean female;
    private String name;
    private int age;
    private Country nationality;
    private int noMatches;
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    private int noGoals;

    public Player(boolean g,String n,int a,Country nat){
        female=g;
        name=n;
        age=a;
        nationality=nat;
        noMatches=0;
        noAssists=0;
        noGoals=0;
        noPasses=0;
        noShots=0;
        noTackles=0;
    }
    public boolean isFemale(){
        return female;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public Country getNationality(){
        return nationality;
    }
    public void update(int t,int p,int s,int a,int g){
        noMatches++;
        noTackles+=t;
        noGoals+=g;
        noShots+=s;
        noPasses+=p;
        noAssists+=a;
    }
    public void printStats(){
        System.out.println(noMatches);
        System.out.println(noGoals);
        System.out.println(noAssists);
        System.out.println(noPasses);
        System.out.println(noShots);
        System.out.println(noTackles);
    }
}
