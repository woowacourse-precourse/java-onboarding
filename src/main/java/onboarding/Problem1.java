package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        System.out.println();
        return answer;
    }

    public static List<Integer> splitNum(int num) {
        int myNum = num;
        List<Integer> result = new ArrayList<>();
        while (myNum > 0) {
            result.add(myNum % 10);
            myNum /= 10;
        }

        return result;
    }


}