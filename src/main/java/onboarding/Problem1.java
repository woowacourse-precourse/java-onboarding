package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        try{
            // 예외 처리
            if (pobi.get(0) + 1 != pobi.get(1)) {
                throw new Exception();
            }
            if (crong.get(0) + 1 != crong.get(1)) {
                throw new Exception();
            }

            int pobiMaxResult = 0;
            for(int i=0;i<pobi.size();i++){
                Integer num = pobi.get(i);
                int sum = sumNumberOfDigits(num);
                int mul = mulNumberOfDigits(num);
                pobiMaxResult = Math.max(pobiMaxResult, sum);
                pobiMaxResult = Math.max(pobiMaxResult, mul);
            }
            int crongMaxResult = 0;
            for(int i=0;i<crong.size();i++){
                Integer num = crong.get(i);
                int sum = sumNumberOfDigits(num);
                int mul = mulNumberOfDigits(num);
                crongMaxResult = Math.max(crongMaxResult, sum);
                crongMaxResult = Math.max(crongMaxResult, mul);
            }
            if(pobiMaxResult>crongMaxResult) return 1;
            else if (pobiMaxResult<crongMaxResult) return 2;
            else return 0;
        } catch (Exception exception){
            return -1;
        }


    }

    private static int sumNumberOfDigits(Integer number) {
        int result = 0;
        while(number != 0){
            result += number % 10;
            number /= 10;
        }
        return result;
    }
    private static int mulNumberOfDigits(Integer number) {
        int result = 1;
        while(number != 0){
            result *= number % 10;
            number /= 10;
        }
        return result;
    }
}