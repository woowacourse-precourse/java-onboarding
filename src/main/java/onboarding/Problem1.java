package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Programs should be written for people to read, and only incidectally for machine to execute
 */

class Problem1 {

    private static final int MAX_PAGE = 400;
    private static final int MIN_PAGE = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(isValid(pobi) && isValid(crong)){
            int pobiMax = getMax(pobi);
            int crongMax = getMax(crong);
            switch (Integer.compare(pobiMax,crongMax)){
                case 1 :
                    return 1;
                case -1 :
                    return 2;
                case 0 :
                    return 0;
            }
        }else {
            return -1;
        }
        return answer;
    }

    /**
     * input 값에 대한 Validation
     **/

    private static boolean isValid(List<Integer> pages){
        return pages.stream().allMatch( page -> page <= MAX_PAGE) &&
                pages.stream().allMatch( page -> page >= MIN_PAGE) &&
                 pages.get(0) + 1 == pages.get(1);
    }

    /**
     * 모든 쪽들 중 최댓값 구하는 함수
     **/

    private static int getMax(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        int max =
                Math.max(getMaxCalculation(leftPage),getMaxCalculation(rightPage));
        return max;
    }

    /**
     * 단일 쪽의 최대값을 구하기 위한 계산함수
     **/

    private static int getMaxCalculation(int page){
        int addition = getSum(getNumberOfDigits(page));
        int multiplication = getMultiple(getNumberOfDigits(page));
        int max = Math.max(addition,multiplication);
        return max;
    }

    /**
     * 단일 쪽의 각 자리수별 숫자를 반환하는 함수
     **/

    private static int[] getNumberOfDigits(int page){
        int[] numberOfDigits = Stream.of(String.valueOf(page).split(""))
                .mapToInt(Integer::parseInt).toArray();
        return numberOfDigits;
    }

    /**
     * 각 자리수 별 덧셈 결과를 반환하는 함수
     **/

    private static int getSum(int[] numList){
        int sum = IntStream.of(numList).sum();
        return sum;
    }

    /**
     * 각 자리수 별 곱셈 결과를 반환하는 함수
     **/

    private static int getMultiple(int[] numList){
        int multiple = Arrays.stream(numList)
                .reduce(1, (num1, num2) -> num1 * num2);
        return multiple;
    }

}