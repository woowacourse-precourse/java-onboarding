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

        int getVisit() {
            return visit;
        }

        void count() {
            visit++;
        }
    }

    static class Persons {
        Map<String, Person> personMap;
        String user;

        Persons(String user) {
            this.user = user;
            personMap = new HashMap<>();
        }
        Person getPerson(String name) {
            if(exists(name)) {
                return personMap.get(name);
            }
            return personMap.put(name, new Person(name));
        }
        boolean exists(String name) {
            return personMap.containsKey(name);
        }
        void countVisit(List<String> visitors) {
            for(String visitor : visitors) {
                getPerson(visitor).count();
            }
        }

        int numOfFriends(String name) {
            return numOfIntersection(getPerson(user).friends, getPerson(name).friends);
        }

        int numOfIntersection(Set<Person> a, Set<Person> b) {
            if(a.isEmpty() || b.isEmpty()) {
                return 0;
            }
            int count = 0;
            for(Person friend : a) {
                if(b.contains(friend)) {
                    count++;
                }
            }
            return count;
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
