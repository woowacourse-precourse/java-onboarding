package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if ((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)){
            return -1;
        }
        int answer = 0;

        int max_pobi_left = getMax(pobi.get(0));
        int max_pobi_right = getMax(pobi.get(1));
        int max_crong_left = getMax(crong.get(0));
        int max_crong_right = getMax(crong.get(1));

        int max_pobi = Math.max(max_pobi_left, max_pobi_right);
        int max_crong = Math.max(max_crong_left, max_crong_right);

        if (max_pobi > max_crong){
            answer = 1;
        }
        else if (max_pobi < max_crong) {
            answer = 2;
        }

        return answer;
    }

    private static int getMax(Integer i) {
        int sum = 0;
        int mul = 1;
        while (i > 0){
            int digit = i % 10;
            sum += digit;
            mul *= digit;
            i /= 10;
        }
        return Math.max(sum, mul);
    }
}