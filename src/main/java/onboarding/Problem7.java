package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.*;

public class Problem7 {

    static Map<String, ArrayList> friendMap = new TreeMap<>();
    static Map<String, Integer> mapPoints = new TreeMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();

        //friends map를 만드는 과정
        for (int i = 0; i < friends.size(); i++) {
            makeFriendsMap(friends.get(i));
        }

        friendsPlusPoint(user, friendMap.get(user));
        visitorsPlusPoint(visitors, friendMap.get(user));

        List<String> keyList = new ArrayList<>(mapPoints.keySet());

        // 정렬
        keyList.sort((o1, o2) -> mapPoints.get(o2).compareTo(mapPoints.get(o1)));

        return keyList;

    }

    public static void makeFriendsMap(List<String> friendsList) {

        ArrayList list1 = friendMap.getOrDefault(friendsList.get(0), new ArrayList());
        ArrayList list2 = friendMap.getOrDefault(friendsList.get(1), new ArrayList());

        list1.add(friendsList.get(1));
        list2.add(friendsList.get(0));

        friendMap.put(friendsList.get(0), list1);
        friendMap.put(friendsList.get(1), list2);
    }

    public static void friendsPlusPoint(String user, ArrayList arrayList) {
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
    }

    public static void visitorsPlusPoint(List<String> visitors, ArrayList arrayList) {

        for (String visitorName : visitors) { //an, jun, sh, do, mr
            if (!arrayList.contains(visitorName)) {
                mapPoints.put(visitorName, mapPoints.getOrDefault(visitorName, 0) + 1);
            }
        }
    }
}
