package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, Integer> recommendScore = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        scoreInitial(user, friends, visitors);
        List<String> answer = highestScoreOf5();
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

    private static void friendScore(List<String> initialList) {
        for (String name : initialList) {
            if (recommendScore.containsKey(name)) {
                recommendScore.put(name, recommendScore.get(name) + 10);
                continue;
            }
            recommendScore.put(name, 10);
        }
    }

    private static void visitingScore(List<String> visitors, List<String> friendsList) {
        for (String visitor : visitors) {
            if (recommendScore.containsKey(visitor) && !friendsList.contains(visitor)) {
                recommendScore.put(visitor, recommendScore.get(visitor) + 1);
                continue;
            }
            if (!friendsList.contains(visitor)) {
                recommendScore.put(visitor, 1);
            }
        }
    }

    private static void scoreInitial(String user, List<List<String>> friends, List<String> visitors) {
        recommendScore.clear();
        List<String> initialList = new ArrayList<>();
        List<String> friendsList = usersFriendsList(user, friends);
        for (String friend : friendsList) {
            for (List<String> names : friends) {
                if (names.contains(friend)) {
                    int index = names.indexOf(friend);
                    if (index == 0 && !friendsList.contains(names.get(1)) && !names.get(1).equals(user)) {
                        initialList.add(names.get(1));
                    } else if (!friendsList.contains(names.get(0)) && !names.get(0).equals(user)) {
                        initialList.add(names.get(0));
                    }
                }
            }
        }

        friendScore(initialList);
        visitingScore(visitors, friendsList);

    }

    private static List<String> sorting() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(recommendScore.entrySet());
        list.sort((o1, o2) -> {
            int compare = (o1.getValue() - o2.getValue()) * -1;
            return compare == 0 ? o1.getKey().compareTo(o2.getKey()) : compare;
        });
        List<String> sortedList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedList.add(entry.getKey());
        }

        return sortedList;
    }

    private static List<String> highestScoreOf5() {
        List<String> sortedList = sorting();
        List<String> result = new ArrayList<>();
        if (recommendScore.size() <= 5) {
            for (int i = 0; i < recommendScore.size(); i++) {
                result.add(sortedList.get(i));
            }
        } else {
            for (int i = 0; i < 5; i++) {
                result.add(sortedList.get(i));
            }
        }
        return result;
    }

}
