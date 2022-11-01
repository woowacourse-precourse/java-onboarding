package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1;i<=number;i++){
            int temp = i;
            while(temp > 0){
                if(temp % 10 == 3||temp % 10 == 6||temp % 10 == 9){
                    answer++;
                }
                temp /= 10;
            }
        }
        return answer;
    }
}
