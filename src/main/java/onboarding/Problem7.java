package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    final static int LEFT_FRIEND = 0;
    final static int RIGHT_FRIEND = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        boolean isBoolean = true;
        List<String> answer = new ArrayList<>();
        Map<String, Integer> priorityPersonMap = new HashMap<>();
        List<String> userFriendList = new ArrayList<>();
        List<List<String>> friendExcetionUserList = new ArrayList<>();

        for (List<String> friendPairList : friends) {
            if (isContainerNameAtList(friendPairList, user)) {
                String nameUserFriend = getAnotherPairName(friendPairList, user);
                userFriendList.add(nameUserFriend);
            } else {
                friendExcetionUserList.add(friendPairList);
            }
        }

        int numFriendPriority = 10;
        for (String myFriend : userFriendList) {
            for (List<String> friendPair : friendExcetionUserList) {
                addAnotherPriority2Map(priorityPersonMap, numFriendPriority, myFriend, friendPair);
            }
        }

        // 친구 리스트에 포함되지 않을 때
        int numVisitorPriority = 1;
        for (String nameVisitor : visitors) {
            isBoolean = !isContainerNameAtList(userFriendList, nameVisitor);
            addVisitorPriority2Map(priorityPersonMap, nameVisitor, numVisitorPriority, isBoolean);
        }

        // 우선순위
        List<String> priorityPersonList = getSortListToKeyOfMap(priorityPersonMap);
        answer.addAll(priorityPersonList);
        System.out.println("answer = " + answer);
        return answer;
    }

    private static void addAnotherPriority2Map(Map<String, Integer> targetMap, int priority, String myFriend, List<String> compairList) {
        if (isContainerNameAtList(compairList, myFriend)) {
            String nameAnotherPair = getAnotherPairName(compairList, myFriend);
            addMapPriority(nameAnotherPair, priority, targetMap);
        }
    }

    private static void addVisitorPriority2Map(Map<String, Integer> targetMap, String nameVisitor, int priority, boolean booleanWant) {
        if (booleanWant) {
            addMapPriority(nameVisitor, priority, targetMap);
        }
    }

    private static List<String> getSortListToKeyOfMap(Map<String, Integer> map) {
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String str_1, String str_2) {

                if (isEqualsMapValue(str_1, str_2, map)) {
                    return (str_1.compareTo(str_2));
                }
                else {
                    return (map.get(str_2) - map.get(str_1));
                }
            }
        });
        return keySet;
    }

    private static boolean isEqualsMapValue(String str_1, String str_2, Map<String, Integer> map) {
        return map.get(str_2) == map.get(str_1);
    }

    private static boolean isContainerNameAtList(List<String> list, String str) {
        return list.contains(str);
    }

    private static void addMapPriority(String name, int priority, Map<String, Integer> map) {
        Integer mapValue = 0;
        if (map.containsKey(name)) {
            mapValue = map.get(name);
            map.put(name, mapValue + priority);
        } else {
            map.put(name, priority);
        }
    }

    private static String getAnotherPairName(List<String> friendPairList, String user) {
        if (friendPairList.get(0).equals(user)) {
            return friendPairList.get(1);
        } else {
            return friendPairList.get(0);
        }
    }

    private static List<String> deduplicationList(ArrayList<String> List) {
        return List.stream().distinct().collect(Collectors.toList());
    }

    private static boolean strAddressEquals(String user, String leftFriendsInList) {
        return Objects.equals(user, leftFriendsInList);
    }
}
