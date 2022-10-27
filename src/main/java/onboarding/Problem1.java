package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        int pobiScore = 0;
        int crongScore = 0;
        
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

