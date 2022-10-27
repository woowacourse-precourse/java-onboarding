package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    static boolean invalid(List<Integer> list){
        int left = list.get(0);
        int right = list.get(1);

        if(left+1 != right) return true;
        if(left%2 == 0) return true;
        if(out_of_bound(left) || out_of_bound(right)) return true;
        return false;
    }

    static boolean out_of_bound(int number){
        if(number >= 1 && number <= 400) return false;
        return true;
    }

}