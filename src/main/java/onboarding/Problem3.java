package onboarding;
import java.util.*;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int length = (int)(Math.log10(number)+1);

        for(int i=1; i<=number;i++){
            int tmp = i;
            for(int j=0;j<(int)(Math.log10(i)+1);j++) {
                if(tmp%10==3||tmp%10==6||tmp%10==9){
                    answer++;
                }
                tmp/=10;
            }
        }
        return answer;
    }
}
