package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] charArray = word.toCharArray();

        for (int i = 0; i < charArray.length; i++) {

            if (isUpperCase(charArray[i])) {
                charArray[i] = (char) ('Z' + 'A' - charArray[i]);
            } else if (isLowerCase(charArray[i])) {
                charArray[i] = (char) ('z' + 'a' - charArray[i]);
            }
        }

        answer = new String(charArray);
        return answer;
    }


    static boolean isUpperCase(char c) {
        return 'A' <= c && c <= 'Z';
    }

    static boolean isLowerCase(char c) {
        return 'a' <= c && c <= 'z';
    }
}
