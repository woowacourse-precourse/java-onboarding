package onboarding.problem7;

public class Visitor {

    private String name;

    protected Visitor() {

    }

    public Visitor(String name) {
        this.name = name;
    }

    public static Visitor of(String name) {
        return new Visitor(name);
    }

    public String getName() {
        return name;
    }
}
