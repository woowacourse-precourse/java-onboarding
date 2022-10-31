package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> result = new TreeSet<>(); // 정렬(오름차순), 중복 제거를 위해 TreeSet 사용

        for (List<String> form : forms) {
            String email = getEmail(form);
            String nickName = getNickName(form);

            if (isDuplicated(forms, nickName)) {
                result.add(email);
            }
        }

        return new ArrayList<>(result);
    }

    /**
     * 해당 닉네임이 중복 위험 단어를 포함하는지 알려줍니다.
     */
    private static boolean isDuplicated(List<List<String>> forms, String nickName) {
        List<String> duplicatedWords = getDuplicatedWords(forms);

        for (String duplicatedWord : duplicatedWords) {
            if (nickName.contains(duplicatedWord)) {
                return true;
            }
        }
        return false;
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
