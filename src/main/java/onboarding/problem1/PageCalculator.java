package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class PageCalculator {

    public List<Integer> getResult(List<List<Integer>> pageList) {
        // page를 받아 계산 결과를 리턴한다.
        List<Integer> result = new ArrayList<>();
        pageList.forEach(pages -> result.add(getMaxValue(pages)));

        return result;
    }

    private int getMaxValue(List<Integer> pages) {
        // page를 받아 값을 계산한다.
        int max = Integer.MIN_VALUE;

        for (Integer page : pages) {
            // page의 자리수 별로 계산을 수행하여 max값을 산출한다.
            // 그 중에서도 골라서 max값에 저장.
            max = Math.max(max, calculatePage(page));
        }

        return max;
    }

    private int calculatePage(Integer page) {
        char[] pageNums = String.valueOf(page).toCharArray();

        // 자릿수 별로 계산 수행
        int sum = 0;
        int multiplication = 1;
        for (char pageNum : pageNums) {
            sum += pageNum - '0';
            multiplication *= (pageNum - '0');
        }

        return Math.max(sum, multiplication);  // 덧셈, 곱셈 중 최대값 반환.
    }
}
