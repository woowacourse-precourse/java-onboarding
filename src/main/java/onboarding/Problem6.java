package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 6.
 * 1. 한 닉네임의 연속 2개씩 모든 단어 추출
 * 2. 해당 단어들을 포함하고 있는 닉네임들의 이메일을 answer에 추가(단, 자기 자신은 제외)
 *    - 이때 중복을 제거하기 위해 set 활용
 * 3. answer 이메일을 기준으로 정렬
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        return answer;
    }

    /**
     * 주어진 닉네임에서 연속 2개씩 모든 단어 추출하는 메소드
     */
    private static List<String> getTwoConsecutiveWords(String nickname) {
        List<String> twoConsecutiveWords = new ArrayList<>();

        for (int i = 0; i < nickname.length() - 1; ++i) {
            twoConsecutiveWords.add(nickname.substring(i, i + 2));
        }
        return twoConsecutiveWords;
    }
}
