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
                if (isUpperCase(element))
                    answer += convertUpper(element);
                else
                    answer += convertLower(element);
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

    public static boolean isUpperCase(Character word) {
        int wordCode = (int) word;
        if (UpperCaseMinCode <= wordCode && wordCode <= UpperCaseMaxCode)
            return true;
        return false;
    }

    public static Character convertUpper(Character word) {
        int result = (UpperCaseMinCode + UpperCaseMaxCode) - (int) word;
        return (char) result;
    }

    public static Character convertLower(Character word) {
        int result = (LowerCaseMinCode + LowerCaseMaxCode) - (int) word;
        return (char) result;
    }
}
