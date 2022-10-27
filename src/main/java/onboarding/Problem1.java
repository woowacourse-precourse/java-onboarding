package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        if(pobi.get(0) != pobi.get(1) - 1) return -1;
        if(crong.get(0) != crong.get(1) - 1) return -1;

        int pobiMax;
        int crongMax;
        ArrayList<Integer> pobiList = new ArrayList<>();
        ArrayList<Integer> crongList = new ArrayList<>();

        for(int i = 0; i < 2; i++) {
            pobiList.add(plus(pobi.get(i)));
            pobiList.add(mul(pobi.get(i)));
            crongList.add(plus(crong.get(i)));
            crongList.add(mul(crong.get(i)));
        }

        Collections.sort(pobiList);
        Collections.sort(crongList);

        pobiMax = pobiList.get(3);
        crongMax = crongList.get(3);

        if(pobiMax > crongMax) answer = 1;
        else if(pobiMax < crongMax) answer = 2;
        else answer = 0;

        return answer;
    }

    public static int plus(int n) {
        int answer = 0;

        while(n > 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }

    public static int mul(int n) {
        int answer = 1;

        while(n > 0) {
            answer *= n % 10;
            n /= 10;
        }

        return answer;
    }
}