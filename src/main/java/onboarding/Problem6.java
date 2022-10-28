package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String> words = List.of("");

        if (isError(forms)) {
            return answer = List.of("-1");
        }

        words = findTwoWord(forms);

        answer = containsWords(forms, words);

        return answer;
    }

    public static List<String> containsWords(List<List<String>> forms, List<String> words) {
        List<String> nickNames = new ArrayList<>();
        for (List<String> form : forms) {
            for (String word : words) {
                if (form.get(1).contains(word)) {
                    nickNames.add(form.get(0));
                }
            }
        }

        return nickNames;
    }

    public static List<String> findTwoWord(List<List<String>> forms) {
        Map<String, Integer> allWords = new HashMap<>();
        for (List<String> form : forms) {
            String nickName = form.get(1);
            for (int j = 0; j < nickName.length() - 1; j++) {
                String word = nickName.substring(j, j + 2);
                allWords.put(word, allWords.getOrDefault(word, 0) + 1);
            }
        }

        return allWords.entrySet().stream()
                .filter(e -> e.getValue() >= 2)
                .map(Map.Entry :: getKey)
                .collect(Collectors.toList());
    }

    public static boolean isError(List<List<String>> forms) {
        boolean flag = false;
        if (forms.size() < 1 || forms.size() > 10000) { // 크루 수
            flag = true;
        }
        for (List<String> form : forms) {
            if (form.get(0).length() < 11 || form.get(0).length() >= 20) { // 이메일 길이
                flag = true;
            }
            if (!form.get(0).split("@")[1].equals("email.com")) { // 이메일 도메인
                flag = true;
            }
            if (!form.get(1).matches("^[가-힣]")) { // 닉네임 한글
                flag = true;
            }
            if (form.get(1).length() < 1 || form.get(1).length() >= 20) { // 닉네임 길이
                flag = true;
            }
        }
        return flag;
    }
}
