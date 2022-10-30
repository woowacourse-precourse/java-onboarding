package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    private static final int CAPITAL_A = 'A';
    private static final int CAPITAL_Z = 'Z';
    private static final int SMALL_A = 'a';
    private static final int SMALL_Z = 'z';

    private static List<Integer> getUnicodeThreshold(Integer unicode) {
        List<Integer> thresholds = new ArrayList<>();

        if (unicode >= CAPITAL_A && unicode <= CAPITAL_Z) {
            thresholds.add(CAPITAL_A);
            thresholds.add(CAPITAL_Z);
        } else if (unicode >= SMALL_A && unicode <= SMALL_Z) {
            thresholds.add(SMALL_A);
            thresholds.add(SMALL_Z);
        }

        return thresholds;
    }

    private static Character translater(List<Integer> threshold, int letterUnicode) {
        char translatedLetter = (char) letterUnicode;

        if (threshold.size() == 2) {
            int translatedUnicode = threshold.get(0) + (threshold.get(1) - letterUnicode);
            translatedLetter = (char) translatedUnicode;
        }

        return translatedLetter;
    }

    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int unicode = letter;

            List<Integer> threshold = getUnicodeThreshold(unicode);

            answer += translater(threshold, unicode);
        }

        return answer;
    }
}
