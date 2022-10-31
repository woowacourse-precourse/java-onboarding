package onboarding.problem1;

import onboarding.validation.MinMaxInputValidatable;
import onboarding.validation.MinMaxIntegerInputValidate;

import java.util.List;

import static java.lang.Math.*;
import static onboarding.validation.MinMaxIntegerInputValidate.*;

/*
 * - pobi와 crong의 input이 길이가 2인지 판단한다.
 * - pobi와 crong의 input의 원소들이 페이지의 최소값인 1과 최대값인 400사이인지 확인한다.
 * - pobi와 crong의 input이 각각 연속된 숫자 리스트인지 확인한다. ex) [97, 98] -> (O), [98,100] -> (X)
 * - pobi와 crong의 input이 각각 [홀수, 짝수] 쌍인지 확인한다.
 * - pobi와 crong의 input이 [홀수, 짝수]인 쌍에서 짝수값이 홀수 값보다 1 큰지 확인한다.
 */
public class Problem1Validation {
    public static boolean problem1InputValidation(List<Integer> list, int userInputLength, int bookMin, int bookMax) {
        return isBookNumberBetweenMinAndMax(list, bookMin, bookMax, userInputLength)
                && isBookNumberContinuous(list, userInputLength)
                && isBookNumberOddEvenPair(list, userInputLength)
                && isFirstAddOneEqualsSecondValue(list, userInputLength);
    }

    private static boolean userInputSizeEquals(List<Integer> userInput, int listSize) {
        if (userInput.size() == listSize) {
            return true;
        }
        return false;
    }

    private static boolean isBookNumberBetweenMinAndMax(List<Integer> userInput, int bookMin, int bookMax, int userInputLength) {
        if (userInputSizeEquals(userInput, userInputLength)) {
            MinMaxInputValidatable minMaxInputValidator = getMinMaxIntegerInputValidate();
            long count = userInput.stream()
                    .filter(pageNum -> minMaxInputValidator.isInputBetweenMinAndMax(pageNum, bookMin, bookMax))
                    .count();
            return Long.valueOf(userInput.size()) == count;
        } else {
            return false;
        }
    }

    private static boolean isBookNumberContinuous(List<Integer> list, int userInputLength) {
        if (userInputSizeEquals(list, userInputLength)) {
            int abs = abs(list.get(0) - list.get(1));
            if (abs == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }


    }

    private static boolean isBookNumberOddEvenPair(List<Integer> list, int userInputLength) {
        if (userInputSizeEquals(list, userInputLength)) {
            if ((list.get(0) % 2 == 1) && (list.get(1) % 2 == 0)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    private static boolean isFirstAddOneEqualsSecondValue(List<Integer> list, int userInputLength) {
        if (userInputSizeEquals(list, userInputLength)) {
            if (list.get(0) + 1 == list.get(1)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static boolean isBetween(Integer pageNum, int bookMin, int bookMax) {
        if (bookMin <= pageNum && pageNum <= bookMax) {
            return true;
        } else {
            return false;
        }
    }
}
