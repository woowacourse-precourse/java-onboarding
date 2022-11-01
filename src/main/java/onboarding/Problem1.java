package onboarding;

import java.util.List;

class Problem1 {

    public static int sum_multi(int a) {
        String string_a = Integer.toString(a);

        int result_sum = 0;
        int result_multi = 1;

        for (int i = 0; i < string_a.length(); i++) {
            result_sum += (string_a.charAt(i) - '0');
            result_multi *= (string_a.charAt(i) - '0');

        }
        if (result_sum > result_multi) {
            return result_sum;
        } else {
            return result_multi;
        }

    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
//        int answer = Integer.MAX_VALUE;
//        return answer;

        int pobi_left = pobi.get(0);
        int pobi_right = pobi.get(1);


    }
}