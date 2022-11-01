package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return clap(number);
    }

    static int clap(int number){
        int totalTime=0;
        for(int i=1; i<=number; i++){
            totalTime+=clapTime(i);
        }
        return totalTime;
    }

    static int clapTime(int number){
        int time=0;
        while(number!=0){
            if(number%10==3||number%10==6||number%10==9)time++;
            number/=10;
        }
        return time;
    }
}