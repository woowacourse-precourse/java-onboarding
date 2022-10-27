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
        
        // 크롱 점수
        int crongLSum = getSum(crong.get(0));
        int crongLMulti = getMultiply(crong.get(0));
        int crongLMax = Math.max(crongLSum, crongLMulti);
        
        int crongRSum = getSum(crong.get(1));
        int crongRMulti = getMultiply(crong.get(1));
        int crongRMax = Math.max(crongRSum, crongRMulti);
        
        crongScore = Math.max(crongLMax, crongRMax);
        
        // 승자 구하기
        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        } else if (pobiScore == crongScore) {
            answer = 0;
        } else {
            answer = -1;
        }
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

