package onboarding.problem3.objects;

public class Player {

    private Clap clap;

    public Player(int number) {
        this.clap = new Clap(number);
    }

    public int numberComeTrue(Rule rule) {
        return rule.numberComeTrue(this.clap);
    }
}
