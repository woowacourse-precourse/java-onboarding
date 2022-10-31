package onboarding;

import java.util.List;

/* 해당 클래스에서 다른 세부 오류는 private 로 제한하고
 * isException 만 열어야할까?
 */
public class Problem1Exception {

    public static boolean isException(List<Integer> pages) {
        if (isEndOfSide(pages)) {
            return true;
        }
        if (isOutOfRange(pages)) {
            return true;
        }
        if (isSeparatedPages(pages)) {
            return true;
        }
        return false;
    }

    /**
     * 시작면에 있는 지 판별하는 함수
     */
    public static boolean isEndOfSide(List<Integer> pages) {
        for (Integer page : pages) {
            if (page == 1) { //시작면이 있으면
                return true;
            }
            if (page == 400) { //마지막면이 있으면
                return true;
            }
        }
        return false;
    }

    /**
    * 페이지가 책의 범위 내에 있는지 확인하는 함수
    * 위의 함수랑 합칠 수 있는데 합쳐야 할까?
    */
    public static boolean isOutOfRange(List<Integer> pages) {
        for (Integer page : pages) {
            if (page < 1) {
                return true;
            }
            if (page > 400) {
                return true;
            }
        }
        return false;
    }

    /**
     * 페이지가 이어져있는지 확인하는 함수
     */
    public static boolean isSeparatedPages(List<Integer> pages) {
        int leftPageNumber = pages.get(0);
        int rightPageNumber = pages.get(1);

        int difference = Math.abs(leftPageNumber - rightPageNumber);

        if (difference == 1) { //바로 옆인 경우만
            return false;
        }
        return true;
    }
}
