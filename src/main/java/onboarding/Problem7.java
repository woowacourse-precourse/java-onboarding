package onboarding;

import java.util.*;

public class Problem7 {

    static class Person {
        int score;
        String name;

        Person(int score, String name) {
            this.score = score;
            this.name = name;
        }
    }


    public static Map<String, Set<String>> createMap(List<List<String>> friends) {

        Map<String, Set<String>> answer = new HashMap<>();
        String f1, f2;


        for (List<String> friend : friends) {

            f1 = friend.get(0);
            f2 = friend.get(1);


            if (answer.containsKey(f1)) {
                answer.get(f1).add(f2);
            } else {
                answer.put(f1, new HashSet<>(List.of(f2)));
            }

            if (answer.containsKey(f2)) {
                answer.get(f2).add(f1);
            } else {
                answer.put(f2, new HashSet<>(List.of(f1)));
            }

        }

        return answer;

    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Set<String>> graph = createMap(friends);
        Map<String, Integer> score = new HashMap<>();


        for(String i : graph.get(user)){
            for(String j : graph.get(i)) {
                if (j.compareTo(user) == 0) {
                    continue;
                }
                if (score.containsKey(j)) {
                    score.replace(j, score.get(j)+10);
                } else {
                    score.put(j, 10);
                }
            }
        }


        for(String i : visitors){
            if(score.containsKey(i)) {
                score.replace(i, score.get(i) +1);
            } else {
                score.put(i, 1);
            }
        }


        for(String i : graph.get(user)) score.remove(i);

        List<Person> lst = new ArrayList<>();

        for(String i : score.keySet()) lst.add(new Person(score.get(i), i));


        Comparator<Person> comparator = (p1, p2) -> {
            if (p2.score != p1.score) {
                return p2.score - p1.score;
            } else {
                return p1.name.compareTo(p2.name);
            }
        };

        Collections.sort(lst, comparator);

        List<String> answer = new ArrayList<>();
        for (Person i : lst) answer.add(i.name);

        return answer;
    }
}
