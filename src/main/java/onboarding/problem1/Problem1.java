package onboarding.problem1;

import static onboarding.problem1.Constants.ADDITION_INITIAL_VALUE;
import static onboarding.problem1.Constants.ERROR_LENGTH;
import static onboarding.problem1.Constants.ERROR_MESSAGE;
import static onboarding.problem1.Constants.ERROR_PAGE_GAP;
import static onboarding.problem1.Constants.ERROR_PAGE_ODD_AND_EVEN;
import static onboarding.problem1.Constants.LEFT_PAGE_INDEX;
import static onboarding.problem1.Constants.LEFT_REMAINDER;
import static onboarding.problem1.Constants.LINE_BREAK;
import static onboarding.problem1.Constants.MULTIPLICATION_INITIAL_VALUE;
import static onboarding.problem1.Constants.PAGE_GAP;
import static onboarding.problem1.Constants.PLAYER_LENGTH;
import static onboarding.problem1.Constants.QUOTIENT;
import static onboarding.problem1.Constants.REGEX_NO_SPACE;
import static onboarding.problem1.Constants.RESULT_CRONG_WIN;
import static onboarding.problem1.Constants.RESULT_EXCEPTION;
import static onboarding.problem1.Constants.RESULT_POBI_WIN;
import static onboarding.problem1.Constants.RESULT_TIE;
import static onboarding.problem1.Constants.RIGHT_PAGE_INDEX;
import static onboarding.problem1.Constants.RIGHT_REMAINDER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            validatePages(pobi);
            validatePages(crong);
            return getSolution(getScore(pobi), getScore(crong));
        } catch (IllegalArgumentException exception) {
            System.out.printf(ERROR_MESSAGE, exception.getMessage());
            System.out.printf(LINE_BREAK);
            return RESULT_EXCEPTION;
        }
    }

    private static void validatePages(List<Integer> player) {
        validatePageLength(player);
        validatePageOddEven(player);
        validatePageOrder(player);
    }


    private static int getScore(List<Integer> player) {
        return Collections.max(getResults(player));
    }

    private static List<Integer> getResults(List<Integer> player) {
        List<Integer> playerResults = new ArrayList<>();
        for (int playerNumber : player) {
            List<String> playerDigits = new ArrayList<>(splitNumber(playerNumber));
            playerResults.addAll(getAdditionResults(playerDigits));
            playerResults.addAll(getMultiplicationResults(playerDigits));
        }
        return playerResults;
    }

    private static List<Integer> getMultiplicationResults(List<String> playerDigits) {
        List<Integer> multiplicationResults = new ArrayList<>();
        int multiplication = MULTIPLICATION_INITIAL_VALUE;
        for (String playerDigit : playerDigits) {
            multiplication *= Integer.parseInt(playerDigit);
        }
        multiplicationResults.add(multiplication);
        return multiplicationResults;
    }

    private static List<Integer> getAdditionResults(List<String> playerDigits) {
        List<Integer> additionResults = new ArrayList<>();
        int addition = ADDITION_INITIAL_VALUE;
        for (String playerDigit : playerDigits) {
            addition += Integer.parseInt(playerDigit);
        }
        additionResults.add(addition);
        return additionResults;
    }

    private static void validatePageOrder(List<Integer> player) {
        if (player.get(LEFT_PAGE_INDEX) + PAGE_GAP != player.get(RIGHT_PAGE_INDEX)) {
            throw new IllegalArgumentException(ERROR_PAGE_GAP);
        }
    }

    private static void validatePageOddEven(List<Integer> player) {
        if (isLeftPageOddNumber(player) || isrightPageEvenNumber(player)) {
            throw new IllegalArgumentException(ERROR_PAGE_ODD_AND_EVEN);
        }
    }

    private static boolean isrightPageEvenNumber(List<Integer> player) {
        return player.get(RIGHT_PAGE_INDEX) % QUOTIENT != RIGHT_REMAINDER;
    }

    private static boolean isLeftPageOddNumber(List<Integer> player) {
        return player.get(LEFT_PAGE_INDEX) % QUOTIENT != LEFT_REMAINDER;
    }

    private static void validatePageLength(List<Integer> player) {
        if (player.size() != PLAYER_LENGTH) {
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
    }

    private static List<String> splitNumber(int playerNumber) {
        return List.of(String.valueOf(playerNumber).split(REGEX_NO_SPACE));
    }

    private static int getSolution(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return RESULT_POBI_WIN;
        }
        if (pobiScore < crongScore) {
            return RESULT_CRONG_WIN;
        }
        return RESULT_TIE;
    }
}