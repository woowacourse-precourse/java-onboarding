package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.max;

public class Page {

    int leftPage, rightPage;

    public Page(List<Integer> pages) {

        if (pages.size() != 2) {
            throw new IllegalArgumentException("페이지의 개수는 2개여야 합니다.");
        }

        this.leftPage = pages.get(0);
        this.rightPage = pages.get(1);

        validatePage();
    }

    // 인자로 넘어온 두 페이지 값의 유효성을 검증하는 메서드
    public void validatePage() {

        // 1. 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호
        if (!oddNumber(leftPage)) {
            throw new IllegalArgumentException("왼쪽 페이지가 홀수가 아닙니다.");
        }

        if (!evenNumber((rightPage))) {
            throw new IllegalArgumentException("오른쪽 페이지가 짝수가 아닙니다.");
        }

        // 2. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
        if (leftPage <= 1 || leftPage >= 400 || rightPage <= 1 || rightPage >= 400) {
            throw new IllegalArgumentException("페이지가 게임에 유효한 범위를 벗어났습니다.");
        }

        // 3. 두 페이지는 연속된 값이어야 한다.
        if (rightPage - leftPage != 1){
            throw new IllegalArgumentException();
        }

    }

    public static boolean oddNumber(int pageNum) {
        if (pageNum % 2 != 0) return true;
        else return false;
    }

    public static boolean evenNumber(int pageNum) {
        if (pageNum % 2 == 0) return true;
        else return false;
    }

    // 해당 페이지 값의 자릿수를 더하는 메서드
    public static int addPageNum(int pageNum){
        return getEachPageDigits(pageNum)
                .stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

    // 해당 페이지 값의 자릿수를 곱하는 메서드
    public static int multiplyPageNum(int pageNum){
        int result = 1;
        for (int num : getEachPageDigits(pageNum)){
            result *= num;
        }
        return result;
    }

    public static List<Integer> getEachPageDigits(int pageNum){
        ArrayList<Integer> arrNumList = new ArrayList<>();
        while(pageNum > 0) {
            arrNumList.add(pageNum %10);
            pageNum /= 10;
        }
        return arrNumList;
    }

    // 더한 값과 곱한 값 중에 최댓값인 최종 점수를 반환하는 메서드
    public int getScore() {

        ArrayList<Integer> PossibleScoreList = new ArrayList<>();
        PossibleScoreList.add(addPageNum(leftPage));
        PossibleScoreList.add(addPageNum(rightPage));
        PossibleScoreList.add(multiplyPageNum(leftPage));
        PossibleScoreList.add(multiplyPageNum(rightPage));

        return max(PossibleScoreList);
    }

}
