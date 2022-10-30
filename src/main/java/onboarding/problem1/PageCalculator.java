package onboarding.problem1;

import java.util.List;
import java.util.stream.Collectors;

public class PageCalculator {

    public List<Integer> getResult(List<List<Integer>> pageList) {
        // page를 받아 계산 결과를 리턴한다.
        return pageList.stream()
                .map(this::getMaxValue)
                .collect(Collectors.toList());
    }

    private int getMaxValue(List<Integer> pages) {
        // page를 받아 값을 계산한다.
        return pages.stream()
                .mapToInt(this::calculatePage)
                .max()
                .orElseThrow();
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
