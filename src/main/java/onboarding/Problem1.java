package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1))
            return -1;

        int pobi_high_num, crong_high_num;

        int pobi_left_high_num = Problem1.sumAndMulHigh(pobi.get(0));
        int pobi_right_high_num = Problem1.sumAndMulHigh(pobi.get(1));
        int crong_left_high_num = Problem1.sumAndMulHigh(crong.get(0));
        int crong_right_high_num = Problem1.sumAndMulHigh(crong.get(1));

        if(pobi_left_high_num > pobi_right_high_num)
            pobi_high_num = pobi_left_high_num;
        else
            pobi_high_num = pobi_right_high_num;

        if(crong_left_high_num > crong_right_high_num)
            crong_high_num = crong_left_high_num;
        else
            crong_high_num = crong_right_high_num;

        if(pobi_high_num > crong_high_num)
            answer = 1;
        else if(pobi_high_num < crong_high_num)
            answer = 2;
        else
            answer = 0;

        return answer;
    }

    public static int sumAndMulHigh(int number){
        int num = number;

        int sum = 0 , mul = 1;

        while(true){
            sum = sum + (num % 10);
            mul = mul * (num % 10);
            if(!((num / 10) > 0))
                break;
            num = num / 10;
        }

        if(sum > mul)
            return sum;
        else
            return mul;
    }

}