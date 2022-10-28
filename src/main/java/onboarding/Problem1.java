package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(listException(pobi) || listException(crong)){
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean listException(List<Integer> list){
        return list.size() != 2;
    }
}