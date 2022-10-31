package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;


        if (pobi.get(0) > 0 && pobi.get(1) < 401 && crong.get(0) > 0 && crong.get(1) < 401) {

            if (pobi.get(0) + 1 == pobi.get(1) && crong.get(0) + 1 == crong.get(1)) {
                int final_pobi = comparison(pobi);
                int final_crong = comparison(crong);
                if (final_pobi > final_crong) {
                    answer = 1;
                } else if (final_pobi < final_crong) {
                    answer = 2;
                } else {
                    answer = 0;
                }
            }else {
                answer = -1;
            }
        } else {
            answer = -1;
        }
        return answer;
    }

    public static int comparison(List<Integer> some) {
        int num1 = some.get(0);
        int num2 = some.get(1);
        int temp1 = 0;
        int temp2 = 1;
        List<Integer> tempNum1 = new ArrayList<>();
        List<Integer> tempNum2 = new ArrayList<>();

        while (num1 > 0) { //배열 만드는 곳
            tempNum1.add(num1 % 10);
            num1 /= 10;
        }

        while (num2 > 0) {
            tempNum2.add(num2 % 10);
            num2 /= 10;
        }

        for (int i = 0; i < tempNum1.toArray().length; i++) { // 값 구하는 곳
            temp1 += tempNum1.get(i);
            temp2 *= tempNum2.get(i);
        }
        return Math.max(temp1, temp2);


    }
}
