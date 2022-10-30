package onboarding;

import java.util.*;

public class Problem7 {
    // user는 본인 friends리스트는 2명씩 짝으로, visitors는 같은 인물이 중복되어 나올 수 있다
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(); //반환용 리스트
        List<String> realFriends = new ArrayList<>(); //사용자와 이미 친구인 리스트
        List<String> withFriends = new ArrayList<>(); //친구의 친구 리스트(사용자와 친구X) -> +10점
        List<String> visitFriends = new ArrayList<>(); //방문자 리스트 -> +1점

        return answer;
    }
}