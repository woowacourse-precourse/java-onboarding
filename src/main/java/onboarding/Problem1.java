package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {

            int answer =  Integer.MAX_VALUE;
            Integer pobiScore = findPageScore(pobi);
            Integer crongScore = findPageScore(crong);

            if(pobiScore > crongScore)
                return 1;
            if(pobiScore < crongScore)
                return 2;
            if(pobiScore == crongScore)
                return 0;

            return answer;
        }
        catch (Exception e) {
            return -1;
        }
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

    private static Integer findPageScore(List<Integer> pageNums) throws Exception{

        Integer leftPage = pageNums.get(0);
        Integer rightPage = pageNums.get(1);

        checkNumContinuity(leftPage,rightPage);

        checkOddNumber(leftPage);
        checkEvenNumber(rightPage);

        checkNumRange(leftPage);
        checkNumRange(rightPage);

        Integer leftScore = Math.max(findPageNumberSum(leftPage),findPageNumberProduct(leftPage));
        Integer rightScore = Math.max(findPageNumberSum(rightPage),findPageNumberProduct(rightPage));

        return Math.max(leftScore,rightScore);
    }

    private static void checkNumContinuity(Integer leftNum, Integer rightNum) throws Exception {
        if(rightNum -1 != leftNum) throw new Exception();
    }

    private static void checkNumRange(Integer num) throws Exception {
        if(1>num||400<num) throw new Exception();
    }

    private static void checkOddNumber(Integer num) throws Exception {
        if(num % 2 == 0) throw new Exception();
    }

    private static void checkEvenNumber(Integer num) throws Exception {
        if(num % 2 == 1) throw new Exception();
    }
}