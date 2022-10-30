package onboarding;

import java.util.List;

public class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
//        int answer = Integer.MAX_VALUE;

        //페이지 검증
        int p1 = pobi.get(0);
        int p2 = pobi.get(1);

        int c1 = crong.get(0);
        int c2 = crong.get(1);

        if (p1 == 0 && p2 == 400 && c1 == 0 && c2 == 400) {
            System.out.println("책을 다시 펼치세요");
        }

        if ((p1 + 1 != p2) || (c1 + 1 != c2)) {
            return -1;
        }

        return 0;
    }
}