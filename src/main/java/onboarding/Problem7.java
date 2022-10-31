package onboarding;

import java.util.*;

/**
 * @작성자 rjsah09
 * @작성일 2022.11.01
 *
 * @수정내역
 * */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> usersAndScores = getAllUsers(user, friends, visitors);
        Set<String> myFriends = getMyFriends(user, friends);

        setScore10(user, myFriends, friends, usersAndScores);
        setScore1(user, myFriends, visitors, usersAndScores);

        List<String> answer = getAnswer(usersAndScores);
        return answer;
    }

    private static Map<String, Integer> getAllUsers(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> map = new HashMap<>();

        map.put(user, 0);

        for(List<String> list: friends) {
            for(int i = 0; i < 2; i++) {
                String str = list.get(i);
                map.put(str, 0);
            }
        }

        for(String str: visitors) {
            map.put(str, 0);
        }

        return map;
    }

    private static Set<String> getMyFriends(String str, List<List<String>> doubleList) {
        Set<String> myFriends = new HashSet<>();

        for(List<String> list: doubleList) {
            if(list.get(0).equals(str)) {
                myFriends.add(list.get(1));
            } else if(list.get(1).equals(str)) {
                myFriends.add(list.get(0));
            }
        }

        return myFriends;
    }

    private static void setScore10(String str, Set<String> set, List<List<String>> doubleList, Map<String, Integer> map) {
        for(int i = 0; i < doubleList.size(); i++) {
            List<String> friendsShip = doubleList.get(i);

            if(set.contains(friendsShip.get(0)) && !friendsShip.get(1).equals(str)) {
                map.replace(friendsShip.get(1), map.get(friendsShip.get(1)) + 10);
            } else if(set.contains(friendsShip.get(1)) && !friendsShip.get(0).equals(str)) {
                map.replace(friendsShip.get(0), map.get(friendsShip.get(0)) + 10);
            }
        }
    }

    private static void setScore1(String str, Set<String> myFriends, List<String> visitors, Map<String, Integer> map) {

        for(String visitor: visitors) {
            if(!myFriends.contains(visitor) && !visitor.equals(str)) {
                map.put(visitor, map.get(visitor) + 1);
            }
        }
    }

    private static List<String> removeZero(List<String> list, Map<String, Integer> map) {
        List<String> newList = new ArrayList<>();
        for(String str: list) {
            if(map.get(str) > 0) {
                newList.add(str);
            }
        }

        return newList;
    }

    private static int compareAsc(String o1, String o2) {
        int o1Length = o1.length();
        int o2Length = o2.length();
        int lengthMin = Math.min(o1.length(), o2.length());
        for(int i = 0; i < lengthMin; i++) {
            if(o1.charAt(i) < o2.charAt(i)) {
                return -1;
            } else if(o1.charAt(i) > o2.charAt(i)) {
                return 1;
            }
            if(o1Length < o2Length) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }

    private static List<String> getAnswer(Map<String, Integer> map) {
        List<String> list = new ArrayList<>(map.keySet());
        list = removeZero(list, map);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int o1Score = map.get(o1);
                int o2Score = map.get(o2);

                if(o1Score > o2Score) {
                    return -1;
                } else if (o1Score < o2Score) {
                    return 1;
                } else {
                    return compareAsc(o1, o2);
                }
            }
        });

        if(list.size() > 5) {
            list = list.subList(0, 6);
        }

        return list;
    }

}
