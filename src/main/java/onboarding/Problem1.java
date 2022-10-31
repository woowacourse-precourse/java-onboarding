package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int calpobi(int pobi1, int pobi2) {
        int Respobi = 0;

        int a1 = pobi1 / 100;
        int b1 = (pobi1 % 100) / 10;
        int c1 = pobi1 % 10;

        int a2 = pobi2 / 100;
        int b2 = (pobi2 % 100) / 10;
        int c2 = pobi2 % 10;

        if (a1 != 0) {
            int multpobi1T = a1 * b1 * c1;
            int pluspobi1T = a1 + b1 + c1;

            int multpobi2T = a2 * b2 * c2;
            int pluspobi2T = a2 + b2 + c2;

            int max_mult = Math.max(multpobi1T, multpobi2T);
            int max_plus = Math.max(pluspobi2T, pluspobi1T);

            Respobi = Math.max(max_plus, max_mult);
        }

        else {
            if (b1 != 0) {
                int multpobi1D = b1 * c1;
                int pluspobi1D = b1 + c1;

                int multpobi2D = b2 * c2;
                int pluspobi2D = b2 + c2;

                int max_mult = Math.max(multpobi1D, multpobi2D);
                int max_plus = Math.max(pluspobi2D, pluspobi1D);

                Respobi = Math.max(max_plus, max_mult);
            }
        }
        return Respobi;
    }
}