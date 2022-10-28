package onboarding.problem3.objects;

public class Player {

    private Clap clap;

    public Player(int number) {
        this.clap = new Clap();
    }

    public int numberComeTrue(int num, Rule rule) {
        return rule.numberComeTrue(num, clap);
    }
}
