package onboarding;

public class Problem4 {
    private static final char BLANK_CHARACTER = ' ';


    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char originalChar = word.charAt(i);
            if (originalChar != BLANK_CHARACTER) {
                answer.append(getGreenFrogChar(originalChar));
            } else {
                answer.append(originalChar);
            }
        }

        System.out.println(answer);

        return answer.toString();
    }

    private static char getGreenFrogChar(char originalChar) {
        if (isCapitalLetter(originalChar)) {
            System.out.println(originalChar + " : 대문자입니다.");
            System.out.println(getUpperCharConvert(originalChar));

            return getUpperCharConvert(originalChar);
        } else {
            System.out.println(originalChar + " : 소문자입니다.");

            return getLowerCharConvert(originalChar);
        }
    }

    private static boolean isCapitalLetter(char checkChar) {
        return Character.isUpperCase(checkChar);
    }

    private static char getUpperCharConvert(char originalChar) {
        return (char) ('A' + ('Z' - originalChar));
    }

    private static char getLowerCharConvert(char originalChar) {
        return (char) ('a' + ('z' - originalChar));
    }
}
