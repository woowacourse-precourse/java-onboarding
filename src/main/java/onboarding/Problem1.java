package onboarding;

import java.util.List;

class Problem1 {
    private static int extraction(int page){
        int result;
        int add = 0;
        int mul = 1;
        // 더하기, 곱하기
        while (page != 0){
            add += page % 10;
            mul *= page % 10;
            page /= 10;
        }
        result = Math.max(add, mul);
        return result;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiScore = Math.max(extraction(pobi.get(0)), extraction(pobi.get(1)));
        int crongScore = Math.max(extraction(crong.get(0)), extraction(crong.get(1)));

        return answer;
    }
}