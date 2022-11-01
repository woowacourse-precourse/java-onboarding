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

    public static int winnerOfGame(List<Integer> firstPageList, List<Integer> secondPageList) {
        int maxOfFirstPageList = biggestNumber(firstPageList);
        int maxOfSecondPageList = biggestNumber(secondPageList);

        int result = Math.max(maxOfFirstPageList, maxOfSecondPageList);

        if (maxOfFirstPageList == maxOfSecondPageList) {
            return 0;
        } else if (result == maxOfFirstPageList) {
            return 1;
        } else {
            return 2;
        }

    }

    public static boolean validatePageNumberInRange(List<Integer> pageList) {
        for (int page : pageList) {
            if (page < 1 || page > 400) {
                return false;
            }
        }
        return true;
    }

    public static boolean validatePageNumberSequence(List<Integer> pageList) {
        for (int i = 0; i < pageList.size() - 1; i++) {
            if (pageList.get(i + 1) != pageList.get(i) + 1) {
                return false;
            }
        }
        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!validatePageNumberInRange(pobi) || !validatePageNumberInRange(crong)) {
            return -1;
        }
        if (!validatePageNumberSequence(pobi) || !validatePageNumberSequence(crong)) {
            return -1;
        }

        answer = winnerOfGame(pobi, crong);
        return answer;
    }
}