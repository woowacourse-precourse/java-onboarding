package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int[] pobiArray = pobi.stream().mapToInt(i->i).toArray();
        int[] crongArray = crong.stream().mapToInt(i->i).toArray();
        return answer;
    }
}