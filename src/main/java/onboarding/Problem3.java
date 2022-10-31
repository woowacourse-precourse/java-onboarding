package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if (number <10){
            answer = number/3;
        }
        else {
            answer = 3;
            for (int i=10; i <= number; i++){
                answer += clap(i);
            }
        }
        return answer;
    }
    static int clap(Integer a){
        int count = 0;
        int num = a;
        int res = 0;
        while (num > 0) {
            res = num%10;
            if ((res ==3) || (res ==6) || (res ==9)){
                count += 1;
            }
            num /= 10;
        }
        return count;
    }
}
