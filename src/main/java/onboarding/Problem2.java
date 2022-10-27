package onboarding;

import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static String isDuplicate(String text) {
        char fivot;
        StringBuilder newText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            fivot = text.charAt(i);
            Boolean duplicateFlag = false;
            while (i < text.length() - 2 && fivot == text.charAt(i + 1)) {
                i++;
                duplicateFlag = true;
            }
            if (!duplicateFlag) {
                newText.append(fivot);
            }
        }
        return newText.toString();
    }
}
