package onboarding;

import java.util.List;

class Problem1 {
    public static int pageNumCheck(List<Integer> list) {
        if(list.get(1)!=list.get(0)+1) {
            return -1;
        }
        if(list.get(0)%2==0 || list.get(1)%2==1) {
            return -1;
        }
        if(list.get(0)<=1 || list.get(1)>=400) {
            return -1;
        }
        return 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}