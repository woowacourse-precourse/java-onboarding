package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    /**
     * 중복 위험이 있는 단어 목록을 반환합니다.
     */
    private static List<String> getDuplicatedWords(List<List<String>> forms) {
        List<String> duplicateWords = new ArrayList<>();
        Map<String, Integer> allWords = getAllWords(forms);

        for (String word : allWords.keySet()) {
            if (2 <= allWords.get(word)) {
                duplicateWords.add(word);
            }
        }

        return duplicateWords;
    }

    /**
     * 닉네임에서 추출될 수 있는 모든 단어 목록을 map(단어, 횟수)으로 반환합니다.
     */
    private static Map<String, Integer> getAllWords(List<List<String>> forms) {
        Map<String, Integer> allWords = new HashMap<>();

        for (List<String> form : forms) {
            String nickName = getNickName(form);

            for (int i = 0; i <= nickName.length() - 2; i++) {
                String word = nickName.substring(i, i + 2);
                allWords.put(word, allWords.getOrDefault(word, 0) + 1);
            }
        }

        return allWords;
    }

    private static String getEmail(List<String> form) {
        return form.get(0);
    }

    private static String getNickName(List<String> form) {
        return form.get(1);
    }
}
