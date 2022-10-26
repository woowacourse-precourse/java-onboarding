package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        List<Integer> p = new ArrayList<>(pobi);
        List<Integer> c = new ArrayList<>(crong);

        // 첫페이지나 마지막 페이지가 아닐 경우
        // 페이지가 순서대로가 아닐 경우
        if(p.get(0) == 1 || c.get(0) == 1 || p.get(1) == 400 || c.get(1) == 400 || p.get(1) != p.get(0) + 1 || c.get(1) != c.get(0) + 1) {
            answer = -1;
        } else {
            int pobiMax = Math.max(find_max(p.get(0)), find_max(p.get(1)));
            int crongMax = Math.max(find_max(c.get(0)), find_max(c.get(1)));

            if(pobiMax > crongMax) answer = 1;
            else if(pobiMax < crongMax) answer = 2;
            else answer = 0;
        }
        return answer;
    }

    public static int find_max(int page) {
        int sum = 0;
        int multi = 1;

        while(page > 0) {
            sum += page % 10;
            multi *= page % 10;
            page = page / 10;
        }

        return Math.max(sum, multi);
    }
}