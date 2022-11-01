package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        List<Integer> pobisum = new ArrayList<>();
        List<Integer> crongsum = new ArrayList<>();
        List<Integer> pobimultiplication = new ArrayList<>();
        List<Integer> crongmultiplication = new ArrayList<>();
        int even = 0;
        int odd = 0;

        for (int odd : pobi) {
            if (odd % 2 != 0) {
                answer.add(odd);
            }
        }
        return answer;
    }
}
