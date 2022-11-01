package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.*;

public class Problem7 {


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();

        Map<String, ArrayList> friendMap = new TreeMap<>();
        Map<String, Integer> mapPoints = new TreeMap<>();

        //friends map를 만드는 과정
        for (int i = 0; i < friends.size(); i++) {
            friendMap = makeFriendsMap(friends.get(i), friendMap);
        }

        mapPoints = friendsPlusPoint(user, friendMap.get(user), friendMap, mapPoints);
        mapPoints = visitorsPlusPoint(visitors, friendMap.get(user), mapPoints);

        List<String> keyList = new ArrayList<>(mapPoints.keySet());


        // 정렬
        Map<String, Integer> finalMapPoints = mapPoints;
        keyList.sort((o1, o2) -> finalMapPoints.get(o2).compareTo(finalMapPoints.get(o1)));

        return keyList;

    }

    public static Map<String, ArrayList> makeFriendsMap(List<String> friendsList, Map<String, ArrayList> friendMap) {

        ArrayList list1 = friendMap.getOrDefault(friendsList.get(0), new ArrayList());
        ArrayList list2 = friendMap.getOrDefault(friendsList.get(1), new ArrayList());

        list1.add(friendsList.get(1));
        list2.add(friendsList.get(0));

        friendMap.put(friendsList.get(0), list1);
        friendMap.put(friendsList.get(1), list2);

        return friendMap;
    }

    public static Map<String, Integer> friendsPlusPoint(String user, ArrayList arrayList, Map<String, ArrayList> friendMap, Map<String, Integer> mapPoints) {
        // arrayList {donut shakevan}
        for (String keyName : friendMap.keySet()) { //an, jun, sh, do, mr
            if (!keyName.equals(user)) {
                ArrayList friendList = friendMap.get(keyName); //jun {donut, shakevan}
                for (int k = 0; k < arrayList.size(); k++) { // donut shakevan
                    if (friendList.contains(arrayList.get(k))) {
                        mapPoints.put(keyName, mapPoints.getOrDefault(keyName, 0) + 10);
                    }
                }
            }
        }

        return mapPoints;
    }

    public static Map<String, Integer> visitorsPlusPoint(List<String> visitors, ArrayList arrayList, Map<String, Integer> mapPoints) {

        for (String visitorName : visitors) { //an, jun, sh, do, mr
            if (!arrayList.contains(visitorName)) {
                mapPoints.put(visitorName, mapPoints.getOrDefault(visitorName, 0) + 1);
            }
        }
        return mapPoints;
    }
}
