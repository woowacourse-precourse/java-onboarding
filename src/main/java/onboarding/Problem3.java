package onboarding;

public class Problem3 {
    public static int BaeminClap(int clap) {
        int count = 0;
        while(clap !=0){
            if(clap%10%3 ==0 && clap%10 != 0) {
                count++;
            }
            clap /= 10;
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            answer += BaeminClap(i);
        }
        return answer;
    }
}
