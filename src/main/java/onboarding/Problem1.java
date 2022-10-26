package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isPlayersCorrectInput(Arrays.asList(pobi, crong))) {
            return -1;
        }
        
        int result = Integer.compare(getMaxNumber(pobi), getMaxNumber(crong));
        return result >= 0 ? result : 2;
    }
    
    private static boolean isPlayersCorrectInput(final List<List<Integer>> players) {
        return players.stream()
                .anyMatch(Problem1::isNotCorrectInputNumbers);
    }
    
    private static boolean isNotCorrectInputNumbers(final List<Integer> numbers) {
        int leftNumber = numbers.get(0);
        int rightNumber = numbers.get(1);
        return isNotCorrectEvenAndOdd(leftNumber, rightNumber) || isDifferenceNotOne(leftNumber, rightNumber) || isLeftBigger(leftNumber, rightNumber);
    }
    
    private static boolean isLeftBigger(final int leftNumber, final int rightNumber) {
        return leftNumber >= rightNumber;
    }
    
    private static boolean isDifferenceNotOne(final int leftNumber, final int rightNumber) {
        return leftNumber + 1 != rightNumber;
    }
    
    private static boolean isNotCorrectEvenAndOdd(final int leftNumber, final int rightNumber) {
        return leftNumber % 2 != 1 || rightNumber % 2 != 0;
    }
    
    private static int getMaxNumber(final List<Integer> numbers) {
        return Math.max(getMaxSum(numbers), getMaxMultiply(numbers));
    }
    
    private static int getMaxMultiply(final List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Problem1::multiply)
                .max()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("올바른 값이 아닙니다.");
                });
    }
    
    private static int multiply(final int number) {
        return Arrays.stream(split(number))
                .mapToInt(Integer::parseInt)
                .reduce((accumulateNum, rightNum) -> accumulateNum * rightNum)
                .orElse(0);
    }
    
    private static int getMaxSum(final List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Problem1::sum)
                .max()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("올바른 값이 아닙니다.");
                });
    }
    
    private static int sum(final int number) {
        return Arrays.stream(split(number))
                .mapToInt(Integer::parseInt)
                .sum();
    }
    
    private static String[] split(final int number) {
        return String.valueOf(number).split("");
    }
}