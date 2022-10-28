package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int strToCharDigit = word.charAt(i);                //글자 하나를 불러온다.
            if (isAlphabet(answer, strToCharDigit)) continue;

        }
        return answer.toString();
    }

    private static int distributeUpper(int strToCharDigit) {
        if (Character.isUpperCase(strToCharDigit)) {
            strToCharDigit = (155 - strToCharDigit);
        } else {
            strToCharDigit = (219 - strToCharDigit);
        }
        return strToCharDigit;
    }

    private static boolean isAlphabet(StringBuilder answer, int strToCharDigit) {
        if (strToCharDigit == 32) {
            answer.append(Character.toString(strToCharDigit));
            return true;
        }
        return false;
    }
}
