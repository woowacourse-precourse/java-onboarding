package onboarding;

import java.util.List;

class Problem1 {

    public static int sum_multi(int a) {
        String string_a = Integer.toString(a);

        int result_sum = 0;
        int result_multi = 1;

        for (int i = 0; i < string_a.length(); i++) {
            result_sum += (string_a.charAt(i) - '0');
            result_multi *= (string_a.charAt(i) - '0');

        }
        if (result_sum > result_multi) {
            return result_sum;
        } else {
            return result_multi;
        }

    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
//        int answer = Integer.MAX_VALUE;
//        return answer;

        int pobi_left = pobi.get(0);
        int pobi_right = pobi.get(1);


        int result_pobi_left = sum_multi(pobi_left);
        int result_pobi_right = sum_multi(pobi_right);
        int result_pobi = 0;
        if (result_pobi_left > result_pobi_right) {
            result_pobi = result_pobi_left;
        } else {
            result_pobi = result_pobi_right;
        }

        int crong_left = crong.get(0);
        int crong_right = crong.get(1);

        int result_crong_left = sum_multi(crong_left);
        int result_crong_right = sum_multi(crong_right);
        int result_crong = 0;
        if (result_crong_left > result_crong_right) {
            result_crong = result_crong_left;
        } else {
            result_crong = result_crong_right;
        }

        if (pobi.size() !=2 || crong.size() !=2){
            return -1;
        }
        if (pobi_right-pobi_left !=1 || crong_right-crong_left !=1){
            return -1;
        }
        if (pobi_left ==1 || pobi_right==400 || crong_left ==1 || crong_right==400){
            return  -1;
        }



        int answer = 0;

        if (result_pobi > result_crong) {
            answer = 1;
        } else if (result_pobi < result_crong) {
            answer = 2;
        } else if (result_pobi == result_crong) {
            answer = 0;
        }

        return answer;



    }
}