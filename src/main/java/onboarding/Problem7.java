package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }


    // user의 이름과 String으로 넘겨준 값이 일치하는지 확인
    private static boolean isUser(String friendFriendName, String user) {
        return friendFriendName.equals(user);
    }


    // user와 친구인 사람들의 이름 List반환
    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        List<String> tmp;

        for (int i = 0; i < friends.size(); i++) {
            tmp = friends.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                if (tmp.get(j).equals(user)) {
                    userFriends.add(tmp.get(1 - j));
                }
            }
        }
        return userFriends;
    }

    // 추천 친구와 점수를 기록하기 위한 클래스
    private static class FriendCount {
        String name;
        int count;

        FriendCount(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}