package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] chars = word.toCharArray();

        convert(chars);
        answer = String.valueOf(chars);

        return answer;
    }

    private static void convert(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            int charToAscii = (int) chars[i];
            if (charToAscii >= 97 && charToAscii <= 122) {
                chars[i] = (char) (219 - charToAscii);
            } else if (charToAscii >= 65 && charToAscii <= 90) {
                chars[i] = (char) (155 - charToAscii);
            }
        }
    }
}
