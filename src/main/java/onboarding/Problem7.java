package onboarding;

import java.util.*;

public class Problem7 {
    static HashMap<String, List<String>> friendship = new HashMap<>();
    static HashMap<String, Integer> scores = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends;

        makeFriendship(friends);
        userFriends = friendship.get(user);

        if (userFriends != null) {
            userFriends = removeSameFriends(userFriends);
        }

        for (String crew : friendship.keySet()) {
            /* 유저는 패스한다. */
            if (crew.equals(user)) {
                continue;
            }
            makeScoresWithFriendship(userFriends, crew);
        }

        updateScoresWithVisitors(userFriends, visitors);
        makeAnswer(answer);
        friendship.clear();
        scores.clear();

        return answer;
    }

    public static List<String> removeSameFriends(List<String> userFriends) {
        List<String> removed = new ArrayList<>();

        for(String strValue : userFriends) {
            /* 중복 요소가 없는 경우 요소를 추가한다. */
            if(!removed.contains(strValue)) {
                removed.add(strValue);
            }
        }
        return removed;
    }
    public static void makeAnswer(List<String> answer) {
        List<Map.Entry<String, Integer>> sortedScores = sortScores();
        int count = 0;

        for (Map.Entry<String, Integer> score :sortedScores) {
            addAnswer(answer, score, count);
            count++;
        }
    }

    public static void addAnswer(List<String> answer, Map.Entry<String, Integer> score, int count) {
        if (score.getValue() != 0 && count < 5) {
            answer.add(score.getKey());
        }
    }
    public static List<Map.Entry<String, Integer>> sortScores() {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scores.entrySet());

        sort(entryList);
        return entryList;
    }

    private static void sort(List<Map.Entry<String, Integer>> entryList) {
        entryList.sort((o1, o2) -> {
            String key1, key2;


            if (!o2.getValue().equals(o1.getValue())) {
                return o2.getValue() - o1.getValue();
            }
            key1 = o1.getKey();
            key2 = o2.getKey();
            return key1.compareTo(key2);
        });
    }

    public static void makeScoresWithFriendship(List<String> userFriends, String crew) {
        int score = 0;

        if (userFriends == null) {
            return;
        }
        /* 유저와 친구라면 건너뛴다. */
        if (userFriends.contains(crew)) {
            return;
        }
        for (String crewFriend : friendship.get(crew)) {
            if (userFriends.contains(crewFriend)) {
                score += 10;
            }
        }
        scores.put(crew, score);
    }

    public static void updateScoresWithVisitors(List<String> userFriends, List<String> visitors) {
        int score;

        for (String visitor : visitors) {
            if ((userFriends != null) && (userFriends.contains(visitor))) {
                continue;
            }
            if (scores.containsKey(visitor)) {
                score = scores.get(visitor);
                scores.put(visitor, score + 1);
                continue;
            }
            scores.put(visitor, 1);
        }
    }
    public static void makeFriendship(List<List<String>> friends) {
        String crew1, crew2;

        for (List<String> friend : friends) {
            crew1 = friend.get(0);
            crew2 = friend.get(1);

            addFriendship(crew1, crew2);
            addFriendship(crew2, crew1);
        }
    }

    private static void addFriendship(String crew1, String crew2) {
        List<String> relationship;

        /* 없다면 새로이 추가한다. */
        if (friendship.get(crew1) == null) {
            List<String> list = new ArrayList<>();
            list.add(crew2);
            friendship.put(crew1, list);
            return;
        }
        relationship = friendship.get(crew1);
        relationship.add(crew2);
        friendship.put(crew1, relationship);
    }
}
