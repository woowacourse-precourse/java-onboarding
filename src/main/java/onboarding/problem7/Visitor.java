package onboarding.problem7;

public class Visitor {

    private String name;

    protected Visitor() {

    }

    public Visitor(String name) {
        NameValidator.validateName(name);
        this.name = name;
    }

    public static Visitor create(String name) {
        return new Visitor(name);
    }

    public String getName() {
        return name;
    }
}
