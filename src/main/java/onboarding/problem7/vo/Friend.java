package onboarding.problem7.vo;

import java.util.Objects;

public class Friend {
    private final String name;

    private Friend(String name) {
        this.name = name;
    }

    public static Friend of(String name) {
        return new Friend(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Friend))
            return false;
        Friend friend = (Friend)o;
        return name.equals(friend.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                '}';
    }
}
