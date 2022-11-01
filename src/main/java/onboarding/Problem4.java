package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        answer = String.valueOf(conversionCharList(word));

        return answer;
    }

    public static char[] conversionCharList(String word) {
        char[] chars = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            if (chars[i] == ' ') {
                chars[i] = ' ';
            } else if (Character.isUpperCase(chars[i])) {
                chars[i] = (char)(155 - (int)chars[i]);
            } else {
                chars[i] = (char)(219 - (int)chars[i]);
            }
        }

        return chars;
    }
}
