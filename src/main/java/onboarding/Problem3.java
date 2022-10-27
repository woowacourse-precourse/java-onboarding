package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int n, answer = 0;

        for(int num= 1; num<=number; num++){
            n = num;

            while(n!=0){
                if(n%10==3|| n%10==6|| n%10==9)
                    answer++;
                n /= 10;
            }
        }
        return answer;
    }
}
