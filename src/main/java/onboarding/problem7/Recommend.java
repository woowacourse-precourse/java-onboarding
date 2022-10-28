package onboarding.problem7;

public class Recommend {

    private String name;
    private Integer score;

    public Recommend(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public static Recommend create(String name, Integer score) {
        return new Recommend(name, score);
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }
}
