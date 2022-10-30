package onboarding;

import java.util.*;

public class Problem7 {
    static List<String> friendOfUser;
    static List<String> friendOfFriends;
    static Map<String, Integer> scoreOfFriends;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        friendOfUser = new ArrayList<>();
        friendOfFriends = new ArrayList<>();
        scoreOfFriends = new TreeMap<>();

        makeFriendOfUser(user, friends);
        makeFriendOfFriends(user, friends);
        makeVisitors(user, visitors);

        System.out.println(scoreOfFriends);

        answer = makeRecommendFriends(scoreOfFriends);

        return answer;
    }

    //user의 친구 찾기
    public static void makeFriendOfUser(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                friendOfUser.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                friendOfUser.add(friend.get(0));
            }
        }
    }
    
    //친구의 친구 찾기
    public static void makeFriendOfFriends(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {

            if (friend.get(0).equals(user) || friend.get(1).equals(user)) {
                continue;
            }

            if (friendOfUser.contains(friend.get(0)) && friendOfUser.contains(friend.get(1))) {
                continue;
            }

            if (friendOfUser.contains(friend.get(0))) {
                friendOfFriends.add(friend.get(1));
                getScore(friend.get(1), 10);
            } else if (friendOfUser.contains(friend.get(1))) {
                friendOfFriends.add(friend.get(0));
                getScore(friend.get(0), 10);
            }
        }

    }

    //방문자 찾기
    public static void makeVisitors(String user, List<String> visitors) {
        for (String visitor : visitors) {
            if (!user.equals(visitor) && !friendOfUser.contains(visitor)) {
                getScore(visitor, 1);
            }

        }
    }

    //점수 구현
    public static void getScore(String person, int score) {
        scoreOfFriends.put(person, scoreOfFriends.getOrDefault(person, 0) + score);
    }

    //추천친구 기능
    public static List<String> makeRecommendFriends(Map<String, Integer> scoreOfFriends) {
        List<String> ans = new ArrayList<>();
        LinkedList<Map.Entry<String, Integer>> entryList = new LinkedList<>(scoreOfFriends.entrySet());
        //value(점수) 별 비교
        entryList.sort((o1, o2) -> o1.getValue() == o2.getValue() ?
                o1.getKey().compareTo(o2.getKey()) : o2.getValue() - o1.getValue());

        //최대 5명
        int cnt = 0;
        for (Map.Entry<String, Integer> entry : entryList) {
            if (cnt == 5) {
                break;
            }
            //추천점수가 0이 아닌 경우
            if (entry.getValue() != 0) {
                ans.add(entry.getKey());
                cnt++;
            }
        }

        return ans;
    }
}
