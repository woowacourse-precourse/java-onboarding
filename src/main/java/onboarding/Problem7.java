package onboarding;

import problem7.Friend;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Friend friend = new Friend(user, friends, visitors);
        List<String> answer = friend.sortScore();
        return answer;
    }
}
