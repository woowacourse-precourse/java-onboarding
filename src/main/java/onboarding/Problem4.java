package onboarding;

public class Problem4 {
    private static final char BLANK_CHARACTER = ' ';


    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            char originalChar = word.charAt(i);
            if (originalChar != BLANK_CHARACTER) {
                getGreenFrogChar(originalChar);
            }
        }

        return answer;
    }

    private static void getGreenFrogChar(char originalChar) {
        if (isCapitalLetter(originalChar)) {
            System.out.println(originalChar + " : 대문자입니다.");
        } else {
            System.out.println(originalChar + " : 소문자입니다.");
        }
    }

    private static boolean isCapitalLetter(char checkChar) {
        return Character.isUpperCase(checkChar);
    }
}
