package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        int pobiScore = 0;
        int crongScore = 0;
        
        // 포비 점수 
        int pobiLSum = getSum(pobi.get(0));
        int pobiLMulti = getMultiply(pobi.get(0));
        int pobiLMax = Math.max(pobiLSum, pobiLMulti);
        
        int pobiRSum = getSum(pobi.get(1));
        int pobiRMulti = getMultiply(pobi.get(1));
        int pobiRMax = Math.max(pobiRSum, pobiRMulti);
        
        pobiScore = Math.max(pobiLMax, pobiRMax);
        
        return answer;
    }
    
        static int getSum(int n) {
            int sum = 0;
    
            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }
    
            return sum;
        }
        
        static int getMultiply(int n) {
            int multiply = 1;
            while (n != 0) {
                multiply *= n % 10;;
                n /= 10;
            }
            return multiply;
        }
    }

