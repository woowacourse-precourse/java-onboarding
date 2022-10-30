package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = repeat(number);

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

    public static int repeat(int number){
        int count = 0;
        for(int i=1; i<=number; i++){
                count += checknumSYG(i);
        }
        return count;
    }

}
