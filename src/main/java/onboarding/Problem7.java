package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> peopleAndPointMap = makeHashMap(makePeopleList(user, friends, visitors));
        plusFriendPoint(user, friends, peopleAndPointMap);
        plusVisitPoint(visitors, peopleAndPointMap);
        List<String> answer = returnRankingList(peopleAndPointMap);
        return answer;
    }

    private static List<String> returnRankingList(HashMap<String, Integer> peopleAndPointMap) {
        List<String> rankingList = new ArrayList<>();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(peopleAndPointMap.entrySet());
        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (int i = 0; i < 5; i++) {
            rankingList.add(entryList.get(i).getKey());
        }
        return rankingList;
    }
    private static void plusVisitPoint(List<String> visitors, HashMap<String, Integer> peopleAndPointMap) {
        visitors.forEach(visitor -> peopleAndPointMap.compute(visitor, (people, point) -> point + 1));
    }

    private static void plusFriendPoint(String user, List<List<String>> friends, HashMap<String, Integer> peopleAndPointMap) {
        peopleAndPointMap.forEach((people,point) ->
            peopleAndPointMap.put(people, point + returnCommonFriendNumber(user, people, friends) * 10));
    }

    private static int returnCommonFriendNumber(String user, String people, List<List<String>> friends) {
        List<String> userFriendList = returnFriendList(user, friends);
        List<String> peopleFriendList = returnFriendList(people, friends);
        int commonFriendNumber = 0;
        for (String friend : peopleFriendList) {
            if (userFriendList.contains(friend)) {
                commonFriendNumber += 1;
            }
        }
        return commonFriendNumber;
    }

    private static List<String> returnFriendList(String people, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        for (List<String> friend : friends) {
            if (people.equals(friend.get(0))) {
                friendList.add(friend.get(1));
            }
            if (people.equals(friend.get(1))) {
                friendList.add(friend.get(0));
            }
        }
        return friendList;
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
