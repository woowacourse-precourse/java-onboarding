package onboarding;

import java.util.List;

class Problem1 {

    private int findGameValue(List<Integer> ls){
        return 0;
    }

    private static int sumOfDigits(int v){
        int k = v, result = 0;
        while(k > 10) {
            result += (k%10);
            k = k/10;
        }
        result += k;
        return result;
    }

    private static int productOfDigits(int v){
        int k = v, result = 1;
        while(k > 10){
            result *= (k%10);
            k = k/10;
        }
        result *= k;
        return  result;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
//        System.out.printf("%d", productOfDigits(1234));
        return answer;
    }

}