package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> checkUserFriend(String user, List<List<String>> friends) {
        List<String> userFriend = new ArrayList<>();
        List<List<String>> checkF = friends.stream()
                .filter(strings -> strings.contains(user))
                .collect(Collectors.toList());
        for (int i = 0; i < checkF.size(); i++) {
            for (int j = 0; j < checkF.get(i).size(); j++) {
                String name = checkF.get(i).get(j);
                if (!userFriend.contains(name) && !name.equalsIgnoreCase(user))
                    userFriend.add(name);
            }
        }
        return userFriend;
    }

    public static Map<String, Integer> recommendScore(String user, List<List<String>> friends, List<String> userFriend) {
        List<String> friendScoreCheck = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < friends.get(i).size(); j++) {
                String name = friends.get(i).get(j);
                if (!(user.equalsIgnoreCase(name)) && !userFriend.contains(name))
                    friendScoreCheck.add(name);
            }
        }
        Set<String> set = new HashSet<String>(friendScoreCheck);
        Map<String, Integer> score = new HashMap<>();
        for (String str : set) {
            score.put(str, 10 * Collections.frequency(friendScoreCheck, str));
        }
        return score;
    }

    public static Map<String, Integer> viewScore(List<String> userFriend, List<String> visitors) {
        List<String> tmpVisitors = new ArrayList<String>(visitors);

        for (String uf : userFriend) {
            tmpVisitors.remove(uf);
        }
        Set<String> set = new HashSet<String>(tmpVisitors);
        Map<String, Integer> score = new HashMap<>();
        for (String str : set) {
            score.put(str, Collections.frequency(tmpVisitors, str));
        }
        return score;
    }

    public static List<String> totalScore(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriend = checkUserFriend(user, friends);

        Map<String, Integer> recommendS = recommendScore(user, friends, userFriend);
        Map<String, Integer> viewS = viewScore(userFriend, visitors);

        recommendS.forEach((key, value) -> viewS.merge(key, value, (v1, v2) -> v1 + v2));
        List<String> totalS = new ArrayList<>(viewS.keySet());
        Collections.sort(totalS);
        totalS.sort((o1, o2) -> viewS.get(o2).compareTo(viewS.get(o1)));
        for (String key : totalS) {
            System.out.println(key);
        }
        List<String> answerList = new ArrayList<>();
        if (totalS.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                answerList.add(totalS.get(i));
            }
        } else {
            for (int i = 0; i < totalS.size(); i++) {
                answerList.add(totalS.get(i));
            }
        }
        return answerList;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = totalScore(user, friends, visitors);
        return answer;
    }
}
