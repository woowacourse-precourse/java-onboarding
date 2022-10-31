package onboarding;

import java.util.ArrayList;
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
            Person newPerson = new Person(name);
            personMap.put(name, newPerson);
            return newPerson;
        }
        boolean exists(String name) {
            return personMap.containsKey(name);
        }
        void countVisit(List<String> visitors) {
            for(String visitor : visitors) {
                getPerson(visitor).count();
            }
        }

        void addFriends(List<List<String>> friends) {
            for(List<String> friend : friends) {
                addFriend(friend);
            }
        }
        void addFriend(List<String> friend) {
            Person a = getPerson(friend.get(0));
            Person b = getPerson(friend.get(1));
            a.friends.add(b);
            b.friends.add(a);
        }
        int getScore(Person p) {
            String name = p.name;
            int score = 0;
            score += numOfFriends(name) * 10;
            score += getPerson(name).getVisit();
            return score;
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
        boolean isFriend(String a, String b) {
            return getPerson(a).friends.contains(getPerson(b));
        }

        List<Person> getRecommendedFriendsList() {
            List<Person> list = new ArrayList<>();
            for(String name : personMap.keySet()) {
                if(name.equals(user) || isFriend(user, name)) {
                    continue;
                }
                list.add(getPerson(name));
            }
            return list;
        }
    }
    static void sortByName(List<Person> list) {
        Collections.sort(list, (a, b) -> a.name.compareTo(b.name));
    }

    static void sortByScore(List<Person> list, Persons persons) {
        Collections.sort(list, (a, b) -> Integer.compare(persons.getScore(b), persons.getScore(a)));
    }

    static List<String> topFive(List<Person> list, Persons persons) {
        List<String> topFive = new ArrayList<>();
        for(Person p : list) {
            if(persons.getScore(p) == 0) break;
            topFive.add(p.name);
            if(topFive.size() >= 5) break;
        }
        return topFive;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Persons persons = new Persons(user);
        persons.countVisit(visitors);
        persons.addFriends(friends);
        List<Person> list = persons.getRecommendedFriendsList();
        sortByName(list);
        sortByScore(list, persons);
        List<String> answer = topFive(list, persons);

        return answer;
    }
}
