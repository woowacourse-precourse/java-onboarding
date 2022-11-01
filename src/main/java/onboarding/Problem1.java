package onboarding;

import java.util.List;
import java.lang.Math;

class Problem1 {
    public boolean checkValid(List<Integer> test) {
        int first = test.get(1);
        int second = test.get(2);

        return ( (second-first) == 1 && 0 < first && first < 400 );
    }

    public int getGreatest(int test) {
        int sum = 0, mul = 1;
        int len = (int)(Math.log10(test)+1);

        for (int i = 0; i < len; i++) {
            sum += test % 10;
            mul *= test % 10;
            test = test / 10;
        }

        return Math.max(sum, mul);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        Problem1 prob = new Problem1();
        int p,c;

        if ( !(prob.checkValid(pobi) && prob.checkValid(crong)) )
            return -1;

        p = Math.max(prob.getGreatest(pobi.get(1)),prob.getGreatest(pobi.get(2)));
        c = Math.max(prob.getGreatest(crong.get(1)),prob.getGreatest(crong.get(2)));

        if (c < p)
            answer = 1;
        else if (p < c)
            answer = 2;
        else
            answer = 0;

        return answer;
    }
}