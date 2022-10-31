package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, Integer> nameAndScore = new HashMap<>();

        for (List<String> ls : friends) {
            if (isUser(user, ls.get(1)) || isAlreadyFriend(nameAndScore, ls.get(1))) {
                continue;
            }

            if (!nameAndScore.containsKey(ls.get(0))) {
                nameAndScore.put(ls.get(0), -1);
            }

            calculateFriendScore(nameAndScore, ls.get(1));
        }

        for (String name : visitors) {
            calculateVisitorScore(nameAndScore, name);
        }

        LinkedList<Map.Entry<String, Integer>> entries = new LinkedList<>(nameAndScore.entrySet());
        entries.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            } else {
                return o2.getValue() - o1.getValue();
            }
        });

        answer = new ArrayList<>();

        getAnswer(entries, answer);

        return answer;
    }

    /**
     * whose already friend with me is stored as {name, -1} in nameAndScore
     * return true if he / she is already friend
     * @param nameAndScore
     * @param name
     * @return
     */
    static boolean isAlreadyFriend(Map<String, Integer> nameAndScore, String name) {
        return nameAndScore.containsKey(name) && nameAndScore.get(name).equals(-1);
    }

    /**
     * return true if name is equal to user
     * @param user
     * @param name
     * @return
     */
    static boolean isUser(String user, String name) {
        return name.equals(user);
    }

    static void calculateFriendScore(Map<String, Integer> nameAndScore, String name) {
        if (!nameAndScore.containsKey(name)) {
            nameAndScore.put(name, 10);
        } else {
            nameAndScore.put(name, nameAndScore.get(name) + 10);
        }
    }

    static void calculateVisitorScore(Map<String, Integer> nameAndScore, String name) {
        if (nameAndScore.containsKey(name)) {
            if (!nameAndScore.get(name).equals(-1)) {
                nameAndScore.put(name, nameAndScore.get(name) + 1);
            }
        } else {
            nameAndScore.put(name, 1);
        }
    }

    static void getAnswer(LinkedList<Map.Entry<String, Integer>> entries, List<String> answer) {
        for (Map.Entry<String, Integer> entry : entries) {
            if (answer.size() == 5) {
                break;
            }

            if (entry.getValue() > 0) {
                answer.add(entry.getKey());
            }
        }
    }
}
