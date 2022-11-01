package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int max_p = 0;
        int max_c = 0;
        int temp_plus;
        int temp_multi;

        Integer p0 = pobi.get(0);
        Integer p1 = pobi.get(1);
        Integer c0 = crong.get(0);
        Integer c1 = crong.get(1);

        if (p0 % 2 != 1 || p0 + 1 != p1 || c0 % 2 != 1 || c0 + 1 != c1)
            return -1;
        else {
            String[] p_string = {p0.toString(), p1.toString()};
            String[] c_string = {c0.toString(), c1.toString()};

            max_p = getMax(max_p, p_string);
            max_c = getMax(max_c, c_string);
        }

        if (max_p == max_c)
            return 0;
        else if (max_p > max_c)
            return 1;
        else
            return 2;
    }

    private static int getMax(int max, String[] string) {
        int temp_plus;
        int temp_multi;
        for (String s : string) {
            temp_plus = 0;
            temp_multi = 1;
            for (int i = 0; i < s.length(); i++) {
                temp_plus += s.charAt(i) - '0';
                temp_multi *= s.charAt(i) - '0';
            }
            if (temp_plus < temp_multi) {
                if (max < temp_multi)
                    max = temp_multi;
            } else {
                if (max < temp_multi)
                    max = temp_multi;
            }
        }
        return max;
    }
}