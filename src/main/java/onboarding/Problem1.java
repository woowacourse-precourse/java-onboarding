package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    static int left = 0, right = 1;
    static boolean isAvail(List<Integer> player) {
        int leftPage = player.get(0);
        int rightPage = player.get(1);
        return leftPage > 1 && rightPage < 400 && (rightPage - leftPage == 1);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}