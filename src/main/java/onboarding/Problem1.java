package onboarding;

import java.util.ArrayList;
import java.util.List;

/** 구현 기능 목록
 * 1. 페이지 숫자 자릿수 별로 분리하여 리스트로 반환
 * 2. 분리된 숫자의 합 반환
 * 3. 분리된 숫자의 곱 반환
 * 4. 가장 큰 수 반환
 * 5. 이긴 사람 정하기
 * 6. 예외 처리
 * */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (getMaxNumber(pobi) > getMaxNumber(crong))
            answer = 1;
        if (getMaxNumber(pobi) < getMaxNumber(crong))
            answer = 2;
        if (getMaxNumber(pobi) == getMaxNumber(crong))
            answer = 0;
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

    private static int getMaxNumber(List<Integer> pages) {
        int max = 0;
        for(Integer page : pages) {
            List<Integer> pageNumbers = getPageNumbers(page);
            max = Math.max(Math.max(getSum(pageNumbers), getMultiply(pageNumbers)), max);
        }
        return max;
    }
}