package onboarding;

import java.util.List;

class Problem1 {
    /* 기능 단위
    * 1. 예외 처리 (PageException)
    *   a. 오른쪽 페이지가 맨 앞페이지인 경우
    *   b. 왼쪽 페이지가 맨 뒷페이지인 경우
    *   c. 왼쪽 페이지의 홀수, 오른쪽 짝수 검사
    *   d. 각 페이지가 0과 400 사이를 넘는 경우
    * 2. 페이지 각 자리 숫자 더하기 (addPage)
    * 3. 페이지 각 자리 숫자 곱하기 (multiplePage)
    * 4. 2, 3에서 구한 수 중 max 값 구하기 (getMaxPage)
    * */
    private static boolean PageException(List<Integer> target) {
        return ContinuityException(target) || EndException(target);
    }
    private static boolean ContinuityException(List<Integer> target) {
        return target.get(1) - target.get(0) != 1;
    }
    private static boolean EndException(List<Integer> target) {
        return target.get(0) == null || target.get(1) <= 0 || target.get(0) >= 400 || target.get(1) == null;
    }
    private static boolean isOdd(Integer page) {
        return page % 2 == 1;
    }
    private static boolean isEven(Integer page) {
        return page%2 == 0;
    }

    private static int addPage(int page) {
        int addResult = 0;
        int digit = (int) (Math.log10(page)) + 1;
        while(digit > 0) {
            addResult += page/(Math.pow(10, digit-1));
            page %= (Math.pow(10, digit-1));
            digit --;
        }
        System.out.println("Add result:" + addResult);
        return addResult;
    }

    private static int multiplePage(int page) {
        int multipleResult = 1;
        int digit = (int) (Math.log10(page)) + 1;
        while(digit > 0) {
            multipleResult *= page/(Math.pow(10, digit-1));
            page %= (Math.pow(10, digit-1));
            digit --;
        }
        System.out.println("Multiple result:" + multipleResult);
        return multipleResult;
    }

    private static int getMaxPage(List<Integer> target) {
        int leftPage = target.get(0);
        int rightPage = target.get(1);
        int maxLeftPage = Math.max(addPage(leftPage), multiplePage(leftPage));
        int maxRightPage = Math.max(addPage(rightPage), multiplePage(rightPage));
        System.out.printf("max left: %d , max right: %d\n\n", maxLeftPage, maxRightPage);
        return Math.max(maxLeftPage, maxRightPage);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(PageException(pobi) || PageException(crong)) return -1;
        if(!isOdd(pobi.get(0)) || !isEven(pobi.get(1))) return -1;
        if(!isOdd(crong.get(0)) || !isEven(crong.get(1))) return -1;

        if(getMaxPage(pobi) > getMaxPage(crong))    return 1;
        else if (getMaxPage(pobi) < getMaxPage(crong))  return 2;
        else if (getMaxPage(pobi) == getMaxPage(crong)) return 0;
        else return -1;
    }
}