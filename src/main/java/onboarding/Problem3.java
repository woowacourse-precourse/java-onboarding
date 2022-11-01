package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        int num=0;

        for(int i=1;i<=number;i++){
            int n=i;
            while(n>0){
                num=n%10;
                if(num==3||num==6||num==9){
                    answer++;
                }
                n/=10;
            }
        }

        return answer;
    }
}
