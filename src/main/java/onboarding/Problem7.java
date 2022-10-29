package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        /* ArrayList를 이용하여 user의 친구 아이디를 추가 */
        List<String> ar = new ArrayList<>();

        /* friends 리스트에서 user의 친구 아이디를 찾아 ar 리스트에 추가하는 기능 */
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                int n = friends.get(i).indexOf(user);
                ar.add(friends.get(i).get(1 - n));
            }
        }

        return answer;
    }
}
