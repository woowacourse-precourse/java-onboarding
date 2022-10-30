package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scores = new HashMap<>();
    }

    /* 누군가가 주어졌을 때 길이 2인 List에 없으면 "", 있으면 나머지 한명 반환하는 메서드 */
    private static String pickAnotherOne(List<String> friendPair, String someone) {
        int index;
        if (!(friendPair.contains(someone))) {
            return "";
        }

        index = friendPair.indexOf(someone);
        String friend = friendPair.get(1-index);
        return friend;
    }

    /* friends 목록을 순회하면서 유저의 친구를 뽑아내 List로 반환하는 메서드 */
    private static List<String> pickUserFriends(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();

        for (List<String> friendPair : friends) {
            String someone = pickAnotherOne(friendPair, user);
            if (!(someone.equals(""))) {
                result.add(someone);
            }
        }

        return result;
    }

    /* 주어진 아이디를 key로 하는 Map에 원하는 만큼 점수 추가 하는 메서드 */
    private static void incrementScore(Map<String, Integer> score, String id, int scoreAmount) {
        int point = score.getOrDefault(id, 0) + scoreAmount;
        score.put(id, point);
    }

    /* 사용자의 친구의 친구를 찾아 그 사람들에게 10점씩 추가하고 Map에 기록하는 메서드 */
    private static void recordFriendsScore(Map<String, Integer> scores, List<String> userFriends, List<List<String>> friends, String user) {
        for (String friend : userFriends) {
            for (List<String> friendPair : friends) {
                String someone = pickAnotherOne(friendPair, friend);

                if (!(someone.equals("")) && !(someone.equals(user))) {
                    incrementScore(scores, someone, 10);
                }
            }
        }
    }
}
