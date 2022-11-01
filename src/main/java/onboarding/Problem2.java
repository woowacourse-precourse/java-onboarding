package onboarding;

import java.util.ArrayList;
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
        List<Integer> indices = new ArrayList<Integer>();

        cryptogram = cryptogram + ".";
        Integer firstWindow=0;
        Integer secondWindow=1;

        // 문자열 해독 과정
        while(secondWindow != cryptogram.length()) {
            if (cryptogram.charAt(firstWindow) == cryptogram.charAt(secondWindow)) {
                secondWindow += 1;
                continue;
            } else if (secondWindow - firstWindow == 1) {
                firstWindow = secondWindow;
            } else {
                for (int j = firstWindow; j < secondWindow; j++) {
                    indices.add(j);
                }
                firstWindow = secondWindow;
            }
            secondWindow += 1;
        }
        return indices;
    }

    private static String eraseCharByIndex(List<Integer> continuousCharIndices, String cryptogram) {
    }

}
