package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int duplicateLetterIndex = findDuplicateLetterIndex(cryptogram);
        return answer;
    }

    private static int findDuplicateLetterIndex(String word) {
        for (int index = 0; index < word.length() - 1; index++) {
            char leftLetter = word.charAt(index);
            char rightLetter = word.charAt(index + 1);
            if (leftLetter == rightLetter) {
                return index;
            }
        }
        return -1;
    }
}
