package onboarding;

import java.util.List;
import java.lang.Math;
class Problem1 {


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        int p_left = pobi.get(0);
        int p_right = pobi.get(1);
        if (p_right - p_left != 1)
        {answer = -1;
            return answer;}

        int l_plus = 0;
        int l_multi = 1;
        int r_plus = 0;
        int r_multi = 1;

        while (p_left>0)
        {int left_val = p_left % 10;
            p_left /= 10;
            l_plus += left_val;
            l_multi *= left_val;
        }
        while (p_right>0)
        {int right_val = p_right % 10;
            p_right /= 10;
            r_plus += right_val;
            r_multi *= right_val;

        }
        int l_max = Math.max(l_plus, l_multi);
        int r_max = Math.max(r_plus, r_multi);
        int pobi_max = Math.max(l_max, r_max);

        int c_left = crong.get(0);
        int c_right = crong.get(1);
        if (c_right - c_left != 1)
        {answer = -1;
            return answer;}
        int le_plus = 0;
        int le_multi = 1;
        int ri_plus = 0;
        int ri_multi = 1;

        while (c_left>0)
        {int left_val = c_left % 10;
            c_left /= 10;
            le_plus += left_val;
            le_multi *= left_val;
        }
        while (c_right>0)
        {int right_val = c_right % 10;
            c_right /= 10;
            ri_plus += right_val;
            ri_multi *= right_val;

        }
        int le_max = Math.max(le_plus, le_multi);
        int ri_max = Math.max(ri_plus, ri_multi);
        int crong_max = Math.max(le_max, ri_max);


        if (pobi_max > crong_max){answer = 1;}
        if (pobi_max < crong_max){answer = 2;}
        if (pobi_max == crong_max){answer = 0;}

        return answer;
    }

}