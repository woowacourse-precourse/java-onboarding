package onboarding;

import java.util.List;

class Problem1 {

    private static int findGameValue(List<Integer> ls){
        int a = ls.get(0);
        int b = ls.get(1);
        int x = Math.max(sumOfDigits(a), productOfDigits(a));
        int y = Math.max(sumOfDigits(b), productOfDigits(b));

        return Math.max(x,y);
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
//        System.out.printf("########## %d", findGameValue(pobi));
        return answer;
    }

}