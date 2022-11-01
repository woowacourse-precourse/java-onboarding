package onboarding;

import java.util.List;

class Problem1 {
    private static int getMaxScores(int n){
        int tmp_add=0;
        int tmp_mul=1;
        while(n!=0){
            tmp_add += n%10;
            tmp_mul *= n%10;
            n /= 10;
        }
        return Math.max(tmp_add,tmp_mul);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}