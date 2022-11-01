package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            answer += conversion(word.charAt(i));
        }

        return answer;
    }
    // 알파벳 반환 메서드
    public static char conversion(char word) {
        int ascUpper = 65;
        int ascLower = 97;
        int wordInt = 0;

        if (Character.isUpperCase(word)) {
            wordInt = (int)word - ascUpper;
            word = (char)(90 - wordInt);
        } else if (Character.isLowerCase(word)) {
            wordInt = (int)word - ascLower;
            word = (char)(122 - wordInt);
        }
        return word;
    }
}
