package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public int findUserScore(List<Integer> pages) {
        int leftPageNumber = pages.get(0);
        int rightPageNumber = pages.get(1);
        int leftPageScore = Math.max(sumAllNumbersInPage(leftPageNumber), multiplyAllNumbersInPage(leftPageNumber));
        int rightPageScore = Math.max(sumAllNumbersInPage(rightPageNumber), multiplyAllNumbersInPage(rightPageNumber));

        return Math.max(leftPageScore, rightPageScore);
    }

    public int sumAllNumbersInPage(int page) {

        return 0;
    }

    public int multiplyAllNumbersInPage(int page) {
        int result = 1;
        for (Integer number : changeIntToIntList(page)) {
            result = result * number;
        }

        return result;
    }

    public List<Integer> changeIntToIntList(int number) {

        return new ArrayList<>();
    }

}

/*
 * 구현사항
 * 1. 책음 "임의로" 펼친다.
 * 2. "왼쪽 페이지"의 번호의 각 짜리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 3. "오른쪽 페이지"의 번호의 각 짜리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 4. 2~3에서 정한 수 중에 더 큰수를 본인의 점수로 한다.
 * 5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
 * 6. 시작면이나 마지막 면이 나오도록 책을 펼치지 않는다.
 * 포비가 이기면 1, 크롱이 이기면 2, 무승부 0, 예외사항 -1
 */

/* 예외사항
 * 주어진 페이지가 왼쪽 오른쪽이 아닌 경우 -> 차이가 1이 아님
 * 주어진 페이지 중에서 시작과 끝이 있는 경우 -> 1,400이 포함되어 있나?
 * 페이지가 주어진 범위를 넘어선다. 1~400
 */

/* 필요한 함수
 * 1. 번호의 각 숫자를 모두 더하는 함수
 * 2. 번호의 각 숫자를 모두 곱하는 함수
 * 3. 각 사람의 더 큰 숫자를 반환해주는 함수
 * 4. 이긴 사람을 골라주는 함수
 */