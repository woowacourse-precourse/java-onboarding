package onboarding;

import java.util.List;

class Problem1 {

    public static int make_max(int num)
    {
        String now = Integer.toString(num);
        int sum_value = 0;
        int mult_value = 1;
        int result = 0;

        for(int i = 0; i < now.length(); i++){
            sum_value += Character.getNumericValue(now.charAt(i));
            mult_value *= Character.getNumericValue(now.charAt(i));
        }
        result = Math.max(sum_value, mult_value);
        return result;
    }
    public static boolean check_error(List<Integer> list)
    {
        if (list.get(1) - list.get(0) != 1 || list.get(0) % 2 != 1)
        {
            return false;
        }
        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_left = make_max(pobi.get(0));
        int pobi_right = make_max(pobi.get(1));
        int crong_left = make_max(crong.get(0));
        int crong_right = make_max(crong.get(1));
        int pobi_max = Math.max(pobi_left, pobi_right);
        int crong_max = Math.max(crong_left, crong_right);

        if (!check_error(pobi) || !check_error(crong))
        {
            return -1;
        }
        if (pobi_max > crong_max)
            answer = 1;
        else if (pobi_max < crong_max)
            answer = 2;
        else if (pobi_max == crong_max)
            answer = 0;
        else
            answer = -1;
        return answer;
    }
}
