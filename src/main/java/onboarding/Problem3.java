package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int count369(int n){
        int count = 0;

        while(n!=0){
            if(n%10==3|| n%10==6|| n%10==9)
                count++;
            n /= 10;
        }
        return count;
    }
}
