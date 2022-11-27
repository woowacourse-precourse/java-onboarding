package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);
        return getSolution(pobiScore, crongScore);
    }

    private static int getScore(List<Integer> player) {
        List<Integer> playerResult = new ArrayList<>();
        for (int playerNumber : player) {
            List<String> playerDigits = new ArrayList<>(List.of(String.valueOf(playerNumber).split("")));
            int addition = 0;
            int multiplication = 1;
            for (String playerDigit : playerDigits) {
                addition += Integer.parseInt(playerDigit);
                multiplication *= Integer.parseInt(playerDigit);
            }
            playerResult.add(addition);
            playerResult.add(multiplication);
        }
        return Collections.max(playerResult);
    }

    private static int getSolution(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        }
        if (pobiScore < crongScore) {
            return 2;
        }
        if (pobiScore == crongScore) {
            return 0;
        }
        return -1;
    }
}