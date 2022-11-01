package onboarding;

import java.util.List;
class Problem1 {


    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        int pobi_Max=0;
        int crong_Max=0;

        if ((pobi.get(0) + 1 != pobi.get(1)) || (crong.get(0) + 1 != crong.get(1))) {
            answer= -1;
            return answer;
        }
        else if (pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0 || pobi.get(1) % 2 == 1 || crong.get(1) % 2 == 1) {
            answer= -1;
            return answer;
        }





        return answer;
    }


}