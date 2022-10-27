package onboarding;

import java.util.List;

class Problem1 {
    public static int sumOfPageNumber(int page) {
        int result = 0;
        while (page != 0) {
            result += page % 10;
            page /= 10;
        }
        return result;
    }

    public static int productOfPageNumber(int page) {
        int result = 1;
        while (page != 0) {
            result *= page % 10;
            page /= 10;
        }
        return result;
    }

    public static int biggestNumber(List<Integer> pageList) {
        int biggestNumber = 0;
        for (int page : pageList) {
            int sumOfPageNumber = sumOfPageNumber(page);
            int productOfPageNumber = productOfPageNumber(page);
            int biggerNumber = Math.max(sumOfPageNumber, productOfPageNumber);

            if (biggerNumber > biggestNumber) {
                biggestNumber = biggerNumber;
            }
        }
        return biggestNumber;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}