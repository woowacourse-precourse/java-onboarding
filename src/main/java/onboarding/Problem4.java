package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        if (word.length() < 1 || word.length() > 1000) return "error";

        for (int i = 0; i < word.length(); i++) {
            char charWord = word.charAt(i);
            if (charWord == 32) {
                answer += (char)32;
                continue;
            }
            if ((charWord >= 'A' && charWord <= 'Z') || (charWord >= 'a' && charWord <= 'z')) {
                if (Character.isUpperCase(charWord)) {
                    answer += (char)(155 - charWord);
                } else {
                    answer += (char)(219 - charWord);
                }
            } else {
                return "error";
            }
        }

        return answer;
    }
}
