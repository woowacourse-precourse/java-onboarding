package onboarding.problem3.objects;

public class Rule {

    private Clap clap;

    public Rule(Clap clap) {
        this.clap = clap;
    }

    public int numberComeTrue(int number) {
        return clap.getClapCount(number);
    }
}
