package onboarding.problem6.domain;

import java.util.HashSet;
import java.util.Set;

public class Nickname {

    private final String name;

    public Nickname(String name) {
        this.name = name;
    }

    public Set<String> allSubStringWithSize(int size) {
        Set<String> result = new HashSet<>();
        int length = name.length();

        for (int i = 0; i <= length-2; i++) {
            result.add(name.substring(i, i+2));
        }
        return result;
    }
}
