package onboarding;

import java.util.List;
import java.util.stream.Stream;

/*
 *  🚀 기능 명세
    PagePair 객체 (값의 유효성 검증)
        1. 페이지 값의 유효성 검증 (validatePage)
        * 페이지가 범위 내의 값인지, 왼쪽 / 우측 페이지에 알맞은 값(홀수, 짝수)을 가지는지 검사

        2. 페이지 쌍의 유효성 검증 (validatePages)
        * 왼쪽 / 오른쪽 페이지가 연속된 값을 가지는지 검사

        3. 현재 페이지 쌍에서 만들 수 있는 가장 큰 연산값 반환(getMaxValue)
 */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        try {
            //PagePair 객체 생성 -> 유효성 검증
            PagePair pairOfPobi = new PagePair(pobi);
            PagePair pairOfCrong = new PagePair(crong);

            int maxValueOfPobi = pairOfPobi.getMaxValue();
            int maxValueOfCrong = pairOfCrong.getMaxValue();

            if(maxValueOfPobi > maxValueOfCrong) {
                answer = 1;
            }
            else if(maxValueOfPobi < maxValueOfCrong) {
                answer = 2;
            }

        } catch (IllegalStateException exception) {
            answer = -1;
        }
        return answer;
    }
}

class PagePair {
    List<Integer> pagePair;
    static final int IS_LEFT = 1;
    static final int IS_RIGHT = 0;

    public PagePair(List<Integer> pagePair) throws IllegalStateException{
        validatePage(pagePair.get(0), IS_LEFT);
        validatePage(pagePair.get(1), IS_RIGHT);
        validatePagePair(pagePair);
        this.pagePair = pagePair;
    }
    public void validatePage(int page, int isRightPage) {
        if (page <= 0 || page > 400)
            throw new IllegalStateException("페이지는 1 ~ 400 사이의 값을 가져야 합니다.");

        if (isRightPage != (page % 2))
            throw new IllegalStateException("왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수를 가져야 합니다.");
    }
    public void validatePagePair(List<Integer> pagePair) {
        if (pagePair.get(0) + 1 != pagePair.get(1))
            throw new IllegalStateException("펼친 페이지는 연속된 값을 가져야 합니다");
    }

    public int getMaxValue(){
        int maxValue = 0;

        for(Integer page : pagePair){
            int[] digits = Stream.of(String.valueOf(page).split("")).mapToInt(Integer::parseInt).toArray();

            int sumOfEachPosition = 0, productOfEachPosition = 1;

            for(int digit : digits){
                sumOfEachPosition += digit;
                productOfEachPosition *= digit;
            }
            maxValue = Math.max(maxValue, Math.max(sumOfEachPosition, productOfEachPosition));
        }
        return maxValue;
    }
}
