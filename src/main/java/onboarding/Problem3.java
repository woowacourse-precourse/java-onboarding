package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = number/10 * 3 + number%10/3;
        int div = 10;

        while(div <= number){
            int rotate = number/div;
            answer += rotate/10*3*div;
            answer += (rotate-1)%10/3 * div;
            if(rotate%10%3 == 0) answer += number%div + 1;
            div*=10;
        }

        return answer;
    }
}
