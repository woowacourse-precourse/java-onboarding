package onboarding;

import java.awt.*;
import java.awt.image.ImageProducer;
import java.util.*;
import java.util.List;

public class Problem7 {

    public static List<String> recommendFriends(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> score = new HashMap<>();

        // 친구 리스트 생성
        List<String> friendList = makeFriendList(user, friends, visitors);

        // 관련 친구 점수 계산
        score = calculateScore(friends, visitors, friendList);

        // 결과 리스트 정렬
        Map<String, Integer> sortedByKey = new TreeMap<>(score); // 알파벳 순 정렬
        sortedByKey = valueSort(sortedByKey);   // 점수 순 정렬
        List<String> result =  new ArrayList<>(sortedByKey.keySet());
        System.out.println(result);

        return friendList;
    }

    private static List<String> makeFriendList(String user, List<List<String>> friends, List<String> visitors) {

        List<String> friendlist = new ArrayList<>();
        String friend;

        /* 친구 리스트 생성 */
        for (int i = 0; i < friends.size(); i++) {  // 친구인 유저들과 친구인 유저

            friend = friends.get(i).get(1);

            // 중복 제거 및 자신은 포함시키지 않는다.
            if (!friendlist.contains(friend) && friend != user) {
                friendlist.add(friend);
            }

        }

        for (int i = 0; i < visitors.size(); i++) {  // 내 피드를 조회한 유저

            friend = visitors.get(i);

            // 중복 제거 및 자신은 포함시키지 않는다.
            if (!friendlist.contains(friend) && friend != user) {
                friendlist.add(friend);
            }

        }

        for (int i = 0; i < friends.size(); i++) {  // 친구 관계 목록에서 A에 있는 유저는 이미 친구이므로 제외

            friend = friends.get(i).get(0);

            for (int j = 0; j < friendlist.size(); j++) {
                if (friendlist.get(j) == friend) {
                    friendlist.remove(j);
                }
            }

        }

        return friendlist;

    }

    public static HashMap<String, Integer> calculateScore(List<List<String>> friends, List<String> visitors, List<String> friendList) {
        HashMap<String, Integer> result = new HashMap<>();
        String friend;
        int scr;

        for (int i = 0; i < friendList.size(); i++) { // 함께 아는 친구 점수 계산

            scr = 0;
            friend = friendList.get(i);

            for (int j = 0; j < friends.size(); j++) {

                if (friends.get(j).get(1).contains(friend)) {
                    scr += 10;
                }

            }

            result.put(friend, scr);    // 점수 갱신

        }

        for (int i = 0; i < friendList.size(); i++) {   // 방문 횟수 점수 계산

            friend = friendList.get(i);
            scr = result.get(friend);

            for (int j = 0; j < visitors.size(); j++) {

                if (visitors.get(j) == friend) {
                    scr += 1;
                }
            }

            result.replace(friend, scr); // 점수 갱신
        }

        return result;
    }

    public static <K, V extends Comparable<V> > Map<K, V> valueSort(final Map<K, V> map) {
        // Static Method with return type Map and
        // extending comparator class which compares values
        // associated with two keys
        Comparator<K> valueComparator = new Comparator<K>() {

            // return comparison results of values of
            // two keys
            public int compare(K k1, K k2)
            {
                int comp = map.get(k2).compareTo(
                        map.get(k1));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }

        };

        // SortedMap created using the comparator
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = Collections.emptyList();
        answer = makeFriendList(user, friends, visitors);
        return answer;

    }


}
