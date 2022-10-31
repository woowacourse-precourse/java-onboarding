package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        if (pobi.get(0)%2!=1
                || crong.get(0)%2!=1
                || pobi.get(1)!=pobi.get(0)+1
                || crong.get(1)!=crong.get(0)+1
                || pobi.get(0) <= 1
                || crong.get(0) <= 1
                || pobi.get(1) >= 400
                || crong.get(1) >= 400
        ){
            answer = -1;
        }

        int pobi_score = get_max(pobi);
        int crong_score = get_max(crong);

        if (pobi_score > crong_score){ answer = 1; }
        else if (pobi_score < crong_score){ answer = 2; }
        else if (pobi_score == crong_score){ answer = 0; }
        else answer = -1;  // 예외 -1

        return answer;
    }

    public static int get_max(List<Integer> list){
        int left_page = list.get(0);
        int right_page = list.get(1);
        left_page = calculate_max(Integer.toString(left_page));
        right_page = calculate_max(Integer.toString(right_page));
        return Math.max(left_page, right_page);
    }

    public static int calculate_max(String str) {
        int sum = 0;
        int multiply = 1;
        for (int i=0; i<str.length(); i++){
            sum += Integer.parseInt(str.substring(i, i+1));
            multiply *= Integer.parseInt(str.substring(i, i+1));
        }
        return Math.max(sum, multiply);
    }

}