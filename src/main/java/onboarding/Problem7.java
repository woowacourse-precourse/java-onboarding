package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scores = new HashMap<>();
    }

    /* 누군가가 주어졌을 때 길이 2인 List의 나머지 한명을 목적지 List에 추가 해주는 메서드 */
    private static void pickAnotherOne(List<String> destination, List<String> friendPair, String someone) {
        int index;
        if (!(friendPair.contains(someone))) {
            return;
        }

        index = friendPair.indexOf(someone);
        String friend = friendPair.get(1-index);
        destination.add(friend);
    }
}
