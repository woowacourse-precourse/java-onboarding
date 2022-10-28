package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(checkPageException(pobi) || checkPageException(crong)){
            return -1;
        }
        int pobiPoint = findHighValue(pobi);
        int crongPoint = findHighValue(crong);

        return answer;
    }

    private static Boolean checkPageException(List<Integer> pages){
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        System.out.println("leftPage = " + leftPage);
        System.out.println("rightPage = " + rightPage);
        final int FIRST_PAGE = 3;
        final int LAST_PAGE = 398;

        // 페이지가 순차적인 수인지 체크
        if(leftPage + 1 != rightPage) {
            return true;
        }
        // 페이지 홀수/짝수 체크
        if(!(leftPage % 2 == 1 && rightPage % 2 == 0)){
            return true;
        }
        // 페이지 3~398 범위 체크
        if(!(leftPage >= FIRST_PAGE && leftPage < LAST_PAGE
                && rightPage > FIRST_PAGE && rightPage <= LAST_PAGE)){
            return true;
        }
        return false;
    }

    private static int findHighValue(List<Integer> pages){
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        List<Integer> leftPageValues = seperatePage(leftPage);
        List<Integer> rightPageValues = seperatePage(rightPage);

        int leftMaxValue = compareSumAndMultValue(leftPageValues);
        int rightMaxValue = compareSumAndMultValue(rightPageValues);
        return Math.max(leftMaxValue, rightMaxValue);
    }

    // 분리된 페이지의 int 값의 합과 곱 중에 더 큰 값을 리턴
    private static int compareSumAndMultValue(List<Integer> pageValues){
        return Math.max(sumPageValues(pageValues), multPageValues(pageValues));
    }

    // page를 각각의 정수로 분리
    private static List<Integer> seperatePage(int page){
        List<Integer> seperatedPage = new ArrayList<>();
        while(page > 0){
            seperatedPage.add(page % 10);
            page /= 10;
        }
        return seperatedPage;
    }

    // 분리된 page의 값 sum
    private static int sumPageValues(List<Integer> seperatedPage){
        return seperatedPage.stream().mapToInt(Integer::intValue).sum();
    }

    // 분리된 page의 값 Mult
    private static int multPageValues(List<Integer> seperatedPage){
        return seperatedPage.stream().reduce(1, (x,y) -> x*y);
    }

}