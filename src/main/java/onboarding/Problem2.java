package onboarding;

import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {

        String lastVersionCryptogram = cryptogram;
        String recentVersionCryptogram = decrypt(cryptogram);
        String answer = "answer";
        return answer;
    }

    private static String decrypt(String cryptogram) {
        List<Integer> continuousCharIndices = findContinuousChar(cryptogram);

        return eraseCharByIndex(continuousCharIndices, cryptogram);

    }

    private static List<Integer> findContinuousChar(String cryptogram) {
    }

    private static String eraseCharByIndex(List<Integer> continuousCharIndices, String cryptogram) {
    }

}
