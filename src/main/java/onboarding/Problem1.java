package onboarding;

import java.util.ArrayList;
import java.util.List;

/** 구현 기능 목록
 * 1. 페이지 숫자 자릿수 별로 분리하여 리스트로 반환
 * 2. 분리된 숫자의 합 반환
 * 3. 분리된 숫자의 곱 반환
 * 4. 둘 중 더 큰 숫자 반환
 * 5. 이긴 사람 정하기
 * 6. 예외 처리
 * */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static List<Integer> getPageNumbers(int page) {
        List<Integer> pageNumbers = new ArrayList<>();
        while (page > 0) {
            pageNumbers.add(page % 10);
            page /= 10;
        }
        return pageNumbers;
    }

    private static int getSum(List<Integer> pageNumbers) {
        int sum = 0;
        for(int i = 0; i < pageNumbers.size(); i++)
            sum += pageNumbers.get(i);
        return sum;
    }

    private static int getMultiply(List<Integer> pageNumbers) {
        int multiply = 1;
        for(int i = 0; i < pageNumbers.size(); i++)
            multiply *= pageNumbers.get(i);
        return multiply;
    }

    private static int getBiggerNumber(int number1, int number2) {
        if (number1 > number2)
            return number1;
        return number2;
    }
}