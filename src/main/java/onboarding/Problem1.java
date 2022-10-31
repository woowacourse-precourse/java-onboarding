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
        computeNumber(pobi,crong);

        return answer;
    }

    static void computeNumber(List<Integer> pobi, List<Integer> crong){
        //make max, plus number, multiple number
        int p_plus = 0;
        int p_multi = 0;
        int c_plus = 0;
        int c_multi = 0;
        int p_max = 0;
        int c_max = 0;

        
    }
}