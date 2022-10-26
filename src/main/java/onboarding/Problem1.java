package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    //번호의 각 자리 숫자들의 합이나 곱 중 가장 큰값을 구하는 함수
    private static int getNumberMax(int num){
        int sum = 0, multi = 1;
        while(num != 0){
            sum += num%10;
            multi *= num%10;
            num /= 10;
        }
        return Math.max(sum, multi);
    }
}