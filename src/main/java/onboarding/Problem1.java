package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = -1;
        //compute two numbers gap
        int p_gap = pobi.get(1) - pobi.get(0);
        int c_gap = crong.get(1) - crong.get(0);

        //check Exceptions
        //two numbers gap is not 1
        //pobi and crong does not open start page and end page
        //pobi and crong does not start (null)
        if(p_gap != 1 || c_gap != 1){
            return answer;
        }
        else if(pobi.get(0) == 1 || pobi.get(0) == 399){
            return answer;
        }
        else if(crong.get(0) == 1 || crong.get(0) == 399){
            return answer;
        }
        else if(pobi.get(0) == null || pobi.get(1) == null || crong.get(0) == null || crong.get(1) == null){
            return answer;
        }
        //compute numbers
        int p_max = computeMax(pobi);
        int c_max = computeMax(crong);
        //compare pobi max with crong max
        if(p_max > c_max){
            answer = 1;
        }
        else if(c_max > p_max){
            answer = 2;
        }
        else{
            answer = 0;
        }

        return answer;
    }

    static int computeMax(List<Integer> test){
        //make max, plus number, multiple number
        int plus = 0;
        int multi = 1;
        int max = 0;
        int num;

        //compute max
        for(int i = 0; i < 2; i++){
            num = test.get(i);
            while(num > 0){
                plus += num % 10; //plus
                multi *= num % 10; //multi
                num /= 10;
            }
            if(plus >= multi && plus > max){
                max = plus;
            }
            else if(multi > plus && multi > max){
                max = multi;
            }
            plus = 0; //reset
            multi = 1; //reset
        }
        return max;
    }
}