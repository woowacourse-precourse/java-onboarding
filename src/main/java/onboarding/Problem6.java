package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> words = List.of("");

        if (isError(forms)) {
            return answer = List.of("-1");
        }

        words = findTwoWord(forms);

        for (List<String> form : forms) {
            if (containsWords(form, words)) {
                answer.add(form.get(0));
            }
        }

        return answer.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static boolean containsWords(List<String> form, List<String> words) {
        for (String word : words) {
            if (form.get(1).contains(word)) {
                return true;
            }
        }

        return false;
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
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static boolean isError(List<List<String>> forms) {
        if (checkFormsLength(forms)) {
            return true;
        }
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);
            if (checkEmailLength(email) || checkEmailDomain(email) || checkNicknameLanguage(nickName) || checkNicknameLength(nickName)) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkFormsLength(List<List<String>> forms) {
        return forms.size() < 1 || forms.size() > 10000;
    }

    public static boolean checkEmailLength(String email) {
        return email.length() < 11 || email.length() >= 20;
    }

    public static boolean checkEmailDomain(String email) {
        return !email.split("@")[1].equals("email.com");
    }

    public static boolean checkNicknameLanguage(String nickName) {
        return !nickName.matches("^[가-힣]*$");
    }

    public static boolean checkNicknameLength(String nickName) {
        return nickName.length() < 1 || nickName.length() >= 20;
    }
}
