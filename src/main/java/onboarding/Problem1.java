package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = getResult(pobi, crong);
        return answer;
    }

    private static boolean isValidPageNumbers(List<Integer> pageNumbers) {
        if (pageNumbers.size() != 2){
            return false;
        }
        if ((1 > pageNumbers.get(0) || pageNumbers.get(0) > 400)
                && (1 > pageNumbers.get(1) || pageNumbers.get(1) > 400)){
            return false;
        }
        if (pageNumbers.get(0)%2 != 1){
            return false;
        }
        if (pageNumbers.get(0)+1 != pageNumbers.get(1)){
            return false;
        }
        return true;
    }

    private static int getSumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number%10;
            number /= 10;
        }
        return sum;
    }

    private static int getProductOfDigits(int number) {
        int product = 1;
        while (number > 0) {
            product *= number%10;
            number /= 10;
        }
        return product;
    }

    private static int getMaxPoint(List<Integer> numbers) {
        int maxPoint = Integer.MIN_VALUE;
        for (int number: numbers) {
            List<Integer> points = Arrays.asList(maxPoint, getSumOfDigits(number), getProductOfDigits(number));
            maxPoint = Collections.max(points);
        }
        return maxPoint;
    }

    private static int getResult(List<Integer> participants1, List<Integer> participants2) {
        int result = -1;
        if (isValidPageNumbers(participants1)&&isValidPageNumbers(participants2)) {
            int participants1MaxPoint = getMaxPoint(participants1);
            int participants2MaxPoint = getMaxPoint(participants2);
            result = (participants1MaxPoint == participants2MaxPoint) ?
                    0: (participants1MaxPoint > participants2MaxPoint) ? 1:2;
        }
        return result;
    }

}