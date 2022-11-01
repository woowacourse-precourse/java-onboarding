package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // user의 친구 리스트를 생성하는 함수 createUserFriend()
        // 점수를 부여받은(0점이 아닌) 친구의 이름과 그의 점수를 갱신해주는 함수 putRecommendList()

        List<String> userFriends = createUserFriend(user, friends);
        Map<String, Integer> recommendList = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            String friendA = friends.get(i).get(0);
            String friendB = friends.get(i).get(1);

            if (findUserFriend(friendA, userFriends)) {
                putRecommendList(friendB, recommendList, 10);
            }
            if (findUserFriend(friendB, userFriends)) {
                putRecommendList(friendA, recommendList, 10);
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            putRecommendList(visitors.get(i), recommendList, 1);
        }

        List<String> answer = new ArrayList<>();
        return answer;
    }

    public static List<String> createUserFriend(String user, List<List<String>> friends) {

        List<String> userFriends = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            String friendA = friends.get(i).get(0);
            String friendB = friends.get(i).get(1);
            if (friendA.equals(user)) userFriends.add(friendB);
            if (friendB.equals(user)) userFriends.add(friendA);
        }

        return userFriends;

    }

    public static boolean findUserFriend(String friend, List<String> userFriends) {

        for (int i = 0; i < userFriends.size(); i++) {
            if (userFriends.get(i).equals(friend)) {
                return true;
            }
        }

        return false;
    }

    public static void putRecommendList(String friend, Map<String, Integer> recommendList, int point) {

        Iterator<String> iterator = recommendList.keySet().iterator();
        boolean isExist = false;

        while (iterator.hasNext()) {
            if (iterator.next().equals(friend)) {
                int recommendPoint = recommendList.get(friend);
                recommendList.replace(friend, recommendPoint + point);
                isExist = true;
                break;
            }
        }

        if (!isExist) recommendList.put(friend, point);
    }
}
