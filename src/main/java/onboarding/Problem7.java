package onboarding;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 기능 1: 사용자의 친구 목록을 뽑는 함수 작성
 * 기능 2: 친구 추천 점수를 담을 맵 초기화 함수 작성
 * 기능 3: 사용자의 친구 목록을 사용하여 그 친구를 같이 아는 사람들에게 점수를 주는 함수 작성
 * 기능 4: 방문자에게 점수를 주는 함수 작성
 * 기능 5: 시용자와 이미 친구인 사람 삭제하는 함수 작성
 * 기능 6-1: 점수를 첫번째 기준으로, 이름을 두번째 기준으로 하여 내림차순으로 정렬하는 기능 구현
 * 기능 6-2: 0점인 경우를 제외하는 기능 구현
 * 기능 6-3: 최대 5명까지 추천하는 기능 구현
 */
public class Problem7 {

    public static List<String> getUserFriends(List<List<String>> friends, String user) {

        List<String> userFriends = new ArrayList<>();

        // pivot을 1로 두고 user의 이름의 위치를 index로 저장하여 차이의 절대값을 구해서 user의 친구를 리스트에 담음
        final int PIVOT = 1;
        for (List<String> friendList : friends) {
            int friendIndex = friendList.indexOf(user);

            if (friendIndex != -1) {
                userFriends.add(friendList.get(Math.abs(PIVOT - friendIndex)));
            }
        }
        return userFriends;
    }

    public static Map<String, Integer> initScoreMap(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendScoreMap = new HashMap<>();

        for (List<String> friendList : friends) {
            for (String name : friendList) {
                if (user != name) {
                    friendScoreMap.put(name, 0);
                }
            }
        }

        for (String visitor : visitors) {
            friendScoreMap.put(visitor, 0);
        }

        return friendScoreMap;
    }

    public static void addScoreByFriend(String user, List<List<String>> friends,
                                        List<String> userFriends, Map<String, Integer> friendScoreMap) {

        final int PIVOT = 1;
        for (List<String> friendList : friends) {
            for (String friendName : userFriends) {
                int friendIndex = friendList.indexOf(friendName);

                if (friendName == user) {
                    break;
                }

                if (friendIndex == -1) {
                    continue;
                }

                String targetUser = friendList.get(Math.abs(PIVOT - friendIndex));

                if (targetUser != user) {
                    friendScoreMap.put(targetUser, friendScoreMap.get(targetUser) + 10);
                }
            }
        }
    }

    public static void addVisitorScore(List<String> visitors, Map<String, Integer> friendScoreMap) {
        for (String visitor : visitors) {
            friendScoreMap.put(visitor, friendScoreMap.get(visitor) + 1);
        }
    }

    public static void deleteExistFriend(List<String> userFriends, Map<String, Integer> friendScoreMap) {
        for (String friendName : userFriends) {
            if (friendScoreMap.containsKey(friendName)) {
                friendScoreMap.remove(friendName);
            }
        }
    }

    public static List<String> sortMapToList(Map<String, Integer> friendScoreMap) {
        List<String> sortedList = new ArrayList<>();

        friendScoreMap.entrySet().stream()
                .filter(target -> target.getValue() != 0)
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEachOrdered(x -> sortedList.add(x.getKey()));

        if (sortedList.size() > 5) {
            return sortedList.subList(0, 5);
        }

        return sortedList;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, Integer> friendScoreMap = initScoreMap(user, friends, visitors);
        List<String> userFriends = getUserFriends(friends, user);

        addScoreByFriend(user, friends, userFriends, friendScoreMap);
        addVisitorScore(visitors, friendScoreMap);
        deleteExistFriend(userFriends, friendScoreMap);
        answer = sortMapToList(friendScoreMap);

        return answer;
    }

}
