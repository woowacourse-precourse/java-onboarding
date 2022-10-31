package onboarding;

import java.util.List;

class Problem1 {
    static class BookPage {
        private int startPage;
        private int endPage;

        BookPage(int startPage, int endPage) throws Exception {
            if (!isValid(startPage, endPage)) throw new Exception("Wrong Page!");
            this.startPage = startPage;
            this.endPage = endPage;
        }
        private static boolean isValid(int startPage, int endPage) {
            //책의 시작면이나 마지막 면을 펼쳤다면
            if (!isValidPage(startPage, endPage)) return false;

            //페이지 숫자가 연속되지 않았다면
            if (!isConsecutivePages(startPage, endPage)) return false;

            //짝수 홀수가 제 자리에 있지 않았다면
            if (!isCorrectOddAndEven(startPage, endPage)) return false;

            return true;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }



    //페이지가 처음이나 마지막 면이 아닌지 체크
    private static boolean isValidPage(int startPage, int endPage) {
        return startPage >= 1 && endPage <= 400;
    }

    //페이지가 연속된 페이지인지 체크
    private static boolean isConsecutivePages(int startPage, int endPage) {
        return startPage + 1 == endPage;
    }

    //페이지의 왼쪽면이 홀수이고 오른쪽 면이 짝수인지 체크
    private static boolean isCorrectOddAndEven(int startPage, int endPage) {
        return startPage % 2 == 1 && endPage % 2 == 0;
    }

    //전부 곱한 값과 전부 더한 값 중 큰 값 판별
    private static int calculation(int page) {
        int score_multiply = 1; //전부 곱할 경우 값
        int score_plus = 0;     //전부 더할 경우 값
        while (page > 0) {
            int temp = page % 10;
            score_multiply *= temp;
            score_plus += temp;
            page /= 10;
        }

        return Math.max(score_multiply, score_plus);
    }

}