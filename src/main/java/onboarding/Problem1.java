package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 페이지 체크
        int check = 0;
        check += pobi.get(1) - pobi.get(0);
        check += crong.get(1) - crong.get(0);

        if (check != 2)
            return -1;

        // 가장 큰 수 구하기
        int p = getMaximum(pobi);
        int c = getMaximum(crong);

        if (p > c)
            return 1;
        else if (p < c)
            return 2;
        else
            return 0;
    }

    private static int getMaximum(List<Integer> list) {
        int res = 0;

        for (Integer num : list) {
            String[] str = String.valueOf(num).split("");

            // 더하기
            int plus = 0;
            for (String s : str) {
                plus += Integer.parseInt(s);
            }

            // 곱하기
            int times = 1;
            for (String s : str) {
                times *= Integer.parseInt(s);
            }

            res = Math.max(plus, times);
        }

        return res;
    }

}