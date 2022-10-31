package onboarding;

import java.util.*;

public class Problem7 {
    static Set<String> friendSet = new HashSet<>();
    static Map<String, Integer> scoreBoard = new HashMap<>();
    static Map<String, List<String>> friendMap = new HashMap<>();
    static List<String> userSelectedList;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        makeScoreBoard(friends);
        makeFriendSet(friends);
        fillScoreBoeard(user, visitors);
        removeNameFromScoreBoard(user);
        List<String> answer = sortKeys();
        return answer;
    }

    public static void makeScoreBoard(List<List<String>> friends) {
        for (List<String> friend : friends) {
            friendSet.add(friend.get(0));
            friendSet.add(friend.get(1));
        }

        for (String s : friendSet) {
            scoreBoard.put(s, 0);
        }
    }

    public static void makeFriendSet(List<List<String>> friends) {
        for (String s : friendSet) {
            List<String> nameList = new ArrayList<>();
            for (List<String> friend : friends) {
                if (s.equals(friend.get(0))) {
                    nameList.add(friend.get(1));
                } else if (s.equals(friend.get(1))) {
                    nameList.add(friend.get(0));
                }
            }
            friendMap.put(s, nameList);
        }
    }

    public static void fillScoreBoeard(String user, List<String> visitors) {
        userSelectedList = friendMap.get(user);
        for (String s : userSelectedList) {
            List<String> selectedList = friendMap.get(s);
            for (String str : selectedList) {
                if (str.equals(user)) {
                    continue;
                }
                int num10 = scoreBoard.get(str) + 10;
                scoreBoard.put(str, num10);
            }
        }

        for (String s : visitors) {
            if (!scoreBoard.containsKey(s)) {
                scoreBoard.put(s, 1);
            } else {
                int num1 = scoreBoard.get(s) + 1;
                scoreBoard.put(s, num1);
            }
        }
    }

    public static void removeNameFromScoreBoard(String user) {
        scoreBoard.remove(user);
        for (String s : userSelectedList) {
            scoreBoard.remove(s);
        }
    }

    public static List<String> sortKeys() {
        List<String> keyList = new ArrayList<>(scoreBoard.keySet());
        keyList.sort(((o1, o2) -> {
            int res = scoreBoard.get(o2) - scoreBoard.get(o1);
            if (res == 0) {
                return o1.compareTo(o2);
            }
            return res;
        }));
        return new ArrayList<>(scoreBoard.keySet());
    }

}