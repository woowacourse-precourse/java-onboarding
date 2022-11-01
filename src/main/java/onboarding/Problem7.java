package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    final static int LEFT_FRIEND = 0;
    final static int RIGHT_FRIEND = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> priorityPersonMap = new HashMap<>();
        List<String> userFriendList = new ArrayList<>();
        List<List<String>> friendExcetionUserList = new ArrayList<>();

        for (List<String> friendPairList : friends) {
            if (friendPairList.contains(user)) {
                String nameUserFriend = getAnotherPairName(friendPairList, user);
                userFriendList.add(nameUserFriend);
            } else {
                friendExcetionUserList.add(friendPairList);
            }
        }

        for (String myFriend : userFriendList) {
            for (List<String> friendPair : friendExcetionUserList) {
                if (friendPair.contains(myFriend)) {
                    String nameAnotherPair = getAnotherPairName(friendPair, myFriend);
                    addMapPriority(nameAnotherPair, 10, priorityPersonMap);
                }
            }
        }

//        visitors
        // 친구들 리스트에 포함이 안되면
        for (String nameVisitor : visitors) {
            if (!userFriendList.contains(nameVisitor)) {
                addMapPriority(nameVisitor, 1, priorityPersonMap);
            }
        }

        // 우선순위로 정렬
        List<String> keySet = new ArrayList<>(priorityPersonMap.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            // 우선순위로 비교하는 것
            public int compare(String str_1, String str_2) {
                // 1. 우선순위 가 같으면 이름으로 정렬
                // 과연 문자열 비교는 주소로 비교를 하는 것이 맞는가?
                if (priorityPersonMap.get(str_2) == priorityPersonMap.get(str_1)) {
                    return (str_1.compareTo(str_2));
                }
                // 2. 우선 순위  값으로 내림차순 정렬
                else {
                    return (priorityPersonMap.get(str_2) - priorityPersonMap.get(str_1));
                }
            }
        });
        answer.addAll(keySet);
        System.out.println("answer = " + answer);
        return answer;
    }

    // name이랑
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
