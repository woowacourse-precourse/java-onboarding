package onboarding;

import java.util.List;

class Problem1 {
    static int pobi_score = Integer.MIN_VALUE;  // pobi의 점수
    static int crong_score = Integer.MIN_VALUE; // crong의 점수

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int left_pobi = pobi.get(0);    // pobi의 왼쪽 페이지
        int right_pobi = pobi.get(1);   // pobi의 오른쪽 페이지

        int left_crong = crong.get(0);  // crong의 왼쪽 페이지
        int right_crong = crong.get(1); // crong의 오른쪽 페이지

        if(exceptionCheck(left_pobi, right_pobi)) return -1;    // pobi에서 예외상황
        if(exceptionCheck(left_crong, right_crong)) return -1;  // crong에서 예외상황

        calcPobiScore(left_pobi, right_pobi);
        calcCrongScore(left_crong, right_crong);

        if(pobi_score > crong_score) answer = 1;
        if(pobi_score < crong_score) answer = 2;
        if(pobi_score == crong_score) answer = 0;

        return answer;
    }

    static boolean exceptionCheck(int left_page, int right_page) {
        if(left_page % 2 == 0) return true;          // 왼쪽 페이지가 홀수가 아닐 경우
        if(right_page % 2 != 0) return true;         // 오른쪽 페이지가 짝수가 아닐 경우
        if(right_page - left_page != 1) return true; // 오른쪽 페이지 - 왼쪽 페이지의 차가 1이 아닐 경우
        return false; // 이 외의 경우는 예외사항이 아님
    }

    static void calcPobiScore(int left_pobi, int right_pobi) {
        // 왼쪽 페이지
        pobi_score = Math.max(pobi_score, sum(left_pobi));      // 왼쪽 페이지 숫자의 합
        pobi_score = Math.max(pobi_score, multiply(left_pobi)); // 왼쪽 페이지 숫자의 곱

        // 오른쪽 페이지
        pobi_score = Math.max(pobi_score, sum(right_pobi));      // 오른쪽 페이지 숫자의 합
        pobi_score = Math.max(pobi_score, multiply(right_pobi)); // 오른쪽 페이지 숫자의 곱
    }

    static void calcCrongScore(int left_crong, int right_crong) {
        // 왼쪽 페이지
        crong_score = Math.max(crong_score, sum(left_crong));      // 왼쪽 페이지 숫자의 합
        crong_score = Math.max(crong_score, multiply(left_crong)); // 왼쪽 페이지 숫자의 곱

        // 오른쪽 페이지
        crong_score = Math.max(crong_score, sum(right_crong));      // 오른쪽 페이지 숫자의 합
        crong_score = Math.max(crong_score, multiply(right_crong)); // 오른쪽 페이지 숫자의 곱
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