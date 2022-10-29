package onboarding;

import java.util.Objects;

class Person {

    private final String name;
    private int point = 0;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int point) {
        this(name);
        this.point = point;
    }

    public void plusOnePoint() {
        this.point += 1;
    }

    public int getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
