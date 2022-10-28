package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");

        System.out.println(solution(user, friends, visitors));

    }

    static class Person {

        private String name;
        private int score;

        public Person(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Integer> map = new HashMap<>();

        List<String> user_friends = new ArrayList<>();
        List<String> list;

        for (int i = 0; i < friends.size(); i++) {
            list = friends.get(i);
            if (list.get(0).equals(user)) {
                user_friends.add(list.get(1));
            }
            if (list.get(1).equals(user)) {
                user_friends.add(list.get(0));
            }
            map.put(list.get(0), 0);
            map.put(list.get(1), 0);
        }

        for (int i = 0; i < friends.size(); i++) {
            list = friends.get(i);
            for (int j = 0; j < user_friends.size(); j++) {
                if (list.get(0).equals(user_friends.get(j))) {
                    map.put(list.get(1), map.get(list.get(1)) + 10);
                }
                if (list.get(1).equals(user_friends.get(j))) {
                    map.put(list.get(0), map.get(list.get(0)) + 10);
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            map.put(visitors.get(i), map.getOrDefault(visitors.get(i), 0) + 1);
        }

        List<Person> people = new ArrayList<>();
        for (String name : map.keySet()) {
            people.add(new Person(name, map.get(name)));
        }

        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if  (o2.score == o1.score) {
                    o1.name.compareTo(o2.name);
                }
                return o2.score - o1.score;
            }
        });

        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (people.get(i).score != 0) {
                answerList.add(people.get(i).name);
            }
        }

        return answerList;
    }
}
