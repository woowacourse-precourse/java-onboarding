package onboarding;

import onboarding.problem3.Calculator;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0, tmp;
        Calculator calculator = new Calculator();
        for(int i = 1; i <= number; i++){
            tmp = calculator.func(i);
            answer += tmp;
        }
        return answer;
    }
}
