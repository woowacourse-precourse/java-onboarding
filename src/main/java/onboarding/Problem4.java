package onboarding;

public class Problem4 {

    private static final int UpperCaseMinCode = 65;
    private static final int UpperCaseMaxCode = 90;
    private static final int LowerCaseMinCode = 97;
    private static final int LowerCaseMaxCode = 122;

    public static String solution(String word) {
        String answer = "";

        for (char element : word.toCharArray()) {
            if (isAlphabet(element)) {

            }
            else
                answer += element;
        }
        return answer;
    }

    public static boolean isAlphabet(Character word) {
        int wordCode = (int) word;
        if ((UpperCaseMinCode <= wordCode && wordCode <= UpperCaseMaxCode) ||
                (LowerCaseMinCode <= wordCode && wordCode <= LowerCaseMaxCode))
            return true;
        return false;
    }
}
