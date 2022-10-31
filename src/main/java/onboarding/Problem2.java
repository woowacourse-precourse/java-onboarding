
package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        while (hasDuplication(answer)) {
            answer = makeNewWord(answer);
        }

        return answer;
    }

    private static boolean hasDuplication(String word) {
        boolean duplicationValue = false;
        int i = 0;

        while (!duplicationValue && (i < word.length() - 1)) {
            char nowLetter = word.charAt(i);
            char backLetter = word.charAt(i + 1);

            duplicationValue = (nowLetter == backLetter);
            i++;
        }

        return duplicationValue;
    }
}