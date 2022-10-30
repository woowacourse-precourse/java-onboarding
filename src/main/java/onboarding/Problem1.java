package onboarding;

import java.util.List;

class Problem1 {
    public static int pagePlus(int page) {
        int total = 0;
        while (page > 1) {
            total += page%10;
            page /= 10;
        }
        return total;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int[] pobiArray = pobi.stream().mapToInt(i->i).toArray();
        int[] crongArray = crong.stream().mapToInt(i->i).toArray();
        return answer;
    }
}