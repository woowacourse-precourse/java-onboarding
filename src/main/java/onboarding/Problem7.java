package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * 1. 사용자 친구 목록 생성 기능
 * 2. 사용자 Non-친구 목록 생성 기능
 * 3. 친구 추천 점수 계산 기능
 *  3-1. 서로 일치하는 친구 점수 계산 기능
 *  3-2. visitors 점수 계산 기능
 * */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static Set<String> getMyFriends(String user, List<List<String>> friends) {
        return friends.stream()
                .filter(list -> list.contains(user))
                .map(list -> list.toArray(String[]::new))
                .flatMap(Arrays::stream)
                .filter(s -> !s.equals(user))
                .collect(Collectors.toSet());
    }
}
