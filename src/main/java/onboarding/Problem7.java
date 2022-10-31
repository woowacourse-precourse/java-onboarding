package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    //두 사람 중 user와 친구인 다름 사람의 이름을 반환하는 함수
    public static String findAnother(List<String> twoPeople, String user) {
        if (twoPeople.get(0).equals(user))
            return twoPeople.get(1);
        else
            return twoPeople.get(0);
    }
}