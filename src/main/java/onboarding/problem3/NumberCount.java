package onboarding.problem3;

import java.util.List;

public class NumberCount {

    private int maximumNumber;
    private final List<Integer> TARGET_NUMBERS = List.of(3,6,9);

    public int count369Under(int number){
        maximumNumber = number;
        int result = 0;

        int countOfDigits = (int) (Math.log10(number)) + 1;
        for (int digitPlace=1; digitPlace<=countOfDigits; digitPlace++){
            for (int targetNumber : TARGET_NUMBERS){
                result += countNumbersWhenDigitPlaceIsTargetNumber(digitPlace, targetNumber);
            }
        }

        return result;
    }

    private int countNumbersWhenDigitPlaceIsTargetNumber(int digitPlace, int targetNumber){
        int frontNumbers = maximumNumber / (int) Math.pow(10, digitPlace);
        int backNumbers = maximumNumber % (int) Math.pow(10, digitPlace -1);
        int placeNumber = placeValueOfMaximumNumber(digitPlace);

        if (placeNumber < targetNumber){
            return (frontNumbers) * (int) Math.pow(10, digitPlace -1);
        } else if (placeNumber == targetNumber){
            return frontNumbers * (int) Math.pow(10, digitPlace -1) + backNumbers + 1;
        } else {
            return (frontNumbers +1) * (int) Math.pow(10, digitPlace -1);
        }
    }

    private int placeValueOfMaximumNumber(int place){
        return maximumNumber / (int) Math.pow(10, place -1) % 10;
    }
}
