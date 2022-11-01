package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        //friendList => 모든 사용자의 친구 관계 리스트
        Map<String, List<String>> friendList = friendList(friends);
        //scoreList => user의 추천 친구 점수 리스트
        Map<String, Integer> scoreList = getScoreList(friendList, visitors, user);

        //조건에 맞지않는 friend 제거
        removeNotSatisfyCondition(friendList, scoreList, user);
        //점수에 따라 오름차순으로 정렬, 정수가 같으면 이름순으로 정렬, 최대 5명 까지만 저장
        return sortScore(scoreList);
    }

    private static Map<String, List<String>> friendList(List<List<String>> friends) {
        Map<String, List<String>> friendList = new HashMap<>();
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            addFriend(friendList, friend1, friend2);
            addFriend(friendList, friend2, friend1);
        }
        return friendList;
    }

    private static Map<String,Integer> getScoreList(Map<String, List<String>> friendList, List<String> visitors, String user) {
        //사용자와 함께 아는 친구의 수 +10점
        Map<String, Integer> scoreList = new HashMap<>();
        //user가 친구가 한명도 없을 경우 진행하지 않음
        if (friendList.get(user) != null) {
            List<String> userFriendList = friendList.get(user);
            for (String friend : friendList.keySet()) {
                List<String> list = friendList.get(friend);
                int score = getScore(userFriendList, list);
                scoreList.put(friend, score);
            }
        }

        //사용자의 타임 라인에 방문한 횟수 +1점
        for (String visitor : visitors) {
            if (!scoreList.containsKey(visitor)) {
                scoreList.put(visitor, 1);
            }else {
                Integer score = scoreList.get(visitor);
                score++;
                scoreList.replace(visitor, score);
            }
        }
        return scoreList;
    }

    private static void removeNotSatisfyCondition(Map<String, List<String>> friendList, Map<String, Integer> scoreList, String user) {
        //userFriends => 입력받은 user의 친구 리스트
        List<String> userFriends = friendList.get(user);

        //user(자기자신), user와 이미 친구가 되있는경우 제거
        if (friendList.get(user) != null) {
            scoreList.remove(user);
            for (String userFriend : userFriends) {
                scoreList.remove(userFriend);
            }
        }
        //점수가 0이면 제거
        while(scoreList.values().remove(0));
    }

    private static List<String> sortScore(Map<String, Integer> scoreList) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(scoreList.entrySet());
        list.sort((o1, o2) -> {
            int comparision = (o1.getValue() - o2.getValue()) * -1;
            return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
        });
        //5보다 클경우 제거
        return get5List(list);
    }

    private static void addFriend(Map<String, List<String>> friendList, String friend1, String friend2) {
        //friend값이 처음으로 리스트에 들어오면 초기화 진행
        if (!friendList.containsKey(friend1)) {
            friendList.put(friend1, new ArrayList<>());
            friendList.get(friend1).add(friend2);
            return;
        }
        friendList.get(friend1).add(friend2);
    }

    private static int getScore(List<String> userFriendList, List<String> friendList) {
        int score = 0;
        for (String userFriend : userFriendList) {
            if (friendList.contains(userFriend)) {
                score += 10;
            }
        }
        return score;
    }

    private static List<String> get5List(List<Map.Entry<String, Integer>> list) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.add(entry.getKey());
            if (list.size() == 5) return result;
        }
        return result;
    }
}
