package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=1; i<=number; i++){
            for(int j=i; j!=0; j/=10) {
                int slice=j%10;
                if(slice==3||slice==6||slice==9) answer++;
            }
        }
        return answer;
    }


}
