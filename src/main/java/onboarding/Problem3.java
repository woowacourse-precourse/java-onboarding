package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        return answer;
    }

    public static int checknumSYG(int number){
        int temp = number;
        while(temp > 0){
            if(temp%10 == 3||temp%10 == 6||temp%10 == 9)
                return 1;
            temp /= 10;
        }
        return 0;
    }


}
