package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        return answer;
    }

    public static boolean isException(List<Integer> pobi, List<Integer> crong) {

        if(pobi.get(1) == pobi.get(0) + 1 && crong.get(1) == crong.get(0) + 1)
            return false;
        else
            return true;
    }

    public static List<Integer> breakNum(Integer page) {

        List<Integer> broken = new ArrayList<>();

        while(page > 0) {
            broken.add(page % 10);
            page /= 10;
        }

        return broken;
    }

}