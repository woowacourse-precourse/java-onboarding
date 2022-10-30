package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(pobi.size()!=2 || crong.size()!=2){
            return -1;
        }

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


        if(pobi_left/100 !=0){ // 3자리 수인 경우
            pobi_left = Math.max( (pobi_left/100) + (pobi_left%100/10) + (pobi_left%10), (pobi_left/100) * (pobi_left%100/10) * (pobi_left%10));

        } else if( pobi_left/100 ==0 && pobi_left%100/10 != 0){ // 2자리수인 경우
            pobi_left = Math.max( (pobi_left%100/10) + (pobi_left%10),   (pobi_left%100/10) * (pobi_left%10));

        }


        if(pobi_right/100 !=0){ // 3자리 수인 경우
            pobi_right = Math.max( (pobi_right/100) + (pobi_right%100/10) + (pobi_right%10), (pobi_right/100) * (pobi_right%100/10) * (pobi_right%10));

        } else if( pobi_right/100 ==0 && pobi_right%100/10 != 0){ // 2자리수인 경우
            pobi_right = Math.max( (pobi_right%100/10) + (pobi_right%10),   (pobi_right%100/10) * (pobi_right%10));

        }


        if(crong_left/100 !=0){ // 3자리 수인 경우
            crong_left = Math.max( (crong_left/100) + (crong_left%100/10) + (crong_left%10), (crong_left/100) * (crong_left%100/10) * (crong_left%10));

        } else if( crong_left/100 ==0 && crong_left%100/10 != 0){ // 2자리수인 경우
            crong_left = Math.max( (crong_left%100/10) + (crong_left%10),   (crong_left%100/10) * (crong_left%10));

        }


        if(crong_right/100 !=0){ // 3자리 수인 경우
            crong_right = Math.max( (crong_right/100) + (crong_right%100/10) + (crong_right%10), (crong_right/100) * (crong_right%100/10) * (crong_right%10));

        } else if( crong_right/100 ==0 && crong_right%100/10 != 0){ // 2자리수인 경우
            crong_right = Math.max( (crong_right%100/10) + (crong_right%10),   (crong_right%100/10) * (crong_right%10));

        }


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

    /*public static void main(String[] args){
        List<Integer> pobi = List.of(98, 99);
        List<Integer> crong = List.of(1, 2);

        System.out.println(solution(pobi, crong));
    }*/
}