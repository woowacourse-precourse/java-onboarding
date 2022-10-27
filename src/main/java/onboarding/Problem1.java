package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MIN_VALUE;

        if(validation(pobi) || validation(crong)){
            return -1;
        }

        return 0;
    }

    public static boolean validation(List<Integer> list){
        if(list.size() != 2 || list.get(0) <= 1 || list.get(1) >= 400
            || list.get(0) % 2 != 1 || list.get(1) % 2 == 0) {
            return true;
        }

        return list.get(1) - list.get(0) % 2 != 1;
    }
}