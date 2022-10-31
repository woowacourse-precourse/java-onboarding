package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(exception(pobi) || exception(crong)) return -1;

        return answer;
    }

    static boolean exception(List<Integer> list) {
        boolean answer = false;

        if(list.get(0) < 1 || list.get(1) > 400) answer = true;
        if(list.get(1) - list.get(0) != 1) answer = true;
        if(list.get(0) % 2 == 0) answer = true;
        if(list.size() != 2) answer = true;

        return answer;
    }
}