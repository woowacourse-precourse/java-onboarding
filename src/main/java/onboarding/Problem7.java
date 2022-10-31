package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {
    public static Map<String, List<String>> getFriendsList(List<List<String>> friends) {
        Map<String,List<String>> friendsList = new HashMap<>();
        List<String> tmp;
        for (List<String> friend : friends) {
            tmp = friendsList.getOrDefault(friend.get(0), new ArrayList<>());
            tmp.add(friend.get(1));
            friendsList.put(friend.get(0),tmp);
            tmp = friendsList.getOrDefault(friend.get(1),new ArrayList<>());
            tmp.add(friend.get(0));
            friendsList.put(friend.get(1),tmp);
        }
        return friendsList;
    }

    public static Map<String, Integer> getScoreLists(Map<String,List<String>> friendsList, String user) {
        Map<String, Integer> scoreList = new HashMap<>();
        for (String name : friendsList.keySet()) {
            if(friendsList.get(name).contains(user)) {
                for (String friend : friendsList.get(name)) {
                    if (friend.equals(user)) {
                        continue;
                    }
                    int score = scoreList.getOrDefault(friend,0);
                    scoreList.put(friend,score+10);

                }
            }
        }
        return scoreList;
    }

    public static Map<String,Integer> checkVisitor(List<String> visitors, Map<String, Integer> scoreLists) {
        for (String visitor : visitors) {
            int score = scoreLists.getOrDefault(visitor,0);
            scoreLists.put(visitor,score + 1);
        }
        return scoreLists;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String,List<String>> friendsList = getFriendsList(friends);
        Map<String,Integer> scoreLists = getScoreLists(friendsList,user);
        scoreLists = checkVisitor(visitors,scoreLists);
        List<String> keySet = new ArrayList<>(scoreLists.keySet());

        // Value 값으로 오름차순 정렬
        Map<String, Integer> finalScoreLists = scoreLists;
        keySet.sort((o1, o2) -> finalScoreLists.get(o2).compareTo(finalScoreLists.get(o1)));
        for (String key : keySet) {
            if (friendsList.get(user).contains(key)) continue;
            answer.add(key);
        }


        return answer;
    }

}
