/*
[기능 목록]
1. 닉네임 글자 분석
-> 연속된 두 글자들을 key로 가지고 있는 저장소(map)에 닉네임이 들어있는 form의 인덱스 저장
2. 중복된 두 글자를 가지고 있는 이메일 리스트 생성
*/

package onboarding;

import java.util.*;

public class Problem6 {
    static Map<String, Set<Integer>> twoLettersRepository = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static void analyzeNickname (String nickname, int index) {
        int len = nickname.length();
        for (int i = 0; i < len - 1; i++) {
            addToRepository(nickname.substring(i, i+2), index);
        }
    }

    public static void addToRepository (String twoLetters, int index) {
        if (!twoLettersRepository.containsKey(twoLetters)) {
            twoLettersRepository.put(twoLetters, new HashSet<>());
        }
        twoLettersRepository.get(twoLetters).add(index);
    }
}
