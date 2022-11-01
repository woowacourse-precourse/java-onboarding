package onboarding;

import java.util.List;
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int valueOfPobi = 0;
        int valueOfCrong = 0;

        if(!validation(pobi) || !validation(crong))
            return -1;
        valueOfPobi = pageMax(pobi);
        valueOfCrong = pageMax(crong);
        answer = makeGameResult(valueOfPobi, valueOfCrong);

        return answer;
    }
    private static boolean validation(List<Integer> pages) {
        for (Integer page : pages) {
            if (page > 400 || 0 > page)
                return false;
        }
        if (pages.get(0) + 1 != pages.get(1)) {
            return false;
        }
        if (pages.get(0) % 2 == 0 && pages.get(1) % 2 == 1) {
            return false;
        }
        return true;
    }
    private static int pageMax(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        return compareTo(splitEachNumbers(leftPage), splitEachNumbers(rightPage));
    }

    private static int splitEachNumbers(int pageValue) {
        int sumOfPlusPages = 0;
        int sumOfMulPages = 1;

        while (pageValue != 0) {
            sumOfPlusPages += pageValue % 10;
            sumOfMulPages *= pageValue % 10;
            pageValue /= 10;
        }
        return compareTo(sumOfPlusPages, sumOfMulPages);
    }
    private static int compareTo(int left, int right) {
        return (left >= right) ? left : right;
    }

    private static int makeGameResult(int pobi, int crong) {
        int max = 0;

        max = compareTo(pobi, crong);
        if (pobi == crong)
            return 0;
        if (max == pobi)
            return 1;
        return 2;
    }
}
