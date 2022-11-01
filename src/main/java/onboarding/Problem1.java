package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);

        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        // 예외사항 1: 왼쪽 오른쪽 페이지가 차이가 1이 아닐 경우
        // 예외사항 2: 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수가 아닐 경우
        // 예외사항 3: 첫번째 페이지나, 마지막 페이지가 나올 경우

        if (pobiLeftPage % 2 != 1 || pobiRightPage - pobiLeftPage != 1 || crongLeftPage % 2 != 1 || crongRightPage - crongLeftPage != 1) { // 예외사항 1, 2
            answer = -1;
        } else if(pobiLeftPage == 1 || pobiRightPage == 400 || crongLeftPage == 1 || crongRightPage == 400) { // 예외사항 2
            answer = -1;
        } else { // 예외사항이 없을 경우

        }
        return answer;
    }

    public static int getPageSum(int page){ // 페이지의 각 자리 숫자들의 합을 구하는 함수
        int pageSum = 0; // 페이지의 각 자리 숫자들의 합
        while (page > 0) {
            pageSum += page % 10;
            page /= 10;
        }
        return pageSum;
    }
}