package onboarding;

import java.util.List;
import java.util.Random;

import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        try {

            int pobiMax = getMax(pobi);
            int crongMax = getMax(crong);

            answer = pobiMax > crongMax ? 1 : pobiMax == crongMax ? 0 : 2;
        } catch (Exception e){
            answer = -1;
        }
        return answer;
    }

    static int sum (int n){
        int result = 0;
        while(n > 0){
            result += n % 10;
            n /= 10;
        }
        return result;
    }

    static int multiply (int n){
        int result = 1;
        while(n > 0){
            result *= n % 10;
            n /= 10;
        }
        return result;
    }

    static int getMax (List<Integer> arr){
        int maxA = 1;
        for(int num : arr){
            int maxB = max(sum(num), multiply(num));
            if(maxB > maxA) maxA = maxB;
        }
        return maxA;
    }
}