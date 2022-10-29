package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static Integer findPageNumberSum(Integer number) {
        Integer sum = 0;

        while(number > 0){
            sum+= number%10;
            number /= 10;
        }

        return sum;
    }

    private static Integer findPageNumberProduct(Integer number) {
        Integer sum = 1;

        while(number > 0){
            sum*= number%10;
            number /= 10;
        }

        return sum;
    }

    private static Integer findPageScore(List<Integer> pageNums){

        Integer leftPage = pageNums.get(0);
        Integer rightPage = pageNums.get(1);

        Integer leftScore = Math.max(findPageNumberSum(leftPage),findPageNumberProduct(leftPage));
        Integer rightScore = Math.max(findPageNumberSum(rightPage),findPageNumberProduct(rightPage));

        return Math.max(leftScore,rightScore);
    }

}