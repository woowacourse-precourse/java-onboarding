package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        int pobiScore = 0;
        int crongScore = 0;
        
        int getScore(int n) {
            int sum = 0;
            int multiply = 1;

            while (n != 0) {
                sum += n % 10;
                multiply *= n % 10;;
                n /= 10;
            }

        return answer;
        
    }
}
}