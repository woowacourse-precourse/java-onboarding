package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {

    public static final int FIRST_PAGE_INDEX = 0;
    public static final int SECOND_PAGE_INDEX = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!(isValidatePage(pobi) && isValidatePage(crong))) {
            return -1;
        }

        int answer = 0;
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        }
        return answer;
    }

    private static boolean isValidatePage(List<Integer> pageNumList) {
        Integer leftPageNum = pageNumList.get(FIRST_PAGE_INDEX);
        Integer rightPageNum = pageNumList.get(SECOND_PAGE_INDEX);
        return (leftPageNum > 0) && (leftPageNum <= 399) &&
                (rightPageNum > 0) && (rightPageNum <= 400) &&
                (rightPageNum - leftPageNum == 1);
    }

    private static int getScore(List<Integer> pageNumList) {
        Integer firstPage = pageNumList.get(FIRST_PAGE_INDEX);
        Integer secondPage = pageNumList.get(SECOND_PAGE_INDEX);

        List<Integer> firstPageDigitList = getDigitList(firstPage);
        List<Integer> secondPageDigitList = getDigitList(secondPage);

        int sum = getPageSum(firstPageDigitList) + getPageSum(secondPageDigitList);
        int multiple = getPageMultiple(firstPageDigitList) + getPageMultiple(secondPageDigitList);
        return Math.max(sum, multiple);
    }

    private static int getPageMultiple(List<Integer> digitList) {
        return digitList.stream()
                .mapToInt(Integer::intValue)
                .reduce((a, b) -> a * b)
                .getAsInt();
    }

    private static int getPageSum(List<Integer> digitList) {
        return digitList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static List<Integer> getDigitList(Integer page) {
        List<Integer> digitList = new ArrayList<>();
        String pageStr = page.toString();
        Stream.of(pageStr.split(""))
                .mapToInt(Integer::parseInt)
                .forEach(digitList::add);
        return digitList;
    }
}