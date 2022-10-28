package onboarding.domain.problem6;

public class Person {
    private Nickname name;
    public Person(String name) {
        this.name = new Nickname(name);
    }

    public boolean hasOverlapName(Person other) {
        return name.hasOverlap(other.name);
    }
}
