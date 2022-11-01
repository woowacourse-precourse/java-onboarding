package onboarding;

import java.util.*;
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        int l_add, l_mul, r_add, r_mul, p_result, c_result;


            l_add = (pobi.get(0) / 100) + ((pobi.get(0) % 100) / 10) + (pobi.get(0) % 10);
            if (pobi.get(0)/100!=0) { // 두자리 수, 한자리 수의 경우에 곱값이 0이 되버릴 경우를 고려
                l_mul = (pobi.get(0) / 100) * ((pobi.get(0) % 100) / 10) * (pobi.get(0) % 10);
            } else if ((pobi.get(0)%100)/10!=0) {
                l_mul = ((pobi.get(0) % 100) / 10) * (pobi.get(0) % 10);
            } else {
                l_mul = pobi.get(0)%10;
            }
            r_add = (pobi.get(1) / 100) + ((pobi.get(1) % 100) / 10) + (pobi.get(1) % 10);
            if (pobi.get(1)/100!=0) {
                r_mul = (pobi.get(1) / 100) * ((pobi.get(1) % 100) / 10) * (pobi.get(1) % 10);
            } else if ((pobi.get(1)%100)/10!=0) {
                r_mul = ((pobi.get(1) % 100) / 10) * (pobi.get(1) % 10);
            } else {
                r_mul = pobi.get(1)%10;
            }

            p_result = Math.max(Math.max(l_add, l_mul), Math.max(r_add, r_mul)); // 가장 높은 값을 pobi의 대표값으로


            l_add = (crong.get(0) / 100) + ((crong.get(0) % 100) / 10) + (crong.get(0) % 10);
            if (crong.get(0)/100!=0) {
                l_mul = (crong.get(0) / 100) * ((crong.get(0) % 100) / 10) * (crong.get(0) % 10);
            } else if ((crong.get(0)%100)/10!=0) {
                l_mul = ((crong.get(0) % 100) / 10) * (crong.get(0) % 10);
            } else {
                l_mul = crong.get(0)%10;
            }
            r_add = (crong.get(1) / 100) + ((crong.get(1) % 100) / 10) + (crong.get(1) % 10);
            if (crong.get(1)/100!=0) {
                r_mul = (crong.get(1) / 100) * ((crong.get(1) % 100) / 10) * (crong.get(1) % 10);
            } else if ((crong.get(1)%100)/10!=0) {
                r_mul = ((crong.get(1) % 100) / 10) * (crong.get(1) % 10);
            } else {
                r_mul = crong.get(1)%10;
            }


            c_result = Math.max(Math.max(l_add, l_mul), Math.max(r_add, r_mul));



            if (p_result > c_result) {
                answer = 1;
            } else if (p_result < c_result) {
                answer = 2;
            } else if (p_result == c_result) {
                answer = 0;
            } else {
                answer = -1;
            }

            if (pobi.get(0)>pobi.get(1) || crong.get(0)>crong.get(1) || pobi.get(1)!=pobi.get(0)+1 || crong.get(1)!=crong.get(0)+1) {
                answer = -1;
            } // 좌측페이지 값이 우측페이지 값보다 높거나 서로가 연속적인 값이 되지 않을 때


            return answer;
        }




}