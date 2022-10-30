package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> returnUserFriendList(String user, List<List<String>> friends) {
        List<String> userFriendList = new ArrayList<>();
        for (List<String> friend : friends) {
            if (user.equals(friend.get(0))) {
                userFriendList.add(friend.get(1));
            }
            if (user.equals(friend.get(1))) {
                userFriendList.add(friend.get(0));
            }
        }
        return userFriendList;
    }

    private static HashMap<String, Integer> makeHashMap(List<String> peopleList) {
        HashMap<String, Integer> peopleAndPointMap = new HashMap<>();
        peopleList.forEach(x -> peopleAndPointMap.put(x,0));
        return peopleAndPointMap;
    }
    private static List<String> makePeopleList(String user, List<List<String>> friends, List<String> visitors) {
        List<String> list = new ArrayList<>();
        list.add(user);
        for (List<String> friend : friends) {
            list = addToList(list, friend);
        }
        list = addToList(list, visitors);
        return list;
    }
    private static List<String> addToList(List<String> list, List<String> target) {
        List<String> tmp = target.stream()
            .filter(x -> !list.contains(x))
            .collect(Collectors.toList());
        tmp.addAll(list);
        return tmp;
    }
}
