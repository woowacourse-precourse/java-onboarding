package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_left = (int)pobi.get(0);
        int pobi_right = (int)pobi.get(1);
        int crong_left = (int)crong.get(0);
        int crong_right = (int)crong.get(1);
        int pobi_result = Integer.MAX_VALUE;
        int crong_result = Integer.MAX_VALUE;

        if( pobi_left<=1 ||pobi_left>= 399 || pobi_right <=2 || pobi_right>=400){
            return -1;
        }

        if( crong_left<=1 ||crong_left>= 399 || crong_right <=2 || crong_right>=400){
            return -1;
        }

        if( pobi_left%2 !=1 || pobi_right%2 !=0 || crong_left%2 !=1 || crong_right%2 !=0){
            return -1;
        }

        if( (pobi_left+1) != pobi_right || (crong_left+1) != crong_right){
            return -1;
        }

        pobi_left = max_input(pobi_left);
        pobi_right = max_input(pobi_right);
        crong_left = max_input(crong_left);
        crong_right = max_input(crong_right);

        pobi_result = Math.max(pobi_left, pobi_right);
        crong_result = Math.max(crong_left, crong_right);


        if(pobi_result>crong_result){
            answer = 1;
        } else if(pobi_result<crong_result){
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }


    public static int max_input(int input){
        if(input/100 !=0){ // 3자리 수인 경우
            input = Math.max( (input/100) + (input%100/10) + (input%10), (input/100) * (input%100/10) * (input%10));

        } else if( input/100 ==0 && input%100/10 != 0){ // 2자리수인 경우
            input = Math.max( (input%100/10) + (input%10),   (input%100/10) * (input%10));

        }
        return input;
    }

}