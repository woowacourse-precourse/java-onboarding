package onboarding;

import java.util.List;

class Problem1 {
    static int pobi_score;  // pobi의 점수
    static int crong_score; // crong의 점수

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(exceptionCheck(pobi.get(0), pobi.get(1))) return -1;    // pobi 에서 예외상황
        if(exceptionCheck(crong.get(0), crong.get(1))) return -1;  // crong 에서 예외상황

        calcPobiScore(pobi.get(0), pobi.get(1));
        calcCrongScore(crong.get(0), crong.get(1));

        int answer = determineWinner(pobi_score, crong_score);

        return answer;
    }

    static int determineWinner(int pobi, int crong) {
        if(pobi > crong) return 1;
        if(pobi < crong) return 2;
        return 0;
    }

    // 예외 상황을 체크하는 함수 (예외 상황일 경우에 true를 리턴한다)
    static boolean exceptionCheck(int left_page, int right_page) {
        if(left_page % 2 == 0) return true;                // 왼쪽 페이지가 짝수일 경우
        if(right_page % 2 == 1) return true;               // 오른쪽 페이지가 홀수일 경우
        if(left_page >= right_page) return true;           // 왼쪽 페이지 번호가 오른쪽 페이지 번호보다 크거나 같을 경우
        if(right_page - left_page != 1) return true;       // 오른쪽 페이지 - 왼쪽 페이지의 차가 1이 아닐 경우
        if(left_page < 1 || right_page > 400) return true; // 왼쪽 페이지 번호가 1보다 작거나 오른쪽 페이지 번호가 400보다 클 경우
        return false; // 이 외의 경우는 예외사항이 아님
    }

    // pobi의 점수를 계산하는 함수
    static void calcPobiScore(int left_page, int right_page) {
        // 왼쪽 페이지
        pobi_score = Math.max(pobi_score, sum(left_page));      // 왼쪽 페이지 숫자의 합
        pobi_score = Math.max(pobi_score, multiply(left_page)); // 왼쪽 페이지 숫자의 곱

        // 오른쪽 페이지
        pobi_score = Math.max(pobi_score, sum(right_page));      // 오른쪽 페이지 숫자의 합
        pobi_score = Math.max(pobi_score, multiply(right_page)); // 오른쪽 페이지 숫자의 곱
    }

    // crong의 점수를 계산하는 함수
    static void calcCrongScore(int left_page, int right_page) {
        // 왼쪽 페이지
        crong_score = Math.max(crong_score, sum(left_page));      // 왼쪽 페이지 숫자의 합
        crong_score = Math.max(crong_score, multiply(left_page)); // 왼쪽 페이지 숫자의 곱

        // 오른쪽 페이지
        crong_score = Math.max(crong_score, sum(right_page));      // 오른쪽 페이지 숫자의 합
        crong_score = Math.max(crong_score, multiply(right_page)); // 오른쪽 페이지 숫자의 곱
    }

    static int sum(int page) {
        int sum = 0;
        String p = String.valueOf(page);
        for(int i = 0; i < p.length(); i++) {
            sum += Character.getNumericValue(p.charAt(i));
        }
        return sum;
    }

    static int multiply(int page) {
        int total = 1;
        String p = String.valueOf(page);
        for(int i = 0; i < p.length(); i++) {
            total *= Character.getNumericValue(p.charAt(i));
        }
        return total;
    }
}