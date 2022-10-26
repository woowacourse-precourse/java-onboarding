package onboarding;

import java.util.List;

class Problem1 {
    public int inputOfException (List<Integer> pobi,List<Integer> crong) {
        int input = 0;
        if (pobi.get(1) != pobi.get(0) + 1) input = -1;
        if (crong.get(1) != crong.get(0) + 1) input = -1;
        return input;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 p1 = new Problem1();
        int answer = Integer.MAX_VALUE;
        if (p1.inputOfException(pobi, crong) == -1) return -1;



        return answer;
    }
}