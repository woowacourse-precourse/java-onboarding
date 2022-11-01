package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, Integer> recommendScore = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        scoreInitial(user, friends, visitors);
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> usersFriendsList(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                int index = friend.indexOf(user);
                if (index == 0) {
                    result.add(friend.get(1));
                } else {
                    result.add(friend.get(0));
                }
            }
        }

        return result;
    }

    private static void scoreInitial(String user, List<List<String>> friends, List<String> visitors) {
        List<String> initialList = new ArrayList<>();
        List<String> friendsList = usersFriendsList(user, friends);
        for (String friend : friendsList) {
            for (List<String> names : friends) {
                if (names.contains(friend)) {
                    int index = names.indexOf(friend);
                    if (index == 0 && !friendsList.contains(names.get(1))) {
                        initialList.add(names.get(1));
                    } else if (!friendsList.contains(names.get(0))) {
                        initialList.add(names.get(0));
                    }
                }
            }
        }

        for (String s : initialList) {
            if (recommendScore.containsKey(s)) {
                recommendScore.put(s, recommendScore.get(s) + 10);
                continue;
            }
            recommendScore.put(s, 10);
        }

        for (String visitor : visitors) {
            if (recommendScore.containsKey(visitor)) {
                recommendScore.put(visitor, recommendScore.get(visitor) + 1);
                continue;
            }
            recommendScore.put(visitor, 1);
        }

    }

    

}
