package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = repeat(number);

        return answer;
    }

    public static int checknumSYG(int number){
        int temp = number;
        int cnt = 0;
        while(temp > 0){
            if(temp%10 == 3||temp%10 == 6||temp%10 == 9)
                cnt++;
            temp /= 10;
        }
        return cnt;
    }

    public static int repeat(int number){
        int count = 0;
        for(int i=1; i<=number; i++){
                count += checknumSYG(i);
        }
        return count;
    }

}
