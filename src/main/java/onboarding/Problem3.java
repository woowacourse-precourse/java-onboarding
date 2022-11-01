package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    static int checkThree(int n){
        int result = 0;
        while(n>0){
            if(result%10 == 3)result++;
            n/=10;
        }
        return result;
    }
}
