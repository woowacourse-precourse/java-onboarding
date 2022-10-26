package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        return answer;
    }

    private static int maxPage(int page){
        int sum = 0;
        int mul = 1;
        while (page>0){
            sum += page%10;
            mul *= page%10;
            page /= 10;
        }
        return Math.max(sum,mul);
    }
}
