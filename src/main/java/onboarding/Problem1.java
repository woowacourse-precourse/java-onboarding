package onboarding;

import java.util.*;
import java.util.stream.Stream;

class Problem1 {
    static class PageValidationException extends RuntimeException {
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            if (예외 확인 메소드(pobi) || 예외 확인 메소드(crong)) {
                throw new PageValidationException();
            }

            int pobiResult = getResult(pobi);
            int crongResult = getResult(crong);

            if (pobiResult > crongResult) {
                return 1;
            } else if (crongResult > pobiResult) {
                return 2;
            } else if (pobiResult == crongResult) {
                return 0;
            }
        } catch (PageValidationException e) {
            return -1;
        }
    }

    private static int[] splitEachNumbers(int number) {
        int[] arrNum = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
        return arrNum;
    }

    private static int sumNumbers(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        return sum;
    }

    private static int multiplyNumbers(int[] numbers) {
        int result = Arrays.stream(numbers).reduce(1, (a, b) -> a * b);
        return result;
    }

    private static int getResult(List<Integer> inputList) {
        ArrayList<Integer> resultList = new ArrayList<>();
        for (Integer e : inputList) {
            System.out.println("e is");
            System.out.println(e);
            int[] splittedArray = splitEachNumbers(e);
            int sumResult = sumNumbers(splittedArray);
            System.out.println("sumResult is");
            System.out.println(sumResult);
            int multiplyResult = multiplyNumbers(splittedArray);
            System.out.println("multiplyResult is");
            System.out.println(multiplyResult);
            int result = Math.max(sumResult, multiplyResult);
            resultList.add(result);
        }
        int finalResult = Collections.max(resultList);
        return finalResult;
    }
}