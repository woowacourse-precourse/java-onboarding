package onboarding;

public class Problem4 {

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {

            if (isSpelling(word.charAt(i))) {
                answer.append(convertSpelling(word.charAt(i)));
            } else {
                answer.append(word.charAt(i));
            }

        }

        return answer.toString();
    }

    private static boolean isSpelling(char spelling) {

        if (isUpperCase(spelling)) {
            return true;
        } else if (isLowerCase(spelling)) {
            return true;
        } else {
            return false;
        }

    }

    private static char convertSpelling(char spelling) {

        if (isUpperCase(spelling)) {
            return (char)('Z' - (spelling - 'A'));
        } else {
            return (char)('z' - (spelling - 'a'));
        }
    }

    private static boolean isUpperCase(char spelling) {

        if (spelling - 'A' >= 0 && spelling - 'A' < 26) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean isLowerCase(char spelling) {

        if (spelling - 'a' >= 0 && spelling - 'a' < 26) {
            return true;
        } else {
            return false;
        }

    }

}
