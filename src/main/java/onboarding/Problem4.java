package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        try {
            validation(word);

            String answer = transform(word);
            return answer;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public static Map<String, String> makeDict() {
        HashMap<String, String> dict = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char) (65 + i)), String.valueOf((char) (90 - i)));
            dict.put(String.valueOf((char) (97 + i)), String.valueOf((char) (122 - i)));
        }
        return dict;
    }

    public static String transform(String word) {
        Map<String, String> dict = makeDict();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            String tmp = String.valueOf(word.charAt(i));
            if (Character.isAlphabetic(word.charAt(i))) {
                answer.append(dict.get(tmp));
            } else {
                answer.append(tmp);
            }
        }
        return answer.toString();
    }

    public static void validation(String word) {
        if (word.length() < 1 || word.length() > 1000) {
            throw new RuntimeException("문자의 길이는 1 이상 1000 이하 입니다.");
        }
    }
}
