package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int i, n;

        for(i=1;i<=number;i++){
            n = i;
            while(n>0){
                if(n%10==3||n%10==6||n%10==9){
                    answer+=1;
                }
                n/=10;
            }
        }

        return answer;
    }
}
