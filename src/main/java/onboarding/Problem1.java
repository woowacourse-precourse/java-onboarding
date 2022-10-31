package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        // 왼쪽 홀수 시작하지 않을 때, 오른쪽 연속된 숫자 아닐 때, 첫페이지 또는 마지막페이지 또는 벗어난 숫자일 때 예외 -1
        if (pobi.get(0)%2!=1
                || crong.get(0)%2!=1
                || pobi.get(1)!=pobi.get(0)+1
                || crong.get(1)!=crong.get(0)+1
                || pobi.get(0) <= 1
                || crong.get(0) <= 1
                || pobi.get(1) >= 400
                || crong.get(1) >= 400
        ){
            return -1;
        }

        int pobi_score = get_max(pobi);
        int crong_score = get_max(crong);

        if (pobi_score > crong_score){ return 1; }  // 포비가 이긴다면 1
        else if (pobi_score < crong_score){ return 2; }  // 크롱이 이긴다면 2
        else if (pobi_score == crong_score){ return 0; }  // 무승부 0
        else return -1;  // 예외 -1
    }

    public static int get_max(List<Integer> list){  // int 쪽수를 string으로 바꾸고 (최대계산) 하기
        int left_page = list.get(0);
        int right_page = list.get(1);
        left_page = calculate_max(Integer.toString(left_page));
        right_page = calculate_max(Integer.toString(right_page));
        return Math.max(left_page, right_page);
    }

    public static int calculate_max(String str) { // (최대계산) 각 문자의 합과 곱을 계산하여 최댓값을 리턴
        int sum = 0;
        int multiply = 1;
        for (int i=0; i<str.length(); i++){
            sum += Integer.parseInt(str.substring(i, i+1));
            multiply *= Integer.parseInt(str.substring(i, i+1));
        }
        return Math.max(sum, multiply);
    }

}