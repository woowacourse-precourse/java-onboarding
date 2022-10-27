package onboarding;

public class Problem3 {
    public static int clap(int n){
        int cnt = 0;
        for(int i = 1; i < n+1; i++){
            int tmp = i;
            while(tmp>0){
                int x = tmp%10;
                tmp /= 10;
                if(x != 0 && x%3 == 0){
                    cnt++;
                }
            }
        }
        return cnt
    }
    public static int solution(int number) {
        return clap(number);
    }
}
