package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    static class Person {
        String name;
        int visit;
        Set<Person> friends;
        Person(String name) {
            this.name = name;
            this.visit = 0;
            this.friends = new HashSet<>();
        }
    }

    static class Persons {
        Map<String, Person> personMap;

        Persons() {
            personMap = new HashMap<>();
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
