package onboarding;

import java.util.List;

/**
 [기능 구현]
 1. 예외 사항
 2. 두 수를 비교하여 답을 내는 메소드
 3. 자릿수 별로 곱하고 더하는 메소드
 **/
class Problem1 {

    // 예외 사항
    // 1. 들어온 숫자가 홀수/짝수가 아닐 때
    // 2. 연속된 숫자가 아닐 때
    private static boolean exception(List<Integer> pobi, List<Integer> crong) {
        if ((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)) return true;
        if ((pobi.get(0) % 2 != 1) || (crong.get(0) % 2 != 1)) return true;
        if (pobi.get(0) == 1 ||  pobi.get(0) == 399 || crong.get(0) == 1 || crong.get(0) == 399) return true;
        return false;
    }

    // 더하고, 곱하는
    private static int getMax(int num) {
        int pobi_sum = 0;
        int pobi_mul = 1;
        while (num > 0) {
            int rem = num % 10;
            pobi_sum += rem;
            pobi_mul *= rem;
            num /= 10;
        }
        return Math.max(pobi_sum, pobi_mul);
    }

    // 두 수를 비교해서 답을 내는 메소드
    private static int compare(int pobi_max, int crong_max) {
        if (pobi_max > crong_max) return 1;
        else if (pobi_max < crong_max) return 2;
        else return 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}