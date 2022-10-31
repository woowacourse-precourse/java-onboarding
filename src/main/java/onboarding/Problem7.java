package onboarding;

import java.util.*;

public class Problem7 {


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, Set<String>> person2Friends = createPerson2Friends(friends);
        Map<String, Integer> person2Score = createPerson2Score(user, visitors, person2Friends);
        pickUpTop5ByScore(user, answer, person2Friends, person2Score);
        return answer;
    }

    private static Map<String, Set<String>> createPerson2Friends(List<List<String>> friends) {
        Map<String, Set<String>> person2Friends = new HashMap<>();
        for (List<String> friend : friends) {
            for (int i = 0; i < friend.size(); i++) {
                String person1 = friend.get(i);
                String person2 = friend.get((i + 1) % 2);
                if (!person2Friends.containsKey(person1)) {
                    person2Friends.put(person1, new HashSet<>());
                }
                person2Friends.get(person1).add(person2);
            }
        }
        return person2Friends;
    }

    private static Map<String, Integer> createPerson2Score(String user, List<String> visitors, Map<String, Set<String>> person2Friends) {
        Map<String, Integer> person2Score = new Hashtable<>();
        for (String friend : person2Friends.get(user)) {
            for (String friendOfFriend : person2Friends.get(friend)) {
                person2Score.put(friendOfFriend, person2Score.getOrDefault(friendOfFriend, 0) + 10);
            }
        }
        for (String visitor : visitors) {
            person2Score.put(visitor, person2Score.getOrDefault(visitor, 0) + 1);
        }
        return person2Score;
    }

    private static void pickUpTop5ByScore(String user, List<String> answer, Map<String, Set<String>> person2Friends, Map<String, Integer> person2Score) {
        Queue<String> queue = new PriorityQueue<>(
                (p1, p2) -> {
                    int cmp = person2Score.get(p2) - person2Score.get(p1);
                    if (cmp != 0) {
                        return cmp;
                    }
                    return p1.compareTo(p2);
                }
        );
        for (String person : person2Score.keySet()) {
            if (person.equals(user) || person2Friends.get(user).contains(person) || !person2Score.containsKey(person))
                continue;
            if (person2Score.get(person) == 0) {
                continue;
            }
            queue.add(person);
        }
        while (answer.size() < 5 && !queue.isEmpty()) {
            answer.add(queue.remove());
        }
    }

}
