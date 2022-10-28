package onboarding;

public class Problem4 {
    static final int MIN_LENGTH = 1;
    static final int MAX_LENGTH = 1000;
    public static String solution(String word) {
        String answer = "";
        if (!isValidInput(word)) {
            answer = "error";
            return answer;
        }
        answer = convertReverse(word);
        return answer;
    }

    private static String convertReverse(String word) {
        char currentChar;
        char[] wordArr = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            currentChar = wordArr[i];
            if (Character.isAlphabetic(currentChar)) {
                if (Character.isUpperCase(currentChar)) {
                    wordArr[i] = (char)('A' + 'Z' - wordArr[i]);
                }
                if (Character.isLowerCase(currentChar)) {
                    wordArr[i] = (char)('a' + 'z' - wordArr[i]);
                }
            }
        }
        return String.valueOf(wordArr);
    }

    private static boolean isValidInput(String word) {
        return (isNotNull(word) && isValidRange(word));
    }

    private static boolean isValidRange(String word) {
        return word.length() >= MIN_LENGTH && word.length() <= MAX_LENGTH;
    }

    private static boolean isNotNull(String word) {
        return word != null;
    }

    public static void main(String[] args) {
        System.out.println(solution("I love you"));
    }
}
