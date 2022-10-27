package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int getLeftPage(List<Integer> pages) {
        int leftPage = pages.get(0);
        return leftPage;
    }

    private static int getRightPage(List<Integer> pages) {
        int rightPage = pages.get(1);
        return rightPage;
    }

    private static List<Integer> getSplitNums(int page) {
        List<Integer> splitNums = new ArrayList<>();
        
        while (page > 0) {
            int splitNum = page % 10;
            splitNums.add(splitNum);

            page = page / 10;
        }

        return splitNums;
    }

    private static int getNumsSum(List<Integer> splitNums) {
        int sum = splitNums.stream()
                .reduce(0, Integer::sum);

        return sum;
    }

    private static int getNumsMultiplication(List<Integer> splitNums) {
        int multiplication = splitNums.stream()
                .reduce(1, (a, b) -> a * b);

        return multiplication;
    }


    private static int getPageScore(int page) {
        List<Integer> splitNums = getSplitNums(page);

        int sum = getNumsSum(splitNums);
        int multiplication = getNumsMultiplication(splitNums);
        int pageScore = Math.max(sum, multiplication);

        return pageScore;
    }

}
