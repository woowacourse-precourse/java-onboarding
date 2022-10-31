package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();


        return answer;
    }

    // 현재 닉네임에서 2글자 이상 연속된 부분문자열의 사용횟수
    public static void countSubstring(Map<String, Integer> map, String nickname) {
        // 문자열 개수
        for (int i = 2; i < nickname.length(); i++) {
            countSubStringOfLength(map, nickname, i);
        }
    }

    // 해당 길이 부분문자열 카운팅
    private static void countSubStringOfLength(Map<String, Integer> map, String nickname, int length) {
        // 시작점
        for (int i = 0; i <= nickname.length() - length; i++) {
            String subString = nickname.substring(i, i + length);
            int cnt = map.getOrDefault(subString, 0) + 1;
            map.put(subString, cnt);
        }
    }
}
