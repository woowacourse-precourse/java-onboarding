package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        if(isPageInvalid(pobi) || isPageInvalid(crong)) return -1;
        if (isPageNotContinuous(pobi) || isPageNotContinuous(crong)) return -1;

        int pobi_score = Math.max(maxAddorMultiply(pobi.get(0)), maxAddorMultiply(pobi.get(1)));
        int crong_score = Math.max(maxAddorMultiply(crong.get(0)), maxAddorMultiply(crong.get(1)));

        if (pobi_score > crong_score) answer = 1;
        if (pobi_score < crong_score) answer = 2;
        return answer;
    }
    public static boolean isPageInvalid(List<Integer> array) {
        return (array.get(0) <= 1) || (array.get(0) >= 400) || (array.get(1) <= 1) || (array.get(1) >= 400);
    }
    public static boolean isPageNotContinuous(List<Integer> array) {
        return array.get(0) != array.get(1) -1;
    }
    public static int maxAddorMultiply(int page) {
        int sum = 0;
        int tmp = page;
        while(tmp!=0) {
            sum += tmp%10;
            tmp /=10;
        }

        tmp = page;
        int mul = 1;
        while(tmp!=0) {
            mul *= tmp%10;
            tmp /=10;
        }

        return Math.max(sum, mul);
    }
}