package onboarding;

import static onboarding.problem1.Constants.ADDITION_INITIAL_VALUE;
import static onboarding.problem1.Constants.LEFT_PAGE_INDEX;
import static onboarding.problem1.Constants.LEFT_REMAINDER;
import static onboarding.problem1.Constants.LINE_BREAK;
import static onboarding.problem1.Constants.MAX_PAGE_NUMBER;
import static onboarding.problem1.Constants.MIN_PAGE_NUMBER;
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
import onboarding.problem1.ErrorMessage;

public class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            validatePages(pobi);
            validatePages(crong);
            return getSolution(getScore(pobi), getScore(crong));
        } catch (IllegalArgumentException exception) {
            System.out.printf(ErrorMessage.MESSAGE.getMessage(), exception.getMessage());
            System.out.printf(LINE_BREAK);
            return RESULT_EXCEPTION;
        }
    }

    private static void validatePages(List<Integer> player) throws IllegalArgumentException {
        validatePageRange(player);
        validatePageLength(player);
        validatePageOddEven(player);
        validatePageGap(player);
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

    private static void validatePageRange(List<Integer> player) throws IllegalArgumentException {
        for (int pageNumber : player) {
            if (pageNumber < MIN_PAGE_NUMBER || pageNumber > MAX_PAGE_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.PAGE_RANGE.getMessage());
            }
        }
    }

    private static void validatePageGap(List<Integer> player) throws IllegalArgumentException {
        if (player.get(LEFT_PAGE_INDEX) + PAGE_GAP != player.get(RIGHT_PAGE_INDEX)) {
            throw new IllegalArgumentException(ErrorMessage.PAGE_GAP.getMessage());
        }
    }

    private static void validatePageOddEven(List<Integer> player) throws IllegalArgumentException {
        if (isLeftPageOddNumber(player) || isrightPageEvenNumber(player)) {
            throw new IllegalArgumentException(ErrorMessage.PAGE_ODD_AND_EVEN.getMessage());
        }
    }

    private static boolean isrightPageEvenNumber(List<Integer> player) throws IllegalArgumentException {
        return player.get(RIGHT_PAGE_INDEX) % QUOTIENT != RIGHT_REMAINDER;
    }

    private static boolean isLeftPageOddNumber(List<Integer> player) {
        return player.get(LEFT_PAGE_INDEX) % QUOTIENT != LEFT_REMAINDER;
    }

    private static void validatePageLength(List<Integer> player) {
        if (player.size() != PLAYER_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.LENGTH.getMessage());
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