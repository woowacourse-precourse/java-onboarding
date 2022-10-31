package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_sumMax = Integer.max(sum_digit(pobi.get(0)), sum_digit(pobi.get(1)));

        return pobi_sumMax;
    }
    // 주어진 숫자의 각 자리 수를 더하여 반환
    private static int sum_digit(int value){
        int temp, sum = 0;

        do{
            temp = value % 10;
            sum += temp;
            value /= 10;
        } while(value != 0);

        return sum;
    }


    public static void main(String[] args) {
        System.out.println(solution(List.of(97, 98), List.of(197, 198)));
    }
}