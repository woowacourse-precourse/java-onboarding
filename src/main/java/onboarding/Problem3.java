package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int j=i;
            while(j>0) {
                int k=j;
                k= j%10;
                if(k ==3 || k==6 || k==9 ){
                    answer++;
                }
                k/=10;
                j/=10;
            }
        }
        return answer;
    }
}
