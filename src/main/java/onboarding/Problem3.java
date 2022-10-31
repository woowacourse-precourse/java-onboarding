package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        return answer;
    }

    public static int countClap(int num){
        int clap=0;

        while(num>0){
            if( num%10==3 || num%10==6 || num%10==9 ) clap++;
            num/=10;
        }
        return clap;
    }
}
