package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        /*
         * 1. 우선, 페이지 번호의 유효성을 검증한다.
         * 2. 페이지 번호의 각 자리의 숫자를 모두 더하거나 모두 곱해 가장 큰 수를 계산한다.
         * 3. 2번에서 구한 값을 바탕으로 결과를 구한다.
         * */
        int answer = Integer.MAX_VALUE;
        int pobiScore; // 포비 점수
        int crongScore; // 크롱 점수

        // 1. 페이지 유효성 검증
        if (isValidPage(pobi) == false || isValidPage(crong) == false) {
            return -1;
        }

        // 2. 가장 큰 수 계산
        pobiScore = getMaxScore(pobi);
        crongScore = getMaxScore(crong);

        // 3. 결과 계산
        answer = getResult(pobiScore, crongScore);

        return answer;
    }

    public static boolean isValidPage(List<Integer> bookPages) {
        int leftPage = bookPages.get(0); // 왼쪽 페이지
        int rightPage = bookPages.get(1); // 오른쪽 페이지

        // 각 페이지의 번호가 [1,400]을 벗어나는 경우
        if (leftPage < 1 || leftPage > 400 || rightPage < 1 || rightPage > 400) {
            return false;
        }

        // 왼쪽 페이지가 홀수 번호가 아니거나 오른쪽 페이지가 짝수 번호가 아닌 경우
        if (leftPage % 2 != 1 || rightPage % 2 != 0) {
            return false;
        }

        // 연속된 페이지가 아닌 경우
        if (rightPage - leftPage != 1) {
            return false;
        }

        return true;
    }

    public static int getMaxScore(List<Integer> bookPages) {
        int maxScore = 0; // 반환하는 가장 큰 수

        for (Integer bookPage : bookPages) {
            int pageSum = 0; // 페이지 번호 각 자리의 합
            int pageProduct = 1; // 페이지 번호 각 자리의 곱

            String strNum = Integer.toString(bookPage);
            for (int j = 0; j < strNum.length(); j++) {
                pageSum += strNum.charAt(j) - '0';
                pageProduct *= strNum.charAt(j) - '0';
            }

            if (maxScore < Math.max(pageSum, pageProduct)) {
                maxScore = Math.max(pageSum, pageProduct);
            }
        }

        return maxScore;
    }

    public static int getResult(int pScore, int cScore) {
        if (pScore > cScore) {
            return 1; // 포비가 이긴다면
        } else if (pScore < cScore) {
            return 2; // 크롱이 이긴다면
        } else {
            return 0; // 무승부
        }
    }
}
