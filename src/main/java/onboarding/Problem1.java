package onboarding;

import java.util.List;

class Problem1 {
    final static int exception = -1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        final int pobiWin = 1;
        final int crongWin = 2;
        final int draw = 0;


        // 예외사항 처리
        if (PageErrorCheck(pobi) == exception || PageErrorCheck(crong) == exception) {
            return exception;
        }

        // pobi와 crong이 뽑은 두 페이지 중 계산 결과의 각각의 최대값 구하기
        int pobiMaxResult = Math.max(calculation(pobi.get(0)), calculation(pobi.get(1)));
        int crongMaxResult = Math.max(calculation(crong.get(0)),calculation(crong.get(1)));

        // 포비와 크롱의 승부 결과
        if (pobiMaxResult < crongMaxResult) {
            answer = crongWin;
        } else if (pobiMaxResult == crongMaxResult) {
            answer = draw;
        } else answer = pobiWin;

        return answer;
    }

    //예외사항 처리하는 매소드
    public static int PageErrorCheck(List<Integer> pages) {
        int errorNumber = 0;

        // 포보와 크롱이 얻을 수 있는 페이지는 2개뿐
        if (pages.size() != 2) {
            errorNumber = exception;
        }

        //포비와 크롱이 책의 페이지 범위를 초과한 경우와 첫 면과 마지막 면을 펼치지 않아야함
        if (pages.get(0)<=1 || pages.get(1)>=400) {
            errorNumber = exception;
        }

        // 왼쪽 페이지 번호는 홀수이고 오른쪽 페이지 번호는 짝수여야 함
        if (pages.get(0)%2 == 0 || pages.get(1)%2 != 0) {
            errorNumber = exception;
        }

        // 두 페이지는 연속된 자연수여야 함
        if (pages.get(1)-pages.get(0) != 1) {
            errorNumber = exception;
        }

        return errorNumber;
    }

    // 왼쪽 페이지 번호와 오른쪽 페이지 번호의 각 자리의 합과 곱셈 중 최대값 구하는 메소드
    public static int calculation(int page) {
        int sum = 0;
        int multiply = 1;

        while (page != 0) {
            sum += page%10;
            multiply *= page%10;
            page /= 10;
        }

        return Math.max(sum, multiply);
    }
}