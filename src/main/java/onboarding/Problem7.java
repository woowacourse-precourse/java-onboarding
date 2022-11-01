package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(5);

        // user 와 친구인 사람 추출
        List<String> together = userFriends(friends, user);

        Map<String, Integer> map = addFriends(friends, together, user);
        addVisitor(visitors, together, map);

//        이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.
        Map<String, Integer> sortedMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1).equals(map.get(o2))) return o1.compareTo(o2);
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        sortedMap.putAll(map);

        for(String s : sortedMap.keySet()){
            if (answer.size() == 5) break;
            if (sortedMap.get(s) > 0) {
                answer.add(s);
            }
        }
        return answer;
    }

    static Map<String, Integer> addVisitor(List<String> visitors, List<String> userFriend, Map<String, Integer> recommend) {
        for (String v : visitors) {
            if (!userFriend.contains(v)) {
                if (recommend.containsKey(v)) {
                    recommend.replace(v, recommend.get(v) + 1);
                } else {
                    recommend.putIfAbsent(v, 1);
                }
            }
        }
        return recommend;
    }

    static List<String> userFriends(List<List<String>> friends, String user) {
        List<String> list = new ArrayList<>();
        for (List<String> friend : friends) {
            for (int j = 0; j < friend.size(); j++) {
                if (friend.contains(user) && !friend.get(j).equals(user)) {
                    list.add(friend.get(j));
                }
            }
        }
        return list;
    }

    static Map<String, Integer> addFriends(List<List<String>> friends, List<String> userFriend, String user) {
        Map<String, Integer> map = new HashMap<>();
        for (List<String> friend : friends) {
            for (String s : friend) {
                if (checkFriend(userFriend, s, user)) {
                    addFriendScore(map, s);
                }
            }
        }
        return map;
    }

    static Map<String, Integer> addFriendScore(Map<String, Integer> recommend, String s) {
        if (recommend.containsKey(s)) {
            recommend.replace(s, recommend.get(s) + 10);
        } else {
            recommend.putIfAbsent(s, 10);
        }
        return recommend;
    }

    static boolean checkFriend(List<String> userFriend, String s, String user) {
        return !(userFriend.contains(s) || s.equals((user)));
    }

}
