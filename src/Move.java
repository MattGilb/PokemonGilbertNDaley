public class Move {


    int dmg, pp;
    private String name;

    public Move(String name, int dmg, int pp) {


        this.name = name;
        this.dmg = dmg;
        this.pp = pp;

    }


    public String getName() {
        return name;
    }

    public int getDmg() {
        return dmg;
    }

    public int getPp() {
        return pp;
    }
}
