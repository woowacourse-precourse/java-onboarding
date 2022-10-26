package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Programs should be written for people to read, and only incidectally for machine to execute
 */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        try{
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

        }catch (Exception e){
            return  -1;
        }
        return answer;
    }

    /**
     * 사용자의 나올 수 있는 경우의 수 중 최댓값 구하는 함수
     **/

    private static int getMax(List<Integer> pages) throws Exception {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if(leftPage + 1 != rightPage){
            throw new Exception("예외사항 발생");
        }
        int max =
                Math.max(getMaxCalculation(leftPage),getMaxCalculation(rightPage));
        return max;
    }

    /**
     * 최대값을 구하기 위한 계산함수
     **/

    private static int getMaxCalculation(int page){
        int addition = getSum(getNumberOfDigits(page));
        int multiplication = getMultiple(getNumberOfDigits(page));
        int max = Math.max(addition,multiplication);
        return max;
    }

    /**
     * 입력된 숫자의 각 자리수별 숫자를 반환하는 함수
     **/

    private static int[] getNumberOfDigits(int page){
        int[] numberOfDigits = Stream.of(String.valueOf(page).split(""))
                .mapToInt(Integer::parseInt).toArray();
        return numberOfDigits;
    }

    /**
     * 자릿수의 덧셈 결과를 반환하는 함수
     **/

    private static int getSum(int[] numList){
        int sum = IntStream.of(numList).sum();
        return sum;
    }

    /**
     * 자릿수의 곱셈 결과를 반환하는 함수
     **/

    private static int getMultiple(int[] numList){
        int multiple = Arrays.stream(numList)
                .reduce(1, (num1, num2) -> num1 * num2);
        return multiple;
    }

}