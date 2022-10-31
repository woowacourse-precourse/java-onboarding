package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong)  {
        int answer = Integer.MAX_VALUE;
        int pobi1 = Integer.parseInt(String.valueOf(pobi.get(0)));
        int pobi2 = Integer.parseInt(String.valueOf(pobi.get(1)));
        int crong1 = Integer.parseInt(String.valueOf(crong.get(0)));
        int crong2 = Integer.parseInt(String.valueOf(crong.get(1)));

        if (calpobi(pobi1, pobi2) == calcrong(crong1, crong2))
            answer = 0;
        else if ((pobi2 != pobi1 +1) || (crong2 != crong1 + 1))
            answer = -1;
        else if (calpobi(pobi1, pobi2) > calcrong(crong1, crong2))
            answer = 1;
        else if (calpobi(pobi1, pobi2) < calcrong(crong1, crong2))
            answer = 2;
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

    public static int calcrong(int crong1, int crong2) {

        int Rescrong = 0;

        int x1 = crong1 / 100;
        int y1 = (crong1 % 100) / 10;
        int z1 = crong1 % 10;

        int x2 = crong2 / 100;
        int y2 = (crong2 % 100) / 10;
        int z2 = crong2 % 10;

        if (x1 != 0) {
            int multcrong1T = x1 * y1 * z1;
            int pluscrong1T = x1 + y1 + z1;

            int multcrong2T = x2 * y2 * z2;
            int pluscrong2T = x2 + y2 + z2;

            int max_mult = Math.max(multcrong2T, multcrong1T);
            int max_plus = Math.max(pluscrong2T, pluscrong1T);

            Rescrong = Math.max(max_plus, max_mult);
        }

        else {
            if (y1 != 0) {
                int multcrong1D = y1 * z1;
                int pluscrong1D = y1 + z1;

                int multcrong2D = y2 * z2;
                int pluscrong2D = y2 + z2;

                int max_mult = Math.max(multcrong2D, multcrong1D);
                int max_plus = Math.max(pluscrong2D, pluscrong1D);

                Rescrong = Math.max(max_plus, max_mult);
            }
        }
        return Rescrong;
    }
}